package br.ufpr.tads.agenda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dieval
 */
public final class Conexao {

    private static Conexao INSTANCE = null;

    private java.sql.Connection conn = null;

    private Conexao() {
    }

    public static synchronized Conexao getInstance() {
        if (INSTANCE == null) {
            synchronized (Conexao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Conexao();
                }
            }
        }
        return INSTANCE;
    }

    public java.sql.Connection getConnection() {
        if (this.conn == null) {
            java.sql.Connection c = null;
            try {
                Class.forName("org.h2.Driver");
                
                java.io.File atual = new java.io.File(".");
                java.io.File dadosDir = new java.io.File(atual,"dados/agenda");
                String url = String.format("jdbc:h2:file:%s", dadosDir.getAbsolutePath() );
//                c = DriverManager.getConnection("jdbc:h2:file:C:\\projetos\\aula\\AgendaJDBC\\dados\\agenda",
                //c = DriverManager.getConnection("jdbc:h2:file:C:\\projetos\\aulas\\AgendaJDBC\\dados\\agenda",
                //        "sa", "");
                c = DriverManager.getConnection(url, "sa", "");
                
                java.sql.Statement cmd = c.createStatement();
                cmd.execute("create sequence if not exists agendaseq start with 1;");
                cmd.execute("create table if not exists agenda (\n" +
"id int not null default next value for agendaseq,\n" +
"nome varchar(100) not null,\n" +
"telefone varchar(50) not null,\n" +
" primary key (id)\n" +
")\n" +
"");
                if (c != null) {
                    this.conn = c;
                    System.out.println("Conexao com BD aberta.");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public void close() {
        if (this.conn != null) {
            try {
                this.conn.close();
                this.conn = null;
                System.out.println("Conexao com BD fechada.");
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Connection getConnection(Properties databaseProperties) {
        return getInstance().getConnection();
    }

}
