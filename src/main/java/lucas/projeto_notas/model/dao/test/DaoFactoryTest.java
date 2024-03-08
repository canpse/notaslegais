package lucas.projeto_notas.model.dao.test;

import lucas.projeto_notas.model.dao.DaoFactory;
import lucas.projeto_notas.model.dao.NoteDao;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class DaoFactoryTest implements DaoFactory {

    @Override
    public NoteDao getNoteDao() {
        return NoteDaoTest.getInstance();
    }
    
}
