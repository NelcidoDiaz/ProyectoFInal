package source;

import java.io.Serializable;
import java.util.ArrayList;

public class Controladora implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1320277948482211745L;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<OrdenCompra> ordenCompra;
	private static Empleado loginuser;
	private static Controladora control = null;
	
	
	public Controladora() {
		super();
		misComponentes = new ArrayList<Componente>();
		misFacturas = new ArrayList<Factura>();
		misClientes = new ArrayList<Cliente>();
		misCombos = new ArrayList<Combo>();
		misEmpleados = new ArrayList<Empleado>();
		ordenCompra = new ArrayList<OrdenCompra>();
	}
	
	public static Controladora getInstance() {
		if(control == null) {
			control = new Controladora();
		}
		return control;
	}
	
	public static Empleado getLoginuser() {
		return loginuser;
	}

	public static void setLoginuser(Empleado loginuser) {
		Controladora.loginuser = loginuser;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public static Controladora getControl() {
		return control;
	}

	public static void setControl(Controladora control) {
		Controladora.control = control;
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
	
	public void insertarFactura(Factura factura, int ventas) {
		misFacturas.add(factura);
		disminuirCompInsideFactura(factura,ventas);
	}
	
	public void insertarOrdenCompra(OrdenCompra compra) {
		ordenCompra.add(compra);
	}
	
	public boolean eliminarComponente(Componente c) {
		return misComponentes.remove(c);
	}
	
	// Esta funcion se encarga de restar la cantreal de los componentes del almacen si estos se encuentran en factura.
	private void disminuirCompInsideFactura(Factura factura, int ventas) {
		for(int i = 0; i < factura.getComponentes().size(); i++) {
			enctCompFact(factura.getComponentes().get(i).numeroDeSerie,factura,i,ventas);
		}
	}
	
	// Esta funcion se encarga de comparar el numSerie del componente con el que esta en almacen y si esto 
	// se cumple le resta la cantreal al componente del almacen.
	private void enctCompFact(String numSerie, Factura factura, int j, int ventas) {
		boolean existe = false;
		int i = 0;
		while(!existe && i < misComponentes.size()) {
			if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
				existe = true;
				misComponentes.get(i).cantReal -= ventas;
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
	
	public void insertarEmpleado(Empleado empleado) {
		misEmpleados.add(empleado);
	}
	
	public void aumentarCompInsideOrden(OrdenCompra compra) {
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
			if(componentes.cantReal <= componentes.cantMin) {
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
	
	public boolean CompRegistrado(String numSerie) {
		boolean existe = false;  
		int i = 0;
		while(!existe && i < misComponentes.size()) {
			  if(misComponentes.get(i)!=null) {
				  if(misComponentes.get(i).getNumeroDeSerie().equalsIgnoreCase(numSerie)) {
					  existe = true;
				  }
			  }
			
		  }
		  return existe;
	}
	
	public Combo buscCombo(String nombre) {
		for(Combo comb: misCombos) {
			if(comb!=null) {
				if(comb.getNombre().equalsIgnoreCase(nombre)) {
					return comb;
				}
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
	
	public boolean confirmLogin(String user, String pass) {
		boolean login = false;
		for(Empleado m: misEmpleados) {
			if(m!=null) {
				if(m.getId().equals(user)&& m.getCodigo().equalsIgnoreCase(pass)) {
					loginuser = m;
					login = true;
				}
			}
			else {
				loginuser = null;
			}
		}
		return login;
	}
}
