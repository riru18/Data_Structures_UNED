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
import java.text.SimpleDateFormat;



public class OrdenarCelebracionesFrame extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public OrdenarCelebracionesFrame() {
        
        setVisible(true);
        setTitle("Ordenamiento de Celebraciones");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

// Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAsc = new JButton("Ordenar Ascendente (Inserción)");
        JButton btnDesc = new JButton("Ordenar Descendente (Merge Sort)");
        panelBotones.add(btnAsc);
        panelBotones.add(btnDesc);
        add(panelBotones, BorderLayout.NORTH);

        // Tabla
        String[] columnas = {"ID", "Fecha", "Descripción", "País"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Eventos
        btnAsc.addActionListener(e -> ordenarAscendentePorPais());
        btnDesc.addActionListener(e -> ordenarDescendentePorPais());

        // Cargar celebraciones actuales
        cargarTabla(RegistrarCelebracionFrame.getCelebraciones());
    }

    private void cargarTabla(ArrayList<Celebracion> lista) {
        modelo.setRowCount(0);
        for (Celebracion c : lista) {
            modelo.addRow(new Object[]{
                c.getId(), c.getFecha(), c.getDescripcion(), c.getPais()
            });
        }
    }

    // Insertion Sort (ascendente) por país
    private void ordenarAscendentePorPais() {
        ArrayList<Celebracion> lista = new ArrayList<>(RegistrarCelebracionFrame.getCelebraciones());

        for (int i = 1; i < lista.size(); i++) {
            Celebracion key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getPais().compareToIgnoreCase(key.getPais()) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, key);
        }

        cargarTabla(lista);
    }

    //  Merge Sort (descendente) por país
    private void ordenarDescendentePorPais() {
        ArrayList<Celebracion> copia = new ArrayList<>(RegistrarCelebracionFrame.getCelebraciones());
        ArrayList<Celebracion> ordenado = mergeSortDescPais(copia);
        cargarTabla(ordenado);
    }

    private ArrayList<Celebracion> mergeSortDescPais(ArrayList<Celebracion> lista) {
        if (lista.size() <= 1) return lista;

        int medio = lista.size() / 2;
        ArrayList<Celebracion> izq = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Celebracion> der = new ArrayList<>(lista.subList(medio, lista.size()));

        return mergeDescPais(mergeSortDescPais(izq), mergeSortDescPais(der));
    }

    private ArrayList<Celebracion> mergeDescPais(ArrayList<Celebracion> a, ArrayList<Celebracion> b) {
        ArrayList<Celebracion> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).getPais().compareToIgnoreCase(b.get(j).getPais()) > 0) {
                resultado.add(a.get(i++));
            } else {
                resultado.add(b.get(j++));
            }
        }

        while (i < a.size()) resultado.add(a.get(i++));
        while (j < b.size()) resultado.add(b.get(j++));

        return resultado;
    }
        
        
 }
