package source;

import exception.NotNegativeNumberExeption;

public class MemoriaRam extends Componente {
	private int cantMemoria;
	private String tipoMemoria;

	public MemoriaRam(String marca, float precio, String numeroDeSerie, float descuento, int cantReal, int cantMin,
			int cantMax, int cantMemoria, String tipoMemoria) {
		super(marca, precio, numeroDeSerie, descuento, cantReal, cantMin, cantMax);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public int getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(int cantMemoria) throws NotNegativeNumberExeption {
		if (cantMemoria > 0) {
			this.cantMemoria = cantMemoria;
		} else {
			throw new NotNegativeNumberExeption();
		}
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
