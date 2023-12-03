package sample;

/**
 * La clase Lanzador representa a un personaje del juego con atributos como nombre, vida, nivel y género.
 */

public class Raza {

    private final String nombre;  // Nombre del lanzador.
    private final int vida_total; // Vida total del lanzador.
    private int vida;              // Vida actual del lanzador.
    private final int nivel;      // Nivel del lanzador.
    private final char genero;    // Género del lanzador.

    /**
     * Constructor de la clase Lanzador.
     *
     * @param nombre     Nombre del lanzador.
     * @param vida_total Vida total del lanzador.
     * @param vida       Vida actual del lanzador.
     * @param nivel      Nivel del lanzador.
     * @param genero     Género del lanzador.
     */
    
    public Raza(String nombre, int vida_total, int vida, int nivel, char genero) {
        this.nombre = nombre;
        this.vida_total = vida_total;
        this.vida = vida;
        this.nivel = nivel;
        this.genero = genero;
    }

    /**
     * Obtiene el nombre del lanzador.
     *
     * @return Nombre del lanzador.
     */
    
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la vida total del lanzador.
     *
     * @return Vida total del lanzador.
     */
    public int getVida_total() {
        return vida_total;
    }

    /**
     * Obtiene la vida actual del lanzador.
     *
     * @return Vida actual del lanzador.
     */
    
    public int getVida() {
        return vida;
    }

    /**
     * Establece la vida actual del lanzador.
     *
     * @param vida Nueva vida del lanzador.
     */
    
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene el nivel del lanzador.
     *
     * @return Nivel del lanzador.
     */
    
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene el género del lanzador.
     *
     * @return Género del lanzador.
     */
    
    public char getGenero() {
        return genero;
    }
}
