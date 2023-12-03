package sample;

public class Raza {

    private final String nombre;
    private final int vida_total;
    private int vida;
    private final int nivel;
    private final char genero;

    public Pokemon(String nombre, int vida_total, int vida, int nivel, char genero) {
        this.nombre = nombre;
        this.vida_total = vida_total;
        this.vida = vida;
        this.nivel = nivel;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida_total(){return vida_total;}


    public int getVida() {
        return vida;
    }

    public void setVida(int vida){
        this.vida=vida;
    }


    public int getNivel() {
        return nivel;
    }


    public char getGenero() {
        return genero;
    }

}
