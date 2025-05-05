package org.pmoo.juegoProyecto.Pruebas;

import org.pmoo.juegoProyecto.Dado;
import org.pmoo.juegoProyecto.Pruebas.DadoTrucadoParaPruebas;

public class JugadorParaPruebas {


		private String nom;
		private int posCasilla;
		private int turnosPorPerder;
		private int num;

	public JugadorParaPruebas (String pNom) {
			this.nom = pNom;	
			this.posCasilla = 1;
			this.turnosPorPerder = 0;
		}
		
		public String getNombre () {
			return this.nom;
		}
		
		public int getTurnosPorPerder () {
			return this.turnosPorPerder;
		}
		
		public void setPosicion(int pPos) {
			this.posCasilla =pPos;
		}

		public int getPosicion() {
			return this.posCasilla;
		}
		
	//--------------MÃ©todos-------------------------------------------------
	
	public void tirarDado() {
		num= Dado.getMiDado().tirarDado();
		if (this.posCasilla + num == 63) {
			System.out.println("Ha salido un " + num);
			this.avanzar();
			System.out.println("¡Has llegado justo a la meta!");
		} else if (this.posCasilla + num > 63) {
			System.out.println("Ha salido un " + num);
			System.out.println("¡Te pasaste! Necesitas sacar el número exacto para ganar.");
			// No se mueve
		} else {
			System.out.println("Ha salido un " + num);
			this.avanzar();
		}
		num = 0;
	}
	
	public void avanzar() {
	num = DadoTrucadoParaPruebas.getMiDado().tirarDadoTrucado();
	this.posCasilla = posCasilla + num;
	}
	
	public void perderTurnos(int pTurnos) {
	    this.turnosPorPerder += pTurnos;
	}
	
	public void reducirTurnosPorPerder() {
	    if (this.turnosPorPerder > 0){
	    	this.turnosPorPerder--;
	    }
	}

}
