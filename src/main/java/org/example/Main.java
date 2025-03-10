package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Estoque estoque = new Estoque();
    private static VendaSimples vendaSimples = new VendaSimples();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite a opção desejada: ");

            switch (opcao) {
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
        } while (opcao != 5);
    }

    public static void exibirMenu() {
        System.out.println("--- Menu Principal ---");
        System.out.println("1 - Cadastrar Bicicletas");
        System.out.println("2 - Cadastrar Acessórios");
        System.out.println("3 - Realizar Venda");
        System.out.println("4 - Gerar Resumo");
        System.out.println("5 - Sair");
    }

    public static void cadastrarBicicleta() {
        System.out.print("Nome da Bicicleta: ");
        String nome = scanner.nextLine();
        double preco = lerDouble("Preço da bicicleta: ");
        int qtdEstoque = lerInteiro("Quantidade em estoque: ");
        System.out.print("Marca da bicicleta: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo da bicicleta: ");
        String modelo = scanner.nextLine();
        System.out.print("Tamanho da bicicleta: ");
        String tamanho = scanner.nextLine();

        Bicicleta bicicleta = new Bicicleta(nome, preco, qtdEstoque, marca, modelo, tamanho);
        estoque.cadastrarProduto(bicicleta);
        System.out.println("Bicicleta cadastrada com sucesso!");
    }

    public static void cadastrarAcessorio() {
        System.out.print("Nome do acessório: ");
        String nome = scanner.nextLine();
        double preco = lerDouble("Preço do acessório: ");
        int qtdEstoque = lerInteiro("Quantidade em estoque: ");
        System.out.print("Tipo do acessório: ");
        String tipo = scanner.nextLine();

        Acessorio acessorio = new Acessorio(nome, preco, qtdEstoque, tipo);
        estoque.cadastrarProduto(acessorio);
        System.out.println("Acessório cadastrado com sucesso!");
    }

    public static void realizarVenda() {
        estoque.listarProdutos();
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        Produto produto = estoque.buscarProduto(nome);
        if (produto != null) {
            int quantidade = lerInteiro("Quantidade a vender: ");
            vendaSimples.realizarVenda(produto, quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void gerarResumo() {
        System.out.println(vendaSimples.gerarResumo());
    }

    public static void pausar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static int lerInteiro(String mensagem) {
        int valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        return valor;
    }

    public static double lerDouble(String mensagem) {
        double valor = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor numérico.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        return valor;
    }
}
