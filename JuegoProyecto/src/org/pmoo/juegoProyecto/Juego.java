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
        if(turnoActual.getTurnosPorPerder()>0) {
    		if(this.turnoActual.getTurnosPorPerder() ==1) {
    			System.out.println("Puedes volver a tirar en el siguiente turno");
    		}else {
    			System.out.println("Puedes volver a tirar en "+(this.turnoActual.getTurnosPorPerder()-1)+" turnos");
    		}
    		turnoActual.reducirTurnosPorPerder();
    		cambiarTurno();
    	}else {
    		turnoActual.tirarDado();
    		System.out.println("Est�s en la posici�n " + turnoActual.getPosicion());
    		

    		// Comprobar casilla
    		Casilla casilla = Tablero.getTablero().getCasilla(turnoActual.getPosicion());
    		casilla.aplicarEfecto(turnoActual);
    
    		// Comprobar si hay un ganador
    		if (comprobarGanador(turnoActual)) {
    		System.out.println(turnoActual.getNombre() + " ha ganado el juego!");
    		} else {
    			cambiarTurno();
    		}
    	}
    }
        
        public void cambiarTurno() {

        	int i = listaJugadores.indexOf(turnoActual);
            
            // Cambia al siguiente jugador, o al primero si es el último
            if (i + 1 < listaJugadores.size()) {
                turnoActual = listaJugadores.get(i + 1);
            } else {
                turnoActual = listaJugadores.get(0); // Si es el último jugador vuelve al primero
            }
        }

        public boolean comprobarGanador(Jugador pJugador) {
            if(pJugador.getPosicion() == 63) {
            	return true;
            } else { return false;
            	}
        }
        
}