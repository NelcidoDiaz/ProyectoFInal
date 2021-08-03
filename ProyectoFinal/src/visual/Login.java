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

import source.Controladora;
import source.Empleado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
					controladora = new FileInputStream ("control.dat");
					controladoraRead = new ObjectInputStream(controladora);
					Controladora temp = (Controladora)controladoraRead.readObject();
					Controladora.setControl(temp);
					controladora.close();
					controladoraRead.close();
				} catch (FileNotFoundException e) {
					try {
						controladora2 = new  FileOutputStream("empresa.dat");
						controladoraWrite = new ObjectOutputStream(controladora2);
						Empleado temp = new Empleado("Gesbien", "Nuñez", "4023164610","admin","admin",10000);
						Controladora.getInstance().insertarEmpleado(temp);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(180, 47, 66, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("ContraseÃ±a");
		lblContrasea.setBounds(165, 135, 91, 15);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(150, 74, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 186, 124, 19);
		contentPane.add(passwordField);
	}
}
