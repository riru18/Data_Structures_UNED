/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;


// clase usada para formatear las fechas del componente jdatepicker
public class DateLabelFormatter extends AbstractFormatter {

    // formato que se va a usar: año-mes-día
    private final String datePattern = "yyyy-MM-dd";

    // formateador que sigue el patrón definido
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    // convierte el texto ingresado en el jdatepicker a tipo date
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parse(text);
    }

    // convierte un objeto tipo calendar a string con el formato establecido
    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}