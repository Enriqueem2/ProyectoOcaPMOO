package org.pmoo.juegoProyecto;
import java.util.Scanner;

public class Teclado {
    private static Teclado miTeclado = null;
    private Scanner sc;

    private Teclado() {
        sc = new Scanner(System.in);
    }

    public static Teclado getTeclado() {
        if (miTeclado == null) {
            miTeclado = new Teclado();
        }
        return miTeclado;
    }

    public int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido:");
            sc.next(); 
        }
        int numero = sc.nextInt();
        sc.nextLine(); // salta de linea
        return numero;
    }
    
    public String leerString(String pMensaje) { //uso general para dados y turnos
        System.out.print(pMensaje);
        return sc.nextLine();
    }
    
    public String leerNombre(String pMensaje) throws NombreInvalidoException  { //uso exclusivo para nombres
        System.out.print(pMensaje);
        String entrada = sc.nextLine();
        if (entrada.trim().isEmpty()) { /*Trim es para quitar espacios en blanco y isEmpty para ver si esta vacio despues del trim, bibliografia -->https://stackoverflow.com/questions/5819800/whats-the-better-way-to-check-if-a-string-is-empty-than-using-string-trim-len */
            throw new NombreInvalidoException("El nombre no puede estar vacío o contener solo espacios.");
        }
        return entrada;
    }
    public int leerNumeroJugadores() {
        int numJugadores = 0;
        boolean valido = false;

        while (!valido) {
        	System.out.println(); // Línea en blanco para hacer espacio
            System.out.print("Introduce el número de jugadores (entre 2 y 5): ");
            numJugadores = leerEntero();  
            if (numJugadores >= 2 && numJugadores <= 5) {
                valido = true;
            } else {
            	System.out.println();
                System.out.println("Número inválido. Debe estar entre 2 y 5.");
            }
        }

        return numJugadores;
    }

    
}
