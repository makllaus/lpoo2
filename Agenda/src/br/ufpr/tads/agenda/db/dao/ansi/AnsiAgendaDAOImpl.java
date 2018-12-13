package br.ufpr.tads.agenda.db.dao.ansi;

import br.ufpr.tads.agenda.db.dao.AgendaDAO;
import br.ufpr.tads.agenda.db.JDBCUtils;
import br.ufpr.tads.agenda.db.vo.AgendaVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dieval
 */
public class AnsiAgendaDAOImpl extends BaseDAOImp implements AgendaDAO {

    private static final Logger log = Logger.getLogger(AnsiAgendaDAOImpl.class.getCanonicalName());

    public AnsiAgendaDAOImpl() {
        super();
    }

    public AnsiAgendaDAOImpl(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(AgendaVO vo) {
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "insert into agenda (id,nome,telefone) "
                + " values (?,?,?)";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, getMax()+1);
            ps.setString(2, vo.getNome());
            ps.setString(3, vo.getTelefone());
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
    
    private int getMax() {
        int result = 0;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select max(id) from agenda";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }

    @Override
    public void edit(AgendaVO vo) {
        //if (vo.getID() == null) {
        if (vo.getID() < 1) {
            log.warning("update ignored (not id defined) ");
            return;
        }
        java.sql.PreparedStatement ps = null;
        String sql = "update agenda set nome=?,telefone=? "
                + " where id = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNome());
            ps.setString(2, vo.getTelefone());
            ps.setInt(3, vo.getID());
            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not updated.");
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }
    }

    @Override
    public void destroy(Integer id) {
        java.sql.PreparedStatement ps = null;
        String sql = "delete from agenda where id = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not deleted.");
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }
    }

    @Override
    public void destroy(AgendaVO value) {
        destroy( value.getID() );
    }

    @Override
    public List<AgendaVO> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<AgendaVO> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<AgendaVO> findEntities(boolean all, int maxResults, int firstResult) {
        List<AgendaVO> result = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        try {
            verificaConexao();
            ps = conn.prepareStatement("select id,nome,telefone "
                    + " from agenda order by nome");
            rs = ps.executeQuery();
            if (rs.next()) {
                result = new java.util.ArrayList<AgendaVO>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                    AgendaVO vo = new AgendaVO();
                    vo.setID(rs.getInt(1));
                    vo.setNome(rs.getString(2));
                    vo.setTelefone(rs.getString(3));
                    result.add(vo);
                } while ((result.size() < maxResults || all) && rs.next());
            }

        } catch (java.sql.SQLException ex) {
            log.log(Level.SEVERE,"",ex);
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }

    @Override
    public AgendaVO find(Integer id) {
        AgendaVO vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select id,nome,telefone "
                + " from agenda where id = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                vo = new AgendaVO();
                vo.setID(rs.getInt(1));
                vo.setNome(rs.getString(2));
                vo.setTelefone(rs.getString(3));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return vo;
    }

    @Override
    public int getCount() {
        int result = 0;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select count(1) from agenda";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
             log.log(Level.SEVERE,"",ex);
           //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }

    @Override
    public List<AgendaVO> findByName(String nome) {
        List<AgendaVO> result = null;
        AgendaVO vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select id,nome,telefone "
                + " from agenda where nome like ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, String.format("%%%s%%", nome) );
            rs = ps.executeQuery();
            System.out.println( ps.toString() );
            while(rs.next()) {
                vo = new AgendaVO();
                vo.setID(rs.getInt(1));
                vo.setNome(rs.getString(2));
                vo.setTelefone(rs.getString(3));
                if( result == null ) {
                    result = new ArrayList<AgendaVO>();
                }
                result.add(vo);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE,"",ex);
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }

    @Override
    public List<AgendaVO> findByPhone(String fone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
