package main;

public class Vinho {
    private double preço;
    private String nome;
    private String pais;
    private int ano;

    public Vinho(double preço, String nome, String pais, int ano) {
        this.preço = preço;
        this.nome = nome;
        this.pais = pais;
        this.ano = ano;
    }

    public double getPreço() {
        return preço;
    }
}

