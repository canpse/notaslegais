package lucas.projeto_notas.view;

import java.util.Collection;
import java.util.Scanner;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;
import lucas.projeto_notas.util.Observer;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteViewCli implements NoteView, Observer{

    private Collection<NoteDto> notes;
    private Scanner stdin;
    private NoteDao dao;

    public NoteViewCli(Scanner stdin, NoteDao dao) {
        this.stdin = stdin;
        this.dao = dao;
        notes = dao.getAllNotes();
    }
    
    @Override
    public void insertNote() {
        System.out.println("Nota inserida com sucesso");
    }

    @Override
    public void updateNote() {
        
        System.out.println("Nota Alterada com sucesso");
    }

    @Override
    public void deleteNote() {
        System.out.println("Nota deletada com sucesso");
    }

    @Override
    public void showAllNotes() {
        if (this.notes == null) {
            System.out.println("Sem notas gravadas");
        } else {
            for (NoteDto note : notes) {
                System.out.println("\n--------------------\n" + note.getId()+ " : \n" + note.getContent() + "\n-----------------\n");
            }
        }
    }

    @Override
    public void showMenu() {
        String textoMenuPrincipal = "Menu Principal\n";
        textoMenuPrincipal = textoMenuPrincipal.concat("\n1 - Inserir nota");
        textoMenuPrincipal = textoMenuPrincipal.concat("\n2 - Alterar nota");
        textoMenuPrincipal = textoMenuPrincipal.concat("\n3 - Deletar nota");
        textoMenuPrincipal = textoMenuPrincipal.concat("\n4 - Mostrar todas as notas");
        textoMenuPrincipal = textoMenuPrincipal.concat("\n5 - Voltar");
        System.out.println(textoMenuPrincipal);
    }

    @Override
    public int getInputMenuChoice() {
        int input = stdin.nextInt();
        stdin.nextLine();
        return input;
    }

    @Override
    public String getInputNoteContent() {
        System.out.println("Digite o conteudo da nota: \n");
        String content = stdin.nextLine();
        return content;
    }

    @Override
    public int getInputNoteId() {
        System.out.println("Digite o Id da nota:");
        int input = stdin.nextInt();
        stdin.nextLine();
        return input;
    }

    @Override
    public void update() {
        notes = dao.getAllNotes();
    }

    
    
}
