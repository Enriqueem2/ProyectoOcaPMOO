package org.pmoo.juegoProyecto;

public class Jugador {

	private String nom;
	private String color;
	private int posCasilla;
	private int turnosPorPerder;

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
	
//--------------Métodos-------------------------------------------------
	
	public void tirarDado() {
	System.out.println("Ha salido un"+ Dado.getMiDado().tirarDado());
	this.avanzar();
	}
	
	private void avanzar() {
	this.posCasilla = posCasilla + Dado.getMiDado().tirarDado();
	}
	
	public void perderTurnos(int pTurnos) {
	    this.turnosPorPerder += pTurnos;
	}
	
	public void moverACasilla(int pNuevaPos) {
		this.posCasilla = pNuevaPos;
	}
	
}