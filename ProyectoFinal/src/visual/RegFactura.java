package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import source.Componente;
import source.Controladora;
import source.Cliente;
import source.Combo;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import source.DiscoDuro;
import source.MemoriaRam;
import source.TarjetaMadre;
import source.MicroProcesador;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import source.Factura;
public class RegFactura extends JFrame {
	LocalDate date = LocalDate.now();
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTable tblElegidos;
	
	private ArrayList<Componente> componenteElegido = new ArrayList<Componente>();
	 

	// private
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFactura frame = new RegFactura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArrayList<String> getFields() {

		return null;
	}

	 

	public void selectComponets() {

	}
 

	public void adquirirObjetosComprados(ArrayList<Componente> componentes) {
		componenteElegido = componentes;
	}

	private void borrar(String entrada) {
		int contador = 0;
		for (Componente componente : Controladora.getInstance().getMisComponentes()) {
			if (componente.getNumeroDeSerie().equalsIgnoreCase(entrada) == true) {
				// misComponentes.remove(contador);
			}
			contador++;
		}
	}

	/**
	 * Create the frame.
	 */
	public RegFactura() {
		DefaultTableModel model = new DefaultTableModel();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				model.addColumn("Precio");
				model.addColumn("Marca");
				model.addColumn("NumeroDeSerie");
				model.addColumn("cantReal");
				model.addColumn("CantMax");
				model.addColumn("cantMin");
				model.addColumn("cantidad a comprar");
				for (Componente componente : componenteElegido) {
					model.insertRow(contador,
							new Object[] { componente.getMarca(), componente.getPrecio(), componente.getNumeroDeSerie(),
									componente.getDescuento(), componente.getCantReal(), componente.getCantMin(),
									componente.getCantMax() });
					// System.out.println(componente.getMarca());
				}
			}
		});
		setTitle("Hacer Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 462);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 870, 187);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 29, 66, 15);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 59, 66, 15);
		panel.add(lblApellido);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 86, 66, 15);
		panel.add(lblCedula);

		JLabel lblNewLabel = new JLabel("Credito");
		lblNewLabel.setBounds(12, 144, 66, 15);
		panel.add(lblNewLabel);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 113, 66, 15);
		panel.add(lblDireccion);

		txtNombre = new JTextField();
		txtNombre.setBounds(96, 27, 124, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(96, 57, 124, 19);
		panel.add(txtApellido);

		txtCedula = new JTextField();
		txtCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = Controladora.getInstance().buscCliente(txtCedula.getText());
				if (cliente != null) {
					txtNombre.setText(cliente.getNombre());
					txtApellido.setText(cliente.getApellido());
					txtDireccion.setText(cliente.getDireccion());
				}
			}
		});
		txtCedula.setColumns(10);
		txtCedula.setBounds(96, 82, 124, 19);
		panel.add(txtCedula);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(96, 111, 124, 19);
		panel.add(txtDireccion);

		JLabel label = new JLabel("0");
		label.setBounds(106, 144, 66, 15);
		panel.add(label);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(352, 86, 66, 15);
		panel.add(lblProducto);

		JComboBox comboBox_1 = new JComboBox();
		DiscoDuro disco = new DiscoDuro("kwai", 19, "13", 12, 2, 4, 5, "1000", 1123, "ssd");
		Controladora.getInstance().insertarComponente(disco);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valor = comboBox_1.getSelectedItem().toString();
				String Url = "";
				ArrayList<Componente> componente = new ArrayList<Componente>();
				ArrayList<String> misColumnas = new ArrayList<String>();
				misColumnas.addAll(Arrays.asList("Marca", "Precio", "numeroDeSerie", "descuento", "cantReal", "cantMin",
						"cantMax"));
				switch (valor) {
				case "Disco Duro":
					misColumnas.addAll(Arrays.asList("Modelo", "Almacenamiento", "tipoDeConexion"));
					Url = "/visual/imagenes/DiscoDuro-1.jpg";
					for (Componente component : Controladora.getInstance().getMisComponentes()) {
						if (component instanceof DiscoDuro) {
							componente.add(component);
						}
					}
					break;
				case "Memoria Ram":
					misColumnas.addAll(Arrays.asList("Cantidad de Memoria", "Tipo De Memoria"));
					Url = "/visual/imagenes/MemoriaRam-1.jpg";
					for (Componente component : Controladora.getInstance().getMisComponentes()) {
						if (component instanceof MemoriaRam) {
							componente.add(component);
						}
					}
					break;
				case "Tarjeta Madre":
					misColumnas.addAll(Arrays.asList("Tipos de conexion", "Tipo De Conector", "Tipo De Memoria"));
					Url = "/visual/imagenes/TarjetaMadre-1.jpg";
					for (Componente component : Controladora.getInstance().getMisComponentes()) {
						if (component instanceof TarjetaMadre) {
							componente.add(component);
						}
					}
					break;
				case "Micro Procesador":
					misColumnas.addAll(Arrays.asList("modelo", "socket", "velocidad"));
					Url = "/visual/imagenes/MicroProcesador-1.jpg";
					for (Componente component : Controladora.getInstance().getMisComponentes()) {
						if (component instanceof MicroProcesador) {
							componente.add(component);
						}
					}
					break;
				}
				ElegirProductos productos = new ElegirProductos();
				productos.getImages(Url);
				productos.getComponentes(componente);

				productos.setVisible(true);
				productos.setTipoDeComponente(valor);
			 
				productos.getColumns(misColumnas);
				dispose();
			}
		});
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				/*
				 * String valor = comboBox_1.getSelectedItem().toString();
				 * if(valor.equalsIgnoreCase("Disco Duro") == true) {
				 * System.out.println("Hello world"); }
				 */
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "--Por seleccionar--", "Micro Procesador",
				"Memoria Ram", "Tarjeta Madre", "Disco Duro" }));
		comboBox_1.setBounds(436, 81, 184, 24);
		panel.add(comboBox_1);

		tblElegidos = new JTable();
		tblElegidos.setModel(model);

		tblElegidos.setBounds(12, 207, 716, 206);
		contentPane.add(tblElegidos);

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				source.Factura factura = new source.Factura("12", null, 100, date, componenteElegido);
			    final Cliente miCliente = new Cliente(txtNombre.getText(),txtApellido.getText(),txtCedula.getText(),txtDireccion.getText(),factura,Float.parseFloat(label.getText()));
			    factura.setCliente(miCliente);
				Controladora.getInstance().insertarCliente(miCliente);
				Controladora.getInstance().insertarFactura(factura, 1);
				int contador = 0;
				model.setRowCount(0);
				for (Componente componenteElegido : componenteElegido) {
					borrar(componenteElegido.getNumeroDeSerie());
				}
              
			}

		});
		btnFacturar.setBounds(740, 249, 114, 25);
		contentPane.add(btnFacturar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main main = new Main();
				main.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(740, 352, 114, 25);
		contentPane.add(btnCancelar);
	}
}
