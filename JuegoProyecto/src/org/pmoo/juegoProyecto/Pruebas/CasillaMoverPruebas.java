package org.pmoo.juegoProyecto.Pruebas;

import org.pmoo.juegoProyecto.Teclado;

public class CasillaMoverPruebas extends CasillaNormalPruebas{

		    private int destino;
		    private boolean volverATirar;

		    public CasillaMoverPruebas(int pNumCasilla, int pDestino, boolean pVolverATirar) {
		        super(pNumCasilla);
		        this.destino = pDestino;
		        this.volverATirar = pVolverATirar;
		    }
		    @Override// Casillas Puentes y Dados
	    public void aplicarEfecto(JugadorParaPruebas pJugador) {
	        System.out.println("�Has ca�do en una casilla especial! Te mueves de la casilla " + pJugador.getPosicion() + " a la casilla " + destino);
	        pJugador.setPosicion(destino);
	        if (volverATirar) {  
	            System.out.println("�Tiras de nuevo!");
	            System.out.println();
	            Teclado.getTeclado().leerString("Pulsa Intro para lanzar el dado...");
	            System.out.println();
	            pJugador.tirarDado();
	            System.out.println("Est�s es la posici�n " +pJugador.getPosicion());
		        }   
		    }
	}

