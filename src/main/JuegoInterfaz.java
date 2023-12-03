package main;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JuegoInterfaz extends JFrame {

    public JuegoInterfaz() {
        setTitle("Selección de Raza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 6, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        // Crear una etiqueta para el fondo y establecer la imagen
        JLabel fondoLabel = new JLabel();
        ImageIcon fondoIcono = createImageIcon("PracticaProgramacion/resources/Fondo.png", "Fondo");
        fondoLabel.setIcon(fondoIcono);

        // Crear un panel para los botones de selección de raza
        JPanel panelRazas = new JPanel(new GridLayout(2, 6, 10, 10));

        // Agregar botones y etiquetas de razas al panelRazas
        String[] razas = {"Humano", "Elfo", "Enano", "Gnomo", "Hada", "Orco"};
        String[] avatarPaths = {"/humano.png", "/elfo.png", "/enano.png", "/gnomo.png", "/hada.png", "/orco.png"};

        for (int i = 0; i < razas.length; i++) {
            ImageIcon icon = createImageIcon(avatarPaths[i], razas[i]);
            JLabel label = new JLabel(razas[i], JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setIcon(icon);
            panelRazas.add(label);
        }

        // Agregar el fondo y el panel de razas al panel principal
        panelPrincipal.add(fondoLabel);
        panelPrincipal.add(panelRazas);

        // Agregar el panel principal a la ventana
        add(panelPrincipal);

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
