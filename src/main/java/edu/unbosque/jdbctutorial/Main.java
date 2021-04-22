package edu.unbosque.jdbctutorial;

import java.util.*;
import java.sql.*;

import edu.unbosque.jdbctutorial.pojos.Customer;
import edu.unbosque.jdbctutorial.pojos.Film;

public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://35.192.11.12/dvdrental";

    // Database credentials
    static final String USER = "postgres";
    static final String PASS = "O6ifkko09h4Gq7jd";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        List<Customer> customers = new ArrayList<Customer>();
        List<Film> films = new ArrayList<Film>();

        try {

            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT film_id, title, description, name AS language FROM film LEFT JOIN language ON film.language_id = language.language_id";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()) {

                //Retrieve by column name
                int filmId  = rs.getInt("film_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String language = rs.getString("language");

                //Display values
                System.out.print("Film ID: " + filmId);
                System.out.print(", title: " + title);
                System.out.println(", description: " + description);
                System.out.println(", Language: " + language);

                films.add(new Film(filmId, title, description, language));

            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(ClassNotFoundException e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {

            // Clean-up environment

            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }

        }

        System.out.println("Films retrieved: " + films.size());

    }

}
