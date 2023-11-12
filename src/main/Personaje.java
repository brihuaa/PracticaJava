package main;

import java.util.Random;

public class Personaje {
    private String nombre;
    private int nivel;
    private int vida;
    private int mana;
    private int estamina;
    private Raza raza; // Agregamos un atributo para la raza del personaje

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

    public void recibirAtaque(int dano) {
        // Restamos el daño recibido a la vida del personaje
        this.vida -= dano;
    }

    public void atacar(Personaje enemigo) {
        // Lógica para el ataque del personaje
        // Puedes ajustar esta lógica según tus necesidades
        Random random = new Random();
        int dano = random.nextInt(10) + nivel * 2;
        enemigo.recibirAtaque(dano);
    }

    // Otros métodos según sea necesario

    public Raza getRaza() {
        return raza;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getEstamina() {
        return estamina;
    }
}
