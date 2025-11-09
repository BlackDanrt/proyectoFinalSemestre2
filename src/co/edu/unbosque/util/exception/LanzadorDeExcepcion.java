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

public class LanzadorDeExcepcion {

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

	public static void verificarCorreoInvalido(String correo) throws CorreoInvalidoException {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);

		if (!matcher.matches()) {
			throw new CorreoInvalidoException();
		}
	}

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

	public static void verificarString(String texto) throws StringInvalidoException {
		for (int i = 0; i < texto.length(); i++) {
			if (!Character.isLetter(texto.charAt(i))) {
				throw new StringInvalidoException();
			}
		}
	}

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

	public static void verificarContrasenias(String c1, String c2) throws ContraseniaDiferenteException {
		if (!c1.equals(c2)) {
			throw new ContraseniaDiferenteException();
		}
	}

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