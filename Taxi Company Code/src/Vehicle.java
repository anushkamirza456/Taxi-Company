//imports.
import java.util.ArrayList;
import java.util.List;
/**
 * Model shared features of taxis and shuttles.
 */
public class Vehicle
{
    private ArrayList<Booking> bookings = new ArrayList<>();

    private String id;
    public Vehicle(String id)
    {
        this.id = id;
    }

public String getId()
{
    return id;
}

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    // creating bookings to be added.
    public void addBooking(Booking booking) {
        // when a booking is added, +1 is used to ensure array has the capacity so no error/overflow happens.
        bookings.ensureCapacity(bookings.size() + 1);
        bookings.add(booking);
    }
    /**
     * Return the daily takings for this vehicle.
     * @return The takings.
     */
    public int getTakings()
    {
        throw new RuntimeException("getTakings must be overridden");
    }

    /**
     * Return details of this vehicle.
     * @return A string representation of this vehicle.
     */
    public String getDetails()
    {
        return "getDetails must be overridden";
    }

}
