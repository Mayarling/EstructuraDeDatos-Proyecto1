package cr.ac.uned.estructurasdedatos.proyecto1.dominio;

import java.text.DecimalFormat;

/**
 * Esta clase es para tener un arreglo primitivo con el nombre del país y los puntos.
 * 
 * @author Mayarling Martinez
 */
public class Pais {
    // Atributos de la clase.
    private String nombre;
    private double puntos;
    
    /**
     * Se construye un nuevo objeto de tipo Pais.
     */
    public Pais(){
        this.nombre = "";
        this.puntos = 0;  
    }
    
    /**
     * Se construye un nuevo objeto de tipo Pais.
     * 
     * @param nombre nombre del país.
     * @param puntos puntuación del país.
     */
    public Pais(String nombre, Double puntos){
        this.nombre = nombre;
        this.puntos = puntos;   
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
    public void sumarPuntos(double nuevosPuntos){
        this.puntos += nuevosPuntos;
    }
    
    /**
     * Sobre escribimos el método toString.
     * 
     * @return una representación en string del Pais.
     */
    @Override
    public String toString(){
        DecimalFormat formateadorDecimal = new DecimalFormat("#,###.00");
        return this.getNombre() + " (Pts: "+ formateadorDecimal.format(this.puntos)+")";
    }
}
