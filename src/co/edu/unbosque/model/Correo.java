package co.edu.unbosque.model;

public class Correo {

	private String destinatario;
	private String alias;
	private int codigo;

	public Correo() {
		// TODO Auto-generated constructor stub
	}

	public Correo(String destinatario, String alias, int codigo) {
		super();
		this.destinatario = destinatario;
		this.alias = alias;
		this.codigo = codigo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
