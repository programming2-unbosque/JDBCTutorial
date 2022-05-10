package edu.unbosque.jdbctutorial.services;

import edu.unbosque.jdbctutorial.dtos.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnersService {

    // Objects for handling connection
    private Connection conn;

    public OwnersService(Connection conn) {
        this.conn = conn;
    }

    public void updateOwner(Owner owner) {
        // Object for handling SQL statement
        PreparedStatement stmt = null;

        try {

            // Executing a SQL query
            System.out.println("=> Updating owner...");
            stmt = this.conn.prepareStatement("UPDATE Owner SET fullName = ? WHERE idNumber = ?");
            stmt.setString(1, owner.getFullName());
            stmt.setInt(2, owner.getIdNumer());
            int rowsUpdated = stmt.executeUpdate(); // executeUpdate is also used for inserting records

            // Printing results
            System.out.println("Rows updated: " + rowsUpdated + "\n");

            // Closing resources
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
