package source;

public class MicroProcesador extends Componente {
	private String modelo;
	 private String socket;
	 private float velocProcs;
	 
	public MicroProcesador(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax, String modelo, String socket, float velocProcs) {
		super(marca, precio, numeroDeSerie, descuento, cantReal, cantMin, cantMax);
		this.modelo = modelo;
		this.socket = socket;
		this.velocProcs = velocProcs;
	}
	 
}
