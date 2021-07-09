package br.com.compasso.interview.exception;

public class ItemNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ITEM_NAO_ENCONTRADO = "ITEM_NAO_ENCONTRADO";
	
	public ItemNaoEncontradoException() {
		super(ITEM_NAO_ENCONTRADO);
	}
}
