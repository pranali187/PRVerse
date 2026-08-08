using Microsoft.EntityFrameworkCore;
using PRVerse.PaymentService.Data;
using PRVerse.PaymentService.Services;

var builder = WebApplication.CreateBuilder(args);

// MySQL Database
var connectionString = builder.Configuration.GetConnectionString("PaymentDatabase");

builder.Services.AddDbContext<PaymentDbContext>(options =>
    options.UseMySql(
        connectionString,
        ServerVersion.AutoDetect(connectionString)
    )
);

// Controllers
builder.Services.AddControllers();
builder.Services.AddScoped<RazorpayService>();

// OpenAPI
builder.Services.AddOpenApi();

var app = builder.Build();

// Development
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

// Map Controllers
app.MapControllers();

app.Run();