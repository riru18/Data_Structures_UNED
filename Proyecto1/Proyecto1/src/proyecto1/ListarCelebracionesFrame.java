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
import java.util.Iterator;

public class ListarCelebracionesFrame extends JFrame {

    public ListarCelebracionesFrame() {
        setTitle("Listado de Celebraciones");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);

        // Columnas de la tabla
        String[] columnas = {"ID", "Fecha", "Descripción", "País"};

        // Usamos Iterator para recorrer la colección
        ArrayList<Celebracion> celebraciones = RegistrarCelebracionFrame.getCelebraciones();
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Iterator<Celebracion> it = celebraciones.iterator();
        while (it.hasNext()) {
            Celebracion c = it.next();
            Object[] fila = {
                c.getId(),
                c.getFecha(),
                c.getDescripcion(),
                c.getPais()
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        
    }
}
