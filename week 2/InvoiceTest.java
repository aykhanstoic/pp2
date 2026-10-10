package week03.invoice;

public class InvoiceTest {

    public static void main(String[] args) {
        // 1. Normal invoice
        Invoice hammer = new Invoice("1234", "Hammer", 2, 14.95);
        System.out.println("Part number:      " + hammer.getPartNumber());
        System.out.println("Part description: " + hammer.getPartDescription());
        System.out.println("Quantity:         " + hammer.getQuantity());
        System.out.printf ("Price per item:   %.2f%n", hammer.getPricePerItem());
        System.out.printf ("Invoice amount:   %.2f%n", hammer.getInvoiceAmount());   // 2 * 14.95 = 29.90

        System.out.println();

        // 2. Invalid values passed to the constructor are corrected to 0 / 0.0
        Invoice bad = new Invoice("5678", "Screwdriver", -3, -9.99);
        System.out.println("Constructed with qty=-3, price=-9.99:");
        System.out.println("  quantity = " + bad.getQuantity()
                + ", price = " + bad.getPricePerItem()
                + ", amount = " + bad.getInvoiceAmount());

        System.out.println();

        // 3. Setters: valid update, then invalid update
        bad.setQuantity(5);
        bad.setPricePerItem(3.50);
        System.out.println("After setQuantity(5), setPricePerItem(3.50): " + bad);

        bad.setQuantity(0);          // not positive -> 0
        bad.setPricePerItem(-1.0);   // not positive -> 0.0
        System.out.println("After setQuantity(0), setPricePerItem(-1.0): " + bad);

        bad.setPartNumber("9999");
        bad.setPartDescription("Phillips screwdriver");
        System.out.println("After changing number/description: " + bad);
    }
}
