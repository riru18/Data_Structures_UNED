/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */
public class Celebracion {

    private static int contador = 1; // variable estática para generar ids únicos
    
    // atributos de cada celebración
    private int id;
    private String fecha;
    private String descripcion;
    private String pais;

    // constructor para asignar valores 
    public Celebracion(String fecha, String descripcion, String pais) {
        this.id = contador++;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    // métodos getter para poder acceder a cada atributo
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPais() {
        return pais;
    }

    // métodos setter para modificar cada atributo
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    // método toString para retornar la celebración como texto
    @Override
    public String toString() {
        return id + ": " + descripcion + " (" + fecha + ", " + pais + ")";
    }
}
