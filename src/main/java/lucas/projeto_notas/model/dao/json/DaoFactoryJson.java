package lucas.projeto_notas.model.dao.json;

import lucas.projeto_notas.model.dao.DaoFactory;
import lucas.projeto_notas.model.dao.NoteDao;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class DaoFactoryJson implements DaoFactory {

    @Override
    public NoteDao getNoteDao() {
        return NoteDaoJson.getInstance();
    }
    
}
