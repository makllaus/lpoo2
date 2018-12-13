package br.ufpr.tads.agenda.db.dao.h2;

import br.ufpr.tads.agenda.db.DAOFactory;
import br.ufpr.tads.agenda.db.dao.AgendaDAO;

/**
 *
 * @author Dieval
 */
public class DAOH2Factory extends DAOFactory {
    
    public DAOH2Factory() {
        super();
        System.out.println("DAOSH2Factory");
    }

    @Override
    protected AgendaDAO getAgendaDAOImpl() {
        return new H2AgendaDAOImpl(conn);
    }

    
}
