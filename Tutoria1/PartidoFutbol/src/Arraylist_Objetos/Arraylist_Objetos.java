/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arraylist_Objetos;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author alonso
 */
public class Arraylist_Objetos {
    private static final String nombreArchivo = "partidos.txt";
	
	public static void main (String args[]){
		
		// Nos creamos un ArrayList de objetos de la Clase "PartidoFutbol"
		System.out.println("... Nos creamos un ArrayList de objetos de la Clase \"PartidoFutbol\" ...");
		ArrayList<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();
		
		// Instanciamos el archivo donde estan los datos
		File archivo = new File(nombreArchivo);
		Scanner s = null;
		
		try {
			// Leemos el contenido del archivo
			System.out.println("... Leemos el contenido del archivo ...");
			s = new Scanner(archivo);
			// Obtengo los datos de los partidos de fútbol del archivo
			while (s.hasNextLine()){
				String linea = s.nextLine();	// Obtengo una linea del fichero (un partido de fútbol)
				String [] cortarString = linea.split("::");		// Obtengo los datos del partido de futbol
				PartidoFutbol partido = new PartidoFutbol();	// Creo un objeto de la clase "PartidoFutbol"
				
				// Pongo los atributos al objeto "partido"
				partido.setEquipoLocal(cortarString[0]);
				partido.setEquipoVisitante(cortarString[1]);
				partido.setGolesLocal(Integer.parseInt(cortarString[2]));
				partido.setGolesVisitante(Integer.parseInt(cortarString[3]));
				
				// Añadimos el objeto "partido" al ArrayList
				partidos.add(partido);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (s != null)
					s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("... Guardados "+partidos.size()+" partidos de fútbol  ...");
		
		// Imprimimos los elementos del ArrayList
		System.out.println("\n... Resultados de los partidos de Futbol ...");
		Iterator<PartidoFutbol> itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			System.out.println(partido.getEquipoLocal() + " "
					+ partido.getGolesLocal() + "-"
					+ partido.getGolesVisitante() + " "
					+ partido.getEquipoVisitante());
		}
		
		// Eliminamos los partidos de futbol del ArrayList, cuyo resultado
		// no sea un empate
		System.out.println("\n... Tamaño del ArrayList antes de eliminar partidos de futbol = "+partidos.size()+" ...");
		System.out.println("\n... Eliminamos los partidos de futbol cuyo resultado no sea un empate ...");
		itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			// Si los goles no son iguales, eliminamos el partido
			if(partido.getGolesLocal() != partido.getGolesVisitante())
				itrPartidos.remove();
		}
				
		// Imprimimos los elementos del ArrayList
		System.out.println("\n... Tamaño del ArrayList despues de eliminar partidos de futbol = "+partidos.size()+" ...");
		System.out.println("\n... Resultados de los partidos de Futbol con empate ...");
		itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			System.out.println(partido.getEquipoLocal() + " "
					+ partido.getGolesLocal() + "-"
					+ partido.getGolesVisitante() + " "
					+ partido.getEquipoVisitante());
		}
	}
}
