package org.pmoo.juegoProyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

	Jugador j = new Jugador("A");
	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
		 j = null;
	}

	@Test
	public void testJugador() {
		fail("Not yet implemented");
	}

	@Test
	public void testTirarDado() {
		//Comprobar movimiento
		int a = j.getPosicion();
		System.out.println(j.getPosicion());
		j.tirarDado();
		System.out.println(j.getPosicion());
		int b = j.getPosicion();
		assertTrue(b > a);
		
		//Comprobar número exacto para llegar a la meta
		System.out.println();
		System.out.println();
		System.out.println("Prueba de número exacto");
		System.out.println();
		while(j.getPosicion() != 63) {
			System.out.println("Entra otra vez al bucle");
			j.setPosicion(59);
			j.tirarDado();
			System.out.println(j.getPosicion());
			if(j.getPosicion() == 63) {
				assertTrue(j.getPosicion() == 63);
			}
		}

	}


}
