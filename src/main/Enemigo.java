package main;

/**
 * La clase Enemigo representa a los enemigos con los que el jugador puede enfrentarse en el juego.
 * Cada enemigo tiene un tipo, nivel, salud, mana y estamina.
 * La salud, mana y estamina se inicializan según el tipo y el nivel del enemigo.
 */
public class Enemigo {
    private String tipo;
    private int nivel;
    private int salud;
    private int mana;
    private int estamina;

    /**
     * Constructor de la clase Enemigo.
     * Inicializa un enemigo con un tipo y nivel específicos.
     * Inicializa la salud, mana y estamina según el tipo y el nivel.
     *
     * @param tipo  El tipo de enemigo.
     * @param nivel El nivel del enemigo.
     */
    public Enemigo(String tipo, int nivel) {
        this.tipo = tipo;
        this.nivel = nivel;
        inicializarAtributos();
        
    }

    /**
     * Inicializa la salud, mana y estamina del enemigo según su tipo y nivel.
     * Los valores específicos se determinan mediante un conjunto de reglas basadas en el tipo de enemigo.
     */
    private void inicializarAtributos() {
        // Lógica para inicializar salud, mana y estamina según el tipo y el nivel del enemigo
        // ...
    }

    /**
     * Método para que el enemigo reciba un ataque del jugador.
     *
     * @param dano El daño infligido por el jugador.
     */
    public void recibirAtaque(int dano) {
        // Resta el daño recibido a la salud del enemigo
        this.salud -= dano;
    }

    /**
     * Método que representa el ataque del enemigo al jugador.
     * La lógica de ataque se basa en el nivel del enemigo y utiliza valores aleatorios para el daño infligido.
     *
     * @param jugador El personaje del jugador que recibe el ataque.
     */
    public void atacar(Personaje jugador) {
        // Lógica para el ataque del enemigo al jugador
        // ...
    }

    // Métodos getters y setters según sea necesario

    /**
     * Obtiene el tipo de enemigo.
     *
     * @return El tipo de enemigo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nivel del enemigo.
     *
     * @return El nivel del enemigo.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene la salud actual del enemigo.
     *
     * @return La salud actual del enemigo.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Obtiene el mana actual del enemigo.
     *
     * @return El mana actual del enemigo.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Obtiene la estamina actual del enemigo.
     *
     * @return La estamina actual del enemigo.
     */
    public int getEstamina() {
        return estamina;
    }
}
