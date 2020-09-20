
package product.inventory;

import java.util.ArrayList;

/**
 *
 * @author 13055
 */
public class Database {
    
    ArrayList<Product> inventory;
    ArrayList<Product> removed;

    //Class constructor. Creates a database object made of two array lists: one for active inventory and another for deleted items.
    public Database() {
        inventory = new ArrayList<>();
        removed = new ArrayList<>();
    }
    
    //Method for adding a product to the active inventory array list.
    public void addProduct(Product p) {
        this.inventory.add(p);
    }
    
    public void removeProduct(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if(p.getName().equalsIgnoreCase(name)) {
                inventory.remove(p);
                removed.add(p);
            }
        }
    }
    
    public void getProductInfo(Product p) {
        for (int i = 0; i < inventory.size(); i++) {
            if (p.getName().equalsIgnoreCase(inventory.get(i).getName())) {
                Product a = inventory.get(i);
                System.out.println("Product information: " + a.getName() + ", " + a.getPrice() + ", Quantity: " + a.getQuantity());
            }
        }
    }
    
    public void printReport() {
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println("Product     Purchase Date     Quantity     Price     Manufacturer     State");
            System.out.println(p.getName() + "          " + "BLANK" + "         " + p.getQuantity() + "         " + p.getPrice() + "          " + p.getManufacturer().getName() + "         " + p.getManufacturer().getAddress().getState());
        }
    }
    
    public void printDeleted() {
        for (int i = 0; i < removed.size(); i++) {
            Product p = removed.get(i);
            System.out.println("Product     Date        Manufacturer");
            System.out.println(p.getName() + "          " + "BLANK" +  "          " + p.getManufacturer().getName());
        }
    }
}
