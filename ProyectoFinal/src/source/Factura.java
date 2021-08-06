package source;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import exception.NotNegativeNumberExeption;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6000817889584556170L;
	private String codFactura;
	private Cliente cliente;
	private float total;
	private LocalDate fecha;
	private ArrayList<Componente> Componentes;
	private Combo Combos;
	private Fichero archivo;

	public Factura(String codFactura, Cliente cliente, float total, LocalDate fecha, ArrayList<Componente> componentes) {
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

	public void setTotal(float total) throws NotNegativeNumberExeption {
		if (total > 0) {
			this.total = total;
		} else {
			throw new NotNegativeNumberExeption();
		}
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	public ArrayList<Componente> getComponentes() {
		return Componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		Componentes = componentes;
	}
	
   public Combo getCombos() {
		return Combos;
	}

	public void setCombos(Combo combos) {
		Combos = combos;
	}

public void guardar() {
	   this.archivo = new Fichero("~/src/ficheros/facturas.txt");
   }
   
   public void calcTotal() {
	   for(Componente i: Componentes) {
		   if(i!=null) {
			   total += i.calcpreciotot();
		   }
	   } 
   }
}
