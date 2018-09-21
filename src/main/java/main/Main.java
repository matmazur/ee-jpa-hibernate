package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) {



        String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String password = "pass";

        System.out.println("Connecting to the DB + " + jdbcUrl);

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
// THIS ABOVE WORKS CORRECLTY  -  CONNECTION TO THE DB IS PROPER


    }
}
