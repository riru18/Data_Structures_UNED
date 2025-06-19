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

    private static int contador = 1; // Genera IDs únicos 
    private int id;
    private String fecha;
    private String descripcion;
    private String pais;

    public Celebracion(String fecha, String descripcion, String pais) {
        this.id = contador++;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }

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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return id + ": " + descripcion + " (" + fecha + ", " + pais + ")";
    }
}
