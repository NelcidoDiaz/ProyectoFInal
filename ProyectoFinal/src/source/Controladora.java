package source;

import java.util.ArrayList;

public class Controladora {
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private Cliente [] misClientes;
	private ArrayList<OrdenCompra> ordenCompra;
	
	public Controladora() {
		super();
		misComponentes = new ArrayList<Componente>();
		misFacturas = new ArrayList<Factura>();
		misClientes = new Cliente[100];
		ordenCompra = new ArrayList<OrdenCompra>();
	}
	
	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public Cliente[] getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(Cliente[] misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<OrdenCompra> getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(ArrayList<OrdenCompra> ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Componente buscComponente(String numSerie) {
		Componente aux = null;
		boolean existe = false;
		int i = 0;
		while(!existe && i < misComponentes.size()){
			if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
				aux = misComponentes.get(i);
				existe = true;
			}
		}
		return aux;
	}

	public Factura buscFactura(String codFac) {
		Factura aux = null;
		boolean existe  = false;
		int i = 0;
		while(!existe && i<misFacturas.size()) {
			if(misFacturas.get(i).getCodFactura().equalsIgnoreCase(codFac)) {
				aux = misFacturas.get(i);
				existe = true;
			}
			i++;
		}
		return aux;
	}
	
	public Cliente buscCliente(String cedula) {
		Cliente aux = null;
		boolean existe = false;
		int i = 0;
		while(!existe&& i < misClientes.length) {
			if(misClientes[i].getCedula().equalsIgnoreCase(cedula)) {
				aux = misClientes[i];
				existe = true;
			}
			i++;
		}
		return aux;
	}
	
}
