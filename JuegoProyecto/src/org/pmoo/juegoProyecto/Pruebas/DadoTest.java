package org.pmoo.juegoProyecto.Pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pmoo.juegoProyecto.Dado;

public class DadoTest {

	@Before
	public void setUp() {
	}
	Dado dado = Dado.getMiDado();
	
	@After
	public void tearDown() {
	dado = null;
	}

	@Test
	public void testTirarDado() {
		//Probando que el dado devuelve un valor entre 1 y 6:
		int i = 0;
		int valor = 0;
		while(i < 10) {
			valor = dado.tirarDado();
			i++;
			System.out.println(valor);
		}
		assertTrue(valor >= 1 && valor <=6);
		
	}

}
