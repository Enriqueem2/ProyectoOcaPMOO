package org.pmoo.juegoProyecto; //probar metodos

public class pruebas {
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
        juego.jugarPartida(); 
        while(true) {
        juego.jugarTurno();
        }
		
	}
	//subir
}
