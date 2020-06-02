package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Ventana extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtNumero;
	public JTextField txtCorreo;
	public JTextField txtDireccion;
	public JButton btnGuardar;
	public JButton btnVolver;

	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 393);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(72, 116, 186, 29);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(SystemColor.control);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(300,298,114,29);
		contentPane.add(btnGuardar);		
		
		txtApellido = new JTextField();
		txtApellido.setBounds(268, 116, 186, 29);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(72, 180, 138, 29);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(220, 180, 234, 29);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(72, 241, 382, 29);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(SystemColor.control);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(128, 298, 114, 26);
		contentPane.add(btnVolver);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 531, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir nuevo contacto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel.setBounds(161, 11, 245, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(82, 270, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("* Numero telf \u00F3 cel");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(82, 209, 128, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setBounds(230, 209, 125, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("* Nombre");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setBounds(82, 144, 114, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setBounds(278, 144, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Llenar los datos para crear el contacto");
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(43, 60, 335, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Los datos marcados con ( * ) son obligatorios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setBounds(72, 82, 306, 29);
		contentPane.add(lblNewLabel_7);
		
	  
	}
}
