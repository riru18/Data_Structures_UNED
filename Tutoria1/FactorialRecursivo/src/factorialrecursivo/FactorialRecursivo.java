
package factorialrecursivo;


public class FactorialRecursivo {

    
    public static void main(String[] args) {
    
        System.out.println(factorial(10));
    }
    
    public static int factorial(int numero){
        //5x4x3x2x1
        // 5x factorial(4)
        //5x4xfactorial(3)
    
        if (numero==1) {
            return numero;
        }
    return numero*factorial(numero-1);
    }
}
