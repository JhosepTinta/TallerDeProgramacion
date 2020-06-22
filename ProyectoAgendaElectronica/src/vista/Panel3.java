package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel3 extends JPanel{

	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtNumero;
	public JTextField txtCorreo;
	public JTextField txtDireccion;
	public JButton btnGuardar;
	public JButton btnVolver;
	public Panel3() {
		setLayout(null);
		setBackground(Color.GREEN);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		txtNombre = new JTextField();
		txtNombre.setBounds(72, 116, 186, 29);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(SystemColor.control);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(300,298,114,29);
		add(btnGuardar);		
		
		txtApellido = new JTextField();
		txtApellido.setBounds(268, 116, 186, 29);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(72, 180, 138, 29);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(220, 180, 234, 29);
		add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(72, 241, 382, 29);
		add(txtDireccion);
		txtDireccion.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(SystemColor.control);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(128, 298, 114, 26);
		add(btnVolver);

		JLabel lblNewLabel = new JLabel("A\u00F1adir nuevo contacto");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel.setBounds(161, 11, 245, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(82, 270, 84, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("* Numero telf \u00F3 cel");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(82, 209, 128, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setBounds(230, 209, 125, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("* Nombre");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setBounds(82, 144, 114, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setBounds(278, 144, 92, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Llenar los datos para crear el contacto");
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(43, 60, 335, 26);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Los datos marcados con ( * ) son obligatorios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setBounds(72, 82, 306, 29);
		add(lblNewLabel_7);
	}
}
