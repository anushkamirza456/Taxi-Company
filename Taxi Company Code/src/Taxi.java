/**
 * Model a Taxi.
 */

// Taxi inherits from Vehicle.
public class Taxi extends Vehicle {

    private String driver;
    private int pricePerJourney;

    /**
     * Constructor for objects of class Taxi.
     * @param id The taxi's ID.
     * @param driver The taxi's driver.
     * @param pricePerJourney The price per journey.
     */

    // initalise attributes.
    public Taxi(String id, String driver, int pricePerJourney)
    {
        super(id);
        this.driver = driver;
        this.pricePerJourney = pricePerJourney;
    }

    public String getDriver() {
        return driver;
    }

    public String toString()
    {
        // return in example format.
        return "Taxi" + " " + getId() + " " + "driven by" + " " + driver;
    }

    public int getTakings() {
        // use multiplication to find appropriate takings
        return  pricePerJourney * getBookings().size() ;
    }
}

