package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Administrador;
import source.Controladora;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField psfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream controladora;
				FileOutputStream controladora2;
				ObjectInputStream controladoraRead;
				ObjectOutputStream controladoraWrite;
				try {
					controladora = new FileInputStream ("Tienda.dat");
					controladoraRead = new ObjectInputStream(controladora);
					Controladora temp = (Controladora)controladoraRead.readObject();
					Controladora.setControl(temp);
					controladora.close();
					controladoraRead.close();
				} catch (FileNotFoundException e) {
					try {
						controladora2 = new  FileOutputStream("Tienda.dat");
						controladoraWrite = new ObjectOutputStream(controladora2);
						Administrador aux = new Administrador("Gesbien","Nuñez","402316","Admin","Admin",(float) 16582.3,"admin-1");
						Controladora.getInstance().insertarEmpleado(aux);
						controladoraWrite.writeObject(Controladora.getInstance());
						controladora2.close();
						controladoraWrite.close();
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
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(190, 60, 66, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(178, 134, 91, 15);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(150, 86, 124, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psfPassword = new JPasswordField();
		psfPassword.setBounds(150, 161, 124, 19);
		contentPane.add(psfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controladora.getInstance().confirmLogin(txtUsuario.getText(), psfPassword.getText())== true){
					Main frame = new Main();
					frame.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
				}
			}
		});
		btnLogin.setBounds(307, 227, 89, 23);
		contentPane.add(btnLogin);
	}
}
