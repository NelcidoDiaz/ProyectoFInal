package visual;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Fondo extends JFrame {
	public Fondo() {
	}
  public static void main(String[] args) {
		Fondo f = new Fondo();
		f.setSize(400,300);	
		f.setVisible(true);
	    Imagen imagen = new Imagen("/home/nelcido/Imágenes/Screenshot from 2021-07-24 09-28-49.png");
	    imagen.setBounds(1, 1, 70, 70);
	    f.add(imagen);
	    f.repaint();
  }
}
