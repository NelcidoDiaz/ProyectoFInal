package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import source.Cliente;
import source.Controladora;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private RegFactura miFactura;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream control;
				ObjectInputStream controlRead;

				try {
					control = new FileInputStream("Tienda.dat");
					controlRead = new ObjectInputStream(control);
					Controladora temp = (Controladora) controlRead.readObject();
					Controladora.setControl(temp);
					controlRead.close();
				} catch (FileNotFoundException q) {
				
				} catch(IOException q) {
					
				}catch(ClassNotFoundException q) {
					q.printStackTrace();
				}
				try {
					ListarClientes frame = new ListarClientes();
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
	public ListarClientes() {
		DefaultTableModel model = new DefaultTableModel();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				model.addColumn("Cedula");
				model.addColumn("Nombre");
				model.addColumn("Apellido");
				model.addColumn("Direccion");
				model.addColumn("Factura");
				model.addColumn("Credito");
				for (Cliente client : Controladora.getInstance().getMisClientes()) {
					model.insertRow(contador,
							new Object[] { client.getCedula(), client.getNombre(), client.getApellido(),
										  client.getDireccion(),client.getMisFacturas(), client.getCredito()});
				}
			}
		});
		setTitle("Lista de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 404, 169);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(325, 217, 89, 23);
		panel.add(btnCancelar);
	}
}