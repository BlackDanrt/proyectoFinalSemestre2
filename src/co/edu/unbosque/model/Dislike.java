package co.edu.unbosque.model;

public class Dislike {

	private String idEmisor;
	private String idReceptor;

	public Dislike() {
		// TODO Auto-generated constructor stub
	}

	public Dislike(String idEmisor, String idReceptor) {
		super();
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
	}

	public String getIdEmisor() {
		return idEmisor;
	}

	public void setIdEmisor(String idEmisor) {
		this.idEmisor = idEmisor;
	}

	public String getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}

	@Override
	public String toString() {
		return "Dislike [idEmisor=" + idEmisor + ", idReceptor=" + idReceptor + "]";
	}

}
