package org.example;

public class VendaSimples implements Venda{
    private double totalVenda;
    public VendaSimples(){
        this.totalVenda=0.0;
    };
    @Override
    public void realizarVenda(Produto produto, int quantidade){
        if (produto.getQtdEstoque() >= quantidade){
            produto.atualizarEstoque(-quantidade);
            totalVenda+= produto.getPreco()* quantidade;
            System.out.println("Venda realizada: "+quantidade+"x "+produto.getNome());
        }else {
        System.out.println("Estoque insuficiente para" +produto.getNome());
        }
    }

    @Override
    public String gerarResumo() {
        return "Total de vendas: R$: "+totalVenda;
    }

}
