package org.pmoo.juegoProyecto;

public class CasillaMover extends Casilla{
	    private int destino;
	    private boolean volverATirar;

	    public CasillaMover(int pNumCasilla, int pDestino, boolean pVolverATirar) {
	        super(pNumCasilla);
	        this.destino = pDestino;
	        this.volverATirar = pVolverATirar;
	    }

	    @Override // Casillas Puentes, Dados y Ocas
	    public void aplicarEfecto(Jugador pJugador, Juego pJuego) {
	        pJugador.setPosicion(destino);
	        if (volverATirar) {  // Dados y  Ocas
	            pJugador.tirarDado();
	        }else {  //Puentes
	        	if (pJugador.getPosicion() == 6) {
	        	    pJugador.setPosicion(12);
	        	} else if (pJugador.getPosicion() == 12) {
	        	    pJugador.setPosicion(6);
	        	}
	        }
	        
	    }
}

