package br.unisinos;

import java.util.Arrays;

public class Controle extends Jogador {

	public Controle(int portaAvioes, int destroyers, int submarino) {
		super(portaAvioes, destroyers, submarino);
	}
	
	//Método de criação de tabuleiro
	public void criarTabuleiro(Jogador jogador) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				jogador.tabuleiro[i][j] = "~";
			}
		}

		colocarPecas(jogador, "P", 4);
		colocarPecas(jogador, "D", 5);
		colocarPecas(jogador, "S", 6);
	}
	
	//Método de impressão de tabuleiro
	public void imprimirTabuleiro(Jogador jogador) {
		System.out.println("  1 2 3 4 5");
		char c = 65;
		for (int i = 0; i < tabuleiro.length; i++) {
			String str_Array = Arrays.toString(jogador.tabuleiro[i]);
			System.out.println(c + str_Array.replaceAll(",", ""));
			c++;
		}
	}
	
	//Método para criar tabuleiro vazio, que será preenchido com as peças acertadas - usado para imprimir o tabuleiro do computador
	public void criarTabuleiroVazio(Jogador computador) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				computador.tabuleiro[i][j] = "~";
			}
		}
	}
	
	//Método de ataque do jogador ao computador
	public void atacarComputador(Jogador computador, Jogador tabuleiroComputador, Jogador jogador, int linha_Pos,
			char linha, int coluna) {

		try {
			System.out.println("Você atirou em " + Character.toUpperCase(linha) + (coluna + 1));
			Thread.sleep(2000);
		} catch (Exception e) {
			// Try catch para executar sleep
		}

		if ("P".equals(computador.tabuleiro[linha_Pos][coluna])) {
			if (!"~".equals(tabuleiroComputador.tabuleiro[linha_Pos][coluna])) {
				System.out.println("\nVocê atingiu um Porta-Aviões já atingido!");
			} else {
				System.out.println("\nVocê atingiu um Porta-Aviões!");
				tabuleiroComputador.tabuleiro[linha_Pos][coluna] = "P";
				computador.setPortaAvioes(computador.getPortaAvioes() - 1);
			}
		} else if ("D".equals(computador.tabuleiro[linha_Pos][coluna])) {
			if (!"~".equals(tabuleiroComputador.tabuleiro[linha_Pos][coluna])) {
				System.out.println("\nVocê atingiu um Destróier já atingido!");
			} else {
				System.out.println("\nVocê atingiu um Destróier!");
				tabuleiroComputador.tabuleiro[linha_Pos][coluna] = "D";
				computador.setDestroyers(computador.getDestroyers() - 1);
			}
		} else if ("S".equals(computador.tabuleiro[linha_Pos][coluna])) {
			if (!"~".equals(tabuleiroComputador.tabuleiro[linha_Pos][coluna])) {
				System.out.println("\nVocê atingiu um submarino já atingido!");
			} else {
				System.out.println("\nVocê atingiu um Submarino!");
				tabuleiroComputador.tabuleiro[linha_Pos][coluna] = "S";
				computador.setSubmarinos(computador.getSubmarinos() - 1);
			}
		} else {
			System.out.println("\nVocê acertou a água!");
		}

		exibirInformacoes(jogador, tabuleiroComputador, computador);

	}
	
	//Método de ataque do computador ao jogador
	public void atacarJogador(Jogador jogador, Jogador computador, Jogador tabuleiroComputador,
			Jogador tabuleiroJogador) {
		int linha = (int) (Math.random() * 5);
		int coluna = (int) (Math.random() * 5);

		char linha_Char = (char) (65 + linha);

		try {
			System.out.println("\nO computador atirou em " + linha_Char + (coluna + 1));
			Thread.sleep(2000);
		} catch (Exception e) {
			//Try catch para executar sleep
		}

		if ("P".equals(jogador.tabuleiro[linha][coluna])) {
			if (!"~".equals(tabuleiroJogador.tabuleiro[linha][coluna])) {
				System.out.println("\nO computador atingiu um Porta-Aviões já atingido!");
			} else {
				System.out.println("\nCuidado! O computador atingiu um Porta-Aviões!");
				tabuleiroJogador.tabuleiro[linha][coluna] = "P";
				jogador.setPortaAvioes(jogador.getPortaAvioes() - 1);
				jogador.tabuleiro[linha][coluna] = "X";
			}
		} else if ("D".equals(jogador.tabuleiro[linha][coluna])) {
			if (!"~".equals(tabuleiroJogador.tabuleiro[linha][coluna])) {
				System.out.println("\nO computador atingiu um Destróier já atingido!");
			} else {
				System.out.println("\nCuidado! O computador atingiu um Destróier!");
				tabuleiroJogador.tabuleiro[linha][coluna] = "D";
				jogador.setDestroyers(jogador.getDestroyers() - 1);
				jogador.tabuleiro[linha][coluna] = "X";
			}
		} else if ("S".equals(jogador.tabuleiro[linha][coluna])) {
			if (!"~".equals(tabuleiroJogador.tabuleiro[linha][coluna])) {
				System.out.println("\nO computador atingiu um Submarino já atingido!");
			} else {
				System.out.println("\nCuidado! O computador atingiu um Submarino!");
				tabuleiroJogador.tabuleiro[linha][coluna] = "S";
				jogador.setSubmarinos(jogador.getSubmarinos() - 1);
				jogador.tabuleiro[linha][coluna] = "X";
			}
		} else {
			System.out.println("\nUfa! O computador acertou a água!");
		}

		exibirInformacoes(jogador, tabuleiroComputador, computador);
	}
	
	//Método para distribuir peças

	private void colocarPecas(Jogador jogador, String peca, int quantidade) {
		while (quantidade > 0) {
			int i = (int) (Math.random() * 5);
			int j = (int) (Math.random() * 5);
			if (jogador.tabuleiro[i][j] == "~") {
				jogador.tabuleiro[i][j] = peca;
				quantidade--;
			}
		}
	}
	
	//Método para exibir informações dos jogadores
	private void exibirInformacoes(Jogador jogador, Jogador tabuleiroComputador, Jogador computador) {
		try {
			System.out.println("\n------------------------------------");
			System.out.println("\nTabuleiro de " + jogador.getNome() + "\n");
			imprimirTabuleiro(jogador);
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		try {
			System.out.println("\n------------------------------------");
			System.out.println("\nObjetos restantes: ");
			System.out.println(jogador.toString());
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		try {
			System.out.println("------------------------------------");
			System.out.println("\nTabuleiro do computador: " + "\n");
			imprimirTabuleiro(tabuleiroComputador);
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		try {
			System.out.println("\n------------------------------------");
			System.out.println("\nObjetos restantes: ");
			System.out.println(computador.toString());
			System.out.println("------------------------------------");
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		if (computador.getDestroyers() == 0 && computador.getPortaAvioes() == 0 && computador.getSubmarinos() == 0) {
			computador.setVivo(false);
			System.out.println("\n------------------------------------");
			System.out.println("\nParabéns! Você foi o grande vencedor do jogo!");
			System.out.println("\n------------------------------------");
		}

		if (jogador.getDestroyers() == 0 && jogador.getPortaAvioes() == 0 && jogador.getSubmarinos() == 0) {
			jogador.setVivo(false);
			System.out.println("\n------------------------------------");
			System.out.println("\nQue pena! Parece que você perdeu :(");
			System.out.println("\n------------------------------------");
		}

	}
}
