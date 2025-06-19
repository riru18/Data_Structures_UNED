/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

/**
 *
 * @author ricardo.ruizc@uned.cr
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Proyecto1 extends JFrame {

    
    public Proyecto1() {
        setTitle("Gestión de Celebraciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 1, 5, 5));

        JButton btnRegistrar = new JButton("Registrar Celebración");
        JButton btnListar = new JButton("Listar Celebraciones");
        JButton btnBuscarEditar = new JButton("Buscar/Editar Celebración");
        JButton btnPaisesInvertidos = new JButton("Países Invertidos");
        JButton btnOrdenar = new JButton("Ordenar Celebraciones");

        // Acción de botones
        
        btnRegistrar.addActionListener(e -> new RegistrarCelebracionFrame().setVisible(true));
        btnListar.addActionListener(e -> new ListarCelebracionesFrame());
        btnBuscarEditar.addActionListener(e -> new BuscarEditarCelebracionFrame());
        btnPaisesInvertidos.addActionListener(e -> new PaisesInvertidosFrame());
        btnOrdenar.addActionListener(e -> new OrdenarCelebracionesFrame());

        add(btnRegistrar);
        add(btnListar);
        add(btnBuscarEditar);
        add(btnPaisesInvertidos);
        add(btnOrdenar);

        setLocationRelativeTo(null); // Centrar ventana
    }
    
    public static void main(String[] args) {
        
                SwingUtilities.invokeLater(() -> {
            new Proyecto1().setVisible(true);
        });
    }
    
}
