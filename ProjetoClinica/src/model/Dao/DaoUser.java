/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.BeansUser;
import model.connection.ConnectionBD;

/**
 *
 * @author tone
 */
public class DaoUser {
    ConnectionBD conn = new ConnectionBD();
   BeansUser modUser = new BeansUser();
   
   public void salvar(BeansUser modUser){
       conn.connect();
       
       try {
           PreparedStatement pst = conn.conn.prepareStatement("insert into usuarios (user_name,pass,tipo) values(?,?,?)");
           pst.setString(1, modUser.getUsername());
           pst.setString(2, modUser.getPassword());
           pst.setString(3, modUser.getTipo());
           pst.execute();
           System.out.println("dados inseridos com sucesso");
       } catch (SQLException ex) {
           System.out.println("dados não inseridos \nerro: "+ex.getMessage());
           Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public void editar(BeansUser mod){
       conn.connect();
       try { 
           PreparedStatement pst = conn.conn.prepareStatement("update usuarios set user_name=?, pass=?, tipo=? where cod=?");
           pst.setString(1, mod.getUsername());
           pst.setString(2, mod.getPassword());
           pst.setString(3, mod.getTipo());
           pst.setInt(4, mod.getCod());
           pst.execute();
           System.out.println("dados alterados com sucesso");
       } catch (SQLException ex) {
           System.out.println("Dados não atualizados \nerro: "+ex.getMessage());
           Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public void excluir(BeansUser mod){
       conn.connect();
       try {
           PreparedStatement pst = conn.conn.prepareStatement("delete from usuarios where cod=?");
           pst.setInt(1, mod.getCod());
           pst.execute();
       } catch (SQLException ex) {
           System.out.println("Erro ao excluir \nerro: "+ex.getMessage());
           Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public BeansUser buscaUser(BeansUser mod){
       conn.connect();
       conn.executeSql("select * from usuarios where user_name like'%"+mod.getPesquisa()+"%'");
       try {
           conn.rs.first();
           mod.setCod(conn.rs.getInt("cod"));
           mod.setUsername(conn.rs.getString("user_name"));
           mod.setTipo(conn.rs.getString("tipo"));
       } catch (SQLException ex) {
           Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
       }
       conn.desconnect();
       return mod;
   }
}
