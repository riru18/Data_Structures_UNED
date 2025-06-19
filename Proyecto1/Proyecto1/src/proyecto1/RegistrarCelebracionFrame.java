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
        


        // ID no editable
        add(new JLabel("ID:"));
        txtId = new JTextField(String.valueOf(idActual));
        txtId.setEditable(false);
        add(txtId);

        // Fecha con JDatePicker
        add(new JLabel("Fecha (AAAA-MM-DD):"));
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        add(datePicker);

        // Descripción
        add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        add(txtDescripcion);

        // País
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

            if (fecha.isEmpty() || descripcion.isEmpty() || pais.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            Celebracion nueva = new Celebracion(fecha, descripcion, pais);
            celebraciones.add(nueva);
            idActual++;

           
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar la celebración: " + ex.getMessage());
        }
    }

    // Getter para que otras clases accedan a la lista
    public static ArrayList<Celebracion> getCelebraciones() {
        return celebraciones;
    }
}

