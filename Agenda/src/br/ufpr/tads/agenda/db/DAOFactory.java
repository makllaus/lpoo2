package br.ufpr.tads.agenda.db;

import br.ufpr.tads.agenda.db.dao.AgendaDAO;
import br.ufpr.tads.agenda.db.dao.ansi.DAOStandardFactory;
import br.ufpr.tads.agenda.db.dao.h2.DAOH2Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dieval
 */
public abstract class DAOFactory {

    private static final Logger log = Logger.getLogger(DAOFactory.class.getCanonicalName());
    private static DAOFactory INSTANCE = null;
    protected java.sql.Connection conn = null;

    public final static int DB_ANSI_IMPL = 1;
    //public final static int DB_MYSQL_IMPL = 2;
    //public final static int DB_PGSQL_IMPL = 3;
    //public final static int DB_ORACLE_IMPL = 4;
    //public final static int DB_JAVADB_IMPL = 5;
    public final static int DB_H2_IMPL = 6;

    protected DAOFactory() {
        this.conn = Conexao.getInstance().getConnection();
    }

    public synchronized static DAOFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = createInstance(DB_H2_IMPL);
        }
        return INSTANCE;
    }

    public static DAOFactory createInstance(int banco) {
        switch (banco) {
            /*case DB_MYSQL_IMPL:
                INSTANCE = new DAOMySQLFactory();
                break;
            case DB_PGSQL_IMPL:
            case DB_ORACLE_IMPL:
                INSTANCE = new DAOOracleFactory();
                break;*/
            case DB_H2_IMPL:
                INSTANCE = new DAOH2Factory();
                break;
            /*            case DB_JAVADB_IMPL:
                log.warn("Solução de BD não implementada... utilizando o padrão ansi");
                INSTANCE = new DAOStandardFactory();
                break;*/
            default:
                log.log(Level.WARNING, "Solução de BD não implementada... utilizando o padrão ansi");
                INSTANCE = new DAOStandardFactory();
                break;
        }
        return INSTANCE;
    }

    public AgendaDAO getAgendaDAO() {
        return getAgendaDAOImpl();
    }

    protected abstract AgendaDAO getAgendaDAOImpl();
}
