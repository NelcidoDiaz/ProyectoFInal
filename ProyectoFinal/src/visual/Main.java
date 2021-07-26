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
