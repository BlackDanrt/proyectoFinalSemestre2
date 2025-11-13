package co.edu.unbosque.util.exception;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MujerDTO;

/**
 * Clase utilitaria para validar datos y lanzar excepciones personalizadas
 * cuando los datos no cumplen con los requisitos especificados. Proporciona
 * métodos estáticos para verificar correos, contraseñas, alias, fechas de
 * nacimiento y otros tipos de datos.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class LanzadorDeExcepcion {

	/**
	 * Verifica si un correo electrónico ya existe en el sistema.
	 * <p>
	 * Busca en las listas de hombres y mujeres para determinar si el correo
	 * proporcionado ya está siendo utilizado por algún usuario.
	 * </p>
	 * 
	 * @param correo el correo electrónico a verificar
	 * @param mf     la fachada del modelo que proporciona acceso a los DAOs
	 * @throws CorreoExistenteException si el correo ya está registrado en el
	 *                                  sistema
	 */
	public static void verificarCorreoExistente(String correo, ModelFacade mf) throws CorreoExistenteException {
		ArrayList<MujerDTO> mujeres = mf.getMujerDao().getLista();
		ArrayList<HombreDTO> hombres = mf.getHombreDao().getLista();

		for (HombreDTO dto : hombres) {
			if (dto.getCorreo().equals(correo)) {
				throw new CorreoExistenteException();
			}
		}

		for (MujerDTO dto : mujeres) {
			if (dto.getCorreo().equals(correo)) {
				throw new CorreoExistenteException();
			}
		}
	}

	/**
	 * Verifica si un correo electrónico tiene un formato válido.
	 * <p>
	 * Utiliza una expresión regular para validar que el correo cumpla con el
	 * formato estándar de direcciones de correo electrónico.
	 * </p>
	 * 
	 * @param correo el correo electrónico a validar
	 * @throws CorreoInvalidoException si el formato del correo no es válido
	 */
	public static void verificarCorreoInvalido(String correo) throws CorreoInvalidoException {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);

		if (!matcher.matches()) {
			throw new CorreoInvalidoException();
		}
	}

	/**
	 * Verifica si una fecha de nacimiento corresponde a una persona mayor de 18
	 * años y calcula la edad actual.
	 * <p>
	 * Parsea la fecha en formato dd/MM/yyyy y calcula la edad del usuario. Si la
	 * edad es menor a 18 años, lanza una excepción.
	 * </p>
	 * 
	 * @param fecha la fecha de nacimiento en formato dd/MM/yyyy
	 * @return la edad calculada en años
	 * @throws FechaNacimientoInvalidaException si el usuario es menor de 18 años
	 */
	public static int verificarFechaNacimiento(String fecha) throws FechaNacimientoInvalidaException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate fechaNacimiento = LocalDate.parse(fecha, formatter);
		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();

		if (edad < 18) {
			throw new FechaNacimientoInvalidaException();
		}

		return edad;
	}

	/**
	 * Verifica si un alias ya existe en el sistema.
	 * <p>
	 * Busca en las listas de hombres y mujeres para determinar si el alias
	 * proporcionado ya está siendo utilizado por algún usuario.
	 * </p>
	 * 
	 * @param alias el alias a verificar
	 * @param mf    la fachada del modelo que proporciona acceso a los DAOs
	 * @throws AliasExistenteException si el alias ya está registrado en el sistema
	 */
	public static void verificarAliasExistente(String alias, ModelFacade mf) throws AliasExistenteException {
		ArrayList<MujerDTO> mujeres = mf.getMujerDao().getLista();
		ArrayList<HombreDTO> hombres = mf.getHombreDao().getLista();

		for (HombreDTO dto : hombres) {
			if (dto.getAlias().equals(alias)) {
				throw new AliasExistenteException();
			}
		}

		for (MujerDTO dto : mujeres) {
			if (dto.getAlias().equals(alias)) {
				throw new AliasExistenteException();
			}
		}
	}

	/**
	 * Verifica si una cadena de texto contiene únicamente letras.
	 * <p>
	 * Recorre cada carácter de la cadena y valida que sea una letra. Si encuentra
	 * cualquier carácter que no sea letra, lanza una excepción.
	 * </p>
	 * 
	 * @param texto la cadena de texto a verificar
	 * @throws StringInvalidoException si el texto contiene caracteres que no son
	 *                                 letras
	 */
	public static void verificarString(String texto) throws StringInvalidoException {
		for (int i = 0; i < texto.length(); i++) {
			if (!Character.isLetter(texto.charAt(i))) {
				throw new StringInvalidoException();
			}
		}
	}

	/**
	 * Verifica si una contraseña cumple con los requisitos mínimos de seguridad.
	 * <p>
	 * Una contraseña válida debe tener al menos 8 caracteres, contener al menos una
	 * letra mayúscula y al menos un número.
	 * </p>
	 * 
	 * @param contrasenia la contraseña a verificar
	 * @throws ContraseniaDebilException si la contraseña no cumple con los
	 *                                   requisitos de seguridad
	 */
	public static void verificarFortalezaContrasenia(String contrasenia) throws ContraseniaDebilException {
		if (contrasenia.length() < 8) {
			throw new ContraseniaDebilException();
		}

		boolean tieneMayuscula = false;
		boolean tieneNumero = false;

		for (int i = 0; i < contrasenia.length(); i++) {
			if (Character.isUpperCase(contrasenia.charAt(i))) {
				tieneMayuscula = true;
			}
			if (Character.isDigit(contrasenia.charAt(i))) {
				tieneNumero = true;
			}
		}

		if (!tieneMayuscula || !tieneNumero) {
			throw new ContraseniaDebilException();
		}
	}

	/**
	 * Verifica si dos contraseñas son idénticas.
	 * <p>
	 * Este método se utiliza típicamente para validar que la confirmación de
	 * contraseña coincida con la contraseña original.
	 * </p>
	 * 
	 * @param c1 la primera contraseña
	 * @param c2 la segunda contraseña (confirmación)
	 * @throws ContraseniaDiferenteException si las contraseñas no coinciden
	 */
	public static void verificarContrasenias(String c1, String c2) throws ContraseniaDiferenteException {
		if (!c1.equals(c2)) {
			throw new ContraseniaDiferenteException();
		}
	}

	/**
	 * Verifica si un número es válido (positivo y compuesto únicamente por
	 * dígitos).
	 * <p>
	 * Valida que el número sea mayor o igual a cero y que todos sus caracteres sean
	 * dígitos numéricos.
	 * </p>
	 * 
	 * @param numero el número a verificar
	 * @throws NumeroInvalidoException si el número es negativo o contiene
	 *                                 caracteres no numéricos
	 */
	public static void verificarNumero(long numero) throws NumeroInvalidoException {
		String num = String.valueOf(numero);

		for (int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				throw new NumeroInvalidoException();
			}
		}
		if (numero < 0) {
			throw new NumeroInvalidoException();
		}
	}

	/**
	 * Verifica si un nuevo alias ya existe en el sistema al actualizar un perfil.
	 * <p>
	 * Este método permite que un usuario mantenga su alias actual, pero verifica
	 * que el nuevo alias no esté siendo utilizado por otro usuario diferente.
	 * </p>
	 * 
	 * @param aliasPrevio el alias actual del usuario
	 * @param aliasNuevo  el nuevo alias que se desea utilizar
	 * @param mf          la fachada del modelo que proporciona acceso a los DAOs
	 * @throws AliasExistenteActualizadoException si el nuevo alias ya está siendo
	 *                                            utilizado por otro usuario
	 */
	public static void verificarAliasExistenteActualizado(String aliasPrevio, String aliasNuevo, ModelFacade mf)
			throws AliasExistenteActualizadoException {
		ArrayList<MujerDTO> mujeres = mf.getMujerDao().getLista();
		ArrayList<HombreDTO> hombres = mf.getHombreDao().getLista();

		for (HombreDTO dto : hombres) {
			if (dto.getAlias().equals(aliasNuevo) && !dto.getAlias().equals(aliasPrevio)) {
				throw new AliasExistenteActualizadoException();
			}
		}

		for (MujerDTO dto : mujeres) {
			if (dto.getAlias().equals(aliasNuevo) && !dto.getAlias().equals(aliasPrevio)) {
				throw new AliasExistenteActualizadoException();
			}
		}
	}
}