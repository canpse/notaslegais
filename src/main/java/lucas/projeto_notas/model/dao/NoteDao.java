package lucas.projeto_notas.model.dao;

import java.util.Collection;
import lucas.projeto_notas.model.dto.NoteDto;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public interface NoteDao {
    
    boolean insertNote(NoteDto n);
    boolean updateNote(NoteDto n);
    boolean deleteNote(NoteDto n);
    Collection<NoteDto> getAllNotes();
    
}
