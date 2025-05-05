package org.pmoo.juegoProyecto.Pruebas;

public class CasillaPerderTurnoPruebas extends CasillaNormalPruebas {

		private int turnosPerdidos;

	    public CasillaPerderTurnoPruebas(int pNumCasilla, int pTurnosPerdidos) {
	        super(pNumCasilla);
	        this.turnosPerdidos = pTurnosPerdidos;
	    }


	    @Override
	    public void aplicarEfecto(JugadorParaPruebas pJugador) {
	        pJugador.perderTurnos(turnosPerdidos);
	        if(pJugador.getPosicion() ==19) {
	        	System.out.println(" Has caido en la Posada, pierdes 1 turno ");
	        }else if(pJugador.getPosicion() ==31) {
	        	System.out.println(" Has caido en el Pozo, pierdes 2 turnos ");
	        }else if(pJugador.getPosicion() ==42) {
	        	System.out.println(" Has caido en el Laberinto, pierdes 3 turnos ");
	        }else if(pJugador.getPosicion() ==52) {
	        	System.out.println(" Has caido en la Carcel, pierdes 4 turnos ");
	        }
	    }
	}
