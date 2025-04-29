package org.pmoo.juegoProyecto;

public class CasillaMover extends CasillaNormal{
	    private int destino;
	    private boolean volverATirar;

	    public CasillaMover(int pNumCasilla, int pDestino, boolean pVolverATirar) {
	        super(pNumCasilla);
	        this.destino = pDestino;
	        this.volverATirar = pVolverATirar;
	    }
	    @Override// Casillas Puentes y Dados
	    public void aplicarEfecto(Jugador pJugador) {
	        System.out.println("�Has ca�do en una casilla especial! Te mueves de la casilla " + pJugador.getPosicion() + " a la casilla " + destino);
	        pJugador.setPosicion(destino);
	        if (volverATirar) {  
	            System.out.println("�Tiras de nuevo!");
	            pJugador.tirarDado();
	            System.out.println("Est�s es na posici�n " +pJugador.getPosicion());
	        }   
	    }
}

