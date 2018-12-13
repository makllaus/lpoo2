/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import model.connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.BeansMedico;

/**
 *
 * @author tone
 */
public class DaoMedico {
   ConnectionBD conn = new ConnectionBD();
   BeansMedico modMed = new BeansMedico();
   
   public void salvar(BeansMedico modMed){
       conn.connect();
       
       try {
           PreparedStatement pst = conn.conn.prepareStatement("insert into medico (nome,especialidade,crm) values(?,?,?)");
           pst.setString(1, modMed.getNome());
           pst.setString(2, modMed.getEspecialidade());
           pst.setInt(3, modMed.getCrm());
           pst.execute();
           System.out.println("dados inseridos com sucesso");
       } catch (SQLException ex) {
           System.out.println("dados não inseridos \nerro: "+ex.getMessage());
           Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public void editar(BeansMedico mod){
       conn.connect();
       try { 
           PreparedStatement pst = conn.conn.prepareStatement("update medico set nome=?, especialidade=?, crm=? where cod=?");
           pst.setString(1, mod.getNome());
           pst.setString(2, mod.getEspecialidade());
           pst.setInt(3, mod.getCrm());
           pst.setInt(4, mod.getCod());
           pst.execute();
           System.out.println("dados alterados com sucesso");
       } catch (SQLException ex) {
           System.out.println("Dados não atualizados \nerro: "+ex.getMessage());
           Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public void excluir(BeansMedico mod){
       conn.connect();
       try {
           PreparedStatement pst = conn.conn.prepareStatement("delete from medico where cod=?");
           pst.setInt(1, mod.getCod());
           pst.execute();
       } catch (SQLException ex) {
           System.out.println("Erro ao excluir \nerro: "+ex.getMessage());
           Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       conn.desconnect();
   }
   
   public BeansMedico buscaMedico(BeansMedico mod){
       conn.connect();
       conn.executeSql("select * from medico where nome like'%"+mod.getPesquisa()+"%'");
       try {
           conn.rs.first();
           mod.setCod(conn.rs.getInt("cod"));
           mod.setNome(conn.rs.getString("nome"));
           mod.setEspecialidade(conn.rs.getString("especialidade"));
           mod.setCrm(conn.rs.getInt("crm"));
       } catch (SQLException ex) {
           Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Medico não encontrado!");
       }
       conn.desconnect();
       return mod;
   }
   
}
