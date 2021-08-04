package source;

import java.io.Serializable;

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7300474796451438676L;
	private String nombre;
	private String apellido;
	private String cedula;
	public Persona(String nombre, String apellido, String cedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
