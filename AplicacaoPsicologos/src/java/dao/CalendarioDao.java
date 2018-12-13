/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CalendarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalendarioDao {

    public static ArrayList<CalendarioBean> pegaLista() {
        try {
            Connection conn = ConnectionFactory.getConnection();
            String query = "select * from interviews";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ArrayList<CalendarioBean> listaCalendario = new ArrayList<CalendarioBean>();
            try {
                while (rs.next()) {
                    CalendarioBean novo = new CalendarioBean();
                    novo.setId(rs.getInt("id"));
                    
                    novo.setVideo(rs.getString("video"));
                    novo.setDescription(rs.getString("description"));
                    novo.setScore(rs.getString("score"));
                    novo.setStart_time(rs.getString("start_time"));
                    novo.setStatus(rs.getInt("status"));
                    novo.setPackageId(rs.getInt("package_id"));
                    novo.setPsychologistId(rs.getInt("psychologist_id"));
                    novo.setClientId(rs.getInt("client_id"));
                    novo.setPackageDesc("Ainda nao 1");
                    novo.setPsychologistDesc("Ainda nao 2");
                    novo.setPsychologistDesc("Ainda nao 3");
                    listaCalendario.add(novo);
                }
                return(listaCalendario);
            } catch (SQLException ex) {
                Logger.getLogger(CalendarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalendarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
