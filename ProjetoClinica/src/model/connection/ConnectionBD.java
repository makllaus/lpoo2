package model.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionBD {

    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/projetoClinica";
    private String user = "dba";
    private String psw = "";
    public Connection conn;
    
    public void connect(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            conn = DriverManager.getConnection(caminho,user,psw);
            System.out.println("conectado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco de dados\n erro: "+ ex.getMessage());
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void desconnect(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao desconectar do banco de dados\n erro: "+ ex.getMessage());
        }
    }
    
    public void executeSql(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[executeSQL()]Erro ao executar SQL no banco de dados\n erro: "+ ex.getMessage());
        }
    }
}
