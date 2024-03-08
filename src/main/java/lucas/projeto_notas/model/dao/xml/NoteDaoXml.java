package lucas.projeto_notas.model.dao.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;
import lucas.projeto_notas.util.XmlConnection;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteDaoXml implements NoteDao{

    
    private static NoteDaoXml self;
    
    private NoteDaoXml() {
    }
    
    public static NoteDaoXml getInstance(){
        if (self == null) {
            self = new NoteDaoXml();
        }
        return self;
    }
    
    @Override
    public boolean insertNote(NoteDto n) {
        List<NoteDto> notes = XmlConnection.readXml();
        int newId = 0;
        for (NoteDto note : notes) {
            if (note.getId() >= newId) {
                newId = note.getId();
            }
        }
        newId++;
        n.setId(newId);
        notes.add(n);
        XmlConnection.writeNoteXml(notes);
        return true;
    }

    @Override
    public boolean updateNote(NoteDto n) {
        List<NoteDto> notes = XmlConnection.readXml();
        NoteDto noteToUpdated = null;
        for (NoteDto note : notes) {
            if (note.getId() == n.getId()) {
                noteToUpdated = note;
            }
        }
        noteToUpdated.setContent(n.getContent());
        XmlConnection.writeNoteXml(notes);
        return true;
    }

    @Override
    public boolean deleteNote(NoteDto n) {
        List<NoteDto> notes = XmlConnection.readXml();
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
            XmlConnection.writeNoteXml(notes);
        }
        return true;
    }

    @Override
    public Collection<NoteDto> getAllNotes() {
        List<NoteDto> notes = XmlConnection.readXml();
        return notes;
    }
    
}
