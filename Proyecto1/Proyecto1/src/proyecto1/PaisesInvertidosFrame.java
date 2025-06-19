/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */

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
        
        String[] columnas = {"País Invertido"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // Obtener países únicos
        ArrayList<Celebracion> celebraciones = RegistrarCelebracionFrame.getCelebraciones();
        HashSet<String> paisesUnicos = new HashSet<>();

        for (Celebracion c : celebraciones) {
            paisesUnicos.add(c.getPais().trim());
        }

        // Invertir y agregar 
        for (String pais : paisesUnicos) {
            modelo.addRow(new Object[]{invertirRecursivo(pais)});
        }
    }

 
    private String invertirRecursivo(String texto) {
        if (texto.isEmpty()) return "";
        return invertirRecursivo(texto.substring(1)) + texto.charAt(0);
    }
        
 }
