package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class DataMapper {

	public static ArrayList<HombreDTO> convertirHombreaHombreDTO(ArrayList<Hombre> entityList) {
		ArrayList<HombreDTO> dtoList = new ArrayList<HombreDTO>();
		for (Hombre entity : entityList) {
			dtoList.add(new HombreDTO(entity.getNombre(), entity.getAlias(), entity.getEdad(), entity.getCorreo(),
					entity.getContrasenia(), entity.getFoto(), entity.isEsVisiblePefil(), entity.getEdadMinima(),
					entity.getEdadMaxima(), entity.getIngresoMensual(), entity.isPreferenciaDivorcio(),
					entity.getEstatura()));
		}

		return dtoList;
	}

	public static ArrayList<Hombre> convertirHombreDTOaHombre(ArrayList<HombreDTO> dtoList) {
		ArrayList<Hombre> entityList = new ArrayList<Hombre>();
		for (HombreDTO dto : dtoList) {
			entityList.add(new Hombre(dto.getNombre(), dto.getAlias(), dto.getEdad(), dto.getCorreo(),
					dto.getContrasenia(), dto.getFoto(), dto.isEsVisiblePefil(), dto.getEdadMinima(),
					dto.getEdadMaxima(), dto.getIngresoMensual(), dto.isPreferenciaDivorcio(), dto.getEstatura()));
		}

		return entityList;
	}

	public static ArrayList<MujerDTO> convertirMujeraMujerDTO(ArrayList<Mujer> entityList) {
		ArrayList<MujerDTO> dtoList = new ArrayList<MujerDTO>();
		for (Mujer entity : entityList) {
			dtoList.add(new MujerDTO(entity.getNombre(), entity.getAlias(), entity.getEdad(), entity.getCorreo(),
					entity.getContrasenia(), entity.getFoto(), entity.isEsVisiblePefil(), entity.getEdadMinima(),
					entity.getEdadMaxima(), entity.isEsDivorciada(), entity.getEstaturaIdeal(), entity.getEstatura()));
		}

		return dtoList;
	}

	public static ArrayList<Mujer> convertirMujerDTOaMujer(ArrayList<MujerDTO> dtoList) {
		ArrayList<Mujer> entityList = new ArrayList<Mujer>();
		for (MujerDTO dto : dtoList) {
			entityList.add(new Mujer(dto.getNombre(), dto.getAlias(), dto.getEdad(), dto.getCorreo(),
					dto.getContrasenia(), dto.getFoto(), dto.isEsVisiblePefil(), dto.getEdadMinima(),
					dto.getEdadMaxima(), dto.isEsDivorciada(), dto.getEstaturaIdeal(), dto.getEstatura()));
		}

		return entityList;
	}

}
