package lucas.projeto_notas.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class MysqlConnection {

    final static String db_name = "saturno";
    
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + db_name;
            return DriverManager.getConnection(url, "root", "1743");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
