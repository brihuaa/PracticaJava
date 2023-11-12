package main;

/**
 * La clase Raza representa una raza en el juego con atributos como nombre, bonus de vida, bonus de mana y bonus de estamina.
 * Esta clase se utiliza para definir las características específicas de cada raza en el juego.
 */
public class Raza {
    private String nombre;
    private int bonusVida;
    private int bonusMana;
    private int bonusEstamina;

    /**
     * Constructor que crea una nueva raza con el nombre y los bonus especificados.
     *
     * @param nombre       El nombre de la raza.
     * @param bonusVida    El bonus de vida de la raza.
     * @param bonusMana    El bonus de mana de la raza.
     * @param bonusEstamina El bonus de estamina de la raza.
     */
    public Raza(String nombre, int bonusVida, int bonusMana, int bonusEstamina) {
        this.nombre = nombre;
        this.bonusVida = bonusVida;
        this.bonusMana = bonusMana;
        this.bonusEstamina = bonusEstamina;
    }

    // Métodos getters y setters

    /**
     * Obtiene el nombre de la raza.
     *
     * @return El nombre de la raza.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el bonus de vida de la raza.
     *
     * @return El bonus de vida de la raza.
     */
    public int getBonusVida() {
        return bonusVida;
    }

    /**
     * Obtiene el bonus de mana de la raza.
     *
     * @return El bonus de mana de la raza.
     */
    public int getBonusMana() {
        return bonusMana;
    }

    /**
     * Obtiene el bonus de estamina de la raza.
     *
     * @return El bonus de estamina de la raza.
     */
    public int getBonusEstamina() {
        return bonusEstamina;
    }
}
