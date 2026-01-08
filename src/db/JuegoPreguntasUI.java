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

    private void initComponents() {

        JLabel lblTitulo = new JLabel("Registro de Preguntas", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblPregunta = new JLabel("Pregunta:");
        JLabel lblRespuesta = new JLabel("Respuesta:");

        txtPregunta = new JTextField();
        txtRespuesta = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnSalir = new JButton("Salir");

        btnGuardar.addActionListener(e -> guardarPregunta());
        btnSalir.addActionListener(e -> System.exit(0));

        JPanel panelCentro = new JPanel(new GridLayout(4, 1, 10, 10));
        panelCentro.add(lblPregunta);
        panelCentro.add(txtPregunta);
        panelCentro.add(lblRespuesta);
        panelCentro.add(txtRespuesta);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnSalir);

        setLayout(new BorderLayout(10, 10));
        add(lblTitulo, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarPregunta() {

        String pregunta = txtPregunta.getText();
        String respuesta = txtRespuesta.getText();

        if (pregunta.isEmpty() || respuesta.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe completar ambos campos",
                            "Validacion",
                            JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // guardar en oracle . 
        guardarEnBaseDatos(pregunta, respuesta);
        
        JOptionPane.showMessageDialog(this,
                "Pregunta guardada correctamente");
        
        txtPregunta.setText("");
        txtRespuesta.setText("");
    }

    private void guardarEnBaseDatos(String pregunta, String respuesta) {

    }

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