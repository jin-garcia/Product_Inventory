
package product.inventory;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//class for product database. Here we have methods for creating a database object and modifying/printing data about products.
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
            else {
                JOptionPane.showMessageDialog(null, "Product not found - check inventory list.");
            }
        }
    }
    
    public void getProductInfo(String p) {
        for (int i = 0; i < inventory.size(); i++) {
            if (p.equalsIgnoreCase(inventory.get(i).getName())) {
                Product a = inventory.get(i);
                JOptionPane.showMessageDialog(null, "Product information: " + "\n" + a.getName() + ", " + "$" + a.getPrice() + ", Quantity: " + a.getQuantity());
            }
        }
    }
    
    
}
