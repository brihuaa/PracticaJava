package main;

public class Raza {
    private String nombre;
    private int bonusVida;
    private int bonusMana;
    private int bonusEstamina;

    public Raza(String nombre, int bonusVida, int bonusMana, int bonusEstamina) {
        this.nombre = nombre;
        this.bonusVida = bonusVida;
        this.bonusMana = bonusMana;
        this.bonusEstamina = bonusEstamina;
    }

    // Métodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public int getBonusEstamina() {
        return bonusEstamina;
    }
}
