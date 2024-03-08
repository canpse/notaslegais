package lucas.projeto_notas.model.dao.test;

import java.util.ArrayList;
import java.util.Collection;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteDaoTest implements NoteDao{
    
    private static NoteDaoTest self;
    
    private Collection<NoteDto> notes;

    private NoteDaoTest(Collection<NoteDto> notes) {
        this.notes = notes;
    }
    
    public static NoteDaoTest getInstance(){
        if (self == null) {
            self = new NoteDaoTest(new ArrayList<NoteDto>());
        }
        return self;
    }
    
    @Override
    public boolean insertNote(NoteDto n) {
        n.setId(notes.size());
        notes.add(n);
        return true;
    }

    @Override
    public boolean updateNote(NoteDto n) {
        for (NoteDto note : notes) {
            if (note.getId() == n.getId()) {
                note.setContent(n.getContent());
            }
        }
        return true;
    }

    @Override
    public boolean deleteNote(NoteDto n) {
        for (NoteDto note : notes) {
            if (note.getId() == n.getId()) {
                notes.remove(note);
            }
        }
        return true;
    }

    @Override
    public Collection<NoteDto> getAllNotes() {
        return notes;
    }
    
}
