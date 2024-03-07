package br.unisinos;

public class ExcecaoValoresInvalidos extends Exception {
	
	
	private static final long serialVersionUID = 8566674825966358841L;

	public ExcecaoValoresInvalidos(String mensagem) {
		super(mensagem);
	}

	public ExcecaoValoresInvalidos(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
