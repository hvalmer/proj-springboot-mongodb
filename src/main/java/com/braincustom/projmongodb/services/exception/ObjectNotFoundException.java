package com.braincustom.projmongodb.services.exception;

//na RuntimeException,exceção padrão do java, que o compilador exige que seja tratado, diferente do Execption que precisa ser tratado
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
