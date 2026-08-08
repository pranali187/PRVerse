using Razorpay.Api;
using System.Security.Cryptography;
using System.Text;

namespace PRVerse.PaymentService.Services
{
    public class RazorpayService
    {
        private readonly string _keyId;
        private readonly string _keySecret;

        public RazorpayService(IConfiguration configuration)
        {
            _keyId = configuration["Razorpay:KeyId"]
                ?? throw new Exception("Razorpay KeyId is missing.");

            _keySecret = configuration["Razorpay:KeySecret"]
                ?? throw new Exception("Razorpay KeySecret is missing.");
        }

        // Returns Razorpay Key ID
        // This is safe to send to the frontend.
        public string GetKeyId()
        {
            return _keyId;
        }

        // Creates an order in Razorpay
        public Order CreateOrder(
            decimal amount,
            string currency,
            string receipt)
        {
            var client = new RazorpayClient(
                _keyId,
                _keySecret
            );

            var options = new Dictionary<string, object>
            {
                {
                    "amount",
                    (int)(amount * 100)
                },
                {
                    "currency",
                    currency
                },
                {
                    "receipt",
                    receipt
                },
                {
                    "payment_capture",
                    1
                }
            };

            return client.Order.Create(options);
        }

        // Verifies Razorpay payment signature
        public bool VerifyPaymentSignature(
            string orderId,
            string paymentId,
            string signature)
        {
            try
            {
                // Razorpay signature payload
                var payload = orderId + "|" + paymentId;

                // Generate HMAC-SHA256 using Razorpay Key Secret
                using var hmac = new HMACSHA256(
                    Encoding.UTF8.GetBytes(_keySecret)
                );

                var hash = hmac.ComputeHash(
                    Encoding.UTF8.GetBytes(payload)
                );

                // Convert generated hash to hexadecimal
                var generatedSignature =
                    Convert.ToHexString(hash).ToLowerInvariant();

                // Compare generated signature with Razorpay signature
                return generatedSignature == signature;
            }
            catch
            {
                return false;
            }
        }
    }
}