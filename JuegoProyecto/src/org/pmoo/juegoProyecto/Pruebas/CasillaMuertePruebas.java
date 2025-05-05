package org.pmoo.juegoProyecto.Pruebas;

import org.pmoo.juegoProyecto.CasillaNormal;

public class CasillaMuertePruebas extends CasillaNormalPruebas {

	public CasillaMuertePruebas (int pNumCasilla) {
		super(pNumCasilla);
	}

	@Override
	public void aplicarEfecto(JugadorParaPruebas pJugador) {
		System.out.println("Has caido en la casilla Muerte y vuelves al principio");
		pJugador.setPosicion(1);
		}
	}
