
package lucas.projeto_notas;

import java.util.Scanner;
import lucas.projeto_notas.controller.NoteController;
import lucas.projeto_notas.model.dao.DaoFactory;
import lucas.projeto_notas.model.dao.json.DaoFactoryJson;
import lucas.projeto_notas.model.dao.mysql.DaoFactoryMysql;
import lucas.projeto_notas.model.dao.xml.DaoFactoryXml;
import lucas.projeto_notas.view.NoteView;
import lucas.projeto_notas.view.NoteViewCli;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Projeto_notas {

    public static void main(String[] args) {
        DaoFactory df = new DaoFactoryXml();
        Scanner keyboard = new Scanner(System.in);
        NoteView nv = new NoteViewCli(keyboard, df.getNoteDao());
        menuBoasVindas();
        int input = keyboard.nextInt();
        keyboard.nextLine();
        while (input != 7) {
            switch (input) {
                case 1:
                    NoteController nc = new NoteController(df, nv);
                    break;
                default:
                    throw new AssertionError();
            }
            menuBoasVindas();
            input = keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Adeus Volte sempre!");
        keyboard.close();
    }

    private static void menuBoasVindas() {
        System.out.println("Olá, bem vindo ao seu sistema de notas!");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Gerenciar Notas");
        System.out.println("2 - Alterar tipo de persistencia");
        System.out.println("7 - Sair");
    }
    
    
    
}
