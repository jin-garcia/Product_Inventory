/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.inventory;

import java.util.Scanner;

/**
 *
 * @author 13055
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database db = new Database();
        Product p = null;
        Manufacturer manu = null;
        Address address;
        String proName, name, state, city, zip;
        double price;
        int quantity;
        
        System.out.println("Type product manufacturer name, state, city and zip: ");
        name = input.next();
        state = input.next();
        city = input.next();
        zip = input.next();
        
        address = new Address (state,city,zip);
        manu = new Manufacturer (address, name);
        System.out.println(manu.getAddress().getCity());
        
        System.out.println("Type product Name, price and quantity: ");
        proName = input.next();
        price = input.nextDouble();
        quantity = input.nextInt();
        input.nextLine();
        
        p = new Product(proName, price, manu, quantity);
        
        db.addProduct(p);
        
        db.printReport();
        
        System.out.println("Product name to remove: ");
        String delete = input.next();
        db.removeProduct(delete);
        
        db.printDeleted();
        
    }
    
}
