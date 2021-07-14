package source;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private Cliente cliente;
	private float total;
	private Date fecha;
	private ArrayList<Componente> Componentes;
	
	public Factura(Cliente cliente, float total, Date fecha, ArrayList<Componente> componentes) {
		super();
		this.cliente = cliente;
		this.total = total;
		this.fecha = fecha;
		Componentes = componentes;
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

	public void setTotal(float total) {
		this.total = total;
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
