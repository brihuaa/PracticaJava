package main;

import java.util.Random;

/**
 * La clase Personaje representa a un personaje del juego con atributos como nombre, nivel, vida, mana y estamina.
 * También incluye métodos para recibir ataques, realizar ataques y obtener información sobre el personaje.
 */
public class Personaje {
    private String nombre;
    private int nivel;
    private int vida;
    private int mana;
    private int estamina;
    private Raza raza; // Agregamos un atributo para la raza del personaje

    /**
     * Constructor que crea un nuevo personaje con el nombre, nivel y raza especificados.
     *
     * @param nombre El nombre del personaje.
     * @param nivel  El nivel del personaje.
     * @param raza   La raza del personaje.
     */
    public Personaje(String nombre, int nivel, Raza raza) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.raza = raza;
        // Inicializamos vida, mana y estamina según la raza y el nivel
        this.vida = 100 + nivel * raza.getBonusVida();
        this.mana = 50 + nivel * raza.getBonusMana();
        this.estamina = 50 + nivel * raza.getBonusEstamina();
    }

    // Métodos getters y setters

    /**
     * Recibe un ataque y reduce la vida del personaje.
     *
     * @param dano El daño recibido.
     */
    public void recibirAtaque(int dano) {
        // Restamos el daño recibido a la vida del personaje
        this.vida -= dano;
    }

    /**
     * Realiza un ataque al enemigo especificado.
     *
     * @param enemigo El personaje enemigo al que se realiza el ataque.
     */
    public void atacar(Personaje enemigo) {
        // Lógica para el ataque del personaje
        // Puedes ajustar esta lógica según tus necesidades
        Random random = new Random();
        int dano = random.nextInt(10) + nivel * 2;
        enemigo.recibirAtaque(dano);
    }

    // Otros métodos según sea necesario

    /**
     * Obtiene la raza del personaje.
     *
     * @return La raza del personaje.
     */
    public Raza getRaza() {
        return raza;
    }

    /**
     * Obtiene la vida actual del personaje.
     *
     * @return La vida actual del personaje.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Obtiene el mana actual del personaje.
     *
     * @return El mana actual del personaje.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Obtiene la estamina actual del personaje.
     *
     * @return La estamina actual del personaje.
     */
    public int getEstamina() {
        return estamina;
    }
}
