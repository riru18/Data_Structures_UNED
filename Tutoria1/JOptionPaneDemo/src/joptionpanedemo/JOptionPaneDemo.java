
package joptionpanedemo;
import javax.swing.JOptionPane;

public class JOptionPaneDemo {
  
    public static void main(String[] args) {
    String numero;
    numero = JOptionPane.showInputDialog("Digite el número entero");
    JOptionPane.showMessageDialog (null,"El número digitado es " +numero);
    //System.out.println("El número digitado es "+numero);
    }
    
}
