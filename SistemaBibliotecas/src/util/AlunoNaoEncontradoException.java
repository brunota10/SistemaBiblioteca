package util;

public class AlunoNaoEncontradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
