package source;

public class DiscoDuro extends Componente {
	 private String modelo;
	 private int capaAlmacenamiento;
	 private String tipoDeConexion;
	 
	public DiscoDuro(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax, String modelo, int capaAlmacenamiento, String tipoDeConexion) {
		super(marca, precio, numeroDeSerie, descuento, cantReal, cantMin, cantMax);
		this.modelo = modelo;
		this.capaAlmacenamiento = capaAlmacenamiento;
		this.tipoDeConexion = tipoDeConexion;
	}
	 
}
