// imports.
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.HashMap;

public class TaxiCompany
{
    private HashMap<String, Vehicle> vehicles;
    public TaxiCompany()
    {
        vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle aVehicle)
    {
        vehicles.put(aVehicle.getId(), aVehicle);
    }


    public void listAllVehicles()
    {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(vehicle);
        }
    }

    public void listAllBookings()
    {
        // Iterate on each data item in the hashmap.
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println("Vehicle ID:" + " " + vehicle.getId());

            // now iterate on the booking linked with the previous data.
            for (Booking booking : vehicle.getBookings()) {
                System.out.println(booking);
            }
        }
    }

    public int getVehicleTakings(String id) {
        Vehicle vehicle = vehicles.get(id); // Find veichle using ID.
        if (vehicle != null) {
            return vehicle.getTakings();
        } else {
            return -1; // if the veichle id doesn't exist, -1 is returned to show it is not exisiting in database.
        }
    }


    /**
     * Read the bookings from the given file.
     * @param bookingsFilename The name of the file containing the bookings.
     * @throws IOException If there is an error reading the file.
     */
    public void readBookings(String bookingsFilename)
            throws IOException
    {
        Path filePath = Paths.get(bookingsFilename);
        List<String> lines = Files.readAllLines(filePath);
        for(String bookingDetails : lines) {
            bookingDetails = bookingDetails.trim();
            String[] parts = bookingDetails.split(",");
            String id = parts[0];
            String pickupLocation = parts[1];
            String destination = parts[2];
            Booking booking = new Booking(id, pickupLocation, destination); // booking object created.
            Vehicle vehicle = vehicles.get(id); // get specific veichle in hashmap.
            if (vehicle != null) {
                vehicle.addBooking(booking); //add booking to list.
        }
        }
    }

    /**
     * Write a report of all of the vehicles.
     * @param reportFilename The name of the file to write the report to.
     * @throws IOException If there is an error writing the file.
     */
    public void writeReport(String reportFilename)
        throws IOException
    {
        FileWriter writer = new FileWriter(reportFilename);
        writer.write("Taxi Company Report\n");
        // everytime it is run, takings cannot have a value in it already.
        int totalTakings = 0;

        for (Vehicle vehicle : vehicles.values()) {
            int takings = vehicle.getTakings();
            String vehicleType = (vehicle instanceof Taxi) ? "Taxi" : "Shuttle";
            String driverInfo = (vehicle instanceof Taxi) ? "driven by" + " " + ((Taxi) vehicle).getDriver() : " ";
            String journeyWord = (vehicle.getBookings().size() == 1) ? "journey" : "journeys";
            String takingsInfo = "had" + " " + vehicle.getBookings().size() + " " + journeyWord + " " + "and made £" + takings;

            writer.write(vehicleType + " " + vehicle.getId() + " " + driverInfo + " " + takingsInfo + "\n");

            totalTakings = takings;
        }

        // output the total for part 5.
        writer.write(String.format("Total takings for the day £%d\n", totalTakings));

        // close so the system can output it.
        writer.close();


        writer.close();
    }

}
