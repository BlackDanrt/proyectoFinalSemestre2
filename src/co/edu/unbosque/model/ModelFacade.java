package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDao;
	private MujerDAO mujerDao;

	public ModelFacade() {
		hombreDao = new HombreDAO();
		mujerDao = new MujerDAO();
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

}
