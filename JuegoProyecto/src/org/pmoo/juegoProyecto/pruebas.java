package org.pmoo.juegoProyecto; //probar metodos

public class pruebas {
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
		juego.iniciarJuego(2); // Iniciar juego con 2 jugadores
        Jugador jugador = juego.getListaJugadores().get(0);
        jugador.setPosicion(6); // Por ejemplo, poner al jugador en la casilla 6
        CasillaNormal casilla = Tablero.getTablero().getCasilla(jugador.getPosicion());
		casilla.aplicarEfecto(jugador);
		while(true) {
		juego.jugarTurno();
		}

		
		/*Juego juego = Juego.getJuego();
	    int numJugadores = Teclado.getTeclado().leerNumeroJugadores();
	    juego.iniciarJuego(numJugadores);
	    
	    while (true) {
	        juego.jugarTurno();
	        // Tal vez agregar opción de salir o esperar input
	        
	    }*/
	}
	
}
