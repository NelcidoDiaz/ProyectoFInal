package source;

import java.util.ArrayList;

public class Controladora {
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<OrdenCompra> ordenCompra;
	private static Controladora control = null;
	
	
	public Controladora() {
		super();
		misComponentes = new ArrayList<Componente>();
		misFacturas = new ArrayList<Factura>();
		misClientes = new ArrayList<Cliente>();
		misCombos = new ArrayList<Combo>();
		ordenCompra = new ArrayList<OrdenCompra>();
	}
	
	public static Controladora getInstance() {
		if(control == null) {
			control = new Controladora();
		}
		return control;
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
	
	public void insertarOrdenCompra(OrdenCompra compra) {
		ordenCompra.add(compra);
	}
	
	// Esta funcion se encarga de restar la cantreal de los componentes del almacen si estos se encuentran en factura.
	private void disminuirCompInsideFactura(Factura factura) {
		for(int i = 0; i < factura.getComponentes().size(); i++) {
			enctCompFact(factura.getComponentes().get(i).numeroDeSerie,factura,i);
		}
	}
	
	// Esta funcion se encarga de comparar el numSerie del componente con el que esta en almacen y si esto 
	// se cumple le resta la cantreal al componente del almacen.
	private void enctCompFact(String numSerie, Factura factura, int j) {
		boolean existe = false;
		int i = 0;
		while(!existe && i < misComponentes.size()) {
			if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
				existe = true;
				misComponentes.get(i).cantReal -= factura.getComponentes().get(j).cantReal ;
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
	
	public void aumentarCompInsideOrden(OrdenCompra compra, boolean aceptada) {
		boolean existe = false;
		int i = 0;
		while(!existe && i < misComponentes.size()) {
			if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(compra.getComponentes().numeroDeSerie)) {
				existe = true;
				misComponentes.get(i).cantReal += 2*(misComponentes.get(i).cantMin);
			}
			i++;
		}
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
	  for(Componente componente : misComponentes) {
		if(componente.getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
		 return componente;
		}
	  }
	  return null;
	}

	public Factura buscFactura(String codFac) {
		 for(Factura factura : misFacturas) {
		  if(factura.getCodFactura().equalsIgnoreCase(codFac)) {
			return factura;
		  }
		 }
		 return null;
	}
	
	public Cliente buscCliente(String cedula) {
		for(Cliente cliente : misClientes ) {
		 if(cliente.getCedula().equalsIgnoreCase(cedula)) {
			 return cliente;
		 }
		}
		return null;
		
	}
}
