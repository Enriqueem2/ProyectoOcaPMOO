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
	        pJugador.moverACasilla(destino);

	        //Casillas Dados y Casillas Ocas
	        if (volverATirar) {
	            int tirada = pJugador.tirarDado(Dado);
	            pJugador.avanzar(tirada, pJuego);
	        }
	    }
	}

