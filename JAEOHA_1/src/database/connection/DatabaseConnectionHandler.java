/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abanoub samy
 */
public class DatabaseConnectionHandler {

    private static String userName = "abanoub";
    private static String password = "smsm12";
    private static String con = "jdbc:mysql://localhost/chat_database";
    private static Connection databaseconnection = null;
   

    public static Connection getConnection() {

        try {
            databaseconnection = DriverManager.getConnection(con, userName, password);
            System.out.println(" Database connected");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connection failure");
        }

        return databaseconnection;

    }

}
