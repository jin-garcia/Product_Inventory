package product.inventory;

//Class for the product. This class contains 4 elements: manufacturer, name, quantity and price. 

public class Product {
    
    //Declaration for privcate fields. These will represent the product's name, manufacturer, quantity, and price.
    private String name;
    private Double price;
    private Manufacturer manuFac;
    private int quantity;

    //Class constructor for product.
    public Product(String name, Double price, Manufacturer manuFac, int quantity) {
        this.name = name;
        this.price = price;
        this.manuFac = manuFac;
        this.quantity = quantity;
    }

    //Getter that returns product name.
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Manufacturer getManufacturer() {
        return manuFac;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setManufacturer(Manufacturer manuFac) {
        this.manuFac = manuFac;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //Method for removing inventory from the quantity.
    public void sale(int numPurchased) {
        this.quantity -= numPurchased;
    }
    
    //Method for adding inventory to the product quantity.
    public void addInventory(int numAdd) {
        this.quantity += numAdd;
    }
}
