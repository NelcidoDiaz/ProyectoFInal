package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Administrador;
import source.Controladora;
import source.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtUsuario;
	private JTextField txtCodigo;
	private JTextField txtCodAdmin;
	private JTextField txtSueldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegEmpleado frame = new RegEmpleado();
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
	public RegEmpleado() {
		setTitle("Registrar Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(10, 11, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(193, 11, 46, 14);
		panel.add(lblApellido);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCedula.setBounds(10, 53, 46, 14);
		panel.add(lblCedula);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(193, 97, 46, 14);
		panel.add(lblCodigo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsuario.setBounds(10, 97, 46, 14);
		panel.add(lblUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 8, 117, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(249, 8, 129, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(66, 50, 117, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 94, 117, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(249, 94, 129, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(10, 166, 46, 14);
		panel.add(lblTipo);
		
		JComboBox cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Vendedor"}));
		cmbTipo.setBounds(66, 163, 117, 20);
		panel.add(cmbTipo);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String cedula= txtCedula.getText();
				String cod = txtCodigo.getText();
				String usuario = txtUsuario.getText();
				float sueldo = Float.parseFloat(txtSueldo.getText());
				if(cmbTipo.getSelectedItem().equals("Administrador")) {
					String codAdmin = txtCodAdmin.getText();
					Administrador aux = new Administrador(nombre, apellido, cedula, cod, usuario, sueldo, codAdmin);
					Controladora.getInstance().insertarEmpleado(aux);
				}
				else {
					Empleado aux = new Empleado(nombre, apellido, cedula, cod, usuario, sueldo);
					Controladora.getInstance().insertarEmpleado(aux);
				}
				JOptionPane.showMessageDialog(null, "Empleado Registrado");
				limpiar();
			}
		});
		btnRegistrar.setBounds(226, 255, 89, 23);
		panel.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main Frame = new Main();
				Frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(325, 255, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblCodAdministrador = new JLabel("Cod Administrador:");
		lblCodAdministrador.setBounds(10, 206, 98, 14);
		panel.add(lblCodAdministrador);
		
		txtCodAdmin = new JTextField();
		txtCodAdmin.setBounds(118, 203, 86, 20);
		panel.add(txtCodAdmin);
		txtCodAdmin.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(10, 127, 46, 14);
		panel.add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(!Character.isDigit(validar) && validar != '.') {
					e.consume();
				}
				if(validar == '.' && txtSueldo.getText().contains(".")) {
					e.consume();
				}
			}
		});
		txtSueldo.setBounds(66, 125, 117, 20);
		panel.add(txtSueldo);
		txtSueldo.setColumns(10);
	}
	private void limpiar() {
		txtApellido.setText("");
		txtCedula.setText("");
		txtCodAdmin.setText("");
		txtCodigo.setText("");
		txtNombre.setText("");
		txtSueldo.setText("");
		txtUsuario.setText("");
	}
}
