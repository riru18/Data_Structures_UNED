
package listiteratordemo;
import java.util.*;

public class ListIteratorDemo {

   
    public static void main(String[] args) {
        ListIterator<String> litr = null;
    List<String> names = new ArrayList<String>();
    names.add("Alonso");
    names.add("Manuel");
    names.add("Paula");
    names.add("Tomás");
    names.add("Katherine");
    //Creando el iterador de la lista
    litr=names.listIterator();
 
    System.out.println("Recorrido hacia adelante:");
    while(litr.hasNext()){
       System.out.println(litr.next());
    }
    System.out.println("Recorrido hacia atrás");
    while(litr.hasPrevious()){
       System.out.println(litr.previous());
    }
}
}    
