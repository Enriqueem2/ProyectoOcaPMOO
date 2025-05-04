package org.pmoo.juegoProyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {

	@Before
	public void setUp() {
	
	}

	@After
	public void tearDown() throws Exception {

	}


	@Test
	public void testInicializarCasillas() {
		Tablero tablero = Tablero.getTablero();
        tablero.inicializarCasillas();
		// Comprobar que hay 64 casillas (de 0 a 63)
        for (int i = 0; i <= 63; i++) {
            assertNotNull("La casilla " + i + " debería estar inicializada", tablero.getCasilla(i));
        }
        //Bibliografia de instanceof -->https://ifgeekthen.nttdata.com/s/post/que-es-y-como-utilizar-instanceof-en-java-MCGKP3Z2V77RD4ZKVJYG3ABC5CB4?language=es
        // Comprobar tipo de casillas especiales
        assertTrue(tablero.getCasilla(6) instanceof CasillaMover); // puente
        assertTrue(tablero.getCasilla(12) instanceof CasillaMover); // puente
        assertTrue(tablero.getCasilla(26) instanceof CasillaMover); // dado
        assertTrue(tablero.getCasilla(53) instanceof CasillaMover); // dado
        assertTrue(tablero.getCasilla(19) instanceof CasillaPerderTurno); // posada
        assertTrue(tablero.getCasilla(31) instanceof CasillaPerderTurno); // pozo
        assertTrue(tablero.getCasilla(42) instanceof CasillaPerderTurno); // laberinto
        assertTrue(tablero.getCasilla(52) instanceof CasillaPerderTurno); // cárcel
        assertTrue(tablero.getCasilla(58) instanceof CasillaMuerte); // muerte

        // Comprobar tipo normal en una casilla que no debería ser especial
        assertTrue(tablero.getCasilla(1) instanceof CasillaNormal);
    }
	
}
