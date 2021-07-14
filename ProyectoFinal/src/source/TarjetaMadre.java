package source;

public class TarjetaMadre extends Componente {
	 private String tipoDeConector;
	 private String tipoDeMemoria;
	 private String [] tipoDeConexiones;
	 
	public TarjetaMadre(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax, String tipoDeConector, String tipoDeMemoria, String[] tipoDeConexiones) {
		super(marca, precio, numeroDeSerie, descuento, cantReal, cantMin, cantMax);
		this.tipoDeConector = tipoDeConector;
		this.tipoDeMemoria = tipoDeMemoria;
		this.tipoDeConexiones = tipoDeConexiones;
	}
	 
}
