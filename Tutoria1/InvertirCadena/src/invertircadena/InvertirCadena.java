
package invertircadena;
import java.util.Scanner;

public class InvertirCadena {

    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Introduce una cadena de texto: ");
        String cadena = sc.nextLine();
        sc.close();
        String invertida = invertir(cadena);
        System.out.printf("Cadena invertida: %s", invertida);
    }
    private static String invertir(String cadena){
        if(cadena.length()==1){
            return cadena;
        } else {
            return invertir(cadena.substring(1)) + cadena.charAt(0);
        }
    }
}
