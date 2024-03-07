package br.unisinos;

public class Jogador {

	// Atributos do tabuleiro:
	protected int portaAvioes;
	protected int destroyers;
	protected int submarinos;
	protected boolean vivo = true;
	protected String nome;

	// Inicialização do array multidimencional:
	protected String[][] tabuleiro = new String[5][5];

	public Jogador(int portaAvioes, int destroyers, int submarinos) {
		super();
		this.portaAvioes = portaAvioes;
		this.destroyers = destroyers;
		this.submarinos = submarinos;
	}

	// Método toString:
	@Override
	public String toString() {
		return "\n>> Informações sobre o tabuleiro <<\n\nPortaAviões = " + portaAvioes + "\nDestroyers = " + destroyers
				+ "\nSubmarinos = " + submarinos + "\n";
	}

	// Métodos de acesso:
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPortaAvioes() {
		return portaAvioes;
	}

	public void setPortaAvioes(int portaAvioes) {
		this.portaAvioes = portaAvioes;
	}

	public int getDestroyers() {
		return destroyers;
	}

	public void setDestroyers(int destroyers) {
		this.destroyers = destroyers;
	}

	public int getSubmarinos() {
		return submarinos;
	}

	public void setSubmarinos(int submarinos) {
		this.submarinos = submarinos;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
