
package sumardigitos;
import java.util.Scanner;

public class SumarDigitos {

        static Scanner entrada = new Scanner(System.in);
        
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");
        int numero = entrada.nextInt();
        System.out.printf("%nLa suma de los dígitos del número %d es %d", numero, sumaDigitos(numero));
    }
    
    private static int sumaDigitos(int num){
        if(num==0){
            return 0;
        } else {
            return sumaDigitos(num/10) + num%10;
        }
    }
}
