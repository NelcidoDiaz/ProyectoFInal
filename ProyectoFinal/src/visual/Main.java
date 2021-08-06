package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Administrador;
import source.Cliente;
import source.Controladora;
import source.OrdenCompra;

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
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private Controladora miControladora = new Controladora();
	private source.Factura miFactura =  null;
	private Cliente cliente = new Cliente("Nelcido","Diaz","123","calle13",null,12);
	
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
					control = new FileInputStream ("Tienda.dat");
					controlRead = new ObjectInputStream(control);
					Controladora temp = (Controladora)controlRead.readObject();
					Controladora.setControl(temp);
					control.close();
					controlRead.close();
				} catch (FileNotFoundException e) {
					try {
						control2 = new  FileOutputStream("Tienda.dat");
						controlWrite = new ObjectOutputStream(control2);
						controlWrite.writeObject(Controladora.getInstance());
						control2.close();
						controlWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	public void setControladora(Controladora controladora) {
		miControladora = controladora;
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
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 RegFactura factura = new RegFactura();
				  Controladora.getInstance().insertarCliente(cliente);
				 factura.setVisible(true);
				// factura.setControladora(miControladora);
			}
		});
		mntmFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		mnFacturas.add(mntmFacturar);
		
		JMenuItem mntmListFacturas = new JMenuItem("Lista Facturas");
		mntmListFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListFacturas frame = new ListFacturas();
				frame.setVisible(true);
				dispose();
			}
		});
		mnFacturas.add(mntmListFacturas);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnVendedor.add(mnClientes);
		
		JMenuItem mntmListClientes = new JMenuItem("Lista Clientes");
		mntmListClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 ListarClientes listarClientes = new ListarClientes();
				 listarClientes.setVisible(true);
			}
		});
		mntmListClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}
		});
		mnClientes.add(mntmListClientes);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		if(Controladora.getLoginuser() instanceof Administrador) {
			mnAdministrador.setEnabled(true);
		}
		else {
			mnAdministrador.setEnabled(false);
		}
		menuBar.add(mnAdministrador);
		
		JMenu mnComponentes = new JMenu("Componentes");
		mnAdministrador.add(mnComponentes);
		
		JMenuItem mntmRegComponentes = new JMenuItem("Crear Componentes");
		mntmRegComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponentes frame = new RegistroComponentes();
				frame.setControladora(miControladora);
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
		mntmRegCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCombos frame = new RegCombos();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnCombos.add(mntmRegCombo);
		
		JMenuItem mntmListCombo = new JMenuItem("Lista Combos");
		mntmListCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCombos frame = new ListCombos();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnCombos.add(mntmListCombo);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnAdministrador.add(mnEmpleados);
		
		JMenuItem mntmRegEmpleados = new JMenuItem("Registro Empleado");
		mntmRegEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mntmRegEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpleado frame = new RegEmpleado();
				frame.setControladora(miControladora);
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
		
		JButton btnAceptarPedido = new JButton("Aceptar\r\n Pedido");
		btnAceptarPedido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean aceptado = false;
				int i = 0;
				while(!aceptado && i < miFactura.getComponentes().size()) {
					if(miControladora.hacerPedido(miFactura.getComponentes().get(i).getNumeroDeSerie())) {
						OrdenCompra aux = new OrdenCompra(String.valueOf(i),miFactura.getComponentes().get(i), miFactura.getComponentes().get(i).getMarca());
						miControladora.aumentarCompInsideOrden(aux);
					}
				}
			}
		});
		btnAceptarPedido.setBounds(307, 74, 117, 40);
		contentPane.add(btnAceptarPedido);
	}
}
