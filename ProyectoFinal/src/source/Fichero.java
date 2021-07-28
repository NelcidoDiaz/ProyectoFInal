package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	private String direccion;

	public Fichero(String direccion) {
		super();
		this.direccion = direccion;
	}

	public void crearArchivo() {
		File archivo = new File(direccion);
		if (archivo.exists() == false) {
			try {
				archivo.createNewFile();
			} catch (FileNotFoundException nodirec) {
				System.out.println("La ruta esta mal");
			} catch (IOException e) {
				System.out.println("Ha habido algun error");
			}
		}

	}

	public void escribirArchivo() throws IOException {
		 FileWriter archivo = new FileWriter(direccion);
		 try 
		 {
		  archivo.flush();
		 }
		 catch(FileNotFoundException nodirec) 
		 {
			 
		 }
	}
   public void leerArchivo(int cantidadDePropiedades) throws FileNotFoundException {
	   FileReader archivo = new FileReader(direccion);   
	   //
   }
}
