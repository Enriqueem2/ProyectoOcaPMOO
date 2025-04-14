package org.pmoo.juegoProyecto;

public class Jugador {

	private String nom;
	private String color;
	private int posCasilla;
	private Dado dado;
//-----------------Constructor , Getters y Setters-------------------------------
	public Jugador (String pNom,String pColor) {
		this.nom = pNom;
		this.color = pColor;
		this.posCasilla = 0;
	}
	
	public String getNombre () {
		return this.nom;
	}
	
	public void setPosicion(int pPos) {
		this.posCasilla =pPos;
	}

	public int getPosicion() {
		return this.posCasilla;
	}
//--------------Metodos-------------------------------------------------
	public void tirarDado() {
	int tirada = dado.tirarDado();
	this.avanzar();
	
	}
	private void avanzar() {
	int tirada = dado.tirarDado();
	posCasilla = posCasilla + tirada;
		
	}
	public void perderTurnos() {
		
	}
	
	public void moverACasilla(int pNuevaPos) {
		this.posCasilla = pNuevaPos;
	}

	
}
