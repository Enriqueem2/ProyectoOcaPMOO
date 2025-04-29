package org.pmoo.juegoProyecto; //probar metodos

public class pruebas {
	public static void main(String[] args) {
	    Juego juego = Juego.getJuego();
	    int numJugadores = Teclado.getTeclado().leerNumeroJugadores();
	    juego.iniciarJuego(numJugadores);
	    
	    while (true) {
	        juego.jugarTurno();
	        // Tal vez agregar opción de salir o esperar input
	    }
	}
	
}
