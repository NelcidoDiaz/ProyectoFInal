package source;

import java.util.ArrayList;

public class Controladora {
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<OrdenCompra> ordenCompra;
	
	
	public Controladora() {
		super();
		misComponentes = new ArrayList<Componente>();
		misFacturas = new ArrayList<Factura>();
		misClientes = new ArrayList<Cliente>();
		misCombos = new ArrayList<Combo>();
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

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente>  misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public ArrayList<OrdenCompra> getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(ArrayList<OrdenCompra> ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	
	public void insertarComponente(Componente compo ) {
		misComponentes.add(compo);
	}
	
	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
		disminuirCompInsideFactura(factura);
	}
	
	// Esta función se encarga de restar la cantreal de los componentes del almacen si estos se encuentran en factura.
	private void disminuirCompInsideFactura(Factura factura) {
		boolean existe = false;
		int j = 0;
		for(int i = 0; i < factura.getComponentes().size(); i++) {
			enctCompFact(factura.getComponentes().get(i).numeroDeSerie);
		}
	}
	
	// Esta función se encarga de comparar el numSerie del componente con el que esta en almacen y si esto 
	// se cumple le resta la cantreal al componente del almacen.
	private void enctCompFact(String numSerie) {
		boolean existe = false;
		int i = 0;
		while(!existe && i < misComponentes.size()) {
			if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
				existe = true;
				misComponentes.get(i).cantReal=-1;
			}
			i++;
		}
	}

	public void insertarCliente(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void insertarCombo(Combo combo) {
		misCombos.add(combo);
	}
	
	public boolean hacerPedido(String numSerie) {
		boolean pedido = false;
		Componente componentes = buscComponente(numSerie);
		if(componentes!=null) {
			if(componentes.cantReal < componentes.cantMin) {
				pedido = true;
			}
		}
		return pedido;
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
		while(!existe && i<misClientes.size()) {
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = misClientes.get(i);
				existe = true;
			}
			i++;
		}
		return aux;
	}
	
}
