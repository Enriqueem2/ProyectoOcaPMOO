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
            System.out.println("Por favor, introduce un n�mero v�lido:");
            sc.next(); 
        }
        int numero = sc.nextInt();
        sc.nextLine(); // salta de linea
        return numero;
    }
    
    public String leerString(String pMensaje) {
        System.out.print(pMensaje);
        return sc.nextLine();
    }
    
    public int leerNumeroJugadores() {
        int numJugadores = 0;
        boolean valido = false;

        while (!valido) {
        	System.out.println(); // L�nea en blanco para hacer espacio
            System.out.print("Introduce el n�mero de jugadores (entre 1 y 5): ");
            numJugadores = leerEntero();  
            if (numJugadores >= 2 && numJugadores <= 5) {
                valido = true;
            } else {
            	System.out.println();
                System.out.println("N�mero inv�lido. Debe estar entre 1 y 5.");
            }
        }

        return numJugadores;
    }

    
}
