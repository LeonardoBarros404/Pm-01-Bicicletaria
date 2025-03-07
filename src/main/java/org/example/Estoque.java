package org.example;

import java.util.ArrayList;
import java.util.List;
public class Estoque {
    private List<Produto> produtos;
    public Estoque(){
        this.produtos=new ArrayList<>();
    }
    public void cadastrarProduto(Produto produto){
        produtos.add(produto);
    }
    public void removerProduto(Produto produto){
        produtos.remove(produto);
    }
    public Produto buscarProduto(String nome){
        for (Produto produto:produtos){
            if (produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        return null;
    }


    public void atualizarEstoque(String nome, int quantidade){
        Produto produto=buscarProduto(nome);
        if (produto!=null){
            produto.atualizarEstoque(quantidade);
        }else{
            System.out.println("Produto não encontrado.");
        }
    }
    public void listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produtos cadastrado.");
        }else {
            System.out.println("--- Produtos Cadastrados ---");
            for (Produto produto:produtos){
                System.out.println(produto.getInfo());
            }
            System.out.println("------------------------------");
        }
    }
}