package co.edu.unbosque.model;

public class MensajeDTO {

	private String emisor;
	private String receptor;
	private String cuerpoMensaje;
	private String horaEnvio;

	public MensajeDTO() {
		// TODO Auto-generated constructor stub
	}

	public MensajeDTO(String emisor, String receptor, String cuerpoMensaje, String horaEnvio) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.cuerpoMensaje = cuerpoMensaje;
		this.horaEnvio = horaEnvio;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}

	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}

	public String getHoraEnvio() {
		return horaEnvio;
	}

	public void setHoraEnvio(String horaEnvio) {
		this.horaEnvio = horaEnvio;
	}

	@Override
	public String toString() {
		return "Mensaje [emisor=" + emisor + ", receptor=" + receptor + ", cuerpoMensaje=" + cuerpoMensaje
				+ ", horaEnvio=" + horaEnvio + "]";
	}

}
