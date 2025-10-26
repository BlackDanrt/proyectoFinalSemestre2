package co.edu.unbosque.model;

import java.io.Serializable;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2605090105710016709L;

	private String id;
	private String nombre;
	private String apellido;
	private String alias;
	private int edad;
	private String correo;
	private String contrasenia;
	private String foto;
	private int cantLike;
	private boolean esVisiblePefil;
	private long edadMinima;
	private long edadMaxima;
	private boolean estaVerificado;

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.edad = edad;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.foto = foto;
		this.cantLike = cantLike;
		this.esVisiblePefil = esVisiblePefil;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.estaVerificado = estaVerificado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getCantLike() {
		return cantLike;
	}

	public void setCantLike(int cantLike) {
		this.cantLike = cantLike;
	}

	public boolean isEsVisiblePefil() {
		return esVisiblePefil;
	}

	public void setEsVisiblePefil(boolean esVisiblePefil) {
		this.esVisiblePefil = esVisiblePefil;
	}

	public long getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(long edadMinima) {
		this.edadMinima = edadMinima;
	}

	public long getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(long edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public boolean isEstaVerificado() {
		return estaVerificado;
	}

	public void setEstaVerificado(boolean estaVerificado) {
		this.estaVerificado = estaVerificado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias + ", edad="
				+ edad + ", correo=" + correo + ", contrasenia=" + contrasenia + ", foto=" + foto + ", cantLike="
				+ cantLike + ", esVisiblePefil=" + esVisiblePefil + ", edadMinima=" + edadMinima + ", edadMaxima="
				+ edadMaxima + ", estaVerificado=" + estaVerificado + "]";
	}

}