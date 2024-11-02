public class Booking {
    public String vehicleId;
    public String pickupLocation;
    public String destination;

    // create a consructor.
    public Booking(String vehicleId, String pickupLocation, String destination) {
        this.vehicleId = vehicleId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
    }

    // created so that code in taxi/shuttle would run.
    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    // override method + return concatenation.
    public String toString() {
        return vehicleId + "," + pickupLocation + "," + destination;
    }
}
