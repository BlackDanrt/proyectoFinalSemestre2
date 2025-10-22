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

	public void verificarCorreoExistente(String correo) throws CorreoExistenteException {
		ModelFacade mf = new ModelFacade();
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

	public void verificarCorreoInvalido(String correo) throws CorreoInvalidoException {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);

		if (!matcher.matches()) {
			throw new CorreoInvalidoException();
		}
	}

	public void verificarFechaNacimiento(String fecha) throws FechaNacimientoInvalidaException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate fechaNacimiento = LocalDate.parse(fecha, formatter);
		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();

		if (edad < 18) {
			throw new FechaNacimientoInvalidaException();
		}
	}

	public void verificarAliasExistente(String alias) throws AliasExistenteException {
		ModelFacade mf = new ModelFacade();
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

}
