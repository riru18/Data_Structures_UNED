/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */
//importar librerías
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class PaisesInvertidosFrame extends JFrame {

    public PaisesInvertidosFrame() {

        setTitle("Países Invertidos (Recursividad)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //define el nombre de la columna de la tabla
        String[] columnas = {"País Invertido"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER); // agrega la tabla con scroll al centro

        // obtiene lista de celebraciones desde clase registro
        ArrayList<Celebracion> celebraciones = RegistrarCelebracionFrame.getCelebraciones();

        // HashSet permite filtrar países duplicados 
        HashSet<String> paisesUnicos = new HashSet<>();

        // agrega todos los países únicos al conjunto y elimina posibles espacios con trim()
        for (Celebracion c : celebraciones) {
            paisesUnicos.add(c.getPais().trim());
        }

        // invierte cada país llamando método recursivo invertirRecursivo y agrega fila a la tabla
        for (String pais : paisesUnicos) {
            modelo.addRow(new Object[]{invertirRecursivo(pais)});
        }
    }

    // método recursivo, invierte String texto caracter por caracter
    private String invertirRecursivo(String texto) {
        if (texto.isEmpty()) {
            return "";
        }
        return invertirRecursivo(texto.substring(1)) + texto.charAt(0);
    }

}
