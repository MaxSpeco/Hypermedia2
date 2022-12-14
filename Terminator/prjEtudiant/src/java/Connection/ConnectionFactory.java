/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glyder319
 */
public class ConnectionFactory {
    private static Connection connection = null;

    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/courspdb";
    public static final String USER = "sys as sysdba";
    public static final String PASS = "Welcome1";

    public static Connection getConnection()  {
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
       } 
       catch (ClassNotFoundException ex) {
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        }
       catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
}
