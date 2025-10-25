package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class DataMapper {

	public static ArrayList<HombreDTO> convertirListaHombreaHombreDTO(ArrayList<Hombre> entityList) {
		ArrayList<HombreDTO> dtoList = new ArrayList<HombreDTO>();
		for (Hombre entity : entityList) {
			dtoList.add(new HombreDTO(entity.getNombre(), entity.getApellido(), entity.getAlias(), entity.getEdad(),
					entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
					entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(),
					entity.isEstaVerificado(), entity.getId(), entity.getIngresoMensual(),
					entity.isPreferenciaDivorcio(), entity.getEstatura()));
		}

		return dtoList;
	}

	public static ArrayList<Hombre> convertirListaHombreDTOaHombre(ArrayList<HombreDTO> dtoList) {
		ArrayList<Hombre> entityList = new ArrayList<Hombre>();
		for (HombreDTO dto : dtoList) {
			entityList.add(new Hombre(dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(),
					dto.getCorreo(), dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(),
					dto.getEdadMinima(), dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getId(),
					dto.getIngresoMensual(), dto.isPreferenciaDivorcio(), dto.getEstatura()));
		}

		return entityList;
	}

	public static ArrayList<MujerDTO> convertirListaMujeraMujerDTO(ArrayList<Mujer> entityList) {
		ArrayList<MujerDTO> dtoList = new ArrayList<MujerDTO>();
		for (Mujer entity : entityList) {
			dtoList.add(new MujerDTO(entity.getNombre(), entity.getApellido(), entity.getAlias(), entity.getEdad(),
					entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
					entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(),
					entity.isEstaVerificado(), entity.getId(), entity.isEsDivorciada(), entity.getEstaturaIdeal(),
					entity.getEstatura()));
		}

		return dtoList;
	}

	public static ArrayList<Mujer> convertirListaMujerDTOaMujer(ArrayList<MujerDTO> dtoList) {
		ArrayList<Mujer> entityList = new ArrayList<Mujer>();
		for (MujerDTO dto : dtoList) {
			entityList.add(new Mujer(dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(), dto.getCorreo(),
					dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(), dto.getEdadMinima(),
					dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getId(), dto.isEsDivorciada(),
					dto.getEstaturaIdeal(), dto.getEstatura()));
		}

		return entityList;
	}

	public static HombreDTO convertirHombreaHombreDTO(Hombre entity) {
		HombreDTO dto = new HombreDTO(entity.getNombre(), entity.getApellido(), entity.getAlias(), entity.getEdad(),
				entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
				entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(), entity.isEstaVerificado(),
				entity.getId(), entity.getIngresoMensual(), entity.isPreferenciaDivorcio(), entity.getEstatura());

		return dto;
	}

	public static Hombre convertirHombreDTOaHombre(HombreDTO dto) {
		Hombre entity = new Hombre(dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(), dto.getCorreo(),
				dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(), dto.getEdadMinima(),
				dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getId(), dto.getIngresoMensual(),
				dto.isPreferenciaDivorcio(), dto.getEstatura());

		return entity;
	}

	public static MujerDTO convertirMujeraMujerDTO(Mujer entity) {
		MujerDTO dto = new MujerDTO(entity.getNombre(), entity.getApellido(), entity.getAlias(), entity.getEdad(),
				entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
				entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(), entity.isEstaVerificado(),
				entity.getId(), entity.isEsDivorciada(), entity.getEstaturaIdeal(), entity.getEstatura());

		return dto;
	}

	public static Mujer convertirMujerDTOaMujer(MujerDTO dto) {
		Mujer entity = new Mujer(dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(), dto.getCorreo(),
				dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(), dto.getEdadMinima(),
				dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getId(), dto.isEsDivorciada(), dto.getEstaturaIdeal(),
				dto.getEstatura());

		return entity;
	}

}
