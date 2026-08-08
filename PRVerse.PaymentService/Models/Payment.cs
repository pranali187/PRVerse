using System.ComponentModel.DataAnnotations;

namespace PRVerse.PaymentService.Models
{
    public class Payment
    {
        [Key]
        public long PaymentId { get; set; }

        public long UserId { get; set; }

        public long PackageId { get; set; }

        public decimal Amount { get; set; }

        public string Currency { get; set; } = "INR";

        public string? OrderId { get; set; }

        public string? GatewayPaymentId { get; set; }

        public string Status { get; set; } = "CREATED";

        public DateTime CreatedAt { get; set; } = DateTime.UtcNow;
    }
}