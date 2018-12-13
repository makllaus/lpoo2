package br.ufpr.tads.agenda.db.dao.h2;

import br.ufpr.tads.agenda.db.JDBCUtils;
import br.ufpr.tads.agenda.db.dao.AgendaDAO;
import br.ufpr.tads.agenda.db.dao.ansi.AnsiAgendaDAOImpl;
import br.ufpr.tads.agenda.db.vo.AgendaVO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dieval Guizelini
 */
public class H2AgendaDAOImpl extends AnsiAgendaDAOImpl implements AgendaDAO {

    private static final Logger log = Logger.getLogger(H2AgendaDAOImpl.class.getCanonicalName());

    public H2AgendaDAOImpl() {
        super();
    }

    public H2AgendaDAOImpl(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(AgendaVO vo) {
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "insert into agenda (nome,telefone) "
                + " values (?,?)";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNome());
            ps.setString(2, vo.getTelefone());
            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not inserted.");
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    vo.setID(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
        } finally {
            JDBCUtils.close(ps);
        }
    }
}