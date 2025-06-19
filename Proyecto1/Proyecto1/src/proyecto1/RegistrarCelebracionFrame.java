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
    private static ArrayList<Celebracion> celebraciones = new ArrayList<>();

    private JTextField descripcionField;
    private JTextField paisField;
    private JTextField idField;

    private JDatePickerImpl datePicker;

    public RegistrarCelebracionFrame() {
        setTitle("Registrar Celebración");
        setSize(400, 250);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        idField.setEditable(false);
        //idField.setText(String.valueOf(Celebracion.class.getDeclaredFields()[0].getInt(null))); // Opcional: mostrar ID sugerido

        JLabel fechaLabel = new JLabel("Fecha (AAAA-MM-DD):");

        // Configuración del JDatePicker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField();

        JLabel paisLabel = new JLabel("País:");
        paisField = new JTextField();

        formPanel.add(fechaLabel);
        formPanel.add(datePicker);
        formPanel.add(descripcionLabel);
        formPanel.add(descripcionField);
        formPanel.add(paisLabel);
        formPanel.add(paisField);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(e -> guardarCelebracion());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void guardarCelebracion() {
        String fecha = datePicker.getJFormattedTextField().getText().trim();
        String descripcion = descripcionField.getText().trim();
        String pais = paisField.getText().trim();

        if (fecha.isEmpty() || descripcion.isEmpty() || pais.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
            return;
        }

        Celebracion nueva = new Celebracion(fecha, descripcion, pais);
        celebraciones.add(nueva);

        // Limpiar campos
        descripcionField.setText("");
        paisField.setText("");
        datePicker.getModel().setValue(null);
    }

    // Acceso desde otras clases
    public static ArrayList<Celebracion> getCelebraciones() {
        return celebraciones;
    }
}


