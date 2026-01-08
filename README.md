# -_juego_de_preguntas_y_respuestas_java_- :. 
# Juego de Preguntas y Respuestas en Java .  
**Persistencia en Oracle Database 19c**

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/5b867d85-a92a-4161-ae32-48296d9b11a2" />  

<img width="2553" height="1077" alt="image" src="https://github.com/user-attachments/assets/9023723b-6017-4d0a-970b-fc1423570241" />    

<img width="2553" height="1079" alt="image" src="https://github.com/user-attachments/assets/5fde3ced-2785-4b3b-89fe-9b0601c88990" />    

<img width="2554" height="1079" alt="image" src="https://github.com/user-attachments/assets/96af640f-7744-43d5-8f51-60ffc6493091" />

A continuación se presenta una **solución completa, profesional y ejecutable en Java (IntelliJ IDEA)** que cumple exactamente con lo solicitado:

- Juego de Preguntas y Respuestas  
- Uso de **vector (arreglo) bidimensional `String[][]`**  
- Registro de preguntas y respuestas ingresadas por el usuario  
- Persistencia en **Oracle Database 19c**  
- Acceso a datos mediante **JDBC**  
- Estructura clara y lista para **pruebas académicas o técnicas**

---

## 1. Modelo conceptual del juego

El arreglo bidimensional representa el banco de preguntas:

- `preguntas[i][0]` → Pregunta  
- `preguntas[i][1]` → Respuesta  

### Ejemplo

```java
String[][] preguntas = {
    {"¿Capital de Colombia?", "Bogotá"},
    {"¿Resultado de 2 + 2?", "4"}
};
2. Script SQL – Oracle 19c
Ejecutar previamente en Oracle:

CREATE TABLE JUEGO_PREGUNTAS (
    ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PREGUNTA VARCHAR2(300),
    RESPUESTA VARCHAR2(300)
);

3. Arquitectura simple utilizada

db        → Conexión Oracle
ui        → Interfaz gráfica (Swing)
game      → Lógica del juego

4. Clase de conexión Oracle
Paquete: db
Clase: ConexionOracle.java

package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionOracle {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USER = "SYSTEM";
    private static final String PASSWORD = "oracle";

    public static Connection getConexion() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

5. Interfaz gráfica del juego (Swing)
Archivo: JuegoPreguntasUI.java
Paquete: ui

package ui;

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

    // Arreglo bidimensional
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
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Guardar en arreglo bidimensional
        preguntas[contador][0] = pregunta;
        preguntas[contador][1] = respuesta;
        contador++;

        // Guardar en Oracle
        guardarEnBaseDatos(pregunta, respuesta);

        JOptionPane.showMessageDialog(this,
                "Pregunta guardada correctamente");

        txtPregunta.setText("");
        txtRespuesta.setText("");
    }

    private void guardarEnBaseDatos(String pregunta, String respuesta) {

        String sql = "INSERT INTO JUEGO_PREGUNTAS (PREGUNTA, RESPUESTA) VALUES (?, ?)";

        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pregunta);
            ps.setString(2, respuesta);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error en base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new JuegoPreguntasUI().setVisible(true));
    }
}

6. Funcionamiento de la interfaz
El usuario escribe Pregunta y Respuesta

Se almacenan en:
String[][] preguntas
Oracle Database 19c
Confirmación visual mediante JOptionPane
Interfaz limpia, clara y funcional

7. Características técnicas destacadas
Swing nativo (sin dependencias externas)
Uso explícito de vector bidimensional
JDBC puro
Separación lógica UI / BD
Código claro y fácilmente ampliable

8. Posibles mejoras inmediatas
Botón Jugar (validar respuestas)
Tabla JTable para mostrar preguntas
CRUD completo
Arquitectura por capas (DAO / Service)
Temporizador y sistema de puntaje
Migración a JavaFX (versión moderna) :. . / : .
