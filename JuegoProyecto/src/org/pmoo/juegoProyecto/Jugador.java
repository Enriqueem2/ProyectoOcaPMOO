package org.pmoo.juegoProyecto;

public class Jugador {

	private String nom;
	private String color;
	private int posCasilla;
	private int turnosPorPerder;

//-----------------Constructor , Getters y Setters----------------------
	public Jugador (String pNom,String pColor) {
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
	public int tirarDado(Dado pDado) {
		return pDado.getInstance.tirarDado(pDado);
	}
	public void avanzar() {
		int sumar = this.getInstance.tirarDado(pDado);
		
	}
	public void perderTurnos(int pTurnos) {
	    this.turnosPorPerder += pTurnos;
	}
	
	public void moverACasilla(int pNuevaPos) {
		this.posCasilla = pNuevaPos;
	}

	
}
