// imports.
import java.util.Arrays;
import java.util.List;

/**
 * Model a shuttle on a circular route.
 */

// shuttle class inherits from vehicle.
public class Shuttle extends Vehicle
{
    private int pricePerStop;

    // Can store multiple string values.
    private String[] route;

    /**
     * Constructor for objects of class Shuttle.
     * @param id The shuttle's ID.
     * @param pricePerStop The price per stop.
     * @param route The route.
     */

    // Define specific attributes.
    public Shuttle(String id, int pricePerStop, String[] route)
    {
        super(id);
        this.pricePerStop = pricePerStop;
        this.route = route;

    }

    public int getTakings() {
        int totalStops = 0;
        List<String> routeAsList = Arrays.asList(route);

        for (Booking booking : getBookings()) {
            // search for the start and end location in index form.
            int pickupIndex = routeAsList.indexOf(booking.pickupLocation);
            int destinationIndex = routeAsList.indexOf(booking.destination);
            // use maths.abs to find specific value of number.
            int stops = Math.abs(destinationIndex - pickupIndex) + 1; // Calculate number of stops for journey.
            totalStops += stops;
        }
// Use multiplication to find appropritate stop price.
        return totalStops * pricePerStop;
    }


    //tostring method/
    public String toString() {
        return "Shuttle" + " " + getId() + " " + "has the route" + " " + Arrays.toString(route);
    }
}

