package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CorreoDAO;
import co.edu.unbosque.model.persistence.CreadorPdf;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

/**
 * Clase fachada que proporciona un punto de acceso unificado a todos los
 * componentes del modelo. Implementa el patrón de diseño Facade para
 * simplificar la interacción con las diferentes capas de persistencia y
 * utilidades del sistema BosTinder.
 * 
 * <p>
 * Esta clase centraliza el acceso a:
 * </p>
 * <ul>
 * <li>DAOs de persistencia (HombreDAO, MujerDAO, CorreoDAO)</li>
 * <li>Componentes de administración (Administrador)</li>
 * <li>Utilidades del sistema (ConvertorDivisa, CreadorPdf)</li>
 * </ul>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class ModelFacade {

	/**
	 * DAO para el manejo de la persistencia de objetos Hombre.
	 */
	private HombreDAO hombreDao;

	/**
	 * DAO para el manejo de la persistencia de objetos Mujer.
	 */
	private MujerDAO mujerDao;

	/**
	 * DAO para el manejo de la persistencia y envío de correos electrónicos.
	 */
	private CorreoDAO correoDao;

	/**
	 * Instancia del administrador del sistema.
	 */
	private Administrador admin;

	/**
	 * Conversor de divisas para realizar operaciones de cambio monetario.
	 */
	private ConvertorDivisa conDiv;

	/**
	 * Creador de documentos PDF para generar reportes y documentos del sistema.
	 */
	private CreadorPdf cPdf;

	/**
	 * Constructor que inicializa todos los componentes del modelo. Crea instancias
	 * de todos los DAOs, utilidades y componentes administrativos necesarios para
	 * el funcionamiento del sistema.
	 */
	public ModelFacade() {
		hombreDao = new HombreDAO();
		mujerDao = new MujerDAO();
		correoDao = new CorreoDAO();
		admin = new Administrador();
		conDiv = new ConvertorDivisa();
		cPdf = new CreadorPdf();
	}

	/**
	 * Obtiene el DAO de correos electrónicos.
	 * 
	 * @return instancia de CorreoDAO
	 */
	public CorreoDAO getCorreoDao() {
		return correoDao;
	}

	/**
	 * Establece el DAO de correos electrónicos.
	 * 
	 * @param correoDao nueva instancia de CorreoDAO
	 */
	public void setCorreoDao(CorreoDAO correoDao) {
		this.correoDao = correoDao;
	}

	/**
	 * Obtiene el DAO de hombres.
	 * 
	 * @return instancia de HombreDAO
	 */
	public HombreDAO getHombreDao() {
		return hombreDao;
	}

	/**
	 * Establece el DAO de hombres.
	 * 
	 * @param hombreDao nueva instancia de HombreDAO
	 */
	public void setHombreDao(HombreDAO hombreDao) {
		this.hombreDao = hombreDao;
	}

	/**
	 * Obtiene el DAO de mujeres.
	 * 
	 * @return instancia de MujerDAO
	 */
	public MujerDAO getMujerDao() {
		return mujerDao;
	}

	/**
	 * Establece el DAO de mujeres.
	 * 
	 * @param mujerDao nueva instancia de MujerDAO
	 */
	public void setMujerDao(MujerDAO mujerDao) {
		this.mujerDao = mujerDao;
	}

	/**
	 * Obtiene la instancia del administrador del sistema.
	 * 
	 * @return instancia de Administrador
	 */
	public Administrador getAdmin() {
		return admin;
	}

	/**
	 * Establece la instancia del administrador del sistema.
	 * 
	 * @param admin nueva instancia de Administrador
	 */
	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	/**
	 * Obtiene el conversor de divisas.
	 * 
	 * @return instancia de ConvertorDivisa
	 */
	public ConvertorDivisa getConDiv() {
		return conDiv;
	}

	/**
	 * Establece el conversor de divisas.
	 * 
	 * @param conDiv nueva instancia de ConvertorDivisa
	 */
	public void setConDiv(ConvertorDivisa conDiv) {
		this.conDiv = conDiv;
	}

	/**
	 * Obtiene el creador de documentos PDF.
	 * 
	 * @return instancia de CreadorPdf
	 */
	public CreadorPdf getcPdf() {
		return cPdf;
	}

	/**
	 * Establece el creador de documentos PDF.
	 * 
	 * @param cPdf nueva instancia de CreadorPdf
	 */
	public void setcPdf(CreadorPdf cPdf) {
		this.cPdf = cPdf;
	}

}