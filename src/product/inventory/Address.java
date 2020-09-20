package product.inventory;

//Class for Manufacturer's company address. This class contains 3 fields: state, city and zip code.

public class Address {
    
    //Declaration of private fields for the address' state, city and zip.
    private String state;
    private String city;
    private String zip;

    //Class constructor
    public Address(String state, String city, String zip) {
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    //Getter that returns address state.
    public String getState() {
        return state;
    }

    //Gtter that returns address city.
    public String getCity() {
        return city;
    }

    //Getter that returns address zip code.
    public String getZip() {
        return zip;
    }

    //Setter for modifying address state.
    public void setState(String state) {
        this.state = state;
    }

    //Setter for modifying address city.
    public void setCity(String city) {
        this.city = city;
    }

    //Setter for modifying address zip code.
    public void setZip(String zip) {
        this.zip = zip;
    }

}
