package source;

import exception.NotNegativeNumberExeption;

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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapaAlmacenamiento() {
		return capaAlmacenamiento;
	}

	public void setCapaAlmacenamiento(int capaAlmacenamiento) throws NotNegativeNumberExeption {
		if (capaAlmacenamiento > 0) {
			this.capaAlmacenamiento = capaAlmacenamiento;
		} else {
			throw new NotNegativeNumberExeption();
		}
	}

	public String getTipoDeConexion() {
		return tipoDeConexion;
	}

	public void setTipoDeConexion(String tipoDeConexion) {
		this.tipoDeConexion = tipoDeConexion;
	}

}
