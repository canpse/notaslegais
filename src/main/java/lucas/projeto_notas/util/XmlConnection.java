package lucas.projeto_notas.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import lucas.projeto_notas.model.dto.NoteDto;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class XmlConnection {
    
    final static String NOMEDOARQUIVO = "notas";
    final static String LOCALHOST = "src/xml/";
    
    public static boolean writeNoteXml(List<NoteDto> list) {
        Element config = new Element("Notes");
        Document document = new Document(config);
        for (NoteDto note : list) {
            Element xmlnote = new Element("note");
            xmlnote.setAttribute("id", String.valueOf(note.getId()));
            xmlnote.setAttribute("content", note.getContent());
            config.addContent(xmlnote);
        }
        XMLOutputter xout = new XMLOutputter();
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(LOCALHOST + NOMEDOARQUIVO + ".xml"), "UTF-8");
            BufferedWriter file = new BufferedWriter(out);
            xout.output(document, file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<NoteDto> readXml(){
        List<NoteDto> notes = new ArrayList<>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(LOCALHOST + NOMEDOARQUIVO + ".xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element config = doc.getRootElement();
        List<Element> list = config.getChildren("note");
        for (Element xmlnote : list) {
            NoteDto note = new NoteDto(Integer.valueOf(xmlnote.getAttributeValue("id")));
            note.setContent(xmlnote.getAttributeValue("content"));
            notes.add(note);
        }
        return notes;
    }
    
}
