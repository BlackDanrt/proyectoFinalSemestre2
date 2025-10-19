package co.edu.unbosque.model;

public class Hombre extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1962898026481141517L;
	private long ingresoMensual;
	private boolean preferenciaDivorcio;
	private int estatura;

	public Hombre() {
		// TODO Auto-generated constructor stub
	}

	public Hombre(long ingresoMensual, boolean preferenciaDivorcio, int estatura) {
		super();
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	public Hombre(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima, long ingresoMensual,
			boolean preferenciaDivorcio, int estatura) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima);
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	public Hombre(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima);
		// TODO Auto-generated constructor stub
	}

	public long getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(long ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public boolean isPreferenciaDivorcio() {
		return preferenciaDivorcio;
	}

	public void setPreferenciaDivorcio(boolean preferenciaDivorcio) {
		this.preferenciaDivorcio = preferenciaDivorcio;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	@Override
	public String toString() {
		return super.toString() + "Hombre [ingresoMensual=" + ingresoMensual + ", preferenciaDivorcio="
				+ preferenciaDivorcio + ", estatura=" + estatura + "]";
	}

}
