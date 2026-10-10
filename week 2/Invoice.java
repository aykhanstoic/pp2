package week03.invoice;

/**
 * Represents an invoice for one item sold at a hardware store.
 */
public class Invoice {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    /** Initialises all four instance variables.
     *  Setters are used so that the validation rules live in one place. */
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    // ---- getters / setters ----

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    /** A non-positive quantity is stored as 0. */
    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    /** A non-positive price is stored as 0.0. */
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0.0) ? pricePerItem : 0.0;
    }

    // ---- behaviour ----

    /** Invoice amount = quantity * price per item. */
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Invoice[part=%s, desc=%s, qty=%d, price=%.2f, amount=%.2f]",
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}
