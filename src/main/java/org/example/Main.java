package org.example;

import java.util.Scanner;

public class Main {
    private static Estoque estoque=new Estoque();
    private static VendaSimples vendaSimples =new VendaSimples();
    public static Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao=scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastrarBicicleta();
                    pausar();
                    break;
                case 2:
                    cadastrarAcessorio();
                    pausar();
                    break;
                case 3:
                    realizarVenda();
                    pausar();
                    break;
                case 4:
                    gerarResumo();
                    pausar();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao!=5);
    }

    public static void exibirMenu(){
        System.out.println("---Menu Principal---");
        System.out.println("1-Cadastrar Bicicletas");
        System.out.println("2-Cadastrar Acessórios");
        System.out.println("3-Realizar Venda");
        System.out.println("4-Gerar Resumo");
        System.out.println("5-Sair");
    }
    public static void cadastrarBicicleta(){
        System.out.print("Nome da Bicicleta: ");
        String nome = scanner.nextLine();
        System.out.print("Preço da bicicleta: ");
        double preco= scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int qtdEstoque = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marca da bicicleta: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo da bicicleta: ");
        String modelo = scanner.nextLine();
        System.out.print("Tamanhp da bicicleta: ");
        String tamanho = scanner.nextLine();

        Bicicleta bicicleta = new Bicicleta(nome,preco,qtdEstoque,marca,modelo,tamanho);
        estoque.cadastrarProduto(bicicleta);
        System.out.println("Bicicleta cadastrada com sucesso!");
    }
    public static void cadastrarAcessorio(){
        System.out.println("Nome do acessório: ");
        String nome = scanner.nextLine();
        System.out.println("Preço do acessório: ");
        double preco = scanner.nextDouble();
        System.out.println("Quantidade em estoque: ");
        int qtdEstoque=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tipo do acessório: ");
        String tipo = scanner.nextLine();

        Acessorio acessorio=new Acessorio(nome,preco,qtdEstoque,tipo);
        estoque.cadastrarProduto(acessorio);
        System.out.println("Acessório cadastrado com sucesso!");
    }

    public static void realizarVenda(){
        estoque.listarProdutos();
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        Produto produto=estoque.buscarProduto(nome);
        if (produto!=null){
            System.out.println("Quantidade a vender: ");
            int quantidade = scanner.nextInt();
            vendaSimples.realizarVenda(produto,quantidade);
        }else {
            System.out.println("Produto não encontrado.");
        }
    }
    public static void gerarResumo(){
        System.out.println(vendaSimples.gerarResumo());
    }
    public static void pausar(){
        System.out.println("Pressione Enter para continuar");
        scanner.nextLine();
    }
}