package source;

public class Cliente {
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private Factura misFacturas;
	private int credito;
	
	public Cliente(String nombre, String apellido, String cedula, String direccion, Factura misFacturas, int credito) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.misFacturas = misFacturas;
		this.credito = 0;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Factura getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(Factura misFacturas) {
		this.misFacturas = misFacturas;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	

}