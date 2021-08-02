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

	public String getTipoDeConector() {
		return tipoDeConector;
	}

	public void setTipoDeConector(String tipoDeConector) {
		this.tipoDeConector = tipoDeConector;
	}

	public String getTipoDeMemoria() {
		return tipoDeMemoria;
	}

	public void setTipoDeMemoria(String tipoDeMemoria) {
		this.tipoDeMemoria = tipoDeMemoria;
	}

	public String[] getTipoDeConexiones() {
		return tipoDeConexiones;
	}

	public void setTipoDeConexiones(String[] tipoDeConexiones) {
		this.tipoDeConexiones = tipoDeConexiones;
	}
	 
}
