package org.pmoo.juegoProyecto;

import java.util.ArrayList;

public class Juego {
	public static void main(String[] args) {}
	
 	private ArrayList<Jugador> listaJugadores;
	private static Juego miJuego = null;
	private Jugador turnoActual;
	
    private Juego() {
        listaJugadores = new ArrayList<>();
    }

    public static Juego getJuego() {
		if(miJuego == null) {
			miJuego = new Juego();
		}
		return miJuego;
	}
    
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
	}

    public void iniciarJuego(int numJugadores) {
    	
    	int i = 0;
        while (i<numJugadores) {
        	
        	i=i+1;
            String nombre = "Jugador " + (i + 1);
            String color = "Color " + (i + 1);
            
            Jugador jugador = new Jugador(nombre, color);
            listaJugadores.add(jugador);
            
        }

        // Inicializar casillas
        Tablero.getTablero().inicializarCasillas();
        
        // Elegir el primer jugador
        turnoActual = listaJugadores.get(0);  
        
    }
 
        public void jugarTurno() {
        System.out.println(turnoActual.getNombre() + " es tu turno.");

        // El jugador tira el dado y avanza
        turnoActual.tirarDado();
        
        // Comprobar casilla
        Casilla casilla = Tablero.getCasilla(turnoActual.getPosicion());
        casilla.aplicarEfecto(turnoActual, this);
        
        // Comprobar si hay un ganador después del turno
        if (comprobarGanador(turnoActual)) {
            System.out.println(turnoActual.getNombre() + " ha ganado el juego!");
        } else {
            cambiarTurno();
        }
    }
        
        public void cambiarTurno() {

        	int index = listaJugadores.indexOf(turnoActual);
            
            // Cambia al siguiente jugador, o al primero si es el último
            if (index + 1 < listaJugadores.size()) {
                turnoActual = listaJugadores.get(index + 1);
            } else {
                turnoActual = listaJugadores.get(0); // Si es el último jugador, vuelve al primero
            }
        }

        public boolean comprobarGanador(Jugador pJugador) {
            if(pJugador.getPosicion() == 63) {
            	return true;
            } else { return false;
            	}
        }
        
}