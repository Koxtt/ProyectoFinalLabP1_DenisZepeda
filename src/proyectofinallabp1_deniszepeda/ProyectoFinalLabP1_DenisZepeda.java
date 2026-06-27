package proyectofinallabp1_deniszepeda;

import java.util.Scanner;

public class ProyectoFinalLabP1_DenisZepeda {

    public static Scanner entry = new Scanner(System.in);
    public static char[][] mapa = new char[9][9]; 

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        mostrarMenu();
        System.out.print("Seleccione una opcion: ");
        int opc = entry.nextInt();

        if (opc == 1) {
            System.out.println("Mostrando mapa...");
            menuPrincipal(); 
        } else {
            if (opc == 2) {
                System.out.println("Pintando region...");
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