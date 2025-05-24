package org.pmoo.juegoProyecto.Pruebas;

import org.pmoo.juegoProyecto.NombreInvalidoException;
import org.pmoo.juegoProyecto.Teclado;

public class JuegoParaPruebas {
	public static void main(String[] args) {
		JuegoParaPruebas juego = JuegoParaPruebas.getJuegoParaPruebas();
        juego.jugarPartida(); 
	}
	
 	private ListaJugadoresParaPruebas listaJugadores;
	private static JuegoParaPruebas miJuego = null;
	private JugadorParaPruebas turnoActual;
	
    private  JuegoParaPruebas() {
        listaJugadores = new ListaJugadoresParaPruebas();
    }

    public static JuegoParaPruebas getJuegoParaPruebas() {
		if(miJuego == null) {
			miJuego = new JuegoParaPruebas();
		}
		return miJuego;
	}


    public void jugarPartida() {
    	int pNumJugadores = Teclado.getTeclado().leerNumeroJugadores();
        iniciarJuego(pNumJugadores); 
        
        boolean fin = false;
        while (!fin) {
            fin = jugarTurno(); // Si devuelve true, termina
       
        }
    }
    
    public void iniciarJuego(int pNumJugadores) {
    	
    	int i = 0;
        while (i<pNumJugadores) {
        	try {
                String pNombre = Teclado.getTeclado().leerNombre("Escribe tu nombre: ");
                JugadorParaPruebas jugador = new JugadorParaPruebas(pNombre);
                listaJugadores.añadirJugador(jugador);
                i++; // Solo si el nombre es válido
            } catch (NombreInvalidoException e) {
                System.out.println("Error: " + e.getMessage() + " Intentalo de nuevo."); //Bibliografia de getMessage-->https://stackoverflow.com/questions/32840399/printing-exception-vs-exception-getmessage
            }
        }

        // Inicializar casillas
        TableroParaPruebas.getTablero().inicializarCasillas();
        
        // Elegir el primer jugador
        turnoActual = listaJugadores.devolverPrimerJugador();  
        
    }
 
    
    public boolean jugarTurno() {
        System.out.println();
        System.out.println(turnoActual.getNombre() + " es tu turno.");
        Teclado.getTeclado().leerString("Pulsa Intro para lanzar el dado...");
        System.out.println();

        if (turnoActual.getTurnosPorPerder() > 0) {
            if (turnoActual.getTurnosPorPerder() == 1) {
                System.out.println("Puedes volver a tirar en el siguiente turno");
            } else {
                System.out.println("Puedes volver a tirar en " + turnoActual.getTurnosPorPerder() + " turnos");
            }
            turnoActual.reducirTurnosPorPerder();
        	listaJugadores.dibujarTableroConJugadores();
            cambiarTurno();
            return false;
        }

        turnoActual.tirarDado();
        System.out.println("Estás en la posición " + turnoActual.getPosicion());        
        // Comprobar casilla
        
        	CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(turnoActual.getPosicion());
        	if(casilla != null) {
        	casilla.aplicarEfecto(turnoActual);
        	listaJugadores.dibujarTableroConJugadores();
        	}
        
        
        int seguridad = 0; // Casuistica para evitar que haya un bucle infinito en la casilla oca 59, porque si no llega exactamente a la 63 se queda en el mismo sitio y así el bucle solo se repite una vez
        while (TableroParaPruebas.getTablero().esCasillaOca(turnoActual.getPosicion()) && seguridad == 0) {
        if(turnoActual.getPosicion() == 59) {  
        	seguridad++;
        	break;
        }else {
        	int nuevaPos = TableroParaPruebas.getTablero().buscarSiguienteOca(turnoActual.getPosicion());
            turnoActual.setPosicion(nuevaPos);
            System.out.println();
            System.out.println("¡De oca a oca! Avanzas a la casilla " + nuevaPos);
        	listaJugadores.dibujarTableroConJugadores();
            Teclado.getTeclado().leerString("¡Vuelves a tirar! Pulsa Intro para lanzar el dado...");
            System.out.println();
            System.out.println();
            turnoActual.tirarDado();
            System.out.println("Estás en la posición " + turnoActual.getPosicion());
        	listaJugadores.dibujarTableroConJugadores();
        }
        }
        // Comprobar si ha ganado
        if (comprobarGanador(turnoActual)) {
            System.out.println(turnoActual.getNombre() + " ha ganado el juego!");
            return true; //  TERMINA LA PARTIDA
        } else {
            cambiarTurno();

            return false;
        }
    }

        
        public void cambiarTurno() {
        	turnoActual = listaJugadores.cambioDeTurnos();
     
        }

        public boolean comprobarGanador(JugadorParaPruebas pJugador) {
            if(pJugador.getPosicion() == 63) {
            	return true;
            } else { return false;
            	}
        }
       
}