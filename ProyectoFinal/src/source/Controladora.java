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
	
}
