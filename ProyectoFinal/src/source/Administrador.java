package source;

public class Administrador extends Empleado{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String codigoDeAdministrador;

public Administrador(String nombre, String apellido, String cedula, String codigo, String id, float sueldo,
		String codigoDeAdministrador) {
	super(nombre, apellido, cedula, codigo, id, sueldo);
	this.codigoDeAdministrador = codigoDeAdministrador;
}

public String getCodigoDeAdministrador() {
	return codigoDeAdministrador;
}

public void setCodigoDeAdministrador(String codigoDeAdministrador) {
	this.codigoDeAdministrador = codigoDeAdministrador;
}
  
  
}
