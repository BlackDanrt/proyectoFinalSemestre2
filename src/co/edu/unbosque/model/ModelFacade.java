package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CorreoDAO;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDao;
	private MujerDAO mujerDao;
	private CorreoDAO correoDao;
	private Administrador admin;
	private ConvertorDivisa conDiv;

	public ModelFacade() {
		hombreDao = new HombreDAO();
		mujerDao = new MujerDAO();
		correoDao = new CorreoDAO();
		admin = new Administrador();
		conDiv = new ConvertorDivisa();
	}

	public CorreoDAO getCorreoDao() {
		return correoDao;
	}

	public void setCorreoDao(CorreoDAO correoDao) {
		this.correoDao = correoDao;
	}

	public HombreDAO getHombreDao() {
		return hombreDao;
	}

	public void setHombreDao(HombreDAO hombreDao) {
		this.hombreDao = hombreDao;
	}

	public MujerDAO getMujerDao() {
		return mujerDao;
	}

	public void setMujerDao(MujerDAO mujerDao) {
		this.mujerDao = mujerDao;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public ConvertorDivisa getConDiv() {
		return conDiv;
	}

	public void setConDiv(ConvertorDivisa conDiv) {
		this.conDiv = conDiv;
	}

}
