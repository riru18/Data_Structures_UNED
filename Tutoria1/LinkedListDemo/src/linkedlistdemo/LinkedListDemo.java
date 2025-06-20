
package linkedlistdemo;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void imprimir(LinkedList<String> lista) {
        lista.forEach((elemento) -> {
            System.out.print(elemento + "-");
        });
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Alonso");
        lista1.add("Luis");
        lista1.add("Melisa");
        imprimir(lista1);
        lista1.add(1, "Ana");
        imprimir(lista1);
        lista1.remove(0);
        imprimir(lista1);
        lista1.remove("Luis");
        imprimir(lista1);
        System.out.println("Cantidad de elementos en la lista:" + lista1.size());
        if (lista1.contains("Carlos"))
            System.out.println("El nombre 'Carlos' si esta almacenado en la lista");
        else
            System.out.println("El nombre 'Carlos' no esta almacenado en la lista");
        System.out.println("El segundo elemento de la lista es:" + lista1.get(1));
        lista1.clear();
        if (lista1.isEmpty())
            System.out.println("La lista se encuentra vacía");        
    }
    
}
