package source;

public class Main {
	 private static Fichero archivo;
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			archivo = new Fichero("src/ficheros/facturas.txt");
			archivo.crearArchivo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
