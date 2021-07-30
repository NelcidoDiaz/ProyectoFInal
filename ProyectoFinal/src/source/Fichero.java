package source;

import java.io.BufferedReader;
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
   // La 
	public void escribirArchivo() throws IOException {
		 FileWriter archivo = new FileWriter(direccion);
		 try 
		 {
		  archivo.flush();
		  /*while() {
			  
		  }*/
		 }
		 catch(FileNotFoundException nodirec) 
		 {
			 System.out.println("No existe tal archivo");
		 }
	}
   public String leerArchivo(int cantidadDePropiedades) throws IOException {
	   String cadena = "";
	   String cadenaCompleta = "";
	   FileReader archivo = new FileReader(direccion);   
	   BufferedReader b = new BufferedReader(archivo);
	   while((cadena = b.readLine()) != null) {
		 cadenaCompleta.concat(cadena);
	   }
	   return cadenaCompleta;
   }
  
}
