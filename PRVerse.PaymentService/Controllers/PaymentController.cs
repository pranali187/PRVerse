using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PRVerse.PaymentService.Data;
using PRVerse.PaymentService.Models;
using PRVerse.PaymentService.DTOs;
using PRVerse.PaymentService.Services;

namespace PRVerse.PaymentService.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PaymentController : ControllerBase
    {
        private readonly PaymentDbContext _context;
        private readonly RazorpayService _razorpayService;

        public PaymentController(
    PaymentDbContext context,
    RazorpayService razorpayService)
        {
            _context = context;
            _razorpayService = razorpayService;
        }

        // POST: api/Payment/create-order
        [HttpPost("create-order")]
        public async Task<IActionResult> CreateOrder(
            [FromBody] CreateOrderRequest request)
        {
            if (request.Amount <= 0)
            {
                return BadRequest("Amount must be greater than zero.");
            }

            var receipt =
                $"PRVERSE_{request.UserId}_{DateTime.UtcNow.Ticks}";

            var razorpayOrder = _razorpayService.CreateOrder(
                request.Amount,
                request.Currency,
                receipt
            );

            var payment = new Payment
            {
                UserId = request.UserId,
                PackageId = request.PackageId,
                Amount = request.Amount,
                Currency = request.Currency,
                OrderId = razorpayOrder["id"].ToString(),
                Status = "CREATED",
                CreatedAt = DateTime.UtcNow
            };

            _context.Payments.Add(payment);

            await _context.SaveChangesAsync();

            return Ok(new
            {
                paymentId = payment.PaymentId,
                orderId = payment.OrderId,
                amount = request.Amount,
                amountInPaise = (int)(request.Amount * 100),
                currency = request.Currency,
                keyId = _razorpayService.GetKeyId()
            });
        }

        // GET: api/Payment/test
        [HttpGet("test")]
        public IActionResult Test()
        {
            return Ok("Payment Service is working!");
        }

        // POST: api/Payment/create
        [HttpPost("create")]
        public async Task<IActionResult> CreatePayment([FromBody] Payment payment)
        {
            if (payment.Amount <= 0)
            {
                return BadRequest("Amount must be greater than zero.");
            }

            payment.Status = "CREATED";
            payment.CreatedAt = DateTime.UtcNow;

            _context.Payments.Add(payment);
            await _context.SaveChangesAsync();

            return Ok(payment);
        }

        // GET: api/Payment/{id}
        [HttpGet("{id}")]
        public async Task<IActionResult> GetPayment(long id)
        {
            var payment = await _context.Payments
                .FirstOrDefaultAsync(p => p.PaymentId == id);

            if (payment == null)
            {
                return NotFound("Payment not found.");
            }

            return Ok(payment);
        }

        // GET: api/Payment/user/{userId}
        [HttpGet("user/{userId}")]
        public async Task<IActionResult> GetUserPayments(long userId)
        {
            var payments = await _context.Payments
                .Where(p => p.UserId == userId)
                .ToListAsync();

            return Ok(payments);
        }

        // PUT: api/Payment/{id}/status
        [HttpPut("{id}/status")]
        public async Task<IActionResult> UpdatePaymentStatus(
            long id,
            [FromBody] string status)
        {
            var payment = await _context.Payments
                .FirstOrDefaultAsync(p => p.PaymentId == id);

            if (payment == null)
            {
                return NotFound("Payment not found.");
            }

            payment.Status = status;

            await _context.SaveChangesAsync();

            return Ok(payment);
        }
    }
}