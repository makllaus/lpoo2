package br.ufpr.tads.agenda.db.dao.ansi;

import br.ufpr.tads.agenda.db.DAOFactory;
import br.ufpr.tads.agenda.db.dao.AgendaDAO;

/**
 *
 * @author Dieval
 */
public class DAOStandardFactory extends DAOFactory {
    
    public DAOStandardFactory() {
        super();
        System.out.println("DAOStandardFactory");
    }

    @Override
    protected AgendaDAO getAgendaDAOImpl() {
        return new AnsiAgendaDAOImpl(conn);
    }
    
}
