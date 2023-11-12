package main;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {

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

    public static void main(String[] args) {
        // Aquí puedes inicializar y crear un personaje si lo deseas
        // Luego, crea una instancia de VentanaJuego pasando el personaje como parámetro
        // Ejemplo:
        // Raza razaElegida = new Raza("Humanos", 5, 5, 5);
        // Personaje jugador = new Personaje("Jugador", 1, razaElegida);
        // new VentanaJuego(jugador);
    }
}
