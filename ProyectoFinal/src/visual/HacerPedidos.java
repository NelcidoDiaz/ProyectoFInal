package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class HacerPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tblElegidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HacerPedidos frame = new HacerPedidos();
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
	public HacerPedidos() {
		setTitle("Hacer Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 462);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 712, 187);
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
		
		JLabel lblFacturas = new JLabel("Facturas");
		lblFacturas.setBounds(352, 29, 66, 15);
		panel.add(lblFacturas);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 113, 66, 15);
		panel.add(lblDireccion);
		
		textField = new JTextField();
		textField.setBounds(96, 27, 124, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 57, 124, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 82, 124, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 111, 124, 19);
		panel.add(textField_3);
		
		JLabel label = new JLabel("0");
		label.setBounds(106, 144, 66, 15);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(436, 24, 184, 24);
		panel.add(comboBox);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(352, 86, 66, 15);
		panel.add(lblProducto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Por seleccionar--", "Micro Procesador", "Memoria Ram", "Tarjeta Madre", "Disco Duro"}));
		comboBox_1.setBounds(436, 81, 184, 24);
		panel.add(comboBox_1);
		
		tblElegidos = new JTable();
		tblElegidos.setBounds(12, 207, 511, 206);
		contentPane.add(tblElegidos);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setBounds(571, 228, 114, 25);
		contentPane.add(btnFacturar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(571, 344, 114, 25);
		contentPane.add(btnCancelar);
	}
}
