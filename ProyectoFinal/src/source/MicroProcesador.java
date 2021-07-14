package source;

import exception.NotNegativeNumberExeption;

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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public float getVelocProcs() {
		return velocProcs;
	}

	public void setVelocProcs(float velocProcs) throws NotNegativeNumberExeption {
		if(velocProcs>0) {
			this.velocProcs = velocProcs;
		}else {
			throw new NotNegativeNumberExeption("La velocidad del procesador no puede ser negativa");
		}
	}
	
	 
}
