package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import source.Componente;

public class ElegirProductos extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private ArrayList <Componente>  misComponentes;
    private String [] Columnas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirProductos frame = new ElegirProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   public void getColumns(String [] columnas) { 
		Columnas = columnas;
   }
   public void getComponentes(ArrayList <Componente> compenentes) {
	  misComponentes = compenentes;
   }
	/**
	 * Create the frame.
	 */
	public ElegirProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 12, 293, 370);
		contentPane.add(table);
        
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(475, 204, 110, 24);
		contentPane.add(comboBox);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(357, 209, 66, 15);
		contentPane.add(lblCantidad);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(471, 305, 114, 25);
		contentPane.add(btnComprar);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(357, 263, 86, 15);
		contentPane.add(lblDescuento);
		
		JLabel label = new JLabel("0");
		label.setBounds(493, 263, 66, 15);
		contentPane.add(label);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ElegirProductos.class.getResource("/visual/imagenes/White-Background.png")));
		lblImagen.setBounds(336, 12, 249, 153);
		contentPane.add(lblImagen);
		
	}
}
