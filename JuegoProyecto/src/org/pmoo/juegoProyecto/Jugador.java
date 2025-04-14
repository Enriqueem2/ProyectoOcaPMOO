package org.pmoo.juegoProyecto;

public class Jugador {

	private String nom;
	private String color;
	private int posCasilla;

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
	public int tirarDado(Dado pDado) {
		return pDado.tirarDado();
	}
	public void avanzar() {
		int sumar = this.tirarDado();
		
	}
	public void perderTurnos() {
		
	}
	
	public void moverACasilla(int pNuevaPos) {
		this.posCasilla = pNuevaPos;
	}

	
}
