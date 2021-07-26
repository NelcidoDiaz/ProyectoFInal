package source;

import exception.NotNegativeNumberExeption;

public class Cliente extends Persona{
	 
	private String direccion;
	private Factura misFacturas;
	private float credito;
	
	public Cliente(String nombre, String apellido, String cedula,String direccion, Factura misFacturas, int credito) {
		super(nombre,apellido,cedula);
		this.direccion = direccion;
		this.misFacturas = misFacturas;
		this.credito = 0;
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

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) throws NotNegativeNumberExeption {
		if(credito>0) {
			this.credito = credito;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}
	
	

}
