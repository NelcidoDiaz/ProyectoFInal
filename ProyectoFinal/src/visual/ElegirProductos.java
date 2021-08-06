package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import exception.NotNegativeNumberExeption;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import source.Cliente;
import source.Componente;
import source.Controladora;

import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import source.Componente;
import source.DiscoDuro;
import source.MemoriaRam;
import source.TarjetaMadre;
import source.MicroProcesador;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ElegirProductos extends JFrame {

	private JPanel contentPane;

	
	private String Url;
	private ArrayList <Cliente> misClientes = new ArrayList <Cliente>();
	private ArrayList<Componente> misComponentes =  new ArrayList <Componente>();
	private Controladora miControladora = new Controladora();
	private ArrayList<Componente> todosComponentes = new ArrayList <Componente>();
	private ArrayList<Componente> componentesElegidos = new ArrayList <Componente>();
	private String tipoDeComponentes;
	private ArrayList<String> Columnas = new ArrayList<String>();
	private JTable table;
	private JRadioButton rdbtnCombo;
	private JRadioButton rdbtnFactura;
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

	public void getColumns(ArrayList<String> columnas) {
		Columnas = columnas;
	}

	public void getComponentes(ArrayList<Componente> compenentes) {
		misComponentes = compenentes;
	}

	public void getImages(String url) {
		Url = url;
	}

	public void setTipoDeComponente(String tipo) {
		tipoDeComponentes = tipo;
	}
	public void setTodosComponentes(ArrayList<Componente> componentes) {
		todosComponentes = componentes; 
	}
	 public void setControladora(Controladora controladora ) {
	    	miControladora = controladora;	
	    }
	  public void setClientes(ArrayList <Cliente> clientes) {
		     misClientes = clientes;
		    }
	/**
	 * Create the frame.
	 */
	public ElegirProductos() {

		DefaultTableModel model = new DefaultTableModel();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				for (String columna : Columnas) {
					model.addColumn(columna);
				}
				JLabel lblImagen = new JLabel("");
				lblImagen.setIcon(new ImageIcon(ElegirProductos.class.getResource(Url.toString())));
				lblImagen.setBounds(699, 0, 249, 153);
				contentPane.add(lblImagen);
				int contador = 0;
				switch (tipoDeComponentes) {
				case "Disco Duro":
					for (Componente componente : misComponentes) {
						DiscoDuro duro = (DiscoDuro) componente;
						model.insertRow(contador,
								new Object[] { componente.getMarca(), componente.getPrecio(),
										componente.getNumeroDeSerie(), componente.getDescuento(),
										componente.getCantReal(), componente.getCantMin(), componente.getCantMax(),
										duro.getModelo(), duro.getCapaAlmacenamiento(), duro.getTipoDeConexion() });
					}
					break;
				case "Memoria Ram":
					for (Componente componente : misComponentes) {
						MemoriaRam ram = (MemoriaRam) componente;
						model.insertRow(contador,
								new Object[] { componente.getMarca(), componente.getPrecio(),
										componente.getNumeroDeSerie(), componente.getDescuento(),
										componente.getCantReal(), componente.getCantMin(), componente.getCantMax(),
										ram.getCantMemoria(), ram.getTipoMemoria() });
					}
					break;
				case "Tarjeta Madre":
					for (Componente componente : misComponentes) {
						TarjetaMadre tarjetaMadre = (TarjetaMadre) componente;
						model.insertRow(contador, new Object[] { componente.getMarca(), componente.getPrecio(),
								componente.getNumeroDeSerie(), componente.getDescuento(), componente.getCantReal(),
								componente.getCantMin(), componente.getCantMax(), tarjetaMadre.getTipoDeConexiones(),
								tarjetaMadre.getTipoDeConector(), tarjetaMadre.getTipoDeMemoria() });
					}
					break;
				case "Micro Procesador":
					for (Componente componente : misComponentes) {
						MicroProcesador micro = (MicroProcesador) componente;
						model.insertRow(contador,
								new Object[] { componente.getMarca(), componente.getPrecio(),
										componente.getNumeroDeSerie(), componente.getDescuento(),
										componente.getCantReal(), componente.getCantMin(), componente.getCantMax(),
										micro.getModelo(), micro.getSocket(), micro.getVelocProcs() });
					}
					break;
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

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(722, 225, 66, 15);
		contentPane.add(lblCantidad);
		JSpinner spinner = new JSpinner();
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int contador = 0;
				int index = table.getSelectedRow();
				int valorDelSpinner = (Integer) spinner.getValue();
				for (Componente componente : misComponentes) {
					if (contador == index) {
						componentesElegidos.add(componente);
						if (valorDelSpinner == componente.getCantReal()) {
						 model.removeRow(index);
						}
						else {
					     int cantidadRealActual = componente.getCantReal();
					     try {
							componente.setCantReal(cantidadRealActual - valorDelSpinner);
						} catch (NotNegativeNumberExeption e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						
					}
				}
			}
		});
		btnComprar.setBounds(722, 325, 114, 25);
		contentPane.add(btnComprar);

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(722, 279, 86, 15);
		contentPane.add(lblDescuento);

		JLabel label = new JLabel("0");
		label.setBounds(932, 279, 66, 15);
		contentPane.add(label);

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int contador = 0;
				for (Componente componente : misComponentes) {
					if (contador == index) {
						spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
								new Integer(componente.getCantReal()), new Integer(1)));
						label.setText(String.valueOf(componente.getDescuento()));
					}
				}

			}
		});
		table.setBounds(26, 12, 637, 357);
		contentPane.add(table);

		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(891, 223, 86, 20);
		contentPane.add(spinner);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnFactura.isSelected()) {
					RegFactura factura = new RegFactura();
					factura.adquirirObjetosComprados(componentesElegidos);
					factura.setVisible(true);
			 
					factura.setComponentes(todosComponentes);
					factura.setClientes(misClientes);
		     
					factura.setControladora(miControladora);
				}
				else if(rdbtnCombo.isSelected()) {
					RegCombos combo = new RegCombos();
					combo.adquirirObjetos(componentesElegidos);
					combo.setVisible(true);
					combo.setComponentes(todosComponentes);
					combo.setControladora(miControladora);
				}
			 
			 dispose();
			}
		});
		btnSalir.setBounds(884, 325, 114, 25);
		contentPane.add(btnSalir);
		
		JLabel lblSeleccion = new JLabel("Selecci\u00F3n:");
		lblSeleccion.setBounds(722, 170, 148, 14);
		contentPane.add(lblSeleccion);
		
		rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCombo.setSelected(false);
			}
		});
		rdbtnFactura.setBounds(859, 166, 77, 23);
		contentPane.add(rdbtnFactura);
		
		rdbtnCombo = new JRadioButton("Combo");
		rdbtnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFactura.setSelected(false);
			}
		});
		rdbtnCombo.setBounds(989, 166, 77, 23);
		contentPane.add(rdbtnCombo);

	}
}
