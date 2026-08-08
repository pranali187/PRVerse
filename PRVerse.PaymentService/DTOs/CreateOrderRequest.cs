namespace PRVerse.PaymentService.DTOs
{
    public class CreateOrderRequest
    {
        public long UserId { get; set; }

        public long PackageId { get; set; }

        public decimal Amount { get; set; }

        public string Currency { get; set; } = "INR";
    }
}