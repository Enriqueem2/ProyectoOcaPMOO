package org.pmoo.juegoProyecto;

public class CasillaMuerte extends Casilla {
public CasillaMuerte (int pNumCasilla) {
	super(pNumCasilla);
}

@Override
public void aplicarEfecto(Jugador pJugador) {
    // No hace nada
	pJugador.setPosicion(1);
	System.out.println("El jugador"+ pJugador.getNombre()+"Ha caido en la casilla Muerte y vuelve al principio");
	}
}