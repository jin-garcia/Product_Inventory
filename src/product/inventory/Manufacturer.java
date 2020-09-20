package product.inventory;

//Manufacturer class that is made up of only 2 elements: the company's name and address.

public class Manufacturer {
    //Declaration of private fields for company name and address.
    private Address address;
    private String Name;

    public Manufacturer(Address compAdd, String compName) {
        this.address = compAdd;
        this.Name = compName;
    }

    //Getter that returns company address.
    public Address getAddress() {
        return address;
    }

    //Getter that returns company name.
    public String getName() {
        return Name;
    }

    //Setter for modifying company address.
    public void setAddress(Address address) {
        this.address = address;
    }

    //Setter for modifying company name.
    public void setName(String Name) {
        this.Name = Name;
    }

}
