package edu.unbosque.jdbctutorial.services;

import edu.unbosque.jdbctutorial.dtos.UserApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetsService {

    // Objects for handling connection
    private Connection conn;

    public PetsService(Connection conn) {
        this.conn = conn;
    }

    public void countBySpecies(String species) {

        // Objects for handling SQL statement
        Statement stmt = null;

        try {

            // Executing a SQL query
            System.out.println("=> Counting pets by species...");
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) AS count FROM Pet WHERE species = '" + species + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Pointing to fist row
            rs.next();

            // Printing results
            System.out.println("Total of pets by species: " + rs.getInt("count") + "\n");

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
