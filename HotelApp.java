package app;

import struct.Room;
import room.RoomDAO;

import java.util.*;

public class HotelApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            RoomDAO dao = new RoomDAO();
            int choice;
            do {
                System.out.println("\n--- Hotel Menu ---");
                System.out.println("1. View All Rooms");
                System.out.println("2. Book Room");
                System.out.println("3. Checkout Room");
                System.out.println("4. Exit");
                System.out.print("Choice: ");
                choice = sc.nextInt(); sc.nextLine();

                switch (choice) {
                    case 1:
                        List<Room> rooms = dao.getAllRooms();
                        rooms.forEach(r -> System.out.printf("Room %d - %s\n", r.getId(),
                            r.isBooked() ? ("Booked by " + r.getCustomerName()) : "Available"));
                        break;
                    case 2:
                        System.out.print("Room ID to book: ");
                        int bId = sc.nextInt(); sc.nextLine();
                        System.out.print("Customer name: ");
                        String name = sc.nextLine();
                        System.out.println(dao.bookRoom(bId, name) ? "Booked!" : "Failed.");
                        break;
                    case 3:
                        System.out.print("Room ID to checkout: ");
                        int cId = sc.nextInt();
                        System.out.println(dao.checkoutRoom(cId) ? "Checked out!" : "Failed.");
                        break;
                    case 4:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 4);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
