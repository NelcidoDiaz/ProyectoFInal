package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Administrador;
import source.Controladora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileOutputStream control2;
				ObjectOutputStream controlWrite;
				try {
					control2 = new  FileOutputStream("Tienda.dat");
					controlWrite = new ObjectOutputStream(control2);
					controlWrite.writeObject(Controladora.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/visual/imagenes/amazon-icon.jpg")));
		setTitle("Ventana principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		java.net.URL imgUrl = getClass().getResource("./imagenes/amazon-icon.jpg");
		ImageIcon icon = new ImageIcon(imgUrl);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVendedor = new JMenu("Vendedor");
		menuBar.add(mnVendedor);
		
		JMenu mnFacturas = new JMenu("Facturas");
		mnVendedor.add(mnFacturas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mnFacturas.add(mntmFacturar);
		
		JMenuItem mntmListFacturas = new JMenuItem("Lista Facturas");
		mnFacturas.add(mntmListFacturas);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnVendedor.add(mnClientes);
		
		JMenuItem mntmListClientes = new JMenuItem("Lista Clientes");
		mnClientes.add(mntmListClientes);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		if(Controladora.getLoginuser() instanceof Administrador) {
			mnAdministrador.setEnabled(true);
		}
		else {
			mnAdministrador.setEnabled(true);
		}
		menuBar.add(mnAdministrador);
		
		JMenu mnComponentes = new JMenu("Componentes");
		mnAdministrador.add(mnComponentes);
		
		JMenuItem mntmRegComponentes = new JMenuItem("Crear Componentes");
		mntmRegComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponentes frame = new RegistroComponentes();
				frame.setVisible(true);
			}
		});
		
		mnComponentes.add(mntmRegComponentes);
		
		JMenuItem mntmListComponentes = new JMenuItem("Lista Componentes");
		mntmListComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarComponentes frame = new ListarComponentes();
				frame.setVisible(true);
			}
		});

		mnComponentes.add(mntmListComponentes);
		
		JMenu mnCombos = new JMenu("Combos");
		mnAdministrador.add(mnCombos);
		
		JMenuItem mntmRegCombo = new JMenuItem("Crear Combo");
		mnCombos.add(mntmRegCombo);
		
		JMenuItem mntmListCombo = new JMenuItem("Lista Combos");
		mnCombos.add(mntmListCombo);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnAdministrador.add(mnEmpleados);
		
		JMenuItem mntmRegEmpleados = new JMenuItem("Registro Empleado");
		mntmRegEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpleado frame = new RegEmpleado();
				frame.setVisible(true);
			}
		});
		mnEmpleados.add(mntmRegEmpleados);
		
		JMenuItem mntmListEmpleado = new JMenuItem("Lista Empleados");
		mntmListEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleados frame = new ListarEmpleados();
				frame.setVisible(true);
			}
		});
		mnEmpleados.add(mntmListEmpleado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
