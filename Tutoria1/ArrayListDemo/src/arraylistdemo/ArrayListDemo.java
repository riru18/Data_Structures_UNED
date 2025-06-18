
package arraylistdemo;
import java.util.ArrayList;

public class ArrayListDemo {

    
    public static void main(String[] args) {
        // Creando una ArrayList genérica  
        ArrayList arlTest = new ArrayList();
        
    // Tamaño de arrayList  
        System.out.println("Tamaño de ArrayList en la creación:" + arlTest.size()); 
 
        // Permite agregarle algunos elementos  
        arlTest.add("F"); 
        arlTest.add("E"); 
        arlTest.add("L"); 
        arlTest.add("I");
        arlTest.add("Z");
 
        // Vuelva a verificar el tamaño después de agregar elementos 
        System.out.println("Tamaño de ArrayList después de agregar elementos:" + arlTest.size());  
 
        // Mostrar todos los contenidos de ArrayList  
        System.out.println("Lista de todos los elementos:" + arlTest);  
 
        // Eliminar elemento por índice  arlTest.remove (0);  
        System.out.println("Ver contenido después de eliminar elemento por índice:" + arlTest.remove(0));  
 
        // Verifique el tamaño después de eliminar los elementos  
        System.out.println("Tamaño de arrayList después de eliminar elementos:" + arlTest.size()); 
        System.out.println("Lista de todos los elementos después de eliminar elementos:" + arlTest);  
 
        // Verifica si la lista contiene "I"  
        System.out.println(arlTest.contains("I"));     
      
    }
    
}
