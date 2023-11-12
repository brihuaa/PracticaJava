package main;

import java.util.Scanner;

public class Movimiento {

    // Tamaño del mapa
    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;

    // Matriz para representar el mapa
    private static char[][] mapa = new char[FILAS][COLUMNAS];

    // Posición inicial del jugador
    private static int jugadorFila = 2;
    private static int jugadorColumna = 2;

    public static void main(String[] args) {
        inicializarMapa();
        mostrarMapa();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa la dirección (w/a/s/d para arriba/izquierda/abajo/derecha, q para salir): ");
            char direccion = scanner.next().charAt(0);

            if (direccion == 'q') {
                System.out.println("¡Hasta luego!");
                break;
            }

            moverJugador(direccion);
            mostrarMapa();
        }

        scanner.close();
    }

    private static void inicializarMapa() {
        // Llenar el mapa con caracteres representativos del terreno (puedes personalizar esto según tu juego)
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                mapa[i][j] = '.';
            }
        }

        // Colocar al jugador en la posición inicial
        mapa[jugadorFila][jugadorColumna] = 'P';
    }

    private static void mostrarMapa() {
        // Mostrar el mapa en la consola
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void moverJugador(char direccion) {
        // Mover al jugador en la dirección especificada
        switch (direccion) {
            case 'w':
                if (jugadorFila > 0) {
                    mapa[jugadorFila][jugadorColumna] = '.';
                    jugadorFila--;
                    mapa[jugadorFila][jugadorColumna] = 'P';
                }
                break;
            case 'a':
                if (jugadorColumna > 0) {
                    mapa[jugadorFila][jugadorColumna] = '.';
                    jugadorColumna--;
                    mapa[jugadorFila][jugadorColumna] = 'P';
                }
                break;
            case 's':
                if (jugadorFila < FILAS - 1) {
                    mapa[jugadorFila][jugadorColumna] = '.';
                    jugadorFila++;
                    mapa[jugadorFila][jugadorColumna] = 'P';
                }
                break;
            case 'd':
                if (jugadorColumna < COLUMNAS - 1) {
                    mapa[jugadorFila][jugadorColumna] = '.';
                    jugadorColumna++;
                    mapa[jugadorFila][jugadorColumna] = 'P';
                }
                break;
            default:
                System.out.println("Dirección no válida.");
        }
    }
}
