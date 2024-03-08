package lucas.projeto_notas.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import lucas.projeto_notas.model.dto.NoteDto;



/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class JsonConnection {
    
    final static String NOMEDOARQUIVO = "notes";
    final static String LOCALHOST = "src/json/";
    
   public static void write(List<NoteDto> notes) {
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();
	FileWriter writer;
        try {
            writer = new FileWriter(LOCALHOST + NOMEDOARQUIVO + ".json");
            writer.write(gson.toJson(notes));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public static List<NoteDto> read() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                                new FileReader(LOCALHOST + NOMEDOARQUIVO + ".json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<ArrayList<NoteDto>>(){}.getType();
        ArrayList<NoteDto> notes = new ArrayList<NoteDto>();
        notes = new Gson().fromJson(bufferedReader, listType);
        return notes;
    }
    
}
