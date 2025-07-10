package room;

import struct.Room;
import java.sql.*;
import java.util.*;

public class RoomDAO {
    private Connection conn;

    public RoomDAO() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel_db", "your_user", "your_password");
    }

    // List all rooms
    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT id, customer_name, booked FROM rooms";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rooms.add(new Room(rs.getInt("id"), rs.getString("customer_name"), rs.getBoolean("booked")));
            }
        }
        return rooms;
    }

    // Book a room
    public boolean bookRoom(int id, String customer) throws SQLException {
        String check = "SELECT booked FROM rooms WHERE id=?";
        try (PreparedStatement p = conn.prepareStatement(check)) {
            p.setInt(1, id);
            try (ResultSet rs = p.executeQuery()) {
                if (!rs.next() || rs.getBoolean("booked")) return false;
            }
        }

        String upd = "UPDATE rooms SET customer_name=?, booked=1 WHERE id=?";
        try (PreparedStatement p = conn.prepareStatement(upd)) {
            p.setString(1, customer);
            p.setInt(2, id);
            return p.executeUpdate() > 0;
        }
    }

    // Checkout a room
    public boolean checkoutRoom(int id) throws SQLException {
        String check = "SELECT booked FROM rooms WHERE id=?";
        try (PreparedStatement p = conn.prepareStatement(check)) {
            p.setInt(1, id);
            try (ResultSet rs = p.executeQuery()) {
                if (!rs.next() || !rs.getBoolean("booked")) return false;
            }
        }

        String upd = "UPDATE rooms SET customer_name=NULL, booked=0 WHERE id=?";
        try (PreparedStatement p = conn.prepareStatement(upd)) {
            p.setInt(1, id);
            return p.executeUpdate() > 0;
        }
    }
}
