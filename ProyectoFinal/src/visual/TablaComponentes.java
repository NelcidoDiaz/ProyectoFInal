package visual;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class TablaComponentes extends  JDialog{
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaComponentes frame = new TablaComponentes();
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
	public TablaComponentes() {
		setTitle("Tabla de componentes");
		setBounds(100, 100, 450, 314);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 227);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imagen", "Componente"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBounds(335, 250, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lbl_Cantidad = new JLabel("Cantidad:");
		lbl_Cantidad.setBounds(23, 238, 56, 14);
		panel.add(lbl_Cantidad);
		
		JSpinner spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnCantidad.setBounds(85, 235, 64, 20);
		panel.add(spnCantidad);

	}
}
