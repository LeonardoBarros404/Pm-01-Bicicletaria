package org.example;

public class Bicicleta extends Produto{
    public String modelo;
    public String marca;
    public String tamanho;


    //construtor

    public Bicicleta(String nome, double preco, int qtdEstoque, String marca, String modelo, String tamanho) {
        super(nome, preco, qtdEstoque);
        this.marca = marca;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    //metodo abstrato
    @Override
    public String getInfo() {
        return "Bicicleta: " + nome + ", Marca: " + marca + ", Modelo: " + modelo + ", Tamanho: " + tamanho + ", Preço: " + preco;
    }

    //metodo get
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    //metodo set
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}