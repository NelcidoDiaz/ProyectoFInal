package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import source.Componente;
import source.Controladora;
import source.DiscoDuro;
import source.MemoriaRam;
import source.MicroProcesador;
import source.TarjetaMadre;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarComponentes extends JFrame {

	private JPanel contentPane = new JPanel();
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JTable table;
	private int seleccion;
	private JButton btnEliminar;

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
					ListarComponentes frame = new ListarComponentes();
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
	public ListarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 479, 274);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		String[] columns = {"Numero de Serie","Marca","Precio","Cant Real","Tipo","Capacidad", "Tipo de Memoria"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccion = table.getSelectedRow();
				if(seleccion!=-1) {
					btnEliminar.setEnabled(true);
				}else {
					btnEliminar.setEnabled(false);
				}
			}
		});
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		cargarTabla();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(400, 314, 89, 23);
		panel.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este componente?","Confirmación",JOptionPane.WARNING_MESSAGE);
				if(option==JOptionPane.OK_OPTION) {
					Controladora.getInstance().eliminarComponente(Controladora.getInstance().buscComponente(modelo.getValueAt(seleccion, 0).toString()));
					cargarTabla();
					btnEliminar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(296, 314, 89, 23);
		panel.add(btnEliminar);
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(Componente i: Controladora.getInstance().getMisComponentes()) {
			if(i!=null) {
				fila[0] = i.getNumeroDeSerie();
				fila[1] = i.getMarca();
				fila[2] = i.getPrecio();
				fila[3] = i.getCantReal();
				if( i instanceof MemoriaRam) {
					fila[4] = "RAM";
					fila[5] = ((MemoriaRam) i).getCantMemoria() + " GB";
					fila[6] = ((MemoriaRam) i).getTipoMemoria();
				}
				else if( i instanceof DiscoDuro) {
					fila[4] = "Disco Duro";
					fila[5] = ((DiscoDuro) i).getCapaAlmacenamiento() + " GB";
					fila[6] = null;
				}
				else if( i instanceof MicroProcesador) {
					fila[4] = "Microprocesador";
					fila[5] = ((MicroProcesador) i).getVelocProcs() + " Ghz";
					fila[6] = null;
				}
				else if( i instanceof TarjetaMadre) {
					fila[4] = "Tarjeta Madre";
					fila[5] = null;
					fila[6] = ((TarjetaMadre) i).getTipoDeMemoria();
				}
			}
			modelo.addRow(fila);
		}
	}
}
