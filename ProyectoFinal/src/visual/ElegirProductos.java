package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import source.Componente;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElegirProductos extends JFrame {

	private JPanel contentPane;
	
    private ArrayList <Componente>  misComponentes;
    private String Url;
    private ArrayList <String> Columnas = new  ArrayList <String>();
   // private final 
   
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
   public void getColumns(ArrayList <String> columnas) { 
		Columnas = columnas;
   }
   public void getComponentes(ArrayList <Componente> compenentes) {
	  misComponentes = compenentes;
   }
   public void getImages(String url) {
	 Url = url;  
   }
	/**
	 * Create the frame.
	 */
	public ElegirProductos() {
		  
		 DefaultTableModel model = new DefaultTableModel();
		 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				 for(String columna : Columnas) {
						model.addColumn(columna);
						System.out.println(columna);
					 }
				 
			}
			
		});
		
		addWindowStateListener(new WindowStateListener() {
			
			public void windowStateChanged(WindowEvent arg0) {
			
			 
				
			}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(838, 178, 110, 24);
		contentPane.add(comboBox);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(722, 183, 66, 15);
		contentPane.add(lblCantidad);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(727, 286, 114, 25);
		contentPane.add(btnComprar);
		 
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(727, 237, 86, 15);
		contentPane.add(lblDescuento);
		
		JLabel label = new JLabel("0");
		label.setBounds(838, 237, 66, 15);
		contentPane.add(label);
		
	
	
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lblImagen = new JLabel("");
				lblImagen.setIcon(new ImageIcon(ElegirProductos.class.getResource(Url.toString())));
				lblImagen.setBounds(699, 0, 249, 153);
				contentPane.add(lblImagen);
			}
		});
		 
		table.setBounds(12, 23, 638, 363);
		table.setFillsViewportHeight(true); 
		//model.addColumn();
		contentPane.add(table);
		model.addRow(new Object[]{"v1", "v2"});
		
	}
}
