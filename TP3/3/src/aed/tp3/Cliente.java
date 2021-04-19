package aed.tp3;

public class Cliente {
    String morada;
    String nome;
    int valor;

    public Cliente(String morada, String nome, int valor) {
        this.morada = morada;
        this.nome = nome;
        this.valor = valor;
    }

    public String toString() {
        return this.nome + " " + this.morada + " " + this.valor;
    }

}
