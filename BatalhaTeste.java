package br.unisinos;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BatalhaTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria jogadores:
        Controle controleJogador = new Controle(4, 5, 6);
        Controle controleComputador = new Controle(4, 5, 6);

        // Cria objeto apenas para mostrar tabuleiro do computador:
        Controle tabuleiroComputador = new Controle(0, 0, 0);

        // Cria objeto apenas para verificar peças já atingidas:
        Controle tabuleiroJogador = new Controle(0, 0, 0);

        JOptionPane.showMessageDialog(null, "❤️ Bem-vindo ao jogo de batalha naval ❤️");

        controleJogador.setNome(JOptionPane.showInputDialog("Por gentileza, insira o seu nome para iniciarmos o jogo!"));
        try {
            System.out.println("Suas informações iniciais:\n❤️ Nome: " + controleJogador.getNome() + " ❤️");
            System.out.println("------------------------------------");
            System.out.println(controleJogador.toString());
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        try {
            System.out.println("------------------------------------");
            System.out.println("\n" + "Informações iniciais do seu inimigo: ");
            System.out.println(controleComputador.toString());
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        // Cria tabuleiros principais:
        controleJogador.criarTabuleiro(controleJogador);
        controleComputador.criarTabuleiro(controleComputador);

        // Cria tabuleiro do computador só para exibição:
        tabuleiroComputador.criarTabuleiroVazio(tabuleiroComputador);

        // Cria tabuleiro vazio para ir marcando peças já atingidas durante o jogo:
        tabuleiroJogador.criarTabuleiroVazio(tabuleiroJogador);

        System.out.println("------------------------------------");
        System.out.println("\n" + "Tabuleiro de: " + controleJogador.getNome() + "\n");
        controleJogador.imprimirTabuleiro(controleJogador);

        while (true) {

            // Loop para dar continuidade apenas se não houver exceções
            boolean pronto = false;
            while (!pronto) {
                try {

                    System.out.println("\n" + "Vez de " + controleJogador.getNome() + "!" + "\n");
                    System.out.println("---Digite a letra da linha do ataque (A-E)---");

                    // Transforma char em int
                    char linha = scanner.next().charAt(0);
                    int pos = Character.toLowerCase(linha) - 'a';
                    disparaExcecaoLinhas(pos);

                    System.out.println("---Digite o número da coluna do ataque (1-5)--- ");
                    int coluna = scanner.nextInt() - 1;

                    disparaExcecaoColunas(coluna);

                    // Método de ataque do jogador contra o computador:
                    controleJogador.atacarComputador(controleComputador, tabuleiroComputador, controleJogador, pos, linha,
                            coluna);
                    pronto = true;

                } catch (ExcecaoValoresInvalidos e) {
                    System.err.println(e.getMessage());

                } catch (ExcecaoColunasInvalidas e) {
                    System.err.println(e.getMessage());

                } catch (InputMismatchException e) {
                    System.err.println("Insira valores de A-E para as linhas e de 1-4 para as colunas");
                }
            }

            if (!controleComputador.isVivo()) {
                break;
            }

            // Método de ataque do computador contra o jogador:
            controleComputador.atacarJogador(controleJogador, controleComputador, tabuleiroComputador,
                    tabuleiroJogador);
            if (!controleJogador.isVivo()) {
                break;
            }
        }
        scanner.close();
    }

    private static void disparaExcecaoColunas(int coluna) throws ExcecaoColunasInvalidas {
        if (coluna < 0 || coluna > 4) {
            throw new ExcecaoColunasInvalidas("Insira um valor entre 1 e 4 para as colunas:");
        }
    }

    private static void disparaExcecaoLinhas(int pos) throws ExcecaoValoresInvalidos {
        if (pos < 0 || pos > 4) {
            throw new ExcecaoValoresInvalidos("Insira valores de A-E para linhas:");
        }
    }
}
