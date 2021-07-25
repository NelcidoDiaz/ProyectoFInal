package source;

import exception.NotNegativeNumberExeption;

public abstract class Componente {
	 protected String marca;
	 protected float precio;
	 protected String numeroDeSerie;
	 protected float descuento;
	 protected int cantReal;
	 protected int cantMin;
	 protected int cantMax;
	 
	public Componente(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.numeroDeSerie = numeroDeSerie;
		this.descuento = descuento;
		this.cantReal = cantReal;
		this.cantMin = cantMin;
		this.cantMax = cantMax;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio)throws NotNegativeNumberExeption {
		if(precio>0) {
			this.precio = precio;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento)throws NotNegativeNumberExeption {
		if(descuento>0) {
			this.descuento = descuento;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}

	public int getCantReal() {
		return cantReal;
	}

	public void setCantReal(int cantReal)throws NotNegativeNumberExeption {
		if(cantMax>0) {
			this.cantReal = cantReal;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}

	public int getCantMin() {
		return cantMin;
	}

	public void setCantMin(int cantMin)throws NotNegativeNumberExeption {
		if(cantMin>0) {
			this.cantMin = cantMin;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cantMax) throws NotNegativeNumberExeption{
		if(cantMax>0) {
			this.cantMax = cantMax;
		}else {
			throw new NotNegativeNumberExeption();
		}
	}
	
	 
}
