import java.util.Scanner;

public class ReservationManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to KoutsakisHotel Booking Manager!");
        System.out.print("Enter number of reservations to add: ");
        int numberOfReservations = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Reservation[] reservations = new Reservation[numberOfReservations];

        double totalSum = 0;
        double maxPayment = 0;
        String maxCustomer = "";

        // Input loop
        for (int i = 0; i < numberOfReservations; i++) {
            System.out.println("\nReservation #" + (i + 1));

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Number of Nights: ");
            int nights = scanner.nextInt();

            System.out.print("Price per Night: ");
            double pricePerNight = scanner.nextDouble();

            System.out.print("Extra Charges: ");
            double extraCharges = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            reservations[i] = new Reservation(name, roomNumber, nights, pricePerNight, extraCharges);
        }

        System.out.println("\n--- Reservation Receipts ---");

        for (Reservation r : reservations) {
            double subtotal = r.calculateSubtotal();
            double discounted = r.calculateDiscountedTotal();
            double vat = r.calculateVAT();
            double finalTotal = r.calculateFinalTotal();

            System.out.println("\n--- Customer: " + r.getCustomerName() + " ---");
            System.out.println("Room Number: " + r.getRoomNumber());
            System.out.println("Nights: " + r.getNights());
            System.out.println("Price per Night: " + r.getPricePerNight());
            System.out.println("Extra Charges: " + r.getExtraCharges());
            System.out.printf("Subtotal: %.2f\n", subtotal);
            System.out.printf("After Discount: %.2f\n", discounted);
            System.out.printf("VAT (13%%): %.2f\n", vat);
            System.out.printf("Final Total: %.2f\n", finalTotal);

            totalSum += finalTotal;

            if (finalTotal > maxPayment) {
                maxPayment = finalTotal;
                maxCustomer = r.getCustomerName();
            }
        }

        double average = totalSum / numberOfReservations;

        System.out.println("\n=== SUMMARY ===");
        System.out.printf("Average Payment: %.2f\n", average);
        System.out.println("Customer with Highest Payment: " + maxCustomer + " (Amount: " + String.format("%.2f", maxPayment) + ")");

        scanner.close();
    }
}
