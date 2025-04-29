package org.pmoo.juegoProyecto;

public class CasillaMuerte extends CasillaNormal {
public CasillaMuerte (int pNumCasilla) {
	super(pNumCasilla);
}

@Override
public void aplicarEfecto(Jugador pJugador) {
	System.out.println("Has caido en la casilla Muerte y vuelves al principio");
	pJugador.setPosicion(1);
	}
}