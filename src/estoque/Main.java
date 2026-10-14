package estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada estoque = new ListaEncadeada();
        int opcao;

        do {
            System.out.println("\n--- SISTEMA DE CONTROLE DE ESTOQUE ---");
            System.out.println("1. Inserir produto no Início");
            System.out.println("2. Inserir produto no Fim");
            System.out.println("3. Inserir produto em Posição Específica");
            System.out.println("4. Remover produto do Início");
            System.out.println("5. Remover produto do Fim");
            System.out.println("6. Remover produto de Posição Específica");
            System.out.println("7. Pesquisar produto por Código");
            System.out.println("8. Verificar Posição de um Produto");
            System.out.println("9. Listar Geral");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço (R$): ");
                    double preco = scanner.nextDouble();

                    Produto p = new Produto(codigo, nome, quantidade, preco);

                    if (opcao == 1) {
                        estoque.inserirInicio(p);
                    } else if (opcao == 2) {
                        estoque.inserirFim(p);
                    } else {
                        System.out.print("Digite a posição desejada: ");
                        int pos = scanner.nextInt();
                        estoque.inserirPosicao(pos, p);
                    }
                    break;

                case 4:
                    estoque.removerInicio();
                    break;

                case 5:
                    estoque.removerFim();
                    break;

                case 6:
                    System.out.print("Digite a posição que deseja remover: ");
                    int posRem = scanner.nextInt();
                    estoque.removerPosicao(posRem);
                    break;

                case 7:
                    System.out.print("Digite o código do produto para pesquisar: ");
                    int codBusca = scanner.nextInt();
                    Produto encontrado = estoque.pesquisar(codBusca);
                    if (encontrado != null) {
                        System.out.println(">> Encontrado: " + encontrado);
                    } else {
                        System.out.println(">> Produto não encontrado no estoque.");
                    }
                    break;

                case 8:
                    System.out.print("Digite o código do produto para verificar a posição: ");
                    int codPos = scanner.nextInt();
                    int posicao = estoque.verificarPosicao(codPos);
                    if (posicao != -1) {
                        System.out.println(">> O produto está na posição: " + posicao);
                    } else {
                        System.out.println(">> Produto não encontrado no estoque.");
                    }
                    break;

                case 9:
                    estoque.listarGeral();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}