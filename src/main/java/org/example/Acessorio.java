package org.example;

public class Acessorio extends Produto{
    public String tipo;

    public Acessorio(String nome, double preco, int qtdEstoque, String tipo){
        super(nome, preco, qtdEstoque);
        this.tipo=tipo;
    }

    @Override
    public String getInfo(){
        return "Acessório: " +getNome() + ", Tipo: " +tipo +", Preço: " + getPreco();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Tipo não pode ser nulo ou vazio.");
        }
        this.tipo = tipo;
    }
}