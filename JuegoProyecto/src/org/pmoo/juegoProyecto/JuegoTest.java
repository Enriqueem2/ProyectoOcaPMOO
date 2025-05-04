package org.pmoo.juegoProyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	Juego j = Juego.getJuego();
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		j = null;
	}

	@Test
	public void testMain() {

	}

}
