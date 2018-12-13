package br.ufpr.tads.agenda.db.dao.ansi;

import br.ufpr.tads.agenda.db.Conexao;
import java.sql.SQLException;

/**
 *
 * @author Dieval Guizelini
 */
public class BaseDAOImp {

    private java.util.Properties databaseProperties;

    protected java.sql.Connection conn = null;

    public void verificaConexao() throws SQLException {
        if (conn == null) {
            conn = Conexao.getConnection(getDatabaseProperties());
        }
    }

    public void setConnection(java.sql.Connection conn) {
        this.conn = conn;
    }

    public java.sql.Connection getConnection() throws SQLException {
        verificaConexao();
        return conn;
    }

    /**
     * @return the databaseProperties
     */
    public java.util.Properties getDatabaseProperties() {
        return databaseProperties;
    }

    /**
     * @param databaseProperties the databaseProperties to set
     */
    public void setDatabaseProperties(java.util.Properties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

}
