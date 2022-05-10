package edu.unbosque.jdbctutorial.services;

import java.sql.*;

public class PetsService {

    // Objects for handling connection
    private Connection conn;

    public PetsService(Connection conn) {
        this.conn = conn;
    }

    public void countBySpecies(String species) {
        // Object for handling SQL statement
        PreparedStatement stmt = null;

        try {

            // Executing a SQL query
            System.out.println("=> Counting pets by species...");
            stmt = this.conn.prepareStatement("SELECT COUNT(*) AS num_pets FROM Pet WHERE species = ?");
            stmt.setString(1, species);
            ResultSet rs = stmt.executeQuery();

            // Pointing to fist row
            rs.next();

            // Printing results
            System.out.println("Total of " + species + "s: " + rs.getInt("num_pets") + "\n");

            // Closing resources
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace(); // Handling errors from database
        } finally {
            // Cleaning-up environment
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
