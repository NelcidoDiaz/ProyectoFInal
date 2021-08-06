package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import source.Administrador;
import source.Controladora;
import source.Empleado;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class ListarEmpleados extends JFrame {

	private JPanel contentPane;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JTable table;
	private Controladora miControladora = new Controladora();
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
					ListarEmpleados frame = new ListarEmpleados();
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
	public ListarEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 404, 163);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		String[] colums = {"Cedula","Nombre","Apellido","ID", "Codigo","Tipo","Sueldo"};
		modelo.setColumnIdentifiers(colums);
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		cargarTabla();
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setControladora(miControladora);
				dispose();
			}
		});
		btnSalir.setBounds(325, 217, 89, 23);
		panel.add(btnSalir);
	}
	private void cargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(Empleado i : Controladora.getInstance().getMisEmpleados()) {
			if(i!=null) {
				fila[0] = i.getCedula();
				fila[1] = i.getNombre();
				fila[2] = i.getApellido();
				fila[3] = i.getId();
				fila[4] = i.getCodigo();
				fila[6] = i.getSueldo();
				if(i instanceof Administrador) {
					fila[5] = "Administrador";
				}
				else {
					fila[5] = "Vendedor";
				}
			}
			modelo.addRow(fila);
		}
	}
}
