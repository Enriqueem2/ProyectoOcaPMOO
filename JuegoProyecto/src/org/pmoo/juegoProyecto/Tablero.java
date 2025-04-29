	package org.pmoo.juegoProyecto;
	import java.util.ArrayList;
	
	public class Tablero {
	
		private ArrayList<Casilla> listaCasillas;
		private static Tablero miTablero = null;
		
	    private Tablero() {
	        listaCasillas = new ArrayList<Casilla>();
	    }
	
	    public static Tablero getTablero() {
			if(miTablero == null) {
				miTablero = new Tablero();
			}
			return miTablero;
		}
	  
	    
	    public Casilla getCasilla(int numCasilla) {
	        if (numCasilla >= 0 && numCasilla < listaCasillas.size()) {
	            return listaCasillas.get(numCasilla);
	        }
	        return null;
	    }
	    
	    public void inicializarCasillas() {
	        for (int i = 0; i < 63; i++) {
	            listaCasillas.add(new CasillaNormal(i));
	        }
	
	        // Ocas
	        int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};
	        for (int i = 0; i < ocas.length - 1; i++) {
	            int origen = ocas[i];
	            int destino = ocas[i + 1];
	            listaCasillas.set(origen, new CasillaMover(origen, destino, false));
	        }
	        // Última oca (59) no mueve a ninguna otra
	
	        // Puentes
	        listaCasillas.set(6, new CasillaMover(6, 12, false)); // primer puente
	        listaCasillas.set(12, new CasillaMover(12, 6, false)); // segundo puente
	
	        // Dados
	        listaCasillas.set(26, new CasillaMover(26, 53, true)); // primer dado
	        listaCasillas.set(53, new CasillaMover(53, 26, true)); // segundo dado
	
	        // Posada
	        listaCasillas.set(19, new CasillaPerderTurno(19, 1));
	
	        // Pozo
	        listaCasillas.set(31, new CasillaPerderTurno(31, 2));
	
	        // Laberinto
	        listaCasillas.set(42, new CasillaPerderTurno(42, 3));
	
	        // Cárcel
	        listaCasillas.set(52, new CasillaPerderTurno(52, 4));
	
	        // Muerte
	        listaCasillas.set(58, new CasillaMuerte(58));
	    }
	
	    public int buscarSiguienteOca(int posActual) {
	        int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63};

	        for (int i = 0; i < ocas.length - 1; i++) {
	            if (ocas[i] == posActual) {
	                return ocas[i + 1];
	            }
	        }
	        return posActual; // si no hay siguiente oca, se queda en la misma
	    }

	    public boolean esCasillaOca(int posicion) {
	        int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};
	        for (int oca : ocas) {
	            if (oca == posicion) return true;
	        }
	        return false;
	    }

	}