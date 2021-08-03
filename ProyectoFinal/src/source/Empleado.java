package source;

public abstract class Empleado extends Persona {

    private String codigo;
    private String id;
    private float sueldo;
    
	public Empleado(String nombre, String apellido, String cedula,String codigo,String id,float sueldo) {
		super(nombre, apellido, cedula);
		this.codigo = codigo;
		this.id = id;
		this.sueldo = sueldo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
  
}
