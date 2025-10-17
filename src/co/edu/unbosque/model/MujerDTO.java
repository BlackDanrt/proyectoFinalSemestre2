package co.edu.unbosque.model;

public class MujerDTO extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376781876057227158L;
	private boolean esDivorciada;
	private int estaturaIdeal;
	private int estatura;

	public MujerDTO() {
		// TODO Auto-generated constructor stub
	}

	public MujerDTO(boolean esDivorciada, int estaturaIdeal, int estatura) {
		super();
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	public MujerDTO(String nombre, String alias, int edad, String correo, String contrasenia, String foto,
			boolean esVisiblePefil, long edadMinima, long edadMaxima, boolean esDivorciada, int estaturaIdeal,
			int estatura) {
		super(nombre, alias, edad, correo, contrasenia, foto, esVisiblePefil, edadMinima, edadMaxima);
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	public MujerDTO(String nombre, String alias, int edad, String correo, String contrasenia, String foto,
			boolean esVisiblePefil, long edadMinima, long edadMaxima) {
		super(nombre, alias, edad, correo, contrasenia, foto, esVisiblePefil, edadMinima, edadMaxima);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	public int getEstaturaIdeal() {
		return estaturaIdeal;
	}

	public void setEstaturaIdeal(int estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	@Override
	public String toString() {
		return super.toString() + "Mujer [esDivorciada=" + esDivorciada + ", estaturaIdeal=" + estaturaIdeal
				+ ", estatura=" + estatura + "]";
	}

}
