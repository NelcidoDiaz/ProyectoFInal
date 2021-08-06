package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import source.Combo;
import source.Componente;
import source.Controladora;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListCombos extends JFrame {

	private JPanel contentPane;
	private JTable tblCombos;
	private Controladora miControladora = new Controladora();
	private ArrayList<Combo> misCombos = new ArrayList<Combo>();
	private int seleccion;
	private JButton btnSeleccionado;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCombos frame = new ListCombos();
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
	public ListCombos() {
		setTitle("Lista de Combos");
		DefaultTableModel model = new DefaultTableModel();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				model.addColumn("Nombre");
				model.addColumn("Descuento");
				model.addColumn("Precio");
				for (Combo comb : misCombos) {
					model.insertRow(contador,new Object[] { comb.getNombre(),comb.getDescuento(),comb.calcValComb()});
				}
			}
		});
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
		panel_1.setBounds(10, 11, 404, 173);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tblCombos = new JTable();
		tblCombos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccion = tblCombos.getSelectedRow();
				if(seleccion!=-1) {
					btnSeleccionado.setEnabled(true);
				}else {
					btnSeleccionado.setEnabled(false);
				}
				
			}
		});
		tblCombos.setModel(model);
		scrollPane.setViewportView(tblCombos);
		
		btnSeleccionado = new JButton("Seleccionado");
		btnSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combo aux = Controladora.getInstance().buscCombo(model.getValueAt(seleccion, 0).toString());
				btnSeleccionado.setEnabled(false);
				RegFactura factura = new RegFactura();
				factura.adquirirObjetosComprados(aux.getCompCombo());
				factura.setVisible(true);
				factura.setComponentes(aux.getCompCombo());
				factura.setControladora(miControladora);
				dispose();
			}
		});
		btnSeleccionado.setEnabled(false);
		btnSeleccionado.setBounds(209, 217, 106, 23);
		panel.add(btnSeleccionado);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(325, 217, 89, 23);
		panel.add(btnCancelar);
	}

}
