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
        while (f < 10) { 
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

    public static int[] solicitarCoordenada() {
        int[] coords = new int[2];
        System.out.print("Ingrese fila (0-9): ");
        int f = entry.nextInt();
        System.out.print("Ingrese columna (0-9): ");
        int c = entry.nextInt();
        coords[0] = f; 
        coords[1] = c;
        return coords;
    }

    public static boolean coordenadaValida(int f, int c) {
        if (f >= 0 && f < 10 && c >= 0 && c < 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void pintarRegion(int f, int c) {
        if (coordenadaValida(f, c) == false || mapa[f][c] != 'X') {
            // Base
        } else {
            mapa[f][c] = '#';
            pintarRegion(f + 1, c); 
            pintarRegion(f - 1, c); 
            pintarRegion(f, c + 1); 
            pintarRegion(f, c - 1);
        }
    }

    public static int contarRegion(int f, int c) {
        if (coordenadaValida(f, c) == false || mapa[f][c] != '#') {
            return 0;
        } else {
            mapa[f][c] = 'v'; 
            
            int abajo = contarRegion(f + 1, c);
            int arriba = contarRegion(f - 1, c);
            int derecha = contarRegion(f, c + 1);
            int izquierda = contarRegion(f, c - 1);
            
            return abajo + arriba + derecha + izquierda; 
        }
    }

    public static void restaurarMapa(int f, int c) {
        if (coordenadaValida(f, c) && mapa[f][c] == 'v') {
            mapa[f][c] = '#';
            restaurarMapa(f + 1, c);
            restaurarMapa(f - 1, c);
            restaurarMapa(f, c + 1);
            restaurarMapa(f, c - 1);
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
                System.out.println("PINTAR REGION");
                int[] posicion = solicitarCoordenada();
                
                if (coordenadaValida(posicion[0], posicion[1])) {
                    char actual = mapa[posicion[0]][posicion[1]];
                    
                    if (actual == ' ') {
                        System.out.println("No hay region para pintar (celda vacia)");
                    } else {
                        if (actual == '#') {
                            System.out.println("Esta region ya fue pintada");
                        } else {
                            if (actual == 'X') { 
                                System.out.println("Pintando region...");
                                pintarRegion(posicion[0], posicion[1]);
                                
                                
                                int total = contarRegion(posicion[0], posicion[1]);
                                restaurarMapa(posicion[0], posicion[1]); 
                                
                                System.out.println("Region pintada exitosamente.");
                                System.out.println("Cantidad de regiones pintadas: " + total);
                            }
                        }
                    }
                } else {
                    System.out.println("Error: Coordenada fuera de los limites.");
                }
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