package source;

public class MemoriaRam extends Componente {
	private int cantMemoria;
	private String tipoMemoria;
	
	public MemoriaRam(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax, int cantMemoria, String tipoMemoria) {
		super(marca, precio, numeroDeSerie, descuento, cantReal, cantMin, cantMax);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}
	
}
