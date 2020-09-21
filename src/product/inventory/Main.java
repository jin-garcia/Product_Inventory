
package product.inventory;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.ArrayList;

public class Main {

 
    public static void main(String[] args) {
        Database db = new Database();
        boolean done = false;
        
        //While loop for our menu
        while (!done) {
            int menu = GetData.getInt("\tWelcome to our Product Inventory. Please choose from the following list of options: \n" + "\t" + "\n1. Add a new product." + "\n2. Remove an existing product from the active inventory. " +
                    "\n3. Search for product info" + "\n4. Print active inventory report." + "\n5. Print inactive inventory report." + "\n6. Modify product info." + "\n7. Enter a sale." + "\nInput the number that represents your selection." + "\n");
                   
        
            switch(menu) {
            
                case 1: //Add a new product. This selection takes input for product mannufacturer's company name and address info, and product name, price and quantity. It creates a new Address object which it then uses to create an object for manufacturer.
                    String manuName = JOptionPane.showInputDialog("Enter name of product manufacturer: " + "\n");
                    String city = JOptionPane.showInputDialog("Enter manufacturer's city: " + "\n");
                    String state = JOptionPane.showInputDialog("Enter manufacturer's state: " + "\n");
                    String zip = JOptionPane.showInputDialog("Enter manufacturer's zip: " + "\n");
                    
                    Address address = new Address (state,city,zip);
                    Manufacturer manu = new Manufacturer (address,manuName);
                    
                    String name = JOptionPane.showInputDialog("Enter product name: " + "\n");
                    double price = GetData.getDouble("Enter product price: " + "\n");
                    int quantity = GetData.getInt("Enter product quantity: " + "\n");
                    
                    Product p = new Product(name, price, manu, quantity);
                    db.addProduct(p);
 
                    break;
                    
                case 2: //Remove products from inventory database. This option takes the name of the product as input and passes that to the removeProduct function which then adds it to the deleted items database.
                    String delete = JOptionPane.showInputDialog("Enter name of product to be removed: " + "\n");
                    db.removeProduct(delete);
                    JOptionPane.showMessageDialog(null, "Item has been removed from the active inventory." + "\n");
                    break;
                  
                case 3: //Look up and print product info.
                    String productName = JOptionPane.showInputDialog("Enter product name: " + "\n");
                    db.getProductInfo(productName);
                    break;
                    
                case 4: //Print out active product inventory.    
                    String a = "";
                    for (int i = 0; i < db.inventory.size(); i++) {
                        Product r = db.inventory.get(i);
                        a += (r.getName() + "          " +  r.getQuantity() + "         " + r.getPrice() + "          " + r.getManufacturer().getName() + "         " + r.getManufacturer().getAddress().getState() + "\n");
                    }
                    display(a, "          Name     Quantity    Price     Manufacturer     State", JOptionPane.INFORMATION_MESSAGE);
                    break;
                   
                case 5: //Print deleted products report.
                    String r = "";
                    for (int i = 0; i < db.removed.size(); i++) {
                        Product h = db.removed.get(i);
                        r += (h.getName() + "          " + h.getManufacturer().getAddress().getState() +  "          " + h.getManufacturer().getName() + "\n");
                    }
                    display(r, "          Name     State     Manufacturer     ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
                case 6: //Modify product info.
                    int input =  GetData.getInt("1. Type 1 to modify product price." + "\n" + "2. Type 2 to modify product quantity. \n" );
                    if (input ==  1) {
                        String n = JOptionPane.showInputDialog("Enter product name: ");
                       for (int i = 0; i < db.inventory.size(); i++) {
                            if (n.equalsIgnoreCase(db.inventory.get(i).getName())) {
                            Product m = db.inventory.get(i);
                            
                           double b = GetData.getDouble("Enter new product price: ");
                             
                             m.setPrice(b);
                             JOptionPane.showMessageDialog(null, "Item price has been modified." + "\n");
                             break;
                             }
                            else {
                                JOptionPane.showMessageDialog(null, "Product not found - check inventory list." + "\n");
                            }
                         }  
                     }
                     else if(input == 2){
                         String y = JOptionPane.showInputDialog("Enter product name: ");
                         for (int i = 0; i < db.inventory.size(); i++) {
                             if (y.equalsIgnoreCase(db.inventory.get(i).getName())) {
                             Product m = db.inventory.get(i);
                             
                             int b = GetData.getInt("Enter new product quantity: ");
                             
                             m.setQuantity(b);
                             JOptionPane.showMessageDialog(null, "Item quantity has been modified." + "\n");
                             
                             }
                             else {
                                JOptionPane.showMessageDialog(null, "Product not found - check inventory list." + "\n");
                            }
                        }
                    }
                    break;
                case 7: //Enter a sale which modifies quantity of product entered.
                    String sale = JOptionPane.showInputDialog("Enter product name." + "\n");
                    for (int i = 0; i < db.inventory.size(); i++) {
                             if (sale.equalsIgnoreCase(db.inventory.get(i).getName())) {
                             Product o = db.inventory.get(i);
                             
                             int c = GetData.getInt("Enter units sold: ");
                             int q = o.getQuantity();
                             q -= c;
                             
                             o.setQuantity(q);
                             JOptionPane.showMessageDialog(null, "Inventory has been updated." + "\n");
                            }
                    }
            }

        }
    }
 
        public static void display(String s, String heading, int MESSAGE_TYPE) {
            JTextArea text = new JTextArea(s,20,30);
            JScrollPane pane = new JScrollPane(text);
            JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
        }
}
