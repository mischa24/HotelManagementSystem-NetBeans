public class Reservation {
    private String customerName;
    private int roomNumber;
    private int nights;
    private double pricePerNight;
    private double extraCharges;

    public Reservation(String customerName, int roomNumber, int nights, double pricePerNight, double extraCharges) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.pricePerNight = pricePerNight;
        this.extraCharges = extraCharges;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNights() {
        return nights;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getExtraCharges() {
        return extraCharges;
    }

    public double calculateSubtotal() {
        return (nights * pricePerNight) + extraCharges;
    }

    public double calculateDiscountedTotal() {
        double subtotal = calculateSubtotal();
        if (nights > 5) {
            subtotal = subtotal * 0.90;  // 10% έκπτωση
        }
        return subtotal;
    }

    public double calculateVAT() {
        return calculateDiscountedTotal() * 0.13;
    }

    public double calculateFinalTotal() {
        return calculateDiscountedTotal() + calculateVAT();
    }
}
