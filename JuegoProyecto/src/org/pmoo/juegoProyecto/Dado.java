package org.pmoo.juegoProyecto;
import java.util.Random;

public class Dado {

	private int numCaras;
	
	public Dado (int pNumCaras ) {
		this.numCaras = pNumCaras;
	}
	
	public int tirarDado () {
		Random r = new Random();
		int tirada = r.nextInt(this.numCaras)+1;
		return tirada;
	}
}
