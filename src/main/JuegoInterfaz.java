package main;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JuegoInterfaz extends JFrame {

    public JuegoInterfaz() {
        setTitle("Selección de Raza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 6, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        JButton boton = new JButton("GNOMO");

        String[] razas = {"Humano", "Elfo", "Enano", "Gnomo", "Hada", "Orco"};
        String[] avatarPaths = {"/humano.png", "/elfo.png", "/enano.png", "/gnomo.png", "/hada.png", "/orco.png"
        };

        for (int i = 0; i < razas.length; i++) {
            ImageIcon icon = createImageIcon(avatarPaths[i], razas[i]);
            JLabel label = new JLabel(razas[i], JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setIcon(icon);
            panel.add(label);
            
        }
        add(boton);
        add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private ImageIcon createImageIcon(String path, String description) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl, description);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoInterfaz());
    }

}

