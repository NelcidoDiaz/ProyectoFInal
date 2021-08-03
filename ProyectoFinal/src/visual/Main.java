package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Controladora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream control;
				FileOutputStream control2;
				ObjectInputStream controlRead;
				ObjectOutputStream controlWrite;
				try {
					control = new FileInputStream("Controladora.dat");
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
		menuBar.add(mnAdministrador);
		
		JMenu mnComponentes = new JMenu("Componentes");
		mnAdministrador.add(mnComponentes);
		
		JMenuItem mntmRegComponentes = new JMenuItem("Crear Componentes");
		mntmRegComponentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroComponentes regComp = new RegistroComponentes();
				regComp.setVisible(true);
			}
		});
		mnComponentes.add(mntmRegComponentes);
		
		JMenuItem mntmListComponentes = new JMenuItem("Lista Componentes");
		mntmListComponentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarComponentes listcomp = new ListarComponentes();
				listcomp.setVisible(true);
			}
		});
		mnComponentes.add(mntmListComponentes);
		
		JMenu mnCombos = new JMenu("Combos");
		mnAdministrador.add(mnCombos);
		
		JMenuItem mntmRegCombo = new JMenuItem("Crear Combo");
		mnCombos.add(mntmRegCombo);
		
		JMenuItem mntmListCombo = new JMenuItem("Lista Combos");
		mnCombos.add(mntmListCombo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
