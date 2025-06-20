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



public class OrdenarCelebracionesFrame extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    
    public OrdenarCelebracionesFrame() {
        
        // configuración de la ventana
        setVisible(true);
        setTitle("Ordenamiento de Celebraciones");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // panel con botones de selección de tipo de ordenamiento
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAsc = new JButton("Ordenar Ascendente (Inserción)");
        JButton btnDesc = new JButton("Ordenar Descendente (Merge Sort)");
        panelBotones.add(btnAsc);
        panelBotones.add(btnDesc);
        add(panelBotones, BorderLayout.NORTH);

        // se definen las columnas a utilizar y se crea la tabla 
        String[] columnas = {"ID", "Fecha", "Descripción", "País"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // acciones de botones
        btnAsc.addActionListener(e -> ordenarAscendentePorPaisYFecha());
        btnDesc.addActionListener(e -> ordenarDescendentePorPaisYFecha());

        // carga los datos en memoria al abrir la ventana
        cargarTabla(RegistrarCelebracionFrame.getCelebraciones());
    }

    // se muestra la lista de celebraciones ingresadas en la tabla
    private void cargarTabla(ArrayList<Celebracion> lista) {
        modelo.setRowCount(0); //limpia la tabla en caso de haber algún cambio y volverse a abrir esta sección
        for (Celebracion c : lista) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getFecha(),
                c.getDescripcion(),
                c.getPais()
            });
        }
    }

    // algoritmo de inserción, ordena ascendentemente país y fecha  
    private void ordenarAscendentePorPaisYFecha() {
        ArrayList<Celebracion> lista = new ArrayList<>(RegistrarCelebracionFrame.getCelebraciones());

        for (int i = 1; i < lista.size(); i++) {
            Celebracion key = lista.get(i);
            int j = i - 1;

            while (j >= 0 && compararPaisFecha(lista.get(j), key) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, key);
        }

        cargarTabla(lista);
    }

    // ordenamiento descendente con algoritmo merge sort. Ordena país y fecha de forma descendente
    private void ordenarDescendentePorPaisYFecha() {
        ArrayList<Celebracion> lista = new ArrayList<>(RegistrarCelebracionFrame.getCelebraciones());
        ArrayList<Celebracion> ordenada = mergeSortDesc(lista);
        cargarTabla(ordenada);
    }

    // ordena mediante merge sort de forma recursiva
    private ArrayList<Celebracion> mergeSortDesc(ArrayList<Celebracion> lista) {
        if (lista.size() <= 1) return lista;

        int medio = lista.size() / 2;
        ArrayList<Celebracion> izq = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Celebracion> der = new ArrayList<>(lista.subList(medio, lista.size()));

        return mergeDesc(mergeSortDesc(izq), mergeSortDesc(der));
    }

    
    //combina las dos listas ordenadas descendente por país y fecha
    private ArrayList<Celebracion> mergeDesc(ArrayList<Celebracion> a, ArrayList<Celebracion> b) {
        ArrayList<Celebracion> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (compararPaisFecha(a.get(i), b.get(j)) > 0) {
                resultado.add(a.get(i++));
            } else {
                resultado.add(b.get(j++));
            }
        }

        // agrega elementos restantes
        while (i < a.size()) resultado.add(a.get(i++));
        while (j < b.size()) resultado.add(b.get(j++));

        return resultado;
    }

    // compara dos celebraciones primero por país y si son iguales entonces por fecha
    private int compararPaisFecha(Celebracion a, Celebracion b) {
        int compPais = a.getPais().compareToIgnoreCase(b.getPais());
        if (compPais != 0) return compPais;

        return a.getFecha().compareTo(b.getFecha()); 
    }
        
        
 }
