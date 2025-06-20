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
import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;
import org.jdatepicker.impl.*;


public class RegistrarCelebracionFrame extends JFrame {
    private static int idActual = 1;
    private static ArrayList<Celebracion> celebraciones = new ArrayList<>();

    private JTextField txtId;
    private JDatePickerImpl datePicker;
    private JTextField txtDescripcion;
    private JTextField txtPais;

    public RegistrarCelebracionFrame() {
        setTitle("Registrar Celebración");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 10, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        

       
        add(new JLabel("ID:")); // ID no editable
        txtId = new JTextField(String.valueOf(idActual));
        txtId.setEditable(false);
        add(txtId);

        // manejo de fechas con JDatePicker
        add(new JLabel("Fecha (AAAA-MM-DD):"));
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        add(datePicker);

        // agrega botón descripción
        add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        add(txtDescripcion);

        // botón de país
        add(new JLabel("País:"));
        txtPais = new JTextField();
        add(txtPais);

        // Botón guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCelebracion());
        add(btnGuardar);
    }

    private void guardarCelebracion() {
        try {
            String fecha = datePicker.getJFormattedTextField().getText();
            String descripcion = txtDescripcion.getText().trim();
            String pais = txtPais.getText().trim();

            // verificar que usuario ingrese todos los datos
            if (fecha.isEmpty() || descripcion.isEmpty() || pais.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            // agrega información ingresada
            Celebracion nueva = new Celebracion(fecha, descripcion, pais);
            celebraciones.add(nueva);
            idActual++;

           
            this.dispose(); //cierra ventana sin mensaje de confirmación

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar la celebración: " + ex.getMessage()); //manejo de exccepción
        }
    }

    // getter para otras clases
    public static ArrayList<Celebracion> getCelebraciones() {
        return celebraciones;
    }
}

