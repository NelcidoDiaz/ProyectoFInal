package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import source.Componente;
import source.Controladora;
import source.DiscoDuro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegCombos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDescuento;
	private JTextField txtPrecio;
	private ArrayList<Componente> componenteElegido = new ArrayList<Componente>();
	private JComboBox cmbComponentes;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void getCombos() {
	 
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCombos frame = new RegCombos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 
	
	public void adquirirObjetos(ArrayList<Componente> componentes) {
		componenteElegido = componentes;
	}

	/**
	 * Create the frame.
	 */
	public RegCombos() {
		DefaultTableModel model = new DefaultTableModel();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				model.addColumn("NoSerie");
				model.addColumn("Marca");
				model.addColumn("Precio");
				model.addColumn("CantReal");
				model.addColumn("CantMin");
				model.addColumn("CantMax");
				model.addColumn("CantObtenida");
				for(Componente comp: componenteElegido) {
					model.insertRow(contador, new Object[] {comp.getNumeroDeSerie(),comp.getMarca(),comp.getPrecio(),
															comp.getCantReal(), comp.getCantMin(),comp.getCantMax()});
				}
			}
		});
		
		setTitle("Registrar Combos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 14, 53, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 12, 181, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 531, 306);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescuento.setBounds(551, 75, 65, 14);
		panel.add(lblDescuento);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(551, 121, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtDescuento = new JTextField();
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar) && validar != '.') {
					e.consume();
				}
				if(validar == '.' && txtNombre.getText().contains(".")) {
					e.consume();
				}
			}
		});
		txtDescuento.setBounds(635, 73, 113, 20);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(635, 119, 113, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				source.Combo combo = new source.Combo("Jugador Extremo", componenteElegido, 12);
				Controladora.getInstance().insertarCombo(combo);
				txtPrecio.setText(String.valueOf(combo.calcValComb()));
				model.setRowCount(0);
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCrear.setBounds(541, 411, 89, 23);
		panel.add(btnCrear);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(659, 411, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblComponentes = new JLabel("Productos:");
		lblComponentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComponentes.setBounds(551, 14, 63, 14);
		panel.add(lblComponentes);
		
		cmbComponentes = new JComboBox();
		cmbComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = cmbComponentes.getSelectedItem().toString();
				String url = "";
				ArrayList<Componente> componente = new ArrayList<Componente>();
				ArrayList<String> misColumnas = new ArrayList<String>();
				misColumnas.addAll(Arrays.asList("Numero de Serie","Marca","Precio","CantReal","CantMin","CantMax"));
				switch (valor) {
					case "Disco Duro":
						misColumnas.addAll(Arrays.asList("Modelo", "Almacenamiento", "tipoDeConexion"));
						url = "/visual/imagenes/DiscoDuro-1.jpg";
						for (Componente component : Controladora.getInstance().getMisComponentes()) {
							if (component instanceof DiscoDuro) {
								componente.add(component);
							}
						}
						break;
					case "Memoria RAM":
						misColumnas.addAll(Arrays.asList("Cantidad de Memoria", "Tipo De Memoria"));
						url = "/visual/imagenes/MemoriaRam-1.jpg";
						break;
					case "Tarjeta Madre":
						misColumnas.addAll(Arrays.asList("Tipos de conexion", "Tipo De Conector", "Tipo De Memoria"));
						url = "/visual/imagenes/TarjetaMadre-1.jpg";
						break;
					case "Microprocesador":
						misColumnas.addAll(Arrays.asList("modelo", "socket", "velocidad"));
						url = "/visual/imagenes/MicroProcesador-1.jpg";
						break;
				}
				ElegirProductos productos = new ElegirProductos();
				productos.getImages(url);
				productos.getComponentes(componente);

				productos.setVisible(true);
				productos.setTipoDeComponente(valor);
				productos.getColumns(misColumnas);
				dispose();
			}
		});
		cmbComponentes.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Memoria RAM", "Disco Duro", "Microprocesador", "Tarjeta Madre"}));
		cmbComponentes.setBounds(635, 12, 113, 20);
		panel.add(cmbComponentes);
	}
}
