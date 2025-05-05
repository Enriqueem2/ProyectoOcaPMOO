package org.pmoo.juegoProyecto.Pruebas;
import java.util.ArrayList;

import org.pmoo.juegoProyecto.CasillaMover;
import org.pmoo.juegoProyecto.CasillaMuerte;
import org.pmoo.juegoProyecto.CasillaNormal;
import org.pmoo.juegoProyecto.CasillaPerderTurno;
public class TableroParaPruebas {

	
		private ArrayList<CasillaNormalPruebas> listaCasillas;
		private static TableroParaPruebas miTablero = null;
		
	    private TableroParaPruebas() {
	        listaCasillas = new ArrayList<CasillaNormalPruebas>();
	    }
	
	    public static TableroParaPruebas getTablero() {
			if(miTablero == null) {
				miTablero = new TableroParaPruebas();
			}
			return miTablero;
		}
	  
	    
	    public CasillaNormalPruebas getCasilla(int pNumCasilla) {
	        if (pNumCasilla >= 0 && pNumCasilla < listaCasillas.size()) {
	            return listaCasillas.get(pNumCasilla ); 
	        }
	        return null;
	    }
	    
	    public void inicializarCasillas() {
	        for (int i = 0; i <= 63; i++) {
	            listaCasillas.add(new CasillaNormalPruebas(i));
	        }
	
	        // Puentes
        listaCasillas.set(6, new CasillaMoverPruebas(6, 12, false)); // primer puente
        listaCasillas.set(12, new CasillaMoverPruebas(12, 6, false)); // segundo puente

        // Dados
        listaCasillas.set(26, new CasillaMoverPruebas(26, 53, true)); // primer dado
        listaCasillas.set(53, new CasillaMoverPruebas(53, 26, true)); // segundo dado

        // Posada
        listaCasillas.set(19, new CasillaPerderTurnoPruebas(19, 1));

        // Pozo
        listaCasillas.set(31, new CasillaPerderTurnoPruebas(31, 2));

        // Laberinto
        listaCasillas.set(42, new CasillaPerderTurnoPruebas(42, 3));

        // Cárcel
        listaCasillas.set(52, new CasillaPerderTurnoPruebas(52, 4));

        // Muerte
        listaCasillas.set(58, new CasillaMuertePruebas(58));
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
