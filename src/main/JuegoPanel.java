package main;

import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoPanel extends JPanel implements ActionListener {

    private Timer timer;
    private Personaje jugador;
    private Enemigo enemigo;

    public JuegoPanel() {
        setFocusable(true);
        addKeyListener(new TecladoListener());

        // Crear el jugador con la raza elegida
        jugador = crearPersonaje();

        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar al jugador
        g.setColor(Color.BLUE);
        g.fillRect(jugador.getX(), jugador.getY(), 20, 20);

        // Dibujar al enemigo
        if (enemigo != null && !enemigo.isVencido()) {
            g.setColor(Color.RED);
            g.fillRect(enemigo.getX(), enemigo.getY(), 20, 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moverEnemigo();
        repaint();
    }

    private void moverEnemigo() {
        if (enemigo == null || enemigo.isVencido()) {
            // Generar un nuevo enemigo si no hay ninguno o el enemigo anterior fue vencido
            enemigo = new Enemigo();
        }

        // Mover el enemigo hacia el jugador (puedes ajustar la lógica de movimiento según tus necesidades)
        int direccionX = jugador.getX() > enemigo.getX() ? 1 : -1;
        int direccionY = jugador.getY() > enemigo.getY() ? 1 : -1;
        enemigo.mover(direccionX, direccionY);

        // Verificar colisiones
        if (jugador.getX() < enemigo.getX() + 20 && jugador.getX() + 20 > enemigo.getX()
                && jugador.getY() < enemigo.getY() + 20 && jugador.getY() + 20 > enemigo.getY()) {
            // Colisión con el enemigo, realizar lógica de combate
            jugador.atacar(enemigo);
            if (enemigo.isVencido()) {
                // Recompensa al jugador por vencer al enemigo
                jugador.recibirRecompensa();
            }
        }
    }