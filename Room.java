package struct;

public class Room {
    private int id;
    private String customerName;
    private boolean booked;

    public Room(int id, String customerName, boolean booked) {
        this.id = id;
        this.customerName = customerName;
        this.booked = booked;
    }

    public Room(int id) {
        this(id, null, false);
    }

    // Getters and setters
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public boolean isBooked() { return booked; }
    public void setCustomerName(String name) { this.customerName = name; }
    public void setBooked(boolean booked) { this.booked = booked; }
}
