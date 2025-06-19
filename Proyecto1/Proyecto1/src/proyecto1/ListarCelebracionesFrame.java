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



public class ListarCelebracionesFrame extends JFrame {
    
    public ListarCelebracionesFrame() {
        setTitle("Listado de Celebraciones");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        
        
        
        // Columnas de la tabla
        String[] columnas = {"ID", "Fecha", "Descripción", "País"};

        // Datos desde la lista estática
        ArrayList<Celebracion> celebraciones = RegistrarCelebracionFrame.getCelebraciones();
        String[][] datos = new String[celebraciones.size()][4];

        for (int i = 0; i < celebraciones.size(); i++) {
            Celebracion c = celebraciones.get(i);
            datos[i][0] = String.valueOf(c.getId());
            datos[i][1] = c.getFecha();
            datos[i][2] = c.getDescripcion();
            datos[i][3] = c.getPais();
        }

        // Crear tabla con modelo no editable
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla solo de lectura
            }
        };

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
             
        
        
    }
}
