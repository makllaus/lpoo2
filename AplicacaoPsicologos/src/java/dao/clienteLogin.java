/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class clienteLogin {
    // NETO: Tem que fazer bater password com a coluna 'encrypted_password'

    public static boolean loginNpassMatch(String login, String password) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select * from users where email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            return (rs.next());
        } catch (SQLException ex) {

            return false;
        }
    }

    public static boolean kindEqual(String login, Integer kind) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select kind from users where email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            Integer tipoRetornado;
            if (rs.next()) {
                tipoRetornado = rs.getInt("kind");
                if (tipoRetornado == 2) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(clienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public static Integer idDoLogin(String login) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select id from users where email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            Integer idRetornado;
            if (rs.next()) {
                idRetornado = rs.getInt("id");
                return (idRetornado);
            } else {
                return (-1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(clienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }

    public static String nomeDoID(Integer id) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select name from psychologists where user_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String nomeRetornado;
            if (rs.next()) {
                nomeRetornado = rs.getString("name");
                return (nomeRetornado);
            } else {
                return (null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(clienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String getStartById(Integer id) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select interview_start_period from psychologists where user_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String startRetornado;
            if (rs.next()) {
                startRetornado = rs.getString("interview_start_period");
                return(startRetornado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(clienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    
    public static String getEndById(Integer id) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select interview_end_period from psychologists where user_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String endRetornado;
            if (rs.next()) {
                endRetornado = rs.getString("interview_end_period");
                return(endRetornado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(clienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

}
