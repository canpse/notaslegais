package lucas.projeto_notas.model.dao.xml;

import lucas.projeto_notas.model.dao.DaoFactory;
import lucas.projeto_notas.model.dao.NoteDao;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class DaoFactoryXml implements DaoFactory{
    
    public NoteDao getNoteDao() {
        return NoteDaoXml.getInstance();
    }
    
}
