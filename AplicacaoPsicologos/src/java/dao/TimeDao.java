/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.HorarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class TimeDao {

    public static String adicionaAlteraTime(String startTime, String endTime, Integer beanID) {
        try {
            Connection conn = ConnectionFactoryLocal.getConnection();
            String insertQuery = "INSERT INTO horarioatendimento (interview_start_period, interview_end_period, foiefetuado, idpsicologo ) values (?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, startTime + ":00");
            stmt.setString(2, endTime + ":00");
            stmt.setBoolean(3, false);
            stmt.setInt(4, beanID);
            String msg = String.valueOf(stmt.executeUpdate());
            return (msg);

        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ("erro");
    }

    public static ArrayList<HorarioBean> puxaLista() {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select * from horarioatendimento where foiefetuado=false;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ArrayList<HorarioBean> listaHorarios = new ArrayList<HorarioBean>();

            while (rs.next()) {
                HorarioBean novo = new HorarioBean(rs.getInt("id"), rs.getString("interview_start_period"), rs.getString("interview_end_period"), rs.getBoolean("foiefetuado"), rs.getInt("idpsicologo"));
                listaHorarios.add(novo);
            }
            return(listaHorarios);
        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
}