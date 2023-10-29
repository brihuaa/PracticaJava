package main;

import java.util.Random;

public class Enemigo {
    private String tipo;
    private int nivel;
    private int salud;
    private int mana;
    private int estamina;

    public Enemigo(String tipo, int nivel) {
        this.tipo = tipo;
        this.nivel = nivel;
        // Inicializar salud, mana y estamina según el tipo y el nivel
        inicializarAtributos();
    }

    private void inicializarAtributos() {
        Random random = new Random();
        switch (tipo) {
            case "Monstruos de las Sombras":
                salud = 50 + nivel * 5;
                mana = 20 + nivel * 2;
                estamina = 30 + nivel * 3;
                break;
            case "Demonios Menores":
                salud = 60 + nivel * 6;
                mana = 25 + nivel * 2;
                estamina = 25 + nivel * 2;
                break;
            case "Metamorfo Inestable":
                salud = 40 + nivel * 4;
                mana = 30 + nivel * 3;
                estamina = 35 + nivel * 3;
                break;
            case "Criaturas Nocturnas Avanzadas":
                salud = 120 + nivel * 10;
                mana = 40 + nivel * 4;
                estamina = 50 + nivel * 5;
                break;
            case "Demonios de las Llamas":
                salud = 150 + nivel * 10;
                mana = 50 + nivel * 5;
                estamina = 40 + nivel * 4;
                break;
            case "Metamorfos Cambiantes":
                salud = 100 + nivel * 8;
                mana = 60 + nivel * 6;
                estamina = 55 + nivel * 5;
                break;
            case "Bestias de la Oscuridad":
                salud = 200 + nivel * 10;
                mana = 70 + nivel * 7;
                estamina = 60 + nivel * 6;
                break;
            case "Señores Demoníacos":
                salud = 250 + nivel * 10;
                mana = 80 + nivel * 8;
                estamina = 70 + nivel * 7;
                break;
            case "Metamorfos Maestros":
                salud = 180 + nivel * 9;
                mana = 90 + nivel * 9;
                estamina = 80 + nivel * 8;
                break;
            case "Pesadillas Vivientes":
                salud = 300 + nivel * 10;
                mana = 100 + nivel * 10;
                estamina = 90 + nivel * 9;
                break;
            case "Archidemonios":
                salud = 350 + nivel * 10;
                mana = 120 + nivel * 12;
                estamina = 100 + nivel * 10;
                break;
            case "Metamorfos Épicos":
                salud = 280 + nivel * 10;
                mana = 130 + nivel * 13;
                estamina = 110 + nivel * 11;
                break;
            default:
                // En caso de tipo desconocido, establecer atributos predeterminados
                salud = 50;
                mana = 20;
                estamina = 30;
        }
    }

    // Métodos getters y setters según sea necesario

    public void recibirAtaque(int dano) {
        // Restamos el daño recibido a la salud del enemigo
        this.salud -= dano;
    }

    public void atacar(Personaje jugador) {
        // Lógica para el ataque del enemigo al jugador
        // Puedes ajustar esta lógica según tus necesidades
        Random random = new Random();
        int dano = random.nextInt(10) + nivel * 2;
        jugador.recibirAtaque(dano);
    }
}
