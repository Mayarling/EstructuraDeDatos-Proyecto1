package cr.ac.uned.estructurasdedatos.proyecto1;

import cr.ac.uned.estructurasdedatos.proyecto1.gui.PantallaPrincipal;

/**
 * Clase con el método principal.
 * 
 * @author Mayarling Martinez
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PantallaPrincipal pantalla = new PantallaPrincipal();
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
        pantalla.setVisible(true);
    }
}
