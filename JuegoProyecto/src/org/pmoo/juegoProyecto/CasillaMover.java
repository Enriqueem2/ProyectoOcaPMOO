package org.pmoo.juegoProyecto;

public class CasillaMover extends Casilla{
	    private int destino;
	    private boolean volverATirar;

	    public CasillaMover(int pNumCasilla, int pDestino, boolean pVolverATirar) {
	        super(pNumCasilla);
	        this.destino = pDestino;
	        this.volverATirar = pVolverATirar;
	    }

	    @Override // Casillas Puentes y Dados
	    public void aplicarEfecto(Jugador pJugador) {
	        pJugador.setPosicion(destino);
	        if (volverATirar) {  
	            pJugador.tirarDado();
	        }   
	    }
}

