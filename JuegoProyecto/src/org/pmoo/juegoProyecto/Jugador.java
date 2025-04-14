package org.pmoo.juegoProyecto;

public class Jugador {

	private String nom;
	private String color;
	private int posCasilla;
	private int turnosPorPerder;
	private int num;

public Jugador (String pNom, String pColor) {
		this.nom = pNom;	
		this.color = pColor;
		this.posCasilla = 0;
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
	}
	
	private void avanzar() {
	this.posCasilla = posCasilla + num;
	}
	
	public void perderTurnos(int pTurnos) {
	    this.turnosPorPerder += pTurnos;
	}
	
}