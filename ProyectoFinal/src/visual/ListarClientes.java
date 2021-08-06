package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import source.Cliente;
import source.Componente;
import source.Controladora;
import source.DiscoDuro;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class ListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtCredito;
	private ArrayList <Cliente> misClientes = new ArrayList <Cliente>();
	private Controladora miControladora = new Controladora();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes frame = new ListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	public ListarClientes() {
		DefaultTableModel model = new DefaultTableModel();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			int contador = 0;
			for (Cliente cliente: misClientes) {
				 
					model.insertRow(contador,
							new Object[] { cliente.getCedula(),cliente.getNombre(),cliente.getApellido(),cliente.getCredito()});
				}
			}
		});
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {
			}
		});
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(31, 21, 157, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(31, 139, 157, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula");
		lblNewLabel_2.setBounds(31, 248, 157, 52);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(518, 20, 141, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Credito");
		lblNewLabel_4.setBounds(518, 139, 141, 52);
		contentPane.add(lblNewLabel_4);
		
		table = new JTable(model);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombre", "Apellido", "Direccion", "Credito"
			}
		));
		table.setBounds(31, 316, 1008, 319);
		contentPane.add(table);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(185, 34, 190, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(185, 152, 190, 27);
		contentPane.add(txtApellido);
		txtCredito = new JTextField();
		txtDireccion = new JTextField();
		txtCedula = new JTextField();
		txtCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Cliente cliente: misClientes) {
				  if(cliente.getCedula().equals(txtCedula.getText()) == true) {
					txtNombre.setText(cliente.getNombre());
					txtApellido.setText(cliente.getApellido());
					txtDireccion.setText(cliente.getDireccion());
					txtCredito.setText(String.valueOf(cliente.getCredito()));
				  }
				  if(txtCedula.getText().equals("") == true) {
					  txtNombre.setText("");
						txtApellido.setText("");
						txtDireccion.setText("");
						txtCredito.setText("");	  
				  }
				}
			}
		});
		txtCedula.setColumns(10);
		txtCedula.setBounds(185, 261, 190, 27);
		contentPane.add(txtCedula);
		
		 
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(660, 34, 190, 27);
		contentPane.add(txtDireccion);
		
		 
		txtCredito.setColumns(10);
		txtCredito.setBounds(660, 156, 190, 27);
		contentPane.add(txtCredito);
	}
}
