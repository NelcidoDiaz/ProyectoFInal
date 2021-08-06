package source;

import java.io.Serializable;
import java.util.ArrayList;
import exception.NotNegativeNumberExeption;

public class Combo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4319222390093661524L;
	private String nombre;
	private ArrayList<Componente> compCombo;
	private float descuento;
	private float total;

	public Combo(String nombre, ArrayList<Componente> compCombo, float descuento) {
		super();
		this.nombre = nombre;
		this.compCombo = compCombo;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Componente> getCompCombo() {
		return compCombo;
	}

	public void setCompCombo(ArrayList<Componente> compCombo) {
		this.compCombo = compCombo;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) throws NotNegativeNumberExeption {
		if (descuento > 0) {
			this.descuento = descuento;
		} else {
			throw new NotNegativeNumberExeption();
		}

	}

	public float calcValComb() {
		float combo = 0;
		combo = calcPrecioTotal() - calcPrecioTotal() * (descuento/100);
		return combo;
	}

	private float calcPrecioTotal() {
		float total = 0;
		for (Componente componente : compCombo) {
			if (componente != null) {
				total += componente.getPrecio();
			}
		}
		return total;
	}

}
