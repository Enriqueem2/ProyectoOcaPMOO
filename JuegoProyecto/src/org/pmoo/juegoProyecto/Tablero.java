	package org.pmoo.juegoProyecto;
	import java.util.ArrayList;
	
	public class Tablero {
	
		private ArrayList<CasillaNormal> listaCasillas;
		private static Tablero miTablero = null;
		
	    private Tablero() {
	        listaCasillas = new ArrayList<CasillaNormal>();
	    }
	
	    public static Tablero getTablero() {
			if(miTablero == null) {
				miTablero = new Tablero();
			}
			return miTablero;
		}
	  
	    
	    public CasillaNormal getCasilla(int pNumCasilla) {
	        if (pNumCasilla >= 0 && pNumCasilla < listaCasillas.size()) {
	            return listaCasillas.get(pNumCasilla ); 
	        }
	        return null;
	    }
	    
	    public void inicializarCasillas() {
	        for (int i = 0; i <= 63; i++) {
	            listaCasillas.add(new CasillaNormal(i));
	        }
	
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
	
	    public int buscarSiguienteOca(int pPosActual) {
	        int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};

	        for (int i = 0; i < ocas.length - 1; i++) {
	            if (ocas[i] == pPosActual) {
	                return ocas[i + 1];
	            }
	        }
	        return pPosActual; // si no hay siguiente oca, se queda en la misma
	    }

	    public boolean esCasillaOca(int pPosicion) {
	        int[] ocas = {5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59};
	        for (int oca : ocas) {
	            if (oca == pPosicion) return true;
	        }
	        return false;
	    }

	}