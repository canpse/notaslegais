package lucas.projeto_notas.model.dto;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteDto {
    
    private int id;
    private String content;

    public NoteDto(String content) {
        this.content = content;
    }
    
    public NoteDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
