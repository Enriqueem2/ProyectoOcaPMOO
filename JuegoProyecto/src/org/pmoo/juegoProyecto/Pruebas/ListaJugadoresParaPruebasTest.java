package org.pmoo.juegoProyecto.Pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ListaJugadoresParaPruebasTest {

    JugadorParaPruebas jugador1;
    JugadorParaPruebas jugador2;
    JugadorParaPruebas jugador3;
    ListaJugadoresParaPruebas lista;

    @Before
    public void setUp() throws Exception {
        lista = new ListaJugadoresParaPruebas(); // Reinicia la lista
        jugador1 = new JugadorParaPruebas("Ana");
        jugador2 = new JugadorParaPruebas("Luis");
        jugador3 = new JugadorParaPruebas("Sof�a");
    }

    @After
    public void tearDown() throws Exception {
        jugador1 = null;
        jugador2 = null;
        jugador3 = null;
        lista = null;
    }

    @Test
    public void testA�adirJugadorYDevolverPrimerJugador() {
        ListaJugadoresParaPruebas.a�adirJugador(jugador1);
        assertEquals("Debe devolver al primer jugador a�adido", jugador1, lista.devolverPrimerJugador());

        ListaJugadoresParaPruebas.a�adirJugador(jugador2);
        assertEquals("El primer jugador sigue siendo jugador1", jugador1, lista.devolverPrimerJugador());

        assertNotEquals("No debe devolver jugador2 como primero", jugador2, lista.devolverPrimerJugador());
    }

    @Test
    public void testCambioDeTurnos() {
        ListaJugadoresParaPruebas.a�adirJugador(jugador1);
        ListaJugadoresParaPruebas.a�adirJugador(jugador2);
        ListaJugadoresParaPruebas.a�adirJugador(jugador3);

        // Antes del cambio
        assertEquals(jugador1, lista.devolverPrimerJugador());

        // Primer cambio: jugador2 al frente
        JugadorParaPruebas actual = lista.cambioDeTurnos();
        assertEquals(jugador2, actual);
        assertEquals(jugador2, lista.devolverPrimerJugador());
        assertNotEquals(jugador1, lista.devolverPrimerJugador());

        // Segundo cambio: jugador3 al frente
        actual = lista.cambioDeTurnos();
        assertEquals(jugador3, actual);
        assertEquals(jugador3, lista.devolverPrimerJugador());
    }

    @Test
    public void testDibujarTableroConJugadores() {
        // Asignar posiciones para que se muestren en el tablero
        jugador1.setPosicion(1);
        jugador2.setPosicion(5);
        jugador3.setPosicion(10);

        ListaJugadoresParaPruebas.a�adirJugador(jugador1);
        ListaJugadoresParaPruebas.a�adirJugador(jugador2);
        ListaJugadoresParaPruebas.a�adirJugador(jugador3);

        // Chatgpt para comprobar las letras
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        lista.dibujarTableroConJugadores();

        System.setOut(System.out); // Restaurar salida original

        String output = salida.toString();
        assertTrue("Debe contener el n�mero de casilla 1", output.contains("1") || output.contains("A"));
        assertTrue("Debe contener la inicial de Ana", output.contains("A"));
        assertTrue("Debe contener la inicial de Luis", output.contains("L"));
        assertTrue("Debe contener la inicial de Sof�a", output.contains("S"));
        assertFalse("No debe contener la inicial de un jugador que no existe", output.contains("X"));
    }
}
