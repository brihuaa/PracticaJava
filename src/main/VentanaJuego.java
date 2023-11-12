package main;

/**
 * La clase VentanaJuego representa la ventana principal del juego, que contiene un panel de juego.
 * Extiende la clase JFrame y se utiliza para mostrar la interfaz gráfica del juego.
 */
public class VentanaJuego extends JFrame {

    /**
     * Constructor que crea una nueva ventana de juego con el personaje proporcionado.
     *
     * @param jugador El personaje del jugador que se utilizará en el juego.
     */
    public VentanaJuego(Personaje jugador) {
        setTitle("Mi Juego RPG"); // Personaliza el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Evita que la ventana sea redimensionada
        setLocationRelativeTo(null); // Coloca la ventana en el centro de la pantalla

        // Crea un nuevo panel de juego y agrégalo a la ventana
        JuegoPanel juegoPanel = new JuegoPanel(jugador);
        add(juegoPanel);

        // Empaqueta y muestra la ventana
        pack();
        setVisible(true);
    }

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * Puedes inicializar y crear un personaje si lo deseas,
     * luego crea una instancia de VentanaJuego pasando el personaje como parámetro.
     * Ejemplo:
     * <pre>
     * {@code
     * Raza razaElegida = new Raza("Humanos", 5, 5, 5);
     * Personaje jugador = new Personaje("Jugador", 1, razaElegida);
     * new VentanaJuego(jugador);
     * }
     * </pre>
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este ejemplo).
     */
    public static void main(String[] args) {
        // Aquí puedes inicializar y crear un personaje si lo deseas
        // Luego, crea una instancia de VentanaJuego pasando el personaje como parámetro
        // Ejemplo:
        // Raza razaElegida = new Raza("Humanos", 5, 5, 5);
        // Personaje jugador = new Personaje("Jugador", 1, razaElegida);
        // new VentanaJuego(jugador);
    }
}
