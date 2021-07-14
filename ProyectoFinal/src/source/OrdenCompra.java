package source;

import exception.NotNegativeNumberExeption;

public class OrdenCompra {
	private String id;
	private Componente componentes;
	private int cant;
	private String distribuidor;
	
	public OrdenCompra(String id, Componente componentes, int cant, String distribuidor) {
		super();
		this.id = id;
		this.componentes = componentes;
		this.cant = cant;
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

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) throws NotNegativeNumberExeption {
		if(cant>0) {
			this.cant = cant;
		}else {
			throw new NotNegativeNumberExeption("Cantidad no puede ser negativa");
		}
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

}
