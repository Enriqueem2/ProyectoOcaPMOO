package org.pmoo.juegoProyecto;

public class CasillaPerderTurno extends Casilla{
	
	private int turnosPerdidos;

    public CasillaPerderTurno(int pNumCasilla, int pTurnosPerdidos) {
        super(pNumCasilla);
        this.turnosPerdidos = pTurnosPerdidos;
    }


    @Override
    public void aplicarEfecto(Jugador pJugador, Juego pJuego) {
        pJugador.perderTurnos(turnosPerdidos);
    }
}