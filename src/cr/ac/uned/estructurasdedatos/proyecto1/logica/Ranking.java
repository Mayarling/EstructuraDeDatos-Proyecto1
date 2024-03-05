package cr.ac.uned.estructurasdedatos.proyecto1.logica;

import cr.ac.uned.estructurasdedatos.proyecto1.dominio.Pais;
import java.util.Random;

/**
 * Clase que contiene la lógica del programa.
 * 
 * @author Mayarling Martínez.
 */
public class Ranking {
    private Pais[] paises = new Pais[10];
    
    public Ranking(){
        this.paises[0] = new Pais("EEUU", this.generarPuntajeAleatorio());
        this.paises[1] = new Pais("Suecia", this.generarPuntajeAleatorio());
        this.paises[2] = new Pais("Francia", this.generarPuntajeAleatorio());
        this.paises[3] = new Pais("Alemania", this.generarPuntajeAleatorio());
        this.paises[4] = new Pais("Holanda", this.generarPuntajeAleatorio());
        this.paises[5] = new Pais("Canadá", this.generarPuntajeAleatorio());
        this.paises[6] = new Pais("España", this.generarPuntajeAleatorio());
        this.paises[7] = new Pais("Inglaterra", this.generarPuntajeAleatorio());
        this.paises[8] = new Pais("Brasil", this.generarPuntajeAleatorio());
        this.paises[9] = new Pais("Costa Rica", this.generarPuntajeAleatorio());
    }
    
    /**
     * Método para generar un puntaje aleatorio entre 1 y 3000, con decimales.
     * 
     * @return Un valor aleatorio entre 1 y 3000 con 2 decimales.
     */
    private double generarPuntajeAleatorio(){
        Random generadorAleatorio = new Random();
        double numeroAleatorio = generadorAleatorio.nextDouble() + generadorAleatorio.nextInt(2998);
        return numeroAleatorio;
    }
    
    /**
     * Método que ordena los paises de menor a mayor usando el algoritmo Quicksort, y después invierte el arreglo de paises 
     * para presentarlo en orden descendente como corresponde a un ranking.
     * 
     * @return El arreglo paises ordenado de mayor a menor.
     */
    public Pais[] getPaises() {
        this.quicksort(0, this.paises.length-1);
        this.invertirPaises();
        return paises;
    }
    
    /**
     * Método para invertir el arreglo de los paises.
     */
    private void invertirPaises(){
        int posicion = 0;
        int posicionContraria = this.obtenerPosicionContraria(posicion, this.paises.length-1);
        Pais paisTemporal;
        while(posicion < posicionContraria){
            paisTemporal = this.paises[posicionContraria];
            this.paises[posicionContraria] = this.paises[posicion];
            this.paises[posicion] = paisTemporal;
            posicion++;
            posicionContraria--;
        }
    }
    
    /**
     * Método para obtener la posición contraria dada una cantidad de posiciones y una posición específica.
     * 
     * @param posicion La posición específica.
     * @param cantidadPosiciones La cantidad de posiciones.
     * @return La posición contraria a la posción específica dentro de la cantidad de posiciones.
     */
    private int obtenerPosicionContraria(int posicion, int cantidadPosiciones){
        int posicionRelativa = posicion - cantidadPosiciones;
        return Math.abs(posicionRelativa);
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }
    
    /**
     * Método para agregar puntos.
     * 
     * @param indice El indice del país.
     * @param puntos Los puntos a agregar a ese país.
     */
    public void agregarPuntos(int indice, double puntos){
        Pais pais = this.paises[indice];
        pais.sumarPuntos(puntos);
    }
    
    /**
     * Método de ordenamiento de un arreglo de Paises con QuickSort
     * 
     * @param izq La posicion del pais mas a la izq.
     * @param der La posicion del pais más a la der.
     */
    private void quicksort(int izq, int der){
        //pivote.
        Pais paisPivote = paises[izq];
        
        // Los elementos mayores al pivote van a la derecha,
        // los elementos menores al pivote van a la izquierda
        // Variables auxiliares
        int i = izq;
        int j = der;
        Pais paisDeIntercambio;
        
        // se evaluan los elementos para ubicar el nuevo pivote.
        while(i < j){
            // mientras que pais[i] sea menor al pivote se aumenta i
            // cuando no se cumple el while el elemento es mayor al pivote
            // y debera ir a la derecha.
            while(paises[i].getPuntos() <= paisPivote.getPuntos() && i < j){
                i++;
            }
            // mientras que pais[j] sea mayor al pivote se disminuye j
            // cuando no se cumpla el while el elemento es menor al pivote
            // y deberia ir a la izquierda.
            while(paises[j].getPuntos() > paisPivote.getPuntos()){
                j--;
            }
            // siempre y cuando i sea menor a j se hace un intercambio de elementos
            if(i < j){
                paisDeIntercambio = paises[i];
                paises[i] = paises[j];
                paises[j] = paisDeIntercambio; 
            }
        }
        // Se ubica adecuadamente el pivote
        paises[izq] = paises[j];
        paises[j] = paisPivote;
        
        // Si hay elementos que ordenar a la izquierda, se ordenan
        if(izq < j-1){
            quicksort(izq, j-1);
        }
        
        // Si hay elementos que ordenar a la derecha, se ordenan
        if(j+1 < der){
            quicksort(j+1, der);
        }  
    }
}
