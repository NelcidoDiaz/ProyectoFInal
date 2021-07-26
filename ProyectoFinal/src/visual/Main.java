package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.util.ArrayList;

import source.Cliente;
import source.Factura;
import source.Cliente;
import source.Empleado;
import source.Componente;
import source.Combo;

public class Main extends JFrame {
	private static ArrayList<Componente> misComponentes;
	private static ArrayList<Cliente> misClientes;
	private static ArrayList<Factura> misFacturas;
	private static ArrayList<Empleado> misEmpleados;
	private static ArrayList <Combo> misCombos;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void getEmpleado() {

	}

	public static void getClientes() {

	}

	public static void getComponentes() {

	}

	public static void getFactura() {

	}

	public static void setEmpleado(ArrayList<Empleado> __misEmpleados) {

	}

	public static void setClientes(ArrayList<Cliente> __misClientes) {

	}

	public static void setComponentes(ArrayList<Componente> __misComponentes) {

	}

	public static void setFactura(ArrayList<Factura> __misFacturas) {

	}

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

		JMenu mnPrimerItem = new JMenu("Facturar");
		mnVendedor.add(mnPrimerItem);

		JMenu mnClientes = new JMenu("Clientes");
		mnVendedor.add(mnClientes);

		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);

		JMenu mnPedidos = new JMenu("Pedidos");
		mnAdministrador.add(mnPedidos);

		JMenu mnHacerPedido = new JMenu("Hacer Pedido");
		mnPedidos.add(mnHacerPedido);

		JMenu mnVerPedidos = new JMenu("Ver Pedidos");
		mnPedidos.add(mnVerPedidos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
