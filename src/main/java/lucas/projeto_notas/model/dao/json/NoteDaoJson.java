package lucas.projeto_notas.model.dao.json;

import java.util.Collection;
import java.util.List;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;
import lucas.projeto_notas.util.JsonConnection;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
class NoteDaoJson implements NoteDao{

    private static NoteDaoJson self;
    
    private NoteDaoJson() {
    
    }
    
    public static NoteDaoJson getInstance() {
        if (self == null) {
            self = new NoteDaoJson();
        }
        return self;
    }
    
    @Override
    public boolean insertNote(NoteDto n) {
        List<NoteDto> notes = JsonConnection.read();
        int newId = 0;
        for (NoteDto note : notes) {
            if (note.getId() >= newId) {
                newId = note.getId();
            }
        }
        newId++;
        n.setId(newId);
        notes.add(n);
        JsonConnection.write(notes);
        return true;
    }

    @Override
    public boolean updateNote(NoteDto n) {
        List<NoteDto> notes = JsonConnection.read();
        NoteDto noteToUpdated = null;
        for (NoteDto note : notes) {
            if (note.getId() == n.getId()) {
                noteToUpdated = note;
            }
        }
        noteToUpdated.setContent(n.getContent());
        JsonConnection.write(notes);
        return true;
    }

    @Override
    public boolean deleteNote(NoteDto n) {
        List<NoteDto> notes = JsonConnection.read();
        NoteDto noteToBeRemoved = null;
        for (NoteDto note : notes) {
            if (note.getId() == n.getId()) {
                noteToBeRemoved = note;
                break;
            }
        }
        if (noteToBeRemoved == null) {
            return false;
        } else {
            notes.remove(noteToBeRemoved);
        }
        JsonConnection.write(notes);
        return true;
    }

    @Override
    public Collection<NoteDto> getAllNotes() {
        List<NoteDto> notes = JsonConnection.read();
        return notes;
    }
 
    
}
