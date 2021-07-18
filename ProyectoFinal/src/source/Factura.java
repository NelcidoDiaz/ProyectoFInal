package source;

import java.util.ArrayList;
import java.util.Date;

import exception.NotNegativeNumberExeption;

public class Factura {
	private String codFactura;
	private Cliente cliente;
	private float total;
	private Date fecha;
	private ArrayList<Componente> Componentes;
	
	public Factura(String codFactura,Cliente cliente, float total, Date fecha, ArrayList<Componente> componentes) {
		super();
		this.codFactura = codFactura;
		this.cliente = cliente;
		this.total = total;
		this.fecha = fecha;
		Componentes = componentes;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total)throws NotNegativeNumberExeption {
		if(total>0) {
			this.total = total;
		}else {
			throw new NotNegativeNumberExeption("El total no puede ser negativo");
		}
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Componente> getComponentes() {
		return Componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		Componentes = componentes;
	}
	
	
}
