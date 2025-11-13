package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Correo;
import co.edu.unbosque.model.CorreoDTO;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

/**
 * La clase {@code DataMapper} se encarga de realizar conversiones entre
 * entidades del modelo y sus respectivos objetos de transferencia de datos
 * (DTO).
 * <p>
 * Este patrón permite separar la lógica de negocio de la capa de presentación o
 * persistencia, facilitando la transmisión de información entre distintas capas
 * de la aplicación sin exponer directamente las entidades internas.
 * </p>
 * 
 * <p>
 * La clase contiene métodos estáticos que convierten objetos individuales y
 * listas completas de {@link Hombre}, {@link Mujer}, {@link Correo} y
 * {@link Dislike} a sus versiones DTO, y viceversa.
 * </p>
 * 
 * <h3>Ejemplo de uso:</h3>
 * 
 * <pre>{@code
 * Hombre entidad = new Hombre(...);
 * HombreDTO dto = DataMapper.convertirHombreaHombreDTO(entidad);
 * 
 * ArrayList<Mujer> mujeres = ...;
 * ArrayList<MujerDTO> mujeresDTO = DataMapper.convertirListaMujeraMujerDTO(mujeres);
 * }</pre>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class DataMapper {

	/**
	 * Convierte una lista de entidades {@link Hombre} a una lista de objetos
	 * {@link HombreDTO}.
	 * 
	 * @param entityList lista de entidades {@link Hombre}
	 * @return lista de objetos {@link HombreDTO}
	 */
	public static ArrayList<HombreDTO> convertirListaHombreaHombreDTO(ArrayList<Hombre> entityList) {
		ArrayList<HombreDTO> dtoList = new ArrayList<HombreDTO>();
		for (Hombre entity : entityList) {
			dtoList.add(new HombreDTO(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getAlias(),
					entity.getEdad(), entity.getCorreo(), entity.getContrasenia(), entity.getFoto(),
					entity.getCantLike(), entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(),
					entity.isEstaVerificado(), entity.getIngresoMensual(), entity.isPreferenciaDivorcio(),
					entity.getEstatura()));
		}
		return dtoList;
	}

	/**
	 * Convierte una lista de objetos {@link HombreDTO} a una lista de entidades
	 * {@link Hombre}.
	 * 
	 * @param dtoList lista de objetos {@link HombreDTO}
	 * @return lista de entidades {@link Hombre}
	 */
	public static ArrayList<Hombre> convertirListaHombreDTOaHombre(ArrayList<HombreDTO> dtoList) {
		ArrayList<Hombre> entityList = new ArrayList<Hombre>();
		for (HombreDTO dto : dtoList) {
			entityList.add(new Hombre(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(),
					dto.getCorreo(), dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(),
					dto.getEdadMinima(), dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getIngresoMensual(),
					dto.isPreferenciaDivorcio(), dto.getEstatura()));
		}
		return entityList;
	}

	/**
	 * Convierte una lista de entidades {@link Mujer} a una lista de objetos
	 * {@link MujerDTO}.
	 * 
	 * @param entityList lista de entidades {@link Mujer}
	 * @return lista de objetos {@link MujerDTO}
	 */
	public static ArrayList<MujerDTO> convertirListaMujeraMujerDTO(ArrayList<Mujer> entityList) {
		ArrayList<MujerDTO> dtoList = new ArrayList<MujerDTO>();
		for (Mujer entity : entityList) {
			dtoList.add(new MujerDTO(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getAlias(),
					entity.getEdad(), entity.getCorreo(), entity.getContrasenia(), entity.getFoto(),
					entity.getCantLike(), entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(),
					entity.isEstaVerificado(), entity.isEsDivorciada(), entity.getEstaturaIdeal(),
					entity.getEstatura()));
		}
		return dtoList;
	}

	/**
	 * Convierte una lista de objetos {@link MujerDTO} a una lista de entidades
	 * {@link Mujer}.
	 * 
	 * @param dtoList lista de objetos {@link MujerDTO}
	 * @return lista de entidades {@link Mujer}
	 */
	public static ArrayList<Mujer> convertirListaMujerDTOaMujer(ArrayList<MujerDTO> dtoList) {
		ArrayList<Mujer> entityList = new ArrayList<Mujer>();
		for (MujerDTO dto : dtoList) {
			entityList.add(new Mujer(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(),
					dto.getCorreo(), dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(),
					dto.getEdadMinima(), dto.getEdadMaxima(), dto.isEstaVerificado(), dto.isEsDivorciada(),
					dto.getEstaturaIdeal(), dto.getEstatura()));
		}
		return entityList;
	}

	/**
	 * Convierte una entidad {@link Hombre} en su correspondiente {@link HombreDTO}.
	 * 
	 * @param entity entidad {@link Hombre}
	 * @return objeto {@link HombreDTO}
	 */
	public static HombreDTO convertirHombreaHombreDTO(Hombre entity) {
		HombreDTO dto = new HombreDTO(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getAlias(),
				entity.getEdad(), entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
				entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(), entity.isEstaVerificado(),
				entity.getIngresoMensual(), entity.isPreferenciaDivorcio(), entity.getEstatura());
		return dto;
	}

	/**
	 * Convierte un objeto {@link HombreDTO} en su entidad {@link Hombre}
	 * correspondiente.
	 * 
	 * @param dto objeto {@link HombreDTO}
	 * @return entidad {@link Hombre}
	 */
	public static Hombre convertirHombreDTOaHombre(HombreDTO dto) {
		Hombre entity = new Hombre(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(),
				dto.getCorreo(), dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(),
				dto.getEdadMinima(), dto.getEdadMaxima(), dto.isEstaVerificado(), dto.getIngresoMensual(),
				dto.isPreferenciaDivorcio(), dto.getEstatura());
		return entity;
	}

	/**
	 * Convierte una entidad {@link Mujer} en su correspondiente {@link MujerDTO}.
	 * 
	 * @param entity entidad {@link Mujer}
	 * @return objeto {@link MujerDTO}
	 */
	public static MujerDTO convertirMujeraMujerDTO(Mujer entity) {
		MujerDTO dto = new MujerDTO(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getAlias(),
				entity.getEdad(), entity.getCorreo(), entity.getContrasenia(), entity.getFoto(), entity.getCantLike(),
				entity.isEsVisiblePefil(), entity.getEdadMinima(), entity.getEdadMaxima(), entity.isEstaVerificado(),
				entity.isEsDivorciada(), entity.getEstaturaIdeal(), entity.getEstatura());
		return dto;
	}

	/**
	 * Convierte un objeto {@link MujerDTO} en su entidad {@link Mujer}
	 * correspondiente.
	 * 
	 * @param dto objeto {@link MujerDTO}
	 * @return entidad {@link Mujer}
	 */
	public static Mujer convertirMujerDTOaMujer(MujerDTO dto) {
		Mujer entity = new Mujer(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getAlias(), dto.getEdad(),
				dto.getCorreo(), dto.getContrasenia(), dto.getFoto(), dto.getCantLike(), dto.isEsVisiblePefil(),
				dto.getEdadMinima(), dto.getEdadMaxima(), dto.isEstaVerificado(), dto.isEsDivorciada(),
				dto.getEstaturaIdeal(), dto.getEstatura());
		return entity;
	}

	/**
	 * Convierte un objeto {@link CorreoDTO} en su entidad {@link Correo}
	 * correspondiente.
	 * 
	 * @param dto objeto {@link CorreoDTO}
	 * @return entidad {@link Correo}
	 */
	public static Correo convertirCorreoDTOaCorreo(CorreoDTO dto) {
		Correo entity = new Correo(dto.getDestinatario(), dto.getAlias(), dto.getCodigo());
		return entity;
	}

}
