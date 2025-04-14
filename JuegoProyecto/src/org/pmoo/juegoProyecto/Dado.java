package org.pmoo.juegoProyecto;
import java.util.Random;

public class Dado {

    private static Dado miDado = null ;
    private int numCaras;

    private Dado() {
        this.numCaras = 6;  // Por defecto, el dado tiene 6 caras
    }

    public static Dado getMiDado() {
        if (miDado == null) {
        	miDado = new Dado();
        }
        return miDado;
    }
    // Método para tirar el dado
    public int tirarDado() {
        Random r = new Random();
        int tirada = r.nextInt(this.numCaras) + 1;
        return tirada;
    }
}
