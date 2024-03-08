package lucas.projeto_notas.model.bo;

import java.util.ArrayList;
import java.util.Collection;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;
import lucas.projeto_notas.util.Observer;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteBo {
    
    private NoteDto note;
    private NoteDao dao;
    private Collection<Observer> observers;

    public NoteBo(NoteDto note, NoteDao dao) {
        observers = new ArrayList<>();
        this.note = note;
        this.dao = dao;
    }

    public NoteBo() {
    }
    
    public void addObserver(Observer o){
        observers.add(o);
    }
    
    public NoteDto getNote() {
        return note;
    }

    public void setNote(NoteDto note) {
        this.note = note;
    }

    public void insertNote() {
        dao.insertNote(note);
        notifyObservers();
    }
    
    public void updateNote(){
        dao.updateNote(note);
        notifyObservers();
    }
    
    public void deleteNote() {
        dao.deleteNote(note);
        notifyObservers();
    }
    
    public Collection<NoteDto> getAllNotes() {
        notifyObservers();
        return dao.getAllNotes();
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
}
