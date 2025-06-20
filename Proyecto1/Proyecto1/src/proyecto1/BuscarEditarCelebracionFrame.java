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
import org.jdatepicker.impl.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;


public class BuscarEditarCelebracionFrame extends JFrame {
    
    private JTextField txtBuscarPais;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JDatePickerImpl datePicker;
    private JTextField txtDescripcion, txtPais;
    private int indiceSeleccionado = -1;
    
    
    public BuscarEditarCelebracionFrame() {
        
        setTitle("Buscar y Editar Celebración");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        
        
        // panel superior con barra de búsqueda. buscar por país
        JPanel panelBuscar = new JPanel(new FlowLayout());
        txtBuscarPais = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        panelBuscar.add(new JLabel("Buscar por país:"));
        panelBuscar.add(txtBuscarPais);
        panelBuscar.add(btnBuscar);
        add(panelBuscar, BorderLayout.NORTH);

        // se crea el modelo de tabla con las columnas requeridas
        String[] columnas = {"ID", "Fecha", "Descripción", "País"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // garantiza que no se pueda editar directamente la tabla
            }
        };
        
        //se crea tabla con scroll
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // panel inferior con formulario de edición
        JPanel panelEditar = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEditar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelEditar.add(new JLabel("Fecha (AAAA-MM-DD):"));

        // DatePicker. Campo para ingresar la fecha utilizando librería externa
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        panelEditar.add(datePicker);

        // campo para descripción
        panelEditar.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelEditar.add(txtDescripcion);
        
        
        //campo para país
        panelEditar.add(new JLabel("País:"));
        txtPais = new JTextField();
        panelEditar.add(txtPais);

        // botón para guardar los cambios
        JButton btnGuardarCambios = new JButton("Guardar Cambios");
        panelEditar.add(btnGuardarCambios);
        add(panelEditar, BorderLayout.SOUTH);

        // acciones de botones y selección de tabla
        btnBuscar.addActionListener(e -> buscarPorPais());
        tabla.getSelectionModel().addListSelectionListener(e -> cargarDatosSeleccionados());
        btnGuardarCambios.addActionListener(e -> guardarCambios());
    }

    // busca celebraciones que coincidan con el país ingresado 
    private void buscarPorPais() {
        String filtro = txtBuscarPais.getText().trim().toLowerCase();
        ArrayList<Celebracion> celebraciones = RegistrarCelebracionFrame.getCelebraciones();

        modelo.setRowCount(0); // limpia la tabla (cada vez que se abre la ventana)

        for (int i = 0; i < celebraciones.size(); i++) {
            Celebracion c = celebraciones.get(i);
            if (c.getPais().toLowerCase().contains(filtro)) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getFecha(),
                    c.getDescripcion(),
                    c.getPais()
                });
            }
        }
    }

    // carga los datos de la fila seleccionada en los campos del formulario
    private void cargarDatosSeleccionados() {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            ArrayList<Celebracion> lista = RegistrarCelebracionFrame.getCelebraciones();

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    indiceSeleccionado = i;
                    Celebracion c = lista.get(i);

                    // se colocan los datos en los campos para edición
                    txtDescripcion.setText(c.getDescripcion());
                    txtPais.setText(c.getPais());
                    
                    // actualiza el datepicker con la fecha existente
                    try {
                        java.util.Date fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(c.getFecha());
                        datePicker.getModel().setDate(
                            fecha.getYear() + 1900,
                            fecha.getMonth(),
                            fecha.getDate()
                        );
                        datePicker.getModel().setSelected(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    // guarda los cambios hechos en los campos de edición 
    private void guardarCambios() {
        if (indiceSeleccionado != -1) {
            try {
                //obtener nuevos datos ingresados
                String nuevaFecha = datePicker.getJFormattedTextField().getText();
                String nuevaDescripcion = txtDescripcion.getText().trim();
                String nuevoPais = txtPais.getText().trim();

                // validación de campos vacíos
                if (nuevaFecha.isEmpty() || nuevaDescripcion.isEmpty() || nuevoPais.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                    return;
                }

                // actualiza el objeto celebración con sus respectivos atributos
                Celebracion c = RegistrarCelebracionFrame.getCelebraciones().get(indiceSeleccionado);
                c.setFecha(nuevaFecha);
                c.setDescripcion(nuevaDescripcion);
                c.setPais(nuevoPais);

                // cierra la ventana una vez guardados los cambios
                this.dispose();
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar cambios: " + ex.getMessage());
            }
        }
        
        
    }
}
