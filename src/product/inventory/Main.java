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
        Product p;
        Manufacturer manu = null;
        Address address;
        String proName, name, state, city, zip;
        
        System.out.println("Type product manufacturer name, state, city and zip: ");
        name = input.next();
        state = input.next();
        city = input.next();
        zip = input.next();
        
        address = new Address (state,city,zip);
        manu = new Manufacturer (address, name);
        System.out.println(manu.getAddress().getCity());
        
    }
    
}
