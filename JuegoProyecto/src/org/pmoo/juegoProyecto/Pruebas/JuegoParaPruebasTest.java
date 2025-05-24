package org.pmoo.juegoProyecto.Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pmoo.juegoProyecto.Pruebas.JugadorParaPruebas;
import org.pmoo.juegoProyecto.Pruebas.TableroParaPruebas;
import org.pmoo.juegoProyecto.Teclado;

public class JuegoParaPruebasTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		System.out.println();
		System.out.println("Prueba de casillas especiales");	
		System.out.println();

		TableroParaPruebas.getTablero().inicializarCasillas();
		JugadorParaPruebas jugador = new JugadorParaPruebas("X");

		int i = 0;
		while (i <= 5) {

			if (i == 0) {
				System.out.println("Se comprueba la casilla de las ocas");
				jugador.setPosicion(8);
				System.out.println("Escribe un 1 para caer en la oca");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				int nuevaPos = TableroParaPruebas.getTablero().buscarSiguienteOca(jugador.getPosicion());
				System.out.println("¡De oca a oca! Avanzas a la casilla " + nuevaPos);
				Teclado.getTeclado().leerString("¡Vuelves a tirar! Pulsa Intro para lanzar el dado...");
				System.out.println();
				jugador.tirarDado();
				assertTrue(jugador.getPosicion() == nuevaPos); // comprobamos que ha avanzado a la siguiente oca
			}

			if (i == 1) {
				System.out.println("\nSe comprueba la casilla de los puentes");
				jugador.setPosicion(4);
				System.out.println("Escribe un 2 para caer en el puente");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				System.out.println("Estas en la posición " + jugador.getPosicion());
				assertTrue(jugador.getPosicion() == 12);
			}

			if (i == 2) {
				System.out.println("\nSe comprueba la casilla de los puentes de la 12 a la 6");
				jugador.setPosicion(10);
				System.out.println("Escribe un 2 para caer en el puente");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				System.out.println("Estas en la posición " + jugador.getPosicion());
				assertTrue(jugador.getPosicion() == 6);
			}

			if (i == 3) {
				System.out.println("\nSe comprueba la casilla dado de 26 a 53");
				jugador.setPosicion(24);
				System.out.println("Escribe un 2 para caer en el dado");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				System.out.println("Estas en la posición " + jugador.getPosicion());
				assertTrue(jugador.getPosicion() == 53);
			}

			if (i == 4) {
				System.out.println("\nSe comprueba la casilla dado de 53 a 26");
				jugador.setPosicion(51);
				System.out.println("Escribe un 2 para caer en el dado");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				System.out.println("Estas en la posición " + jugador.getPosicion());
				assertTrue(jugador.getPosicion() == 26);
			}

			if (i == 5) {
				System.out.println("\nSe comprueba la casilla muerte");
				jugador.setPosicion(56);
				System.out.println("Escribe un 2 para caer en la casilla Muerte");
				jugador.avanzar();
				CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jugador.getPosicion());
				casilla.aplicarEfecto(jugador);
				System.out.println("Estas en la posición " + jugador.getPosicion());
				assertTrue(jugador.getPosicion() == 0);
			}

			i++;
		}
	
}

	@Test
	public void testIniciarJuego() {
		System.out.println();
		System.out.println();
		System.out.println("Test para comprobar la inicialización del turno y la cantidad de jugadores");
		System.out.println();
		    // Simular manualmente la creacion de 3 jugadores
		    ArrayList<JugadorParaPruebas> jugadores = new ArrayList<JugadorParaPruebas>();
		    jugadores.add(new JugadorParaPruebas("Alice"));
		    jugadores.add(new JugadorParaPruebas("Bob"));
		    jugadores.add(new JugadorParaPruebas("Charlie"));

		    // Verificar que se han creado 3 jugadores
		    assertEquals(3, jugadores.size());

		    // Verificar que el primer jugador agregado sería el del primer turno
		    JugadorParaPruebas turnoInicial = jugadores.get(0);
		    assertEquals("Alice", turnoInicial.getNombre());
		    //Probar con el metodo directamente al crear la misma cantidad de jugadores
		    JuegoParaPruebas.getJuegoParaPruebas().iniciarJuego(3);
		    
		}

	@Test
	public void testCambiarTurno() {
	    System.out.println("\n\nTest para comprobar el cambio de turno\n");

	    // Inicializar tablero y jugador
	    TableroParaPruebas.getTablero().inicializarCasillas();
	    JugadorParaPruebas jug = new JugadorParaPruebas("B");
	    ListaJugadoresParaPruebas.añadirJugador(jug);

	    int i = 0;
	    while (i <= 3) {

	        if (i == 0) { // Posada
	            jug.setPosicion(18);
	            System.out.println("Escribe un 1 para que avance a la Posada y pierda 1 turno");
	            jug.avanzar();
	            CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jug.getPosicion());
	            casilla.aplicarEfecto(jug);
	            System.out.println("Pierde " + jug.getTurnosPorPerder() + " Turno");
	            assertTrue(jug.getTurnosPorPerder() == 1);

	            jug.reducirTurnosPorPerder(); // Simula siguiente turno
	            System.out.println("Se reduce por 1 el turno perdido");
	            System.out.println("Quedan " + jug.getTurnosPorPerder() + " turnos por perder");
	            assertTrue(jug.getTurnosPorPerder() == 0);
	        }

	        if (i == 1) { // Pozo
	            System.out.println();
	            jug.setPosicion(29);
	            System.out.println("Escribe un 2 para que avance al Pozo y pierda 2 turnos");
	            jug.avanzar();
	            CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jug.getPosicion());
	            casilla.aplicarEfecto(jug);
	            System.out.println("Pierde " + jug.getTurnosPorPerder() + " Turnos");
	            assertTrue(jug.getTurnosPorPerder() == 2);

	            jug.reducirTurnosPorPerder();
	            System.out.println("Se reduce por 1 el turno perdido");
	            System.out.println("Quedan " + jug.getTurnosPorPerder() + " turnos por perder");
	            assertTrue(jug.getTurnosPorPerder() == 1);
	        }

	        if (i == 2) { // Laberinto
	            System.out.println();
	            jug.setPosicion(39);
	            System.out.println("Escribe un 3 para que avance al Laberinto y pierda 3 turnos");
	            jug.avanzar();
	            CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jug.getPosicion());
	            casilla.aplicarEfecto(jug);
	            System.out.println("Pierde " + jug.getTurnosPorPerder() + " Turnos");
	            assertTrue(jug.getTurnosPorPerder() == 3);

	            jug.reducirTurnosPorPerder();
	            System.out.println("Se reduce por 1 el turno perdido");
	            System.out.println("Quedan " + jug.getTurnosPorPerder() + " turnos por perder");
	            assertTrue(jug.getTurnosPorPerder() == 2);
	        }

	        if (i == 3) { // Cárcel
	            System.out.println();
	            jug.setPosicion(48);
	            System.out.println("Escribe un 2 para que avance a la Cárcel y pierda 4 turnos");
	            jug.avanzar();
	            CasillaNormalPruebas casilla = TableroParaPruebas.getTablero().getCasilla(jug.getPosicion());
	            casilla.aplicarEfecto(jug);
	            System.out.println("Pierde " + jug.getTurnosPorPerder() + " Turnos");
	            assertTrue(jug.getTurnosPorPerder() == 4);

	            jug.reducirTurnosPorPerder();
	            System.out.println("Se reduce por 1 el turno perdido");
	            System.out.println("Quedan " + jug.getTurnosPorPerder() + " turnos por perder");
	            assertTrue(jug.getTurnosPorPerder() == 3);
	        }

	        i++;
	    }
	}
	@Test
	public void testComprobarGanador() {
		System.out.println();
		System.out.println();
		System.out.println("Test para comprobar el ganador");
		System.out.println();

		//Comprobar que ha ganado alguien
		System.out.println("Tienes que escribir 3");
		JugadorParaPruebas j = new JugadorParaPruebas("A");
		ListaJugadoresParaPruebas.añadirJugador(j);
		j.setPosicion(60);
		j.avanzar(); //Hay que poner un 3
		System.out.println("Está en la posición " + j.getPosicion());
		assertTrue(JuegoParaPruebas.getJuegoParaPruebas().comprobarGanador(j));
        System.out.println(j.getNombre() + " ha ganado el juego!"); //Al solo probarlo con un jugador ponemos el mensaje directamente
        System.out.println();
        System.out.println();
        System.out.println();
		//Comprobar que no ha ganado nadie (se ignoran las casillas especiales al no inicializarlas)
		System.out.println("Puedes escribir cualquier número");
		j.setPosicion(1);
		j.avanzar(); //Poner cualquier número
		System.out.println("Está en la posición " + j.getPosicion());
		assertFalse(JuegoParaPruebas.getJuegoParaPruebas().comprobarGanador(j));
		System.out.println("El jugador no gana");
		
		
	}

}
