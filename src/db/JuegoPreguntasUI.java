package db;

/*String[][] preguntas = {
    {"¿Capital de Colombia?", "Bogotá"},
    {"¿Resultado de 2 + 2?", "4"}
};
*/

import db.ConexionOracle;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JuegoPreguntasUI extends JFrame {

    private JTextField txtPregunta;
    private JTextField txtRespuesta;
    private JButton btnGuardar;
    private JButton btnSalir;

    // arreglo bidimensional
    private String[][] preguntas = new String[100][2];
    private int contador = 0;

    public JuegoPreguntasUI() {

        setTitle("Juego de Preguntas y Respuestas");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {}    

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}