	package org.pmoo.juegoProyecto.Pruebas;
	
	import java.util.ArrayList;
	public class ListaJugadoresParaPruebas {
			
	private static  ArrayList<JugadorParaPruebas> lista;
			
	public ListaJugadoresParaPruebas() {
				lista = new ArrayList<JugadorParaPruebas>();
			}
			
	public static  void añadirJugador (JugadorParaPruebas pJugador) {
		        lista.add(pJugador);
			}
	
			
	public JugadorParaPruebas cambioDeTurnos () {
				    lista.add(lista.remove(0)); //Bibliografia ->https://keepcoding.io/blog/como-usar-arraylist-remove-en-java/
		    return lista.get(0);
	
	}
	
	
	public JugadorParaPruebas devolverPrimerJugador() {
		return lista.get(0);
	}
	
	public void dibujarTableroConJugadores() {
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
	        // Línea superior
	        for (int col = 0; col < pColumnas; col++) {
	            System.out.print("+---------");
	        }
	        System.out.println("+");
	
	        // Línea vacía
	        for (int col = 0; col < pColumnas; col++) {
	            System.out.print("|         ");
	        }
	        System.out.println("|");
	
	     // Línea con número o iniciales de jugadores
	        for (int col = 0; col < pColumnas; col++) {
	            int casilla = tablero[fila][col];
	            
	            if (casilla == 0) {
	                System.out.print("|         ");
	            } else {
	                // Recoger iniciales de jugadores en esta casilla
	                StringBuilder iniciales = new StringBuilder();
	                for (JugadorParaPruebas j : lista) {
	                    if (j.getPosicion() == casilla) {
	                        iniciales.append(Character.toUpperCase(j.getNombre().charAt(0)));
	                    }
	                }
	
	                String contenido;
	                if (iniciales.length() > 0) {
	                    contenido = iniciales.toString();  // Mostrar iniciales si hay jugadores
	                } else {
	                    contenido = String.valueOf(casilla); // Mostrar número de casilla si no hay jugadores
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
	
	
	        // Línea vacía inferior
	        for (int col = 0; col < pColumnas; col++) {
	            System.out.print("|         ");
	        }
	        System.out.println("|");
	    }
	
	    // Línea inferior final
	    for (int col = 0; col < pColumnas; col++) {
	        System.out.print("+---------");
	    }
	    System.out.println("+");
		    }
	
	
	}
