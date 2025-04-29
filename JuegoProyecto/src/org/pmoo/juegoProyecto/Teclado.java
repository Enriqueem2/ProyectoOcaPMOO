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
    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
    public int leerNumeroJugadores() {
        int numJugadores = 0;
        boolean valido = false;

        while (!valido) {
        	System.out.println(); // Línea en blanco para hacer espacio
            System.out.print("Introduce el número de jugadores (entre 1 y 5): ");
            numJugadores = leerEntero();  

            if (numJugadores >= 2 && numJugadores <= 5) {
                valido = true;
            } else {
            	System.out.println();
                System.out.println("Número inválido. Debe estar entre 1 y 5.");
            }
        }

        return numJugadores;
    }

    
}
