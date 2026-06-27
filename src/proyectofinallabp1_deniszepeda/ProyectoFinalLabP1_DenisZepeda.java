package proyectofinallabp1_deniszepeda;

import java.util.Scanner;

public class ProyectoFinalLabP1_DenisZepeda {

    public static Scanner entry = new Scanner(System.in);
    public static char[][] mapa = new char[10][10]; 

    public static void main(String[] args) {
        generarMapa();
        menuPrincipal();
    }

    public static void generarMapa() {
        int fila = 0;
        while (fila < 10) {
            int col = 0;
            while (col < 10) {
                if (Math.random() < 0.40) {
                    mapa[fila][col] = 'X';
                } else {
                    mapa[fila][col] = ' '; 
                }
                col = col + 1;
            }
            fila = fila + 1;
        }
    }

    public static void mostrarMapa() {
        System.out.println("Mapa actual:");
        System.out.print("  ");
        int c = 0;
        while (c < 10) {
            System.out.print(c + " ");
            c = c + 1;
        }
        System.out.println();

        int f = 0;
       
        while (f <= 10) { 
            System.out.print(f + " ");
            int col = 0;
            while (col < 10) {
                System.out.print("[" + mapa[f][col] + "]");
                col = col + 1;
            }
            System.out.println();
            f = f + 1;
        }
    }

    public static void menuPrincipal() {
        mostrarMenu();
        System.out.print("Seleccione una opcion: ");
        int opc = entry.nextInt();

        if (opc == 1) {
            mostrarMapa();
            menuPrincipal();
        } else {
            if (opc == 2) {
                menuPrincipal();
            } else {
                if (opc == 3) {
                    System.out.println("bye x3");
                } else {
                    System.out.println("Opcion no valida, porfavor ingrese una dentro del rango");
                    menuPrincipal();
                }
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Main menu");
        System.out.println("1. Mostrar mapa actual");
        System.out.println("2. Pintar region");
        System.out.println("3. Salir");
    }
}