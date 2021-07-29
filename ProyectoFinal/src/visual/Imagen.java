package visual;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Imagen extends JPanel {
	private ImageIcon image;
	private String nombre;

	public Imagen(String nombre) throws HeadlessException {
		super();
		this.nombre = nombre;
	}
   public void aplicar(Graphics dibujar) {
	 Dimension dimencion = getSize();
	 image = new ImageIcon(getClass().getResource(nombre));
	 dibujar.drawImage(image.getImage(), 0, 0,dimencion.width ,dimencion.height, null);
	 super.paint(dibujar);
   }
}
