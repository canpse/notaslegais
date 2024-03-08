package lucas.projeto_notas.view;

import lucas.projeto_notas.util.Observer;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public interface NoteView extends Observer {

    void insertNote();
    void updateNote();
    void deleteNote();
    void showAllNotes();
    void showMenu();
    int getInputMenuChoice();
    String getInputNoteContent();
    int getInputNoteId();
    
}
