package source;

import java.io.Serializable;

import exception.NotNegativeNumberExeption;

public class OrdenCompra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3528765080551936752L;
	private String id;
	private Componente componentes;
	private String distribuidor;

	public OrdenCompra(String id, Componente componentes, String distribuidor) {
		super();
		this.id = id;
		this.componentes = componentes;
		this.distribuidor = distribuidor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Componente getComponentes() {
		return componentes;
	}

	public void setComponentes(Componente componentes) {
		this.componentes = componentes;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

}
