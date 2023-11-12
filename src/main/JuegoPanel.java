package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase JuegoPanel representa el panel del juego donde se muestra la interfaz gráfica.
 * Controla la representación visual del jugador y los enemigos, así como las actualizaciones
 * periódicas del juego.
 */
public class JuegoPanel extends JPanel {

    private Personaje jugador;
    private Enemigo enemigoActual;

    /**
     * Constructor que inicializa el panel del juego.
     *
     * @param jugador El personaje del jugador que se mostrará en el panel.
     */
    public JuegoPanel(Personaje jugador) {
        this.jugador = jugador;
        this.enemigoActual = generarEnemigoAleatorio();

        // Configurar el panel
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        // Configurar el temporizador para las actualizaciones del juego
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de actualización del juego
                // Aquí puedes manejar el movimiento del jugador, encuentros con enemigos, etc.
                // Por ahora, simplemente actualizaremos al enemigo actual
                enemigoActual = generarEnemigoAleatorio();

                // Volver a pintar el panel después de la actualización
                repaint();
            }
        });
        timer.start();
    }

    /**
     * Genera un enemigo aleatorio.
     *
     * @return Un enemigo con tipo y nivel aleatorios.
     */
    private Enemigo generarEnemigoAleatorio() {
        // Lógica para generar un enemigo aleatorio
        // Puedes personalizar esto según tus necesidades
        String[] tiposEnemigos = {"Monstruos de las Sombras", "Demonios Menores", "Metamorfo Inestable"};
        int nivelEnemigo = (int) (Math.random() * 10) + 1; // Nivel aleatorio entre 1 y 10
        int indiceTipoEnemigo = (int) (Math.random() * tiposEnemigos.length);

        return new Enemigo(tiposEnemigos[indiceTipoEnemigo], nivelEnemigo);
    }

    /**
     * Método sobrescrito que se llama automáticamente para pintar componentes en el panel.
     *
     * @param g El contexto gráfico utilizado para dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar al jugador
        g.setColor(Color.BLUE);
        g.fillRect(100, 100, 50, 50); // Puedes personalizar la apariencia y posición

        // Dibujar al enemigo actual
        g.setColor(Color.RED);
        g.fillRect(400, 100, 50, 50); // Puedes personalizar la apariencia y posición
    }
}
