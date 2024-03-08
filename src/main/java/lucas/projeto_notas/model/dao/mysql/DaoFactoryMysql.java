package lucas.projeto_notas.model.dao.mysql;

import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dao.DaoFactory;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class DaoFactoryMysql implements DaoFactory{

    @Override
    public NoteDao getNoteDao() {
        return NoteDaoMysql.getInstance();
    }
    
    
    
}
