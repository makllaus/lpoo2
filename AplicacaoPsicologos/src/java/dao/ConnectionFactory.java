/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://ec2-184-72-248-8.compute-1.amazonaws.com:5432/d5jektna3sd4ne";
    private static final String USER = "lylsyjkljjoydd";
    private static final String PASS = "02dc17765d96983142b3491c110b61373971c0391d9968b1e9eea7de06515fd1";
    
    public static Connection getConnection() {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
