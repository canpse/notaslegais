package lucas.projeto_notas.controller;

import lucas.projeto_notas.model.bo.NoteBo;
import lucas.projeto_notas.model.dao.mysql.DaoFactoryMysql;
import lucas.projeto_notas.view.NoteView;
import lucas.projeto_notas.model.dao.DaoFactory;
import lucas.projeto_notas.model.dto.NoteDto;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteController {

    private DaoFactory noteDaoFactory;
    private NoteView noteView;

    public NoteController(DaoFactory DaoFactory, NoteView noteView) {
        this.noteDaoFactory = DaoFactory;
        this.noteView = noteView;
        this.startLoop();
    }

    private void startLoop() {
        noteView.showMenu();
        int menuInput = noteView.getInputMenuChoice();
        while (menuInput != 5) {
            switch (menuInput) {
                case 1:
                    processInsert();
                    break;
                case 2:
                    processUpdate();
                    break;
                case 3:
                    processDelete();
                    break;
                case 4:
                    processShowAllNotes();
                    break;
                default:
                    throw new AssertionError();
            }
            noteView.showMenu();
            menuInput = noteView.getInputMenuChoice();
        }
    }

    private void processInsert() {
        String content = noteView.getInputNoteContent();
        NoteBo notebo = new NoteBo(new NoteDto(content), noteDaoFactory.getNoteDao());
        notebo.addObserver(noteView);
        notebo.insertNote();
        noteView.insertNote();
    }

    private void processUpdate() {
        int noteID = noteView.getInputNoteId();
        String content = noteView.getInputNoteContent();
        NoteDto note = new NoteDto(noteID);
        note.setContent(content);
        NoteBo notebo = new NoteBo(note, noteDaoFactory.getNoteDao());
        notebo.addObserver(noteView);
        notebo.updateNote();
        noteView.updateNote();
    }

    private void processShowAllNotes() {
        noteView.showAllNotes();
    }

    private void processDelete() {
        int noteID = noteView.getInputNoteId();
        NoteDto note = new NoteDto(noteID);
        NoteBo notebo = new NoteBo(note, noteDaoFactory.getNoteDao());
        notebo.addObserver(noteView);
        notebo.deleteNote();
        noteView.deleteNote();
    }
    
    
    
    
    
}
