package source;

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
	 
}
