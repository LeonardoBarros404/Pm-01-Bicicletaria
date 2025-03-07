package org.example;

public interface Venda {
    void realizarVenda(Produto produto, int quantidade);

    String gerarResumo();
}
