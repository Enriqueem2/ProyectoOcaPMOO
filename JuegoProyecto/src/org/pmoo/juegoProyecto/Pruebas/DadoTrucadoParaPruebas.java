package org.pmoo.juegoProyecto.Pruebas;
import java.util.Random;

import org.pmoo.juegoProyecto.Teclado;

public class DadoTrucadoParaPruebas {

	    private static DadoTrucadoParaPruebas miDadoTr = null ;
	    private int numCaras;

	    private DadoTrucadoParaPruebas() {
	        this.numCaras = 6;  // Por defecto, el dado tiene 6 caras
	    }

	    public static DadoTrucadoParaPruebas getMiDado() {
	        if (miDadoTr == null) {
	        	miDadoTr = new DadoTrucadoParaPruebas();
	        }
	        return miDadoTr;
	    }
	    // MÃ©todo para tirar el dado
	    public int tirarDadoTrucado() {
	    	System.out.println("Dame un número para el dado trucado");
	       return Teclado.getTeclado().leerEntero();
	    }
	}

	
