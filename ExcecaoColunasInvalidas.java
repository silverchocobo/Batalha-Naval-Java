package br.unisinos;

public class ExcecaoColunasInvalidas extends Exception {

	
	private static final long serialVersionUID = 7181479904251063540L;

	public ExcecaoColunasInvalidas(String mensagem) {
		super(mensagem);
	}

	public ExcecaoColunasInvalidas(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
