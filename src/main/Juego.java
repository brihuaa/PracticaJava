package main;

import java.util.Scanner;

/**
 * La clase Juego representa la lógica principal del juego. Permite a los jugadores
 * seleccionar una raza al inicio, crea un personaje con la raza elegida y muestra
 * la información del jugador antes de continuar con la lógica del juego.
 */
public class Juego {

    /**
     * Punto de entrada principal del juego.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar opciones de razas
        System.out.println("Elige tu raza:");
        System.out.println("1. Humanos");
        System.out.println("2. Elfos");
        System.out.println("3. Enanos");
        System.out.println("4. Orcos");
        System.out.println("5. Hadas");
        System.out.println("6. Gnomos");

        // Obtener la elección del jugador
        int opcion = scanner.nextInt();

        // Crear el jugador con la raza elegida
        Personaje jugador = crearPersonaje(opcion);

        // Mostrar información del jugador
        System.out.println("Has elegido la raza: " + jugador.getRaza().getNombre());
        System.out.println("Vida: " + jugador.getVida());
        System.out.println("Mana: " + jugador.getMana());
        System.out.println("Estamina: " + jugador.getEstamina());

        // Ahora puedes continuar con la lógica del juego, como enfrentarse a enemigos, etc.
    }

    /**
     * Crea un personaje con la raza seleccionada por el jugador.
     *
     * @param opcion La opción de raza seleccionada por el jugador.
     * @return El personaje creado con la raza elegida.
     */
    private static Personaje crearPersonaje(int opcion) {
        Raza razaElegida;
        switch (opcion) {
            case 1:
                razaElegida = new Raza("Humanos", 5, 5, 5);
                break;
            case 2:
                razaElegida = new Raza("Elfos", 8, 4, 6);
                break;
            case 3:
                razaElegida = new Raza("Enanos", 4, 8, 6);
                break;
            case 4:
                razaElegida = new Raza("Orcos", 3, 7, 8);
                break;
            case 5:
                razaElegida = new Raza("Hadas", 9, 3, 5);
                break;
            case 6:
                razaElegida = new Raza("Gnomos", 7, 4, 7);
                break;
            default:
                // Por defecto, elegir humanos
                razaElegida = new Raza("Humanos", 5, 5, 5);
        }

        // Crear y devolver el personaje con la raza elegida
        return new Personaje("Jugador", 1, razaElegida);
    }
}
