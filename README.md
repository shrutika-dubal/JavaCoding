**✅ Features**

1.View All Rooms – Lists all rooms with their status (available/booked).
2.Book Room – Allows a user to book a room by entering ID and name.
3.Checkout Room – Frees up a room by clearing booking info.
4.Database Integration – Room status is saved and retrieved from MySQL.
5.Simple Menu-Driven UI – Console-based interactive interface.

**🧰 Technologies Used**

| Technology         | Usage                                             |
| ------------------ | ------------------------------------------------- |
| **Java (OOP)**     | Core structure (`Room`, `RoomDAO`, encapsulation) |
| **JDBC**           | Database access for CRUD operations               |
| **MySQL**          | Stores room and customer data                     |
| **Scanner (Java)** | User input handling in CLI                        |
| **DAO Pattern**    | Separates database logic from main application    |



**📦 Dependencies
<dependency>
          <groupId>org.postgresql</groupId>
          <artifactId>postgresql</artifactId>
          <version>42.7.1</version>
      </dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version> <!-- or latest -->
</dependency>

**Database Setup Required:

CREATE DATABASE hotel_db;
USE hotel_db;
CREATE TABLE rooms (
    id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    booked BOOLEAN
);

-- Add initial data
INSERT INTO rooms (id, customer_name, booked) VALUES 
(101, NULL, 0),
(102, NULL, 0),
(103, NULL, 0);


📁 Project Structure (Package-wise)

HotelManagement/
├── src/
│   ├── model/
│   │   └── Room.java
│   ├── room/
│   │   └── RoomDAO.java
│   └── app/
│       └── HotelApp.java
└── lib/
    └── (place your JDBC driver jar, e.g. mysql-connector-java.jar)

    
**Developer info:**
Name: shrutika dubal, Aditi patil, Ankita kamble
E-mail:shrutikadubal8@gmail.com , aduu.patil@gmail.com, ankitakamble154@gmail.com
Git-Hub name: shrutika-dubal


