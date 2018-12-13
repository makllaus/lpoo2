package br.ufpr.tads.agenda.db.dao;

import br.ufpr.tads.agenda.db.vo.AgendaVO;
import java.util.List;

/**
 *
 * @author Dieval
 */
public interface AgendaDAO extends BaseDAO<AgendaVO> {

    List<AgendaVO> findByName(String nome);
    
    List<AgendaVO> findByPhone(String fone);
    
}
