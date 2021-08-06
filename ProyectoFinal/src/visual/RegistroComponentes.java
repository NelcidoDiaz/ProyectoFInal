package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import source.Componente;
import source.Controladora;
import source.DiscoDuro;
import source.MemoriaRam;
import source.MicroProcesador;
import source.TarjetaMadre;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtNoSerie;
	private JTextField txtPrecio;
	private JTextField txtConector;
	private JTextField txtMemoria;
	private JTextField txtModelo;
	private JTextField txtSocket;
	private JTextField txtVelocProces;
	private JTextField txtCantMemoria;
	private JTextField txtTipoMemoriaRAM;
	private JTextField txtModeloDisk;
	private JTextField txtAlmacen;
	private JSpinner spnCantReal;
	private JSpinner spnCantMin;
	private JSpinner spnCantMax;
	private JPanel pnlDiscoDuro;
	private JPanel pnlMicroprocesador;
	private JPanel pnlComponente;
	private JPanel pnlMemoriaRam;
	private JPanel pnlTarjetaMadre;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnTarjetaMadre;
	private JCheckBox chckbxIDE;
	private JCheckBox chckbxSATA;
	private JCheckBox chckbxSATA3;
	private JCheckBox chckbxNVMe;
	private JCheckBox chckbxSATA2;
	private JComboBox cmbTipoConexion;
	private JTextField txtDescuento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream control;
				FileOutputStream control2;
				ObjectInputStream controlRead;
				ObjectOutputStream controlWrite;
				try {
					control = new FileInputStream ("Tienda.dat");
					controlRead = new ObjectInputStream(control);
					Controladora temp = (Controladora)controlRead.readObject();
					Controladora.setControl(temp);
					control.close();
					controlRead.close();
				} catch (FileNotFoundException e) {
					try {
						control2 = new  FileOutputStream("Tienda.dat");
						controlWrite = new ObjectOutputStream(control2);
						controlWrite.writeObject(Controladora.getInstance());
						control2.close();
						controlWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					RegistroComponentes frame = new RegistroComponentes();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroComponentes() {

		setTitle("Registro de Componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(17, 10, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(17, 83, 46, 14);
		panel.add(lblPrecio);
		
		JLabel lblNoSerie = new JLabel("No. Serie:");
		lblNoSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoSerie.setBounds(17, 46, 56, 14);
		panel.add(lblNoSerie);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescuento.setBounds(308, 83, 68, 14);
		panel.add(lblDescuento);
		
		JLabel lblCantReal = new JLabel("Cant. Real:");
		lblCantReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantReal.setBounds(17, 130, 68, 14);
		panel.add(lblCantReal);
		
		JLabel lblCantMin = new JLabel("Cant. Min:");
		lblCantMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantMin.setBounds(174, 130, 56, 14);
		panel.add(lblCantMin);
		
		JLabel lblCantMax = new JLabel("Cant. Max:");
		lblCantMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantMax.setBounds(315, 130, 61, 14);
		panel.add(lblCantMax);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(102, 8, 128, 20);
		panel.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtNoSerie = new JTextField();
		txtNoSerie.setBounds(102, 43, 128, 20);
		panel.add(txtNoSerie);
		txtNoSerie.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar) && validar != '.') {
					e.consume();
				}
				if(validar == '.' && txtPrecio.getText().contains(".")) {
					e.consume();
				}
			}
		});
		txtPrecio.setBounds(102, 81, 127, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		spnCantReal = new JSpinner();
		spnCantReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnCantReal.setBounds(102, 127, 56, 20);
		panel.add(spnCantReal);
		
		spnCantMin = new JSpinner();
		spnCantMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnCantMin.setBounds(240, 127, 56, 20);
		panel.add(spnCantMin);
		
		spnCantMax = new JSpinner();
		spnCantMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnCantMax.setBounds(386, 128, 56, 20);
		panel.add(spnCantMax);
		
		pnlTarjetaMadre = new JPanel();
		pnlTarjetaMadre.setVisible(false);
		pnlTarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTarjetaMadre.setBounds(10, 230, 517, 172);
		panel.add(pnlTarjetaMadre);
		pnlTarjetaMadre.setLayout(null);
		
		JLabel lblTipoConector = new JLabel("Tipo Conector:");
		lblTipoConector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoConector.setBounds(17, 24, 93, 14);
		pnlTarjetaMadre.add(lblTipoConector);
		
		JLabel lblTipoMemoria = new JLabel("Tipo Memoria:");
		lblTipoMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoMemoria.setBounds(17, 62, 83, 14);
		pnlTarjetaMadre.add(lblTipoMemoria);
		
		JLabel lblTipoConexiones = new JLabel("Tipo Conexiones:");
		lblTipoConexiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoConexiones.setBounds(17, 107, 100, 14);
		pnlTarjetaMadre.add(lblTipoConexiones);
		
		txtConector = new JTextField();
		txtConector.setBounds(117, 22, 161, 20);
		pnlTarjetaMadre.add(txtConector);
		txtConector.setColumns(10);
		
		txtMemoria = new JTextField();
		txtMemoria.setBounds(117, 60, 161, 20);
		pnlTarjetaMadre.add(txtMemoria);
		txtMemoria.setColumns(10);
		
		chckbxSATA = new JCheckBox("SATA");
		chckbxSATA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSATA.setBounds(81, 128, 65, 23);
		pnlTarjetaMadre.add(chckbxSATA);
		
		chckbxIDE = new JCheckBox("IDE");
		chckbxIDE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxIDE.setBounds(17, 128, 52, 23);
		pnlTarjetaMadre.add(chckbxIDE);
		
		chckbxSATA2 = new JCheckBox("SATA-2");
		chckbxSATA2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSATA2.setBounds(148, 129, 76, 23);
		pnlTarjetaMadre.add(chckbxSATA2);
		
		chckbxSATA3 = new JCheckBox("SATA-3");
		chckbxSATA3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSATA3.setBounds(236, 129, 76, 23);
		pnlTarjetaMadre.add(chckbxSATA3);
		
		chckbxNVMe = new JCheckBox("NVMe");
		chckbxNVMe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNVMe.setBounds(333, 129, 65, 23);
		pnlTarjetaMadre.add(chckbxNVMe);
		
		pnlMicroprocesador = new JPanel();
		pnlMicroprocesador.setVisible(false);
		pnlMicroprocesador.setBounds(10, 230, 517, 172);
		panel.add(pnlMicroprocesador);
		pnlMicroprocesador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlMicroprocesador.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 24, 46, 14);
		pnlMicroprocesador.add(lblModelo);
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSocket.setBounds(10, 66, 46, 14);
		pnlMicroprocesador.add(lblSocket);
		
		txtSocket = new JTextField();
		txtSocket.setBounds(67, 64, 172, 20);
		pnlMicroprocesador.add(txtSocket);
		txtSocket.setColumns(10);
		
		JLabel lblVelocProces = new JLabel("Velocidad Procesamiento:");
		lblVelocProces.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVelocProces.setBounds(10, 114, 146, 14);
		pnlMicroprocesador.add(lblVelocProces);
		
		txtVelocProces = new JTextField();
		txtVelocProces.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar) && validar != '.') {
					e.consume();
				}
				if(validar == '.' && txtPrecio.getText().contains(".")) {
					e.consume();
				}
			}
		});
		txtVelocProces.setBounds(160, 112, 79, 20);
		pnlMicroprocesador.add(txtVelocProces);
		txtVelocProces.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(67, 22, 172, 20);
		pnlMicroprocesador.add(txtModelo);
		txtModelo.setColumns(10);
		
		pnlMemoriaRam = new JPanel();
		pnlMemoriaRam.setVisible(true);
		pnlMemoriaRam.setBounds(10, 230, 517, 172);
		panel.add(pnlMemoriaRam);
		pnlMemoriaRam.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMemoriaRam.setLayout(null);
		
		JLabel lblCantMemoria = new JLabel("Cant. Memoria:");
		lblCantMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantMemoria.setBounds(10, 29, 88, 14);
		pnlMemoriaRam.add(lblCantMemoria);
		
		JLabel lblTipoMemoriaRAM = new JLabel("Tipo Memoria:");
		lblTipoMemoriaRAM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoMemoriaRAM.setBounds(10, 83, 80, 14);
		pnlMemoriaRam.add(lblTipoMemoriaRAM);
		
		txtCantMemoria = new JTextField();
		txtCantMemoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar)) {
					e.consume();
				}
			}
		});
		txtCantMemoria.setBounds(100, 27, 86, 20);
		pnlMemoriaRam.add(txtCantMemoria);
		txtCantMemoria.setColumns(10);
		
		txtTipoMemoriaRAM = new JTextField();
		txtTipoMemoriaRAM.setBounds(100, 81, 86, 20);
		pnlMemoriaRam.add(txtTipoMemoriaRAM);
		txtTipoMemoriaRAM.setColumns(10);
		
		pnlComponente = new JPanel();
		pnlComponente.setBorder(new TitledBorder(null, "Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlComponente.setBounds(10, 155, 517, 64);
		panel.add(pnlComponente);
		pnlComponente.setLayout(null);
		
		rdbtnMemoriaRam = new JRadioButton("Memoria RAM");
		rdbtnMemoriaRam.setSelected(true);
		rdbtnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlTarjetaMadre.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(true);
				pnlDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnTarjetaMadre.setSelected(false);
			}
		});
		rdbtnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMemoriaRam.setBounds(6, 23, 109, 23);
		pnlComponente.add(rdbtnMemoriaRam);
		
		rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		rdbtnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlTarjetaMadre.setVisible(false);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(true);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnTarjetaMadre.setSelected(false);
			}
		});
		rdbtnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDiscoDuro.setBounds(137, 23, 109, 23);
		pnlComponente.add(rdbtnDiscoDuro);
		
		rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		rdbtnMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlTarjetaMadre.setVisible(false);
				pnlMicroprocesador.setVisible(true);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnTarjetaMadre.setSelected(false);
				
			}
		});
		rdbtnMicroprocesador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMicroprocesador.setBounds(248, 23, 121, 23);
		pnlComponente.add(rdbtnMicroprocesador);
		
		rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
		rdbtnTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlTarjetaMadre.setVisible(true);
				pnlMicroprocesador.setVisible(false);
				pnlMemoriaRam.setVisible(false);
				pnlDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
			}
		});
		rdbtnTarjetaMadre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTarjetaMadre.setBounds(387, 23, 109, 23);
		pnlComponente.add(rdbtnTarjetaMadre);
		
		pnlDiscoDuro = new JPanel();
		pnlDiscoDuro.setVisible(false);
		pnlDiscoDuro.setBounds(10, 230, 517, 172);
		panel.add(pnlDiscoDuro);
		pnlDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiscoDuro.setLayout(null);
		
		JLabel lblModeloDisk = new JLabel("Modelo:");
		lblModeloDisk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModeloDisk.setBounds(10, 30, 55, 14);
		pnlDiscoDuro.add(lblModeloDisk);
		
		JLabel lblCapcAlmacen = new JLabel("Almacenamiento:");
		lblCapcAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapcAlmacen.setBounds(10, 73, 99, 14);
		pnlDiscoDuro.add(lblCapcAlmacen);
		
		JLabel lblTipoConexion = new JLabel("Tipo Conexi\u00F3n:");
		lblTipoConexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoConexion.setBounds(10, 115, 88, 14);
		pnlDiscoDuro.add(lblTipoConexion);
		
		txtModeloDisk = new JTextField();
		txtModeloDisk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModeloDisk.setBounds(66, 28, 146, 20);
		pnlDiscoDuro.add(txtModeloDisk);
		txtModeloDisk.setColumns(10);
		
		txtAlmacen = new JTextField();
		txtAlmacen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar)) {
					e.consume();
				}
			}
		});
		txtAlmacen.setBounds(107, 71, 105, 20);
		pnlDiscoDuro.add(txtAlmacen);
		txtAlmacen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("GB");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(220, 73, 26, 14);
		pnlDiscoDuro.add(lblNewLabel);
		
		cmbTipoConexion = new JComboBox();
		cmbTipoConexion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "IDE", "SATA", "SATA-2", "SATA-3", "NVMe"}));
		cmbTipoConexion.setBounds(103, 113, 109, 20);
		pnlDiscoDuro.add(cmbTipoConexion);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = txtMarca.getText();
				String numSerie = txtNoSerie.getText();
				float precio = Float.valueOf(txtPrecio.getText());
				float descuento = Float.valueOf(txtDescuento.getText()) ;
				int cantReal = (int) spnCantReal.getValue();
				int cantMin = (int) spnCantMin.getValue();
				int cantMax = (int) spnCantMax.getValue();
				if(rdbtnMemoriaRam.isSelected()) {
					int cantMemoria = Integer.valueOf(txtCantMemoria.getText());
					String tipoMemoria = txtTipoMemoriaRAM.getText();
					MemoriaRam ram = new MemoriaRam(marca, precio, numSerie, descuento, cantReal, cantMin, cantMax, cantMemoria, tipoMemoria);
					Controladora.getInstance().insertarComponente(ram);
				}
				else if(rdbtnDiscoDuro.isSelected()) {
					String modelo = txtModeloDisk.getText();
					int capAlmacen = Integer.valueOf(txtAlmacen.getText());
					String tipoConexion = String.valueOf(cmbTipoConexion.getSelectedItem().toString());
					DiscoDuro disk = new DiscoDuro(marca, precio, numSerie, descuento, cantReal, cantMin, cantMax, modelo, capAlmacen, tipoConexion);
					Controladora.getInstance().insertarComponente(disk);
				}
				else if(rdbtnMicroprocesador.isSelected()) {
					String modelo = txtModelo.getText();
					String socket = txtSocket.getText();
					float velcProcs = Float.parseFloat(txtVelocProces.getText());
					MicroProcesador cpu = new MicroProcesador(marca, precio, numSerie, descuento, cantReal, cantMin, cantMax, modelo, socket, velcProcs);
					Controladora.getInstance().insertarComponente(cpu);
				}
				else if(rdbtnTarjetaMadre.isSelected()) {
					String tipoConector = txtConector.getText();
					String tipoMemoria = txtMemoria.getText();
					String [] tipoConexion = new String [5];
					String [] conexiones = llenarConexionTarjMadre(tipoConexion);
					TarjetaMadre madre = new TarjetaMadre(marca, precio, numSerie, descuento, cantReal, cantMin, cantMax, tipoConector, tipoMemoria, conexiones);
					Controladora.getInstance().insertarComponente(madre);
				}
				
				JOptionPane.showMessageDialog(null, "Componente registrado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();
			}
		});
		btnAniadir.setBounds(308, 413, 89, 23);
		panel.add(btnAniadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(419, 413, 89, 23);
		panel.add(btnCancelar);
		
		txtDescuento = new JTextField();
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar) && validar != '.') {
					e.consume();
				}
				if(validar == '.' && txtDescuento.getText().contains(".")) {
					e.consume();
				}
			}
		});
		txtDescuento.setBounds(375, 81, 86, 20);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
	}
	
	private String[] llenarConexionTarjMadre (String[] tipoConexion) {
		int i = 0;
		if(chckbxIDE.isSelected()) {
			tipoConexion[i] = "IDE";
			i++;
		}
		if(chckbxSATA.isSelected()) {
			tipoConexion[i] = "SATA";
			i++;
		}
		if(chckbxSATA2.isSelected()) {
			tipoConexion[i] = "SATA-2";
			i++;
		}
		if(chckbxSATA3.isSelected()) {
			tipoConexion[i] = "SATA-3";
			i++;
		}
		if(chckbxNVMe.isSelected()) {
			tipoConexion[i] = "NVMe";
			i++;
		}
		return tipoConexion;
	}
	
	private void limpiar() {
		txtMarca.setText("");
		txtNoSerie.setText("");
		txtPrecio.setText("");
		txtDescuento.setText("");
		txtAlmacen.setText("");
		txtCantMemoria.setText("");
		txtConector.setText("");
		txtMemoria.setText("");
		txtModelo.setText("");
		txtModeloDisk.setText("");
		txtSocket.setText("");
		txtTipoMemoriaRAM.setText("");
		txtVelocProces.setText("");
		spnCantMax.setValue(0);
		spnCantMin.setValue(0);
		spnCantReal.setValue(0);
		rdbtnMemoriaRam.setSelected(true);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMicroprocesador.setSelected(false);
		rdbtnTarjetaMadre.setSelected(false);
		chckbxNVMe.setSelected(false);
		chckbxIDE.setSelected(false);
		chckbxSATA.setSelected(false);
		chckbxSATA2.setSelected(false);
		chckbxSATA3.setSelected(false);
	}
}
