
package cantidadnumeros;
import java.util.Scanner;

public class CantidadNumeros {
    
    public static void main(String[] args) {
        int num = leerNumeroEntero("Introduce un número entero positivo: ");
        System.out.printf("%nEl número de cifras del número %d es %d", num, cuentaCifras(num));
    }
     
    private static int cuentaCifras(int num){
        if(num<10)
            return 1;
        else{
            return 1 + cuentaCifras(num/10);
        }
    }

    private static int leerNumeroEntero(String texto){
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do{
            System.out.print(texto);
            numero = sc.nextInt();
        }while(numero<=0);
        sc.close();
        return numero;
    }   
}
