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
	    Imagen imagen = new Imagen("/imagenes/amazon-icon.jpg");
	    imagen.setBounds(1, 1, 70, 70);
	    f.add(imagen);
	    f.repaint();
  }
}
