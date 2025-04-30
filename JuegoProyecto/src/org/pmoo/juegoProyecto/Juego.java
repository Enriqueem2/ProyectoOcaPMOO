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

    public void jugarPartida() {
    	int pNumJugadores = Teclado.getTeclado().leerNumeroJugadores();
        iniciarJuego(pNumJugadores); 
        
        boolean fin = false;
        while (!fin) {
            this.dibujarTableroConJugadores(listaJugadores); // Dibujar en cada turno
            fin = jugarTurno(); // Si devuelve true, termina
        }
    }
    
    public void iniciarJuego(int pNumJugadores) {
    	
    	int i = 0;
        while (i<pNumJugadores) {
        	
        	i=i+1;
            String pNombre = Teclado.getTeclado().leerString("Escribe tu nombre: ");
            Jugador jugador = new Jugador (pNombre);
            listaJugadores.add(jugador);
            
        }

        // Inicializar casillas
        Tablero.getTablero().inicializarCasillas();
        
        // Elegir el primer jugador
        turnoActual = listaJugadores.get(0);  
        
    }
 
    public boolean jugarTurno() {
        System.out.println();
        System.out.println(turnoActual.getNombre() + " es tu turno.");
        Teclado.getTeclado().leerString("Pulsa Intro para lanzar el dado...");
        System.out.println();
        if(turnoActual.getTurnosPorPerder()>0) {
    		if(this.turnoActual.getTurnosPorPerder() ==1) {
    			System.out.println("Puedes volver a tirar en el siguiente turno");
    		}else {
    			System.out.println("Puedes volver a tirar en "+(this.turnoActual.getTurnosPorPerder())+" turnos");
    		}
    		turnoActual.reducirTurnosPorPerder();
    		cambiarTurno();
    	}else {
    		turnoActual.tirarDado();
    		System.out.println("Est�s en la posici�n " + turnoActual.getPosicion());
    		
    		// Comprobar casilla
    		CasillaNormal casilla = Tablero.getTablero().getCasilla(turnoActual.getPosicion());
    		casilla.aplicarEfecto(turnoActual);
    		while (Tablero.getTablero().esCasillaOca(turnoActual.getPosicion())) {
    		    int nuevaPos = Tablero.getTablero().buscarSiguienteOca(turnoActual.getPosicion());
    		    turnoActual.setPosicion(nuevaPos);
    		    System.out.println();
    		    System.out.println("�De oca a oca! Avanzas a la casilla " + nuevaPos);

    	if (turnoActual.getTurnosPorPerder() > 0) {
            if (turnoActual.getTurnosPorPerder() == 1) {
                System.out.println("Puedes volver a tirar en el siguiente turno");
            } else {
                System.out.println("Puedes volver a tirar en " + turnoActual.getTurnosPorPerder() + " turnos");
            }
            turnoActual.reducirTurnosPorPerder();
            cambiarTurno();
            return false;
        }

    		    Teclado.getTeclado().leerString("�Vuelves a tirar! Pulsa Intro para lanzar el dado...");
    		    System.out.println();
    		    turnoActual.tirarDado();
    		    System.out.println("Est�s en la posici�n " + turnoActual.getPosicion());
    		}
    		// Comprobar si hay un ganador
    		if (comprobarGanador(turnoActual)) {
    		System.out.println(turnoActual.getNombre() + " ha ganado el juego!");
    		} else {
    			cambiarTurno();
    		}
    	}
    	System.out.println("-----------------------------"); //Separador entre turnos (para que no se mezcle tanto texto)
    

         

        while (Tablero.getTablero().esCasillaOca(turnoActual.getPosicion())) {
            int nuevaPos = Tablero.getTablero().buscarSiguienteOca(turnoActual.getPosicion());
            turnoActual.setPosicion(nuevaPos);
            System.out.println();
            System.out.println("�De oca a oca! Avanzas a la casilla " + nuevaPos);

            if (nuevaPos == 63) {
            	this.dibujarTableroConJugadores(listaJugadores);
                break;
            }

            Teclado.getTeclado().leerString("�Vuelves a tirar! Pulsa Intro para lanzar el dado...");
            System.out.println();
            turnoActual.tirarDado();
            System.out.println("Est�s en la posici�n " + turnoActual.getPosicion());
            casilla = Tablero.getTablero().getCasilla(turnoActual.getPosicion());
            casilla.aplicarEfecto(turnoActual);
        }

        // Comprobar si ha ganado
        if (comprobarGanador(turnoActual)) {
            System.out.println(turnoActual.getNombre() + " ha ganado el juego!");
            return true; //  TERMINA LA PARTIDA
        } else {
            cambiarTurno();
            System.out.println("-----------------------------");
            return false;
        }
    }

        
        private void cambiarTurno() {

        	int i = listaJugadores.indexOf(turnoActual);
            
            // Cambia al siguiente jugador, o al primero si es el ultimo
            if (i + 1 < listaJugadores.size()) {
                turnoActual = listaJugadores.get(i + 1);
            } else {
                turnoActual = listaJugadores.get(0); // Si es el ultimo jugador vuelve al primero
            }
        }

        private boolean comprobarGanador(Jugador pJugador) {
            if(pJugador.getPosicion() == 63) {
            	return true;
            } else { return false;
            	}
        }
        
        private void dibujarTableroConJugadores(ArrayList<Jugador> jugadores) {
            int pFilas = 8;
            int pColumnas = 8;
            int[][] tablero = new int[pFilas][pColumnas];
            int num = 1;
            int total = 63;
            int inicioFila = pFilas - 1, finFila = 0;
            int inicioColumna = 0, finColumna = pColumnas - 1;

            while (inicioFila >= finFila && inicioColumna <= finColumna && num <= total) {
                for (int i = inicioColumna; i <= finColumna && num <= total; i++)
                    tablero[inicioFila][i] = num++;
                inicioFila--;

                for (int i = inicioFila; i >= finFila && num <= total; i--)
                    tablero[i][finColumna] = num++;
                finColumna--;

                for (int i = finColumna; i >= inicioColumna && num <= total; i--)
                    tablero[finFila][i] = num++;
                finFila++;

                for (int i = finFila; i <= inicioFila && num <= total; i++)
                    tablero[i][inicioColumna] = num++;
                inicioColumna++;
            }

            // Dibujar el tablero con jugadores
            for (int fila = 0; fila < pFilas; fila++) {
                // L�nea superior
                for (int col = 0; col < pColumnas; col++) {
                    System.out.print("+---------");
                }
                System.out.println("+");

                // L�nea vac�a
                for (int col = 0; col < pColumnas; col++) {
                    System.out.print("|         ");
                }
                System.out.println("|");

             // L�nea con n�mero o iniciales de jugadores
                for (int col = 0; col < pColumnas; col++) {
                    int casilla = tablero[fila][col];
                    
                    if (casilla == 0) {
                        System.out.print("|         ");
                    } else {
                        // Recoger iniciales de jugadores en esta casilla
                        StringBuilder iniciales = new StringBuilder();
                        for (Jugador j : jugadores) {
                            if (j.getPosicion() == casilla) {
                                iniciales.append(Character.toUpperCase(j.getNombre().charAt(0)));
                            }
                        }

                        String contenido;
                        if (iniciales.length() > 0) {
                            contenido = iniciales.toString();  // Mostrar iniciales si hay jugadores
                        } else {
                            contenido = String.valueOf(casilla); // Mostrar n�mero de casilla si no hay jugadores
                        }

                        // Centrado dentro de 9 espacios
                        int espaciosTotales = 9 - contenido.length();
                        int izquierda = espaciosTotales / 2;
                        int derecha = espaciosTotales - izquierda;
                        String espIzq = " ".repeat(izquierda);
                        String espDer = " ".repeat(derecha);

                        System.out.print("|" + espIzq + contenido + espDer);  // Mostrar la casilla con las iniciales
                    }
                }
                System.out.println("|");


                // L�nea vac�a inferior
                for (int col = 0; col < pColumnas; col++) {
                    System.out.print("|         ");
                }
                System.out.println("|");
            }

            // L�nea inferior final
            for (int col = 0; col < pColumnas; col++) {
                System.out.print("+---------");
            }
            System.out.println("+");
        }

       
}