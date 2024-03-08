package lucas.projeto_notas.model.dao.mysql;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import lucas.projeto_notas.model.dao.NoteDao;
import lucas.projeto_notas.model.dto.NoteDto;
import lucas.projeto_notas.util.MysqlConnection;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class NoteDaoMysql implements NoteDao{

    private String tabela = "note";
    private static NoteDaoMysql self;
    
    private NoteDaoMysql() {
    }
    
    public static NoteDaoMysql getInstance(){
        if (self == null) {
            self = new NoteDaoMysql();
        }
        return self;
    }

    public boolean insertNote(NoteDto n) {
        try {
            Connection con = MysqlConnection.connect();
            String sql = "INSERT INTO " + tabela + " (content) values (?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n.getContent());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDaoMysql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateNote(NoteDto n) {
        try {
            Connection con = MysqlConnection.connect();
            String sql = "UPDATE " + tabela + " SET content = ? WHERE idnote = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n.getContent());
            ps.setString(2, ""+n.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDaoMysql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteNote(NoteDto n) {
        try {
            Connection con = MysqlConnection.connect();
            String sql = "DELETE FROM  " + tabela + " WHERE idnote = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ""+n.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDaoMysql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Collection<NoteDto> getAllNotes() {
        try {
            Connection con = MysqlConnection.connect();
            String sql = "SELECT * FROM " + tabela;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<NoteDto> notes = new ArrayList<>();
            while (rs.next()) {                
                NoteDto note = new NoteDto(rs.getInt("idnote"));
                note.setContent(rs.getString("content"));
                notes.add(note);
            }
            return notes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
