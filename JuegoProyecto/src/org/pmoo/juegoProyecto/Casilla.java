package org.pmoo.juegoProyecto;

public abstract class Casilla {
	protected int numCasilla;
	
	public Casilla (int pNumCasilla) {
		this.numCasilla = pNumCasilla;
	}
	
	public abstract void aplicarEfecto (Jugador jugador, Juego juego);
}
