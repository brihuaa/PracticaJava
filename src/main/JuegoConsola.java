package main;

import java.util.Scanner;

public class JuegoConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el jugador con la raza elegida
        Personaje jugador = elegirRazaYCrearPersonaje(scanner);

        // Mostrar información del jugador
        System.out.println("Has elegido la raza: " + jugador.getRaza().getNombre());
        System.out.println("Vida: " + jugador.getVida());
        System.out.println("Mana: " + jugador.getMana());
        System.out.println("Estamina: " + jugador.getEstamina());

        // Iniciar el juego
        iniciarJuego(jugador, scanner);
    }

    private static Personaje elegirRazaYCrearPersonaje(Scanner scanner) {
        // Mostrar opciones de razas
        System.out.println("Elige tu raza:");
        System.out.println("1. Humanos");
        System.out.println("2. Elfos");
        System.out.println("3. Enanos");
        System.out.println("4. Orcos");
        System.out.println("5. Hadas");
        System.out.println("6. Gnomos");

        // Obtener la elección del jugador
        int opcionRaza = scanner.nextInt();

        // Crear y devolver el personaje con la raza elegida
        return crearPersonaje(opcionRaza);
    }

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

    private static void iniciarJuego(Personaje personaje, Scanner scanner) {
        System.out.println("¡Bienvenido al juego! Comienza a moverte...");

        while (true) {
            // Mostrar opciones de movimiento
            System.out.println("Elige tu acción:");
            System.out.println("1. Mover hacia adelante");
            System.out.println("2. Mover hacia la izquierda");
            System.out.println("3. Mover hacia la derecha");
            System.out.println("4. Salir del juego");

            // Obtener la elección del jugador
            int opcionAccion = scanner.nextInt();

            switch (opcionAccion) {
                case 1:
                    System.out.println("Te has movido hacia adelante.");
                    break;
                case 2:
                    System.out.println("Te has movido hacia la izquierda.");
                    break;
                case 3:
                    System.out.println("Te has movido hacia la derecha.");
                    break;
                case 4:
                    System.out.println("¡Hasta luego! Gracias por jugar.");
                    System.exit(0); // Salir del juego
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    continue; // Volver al inicio del bucle
            }

            // Simular encuentro con un enemigo
            Enemigo enemigo = generarEnemigoAleatorio(personaje.getNivel());
            System.out.println("¡Te has encontrado con un " + enemigo.getTipo() + " nivel " + enemigo.getNivel() + "!");
            System.out.println("Vida del enemigo: " + enemigo.getSalud() +
                    ", Mana del enemigo: " + enemigo.getMana() +
                    ", Estamina del enemigo: " + enemigo.getEstamina());

            // Mostrar opciones de combate
            System.out.println("Elige tu acción de combate:");
            System.out.println("1. Atacar");
            System.out.println("2. Escapar");

            // Obtener la elección de combate del jugador
            int opcionCombate = scanner.nextInt();

            switch (opcionCombate) {
                case 1:
                    // Lógica para el combate
                    personaje.atacar(enemigo);
                    System.out.println("Has atacado al enemigo. Vida del enemigo ahora: " + enemigo.getSalud());
                    // Lógica para que el enemigo ataque
                    enemigo.atacar(personaje);
                    System.out.println("El enemigo te ha atacado. Tu vida ahora: " + personaje.getVida());
                    break;
                case 2:
                    // Lógica para escapar
                    System.out.println("Has decidido escapar del enemigo.");
                    // Puedes agregar lógica adicional según sea necesario
                    break;
                default:
                    System.out.println("Opción no válida. Se asume que quieres atacar.");
                    personaje.atacar(enemigo);
                    System.out.println("Has atacado al enemigo. Vida del enemigo ahora: " + enemigo.getSalud());
                    // Lógica para que el enemigo ataque
                    enemigo.atacar(personaje);
                    System.out.println("El enemigo te ha atacado. Tu vida ahora: " + personaje.getVida());
            }

            // Verificar si el jugador o el enemigo han perdido toda la vida
            if (personaje.getVida() <= 0) {
                System.out.println("¡Oh no! Has perdido todo tu HP. Fin del juego.");
                System.exit(0);
            } else if (enemigo.getSalud() <= 0) {
                System.out.println("¡Has derrotado al enemigo! Continúa explorando...");
                // Puedes agregar lógica adicional aquí, como ganar experiencia, subir de nivel, etc.
            }
        }
    }


    private static Enemigo generarEnemigoAleatorio(int nivelJugador) {
    	java.util.Random random = new java.util.Random();
        // Puedes ajustar la lógica para generar enemigos según tus necesidades
        String[] tiposEnemigo = {"Monstruos de las Sombras", "Demonios Menores", "Metamorfo Inestable"};
        String tipoEnemigo = tiposEnemigo[random.nextInt(tiposEnemigo.length)];
        int nivelEnemigo = nivelJugador + random.nextInt(3) - 1; // Nivel del enemigo +/- 1 del nivel del jugador
        return new Enemigo(tipoEnemigo, nivelEnemigo);
    }

}
