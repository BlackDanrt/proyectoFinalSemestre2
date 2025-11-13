package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando se intenta crear un alias que ya existe. Esta
 * excepción se utiliza para indicar que el alias proporcionado ya está siendo
 * utilizado por otra entidad y no puede ser usado nuevamente.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class AliasExistenteException extends Exception {

	/**
	 * Construye una nueva AliasExistenteException con un mensaje de error
	 * predeterminado. El mensaje indica que el alias ya está en uso y sugiere
	 * intentar con otro alias.
	 */
	public AliasExistenteException() {
		super("El alias ya está en uso, intenta con otro");
	}
}