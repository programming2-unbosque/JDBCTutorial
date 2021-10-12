package edu.unbosque.jdbctutorial.services;

import edu.unbosque.jdbctutorial.dtos.UserApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersService {

    // Objects for handling connection
    private Connection conn;

    public UsersService(Connection conn) {
        this.conn = conn;
    }

    public void listUsers() {

        // Objects for handling SQL statement
        Statement stmt = null;

        // Data structure to map results from database
        List<UserApp> userApps = new ArrayList<UserApp>();

        try {

            // Executing a SQL query
            System.out.println("=> Listing users...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM UserApp";
            ResultSet rs = stmt.executeQuery(sql);

            // Reading data from result set row by row
            while(rs.next()) {
                // Extracting row values by column name
                String email  = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                // Creating a new UserApp class instance and adding it to the array list
                userApps.add(new UserApp(email, password, role));
            }

            // Printing results
            System.out.println("Email | Password | Role");
            for (UserApp user : userApps) {
                System.out.print(user.getEmail() + " | ");
                System.out.print(user.getPassword() + " | ");
                System.out.println(user.getRole());
            }

            // Printing total rows
            System.out.println("Total of users retrieved: " + userApps.size() + "\n");

            // Closing resources
            rs.close();
            stmt.close();

        } catch(SQLException se) {
            se.printStackTrace(); // Handling errors from database
        } finally {
            // Cleaning-up environment
            try {
                if(stmt != null) stmt.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
