package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
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
		setBackground(SystemColor.inactiveCaptionBorder);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		
		//TITULO
		JLabel lblNewLabel = new JLabel("Crear Contacto");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel.setBounds(15, 15, 500, 32);
		add(lblNewLabel);
		
		//DATOS
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 170, 285, 35);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(435, 170, 285, 35);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(120, 275, 240, 35);
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(390, 275, 330, 35);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(120, 380, 600, 35);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtDireccion);
		txtDireccion.setColumns(10);

		//TEXTOS
		JLabel lblNewLabel_6 = new JLabel("Llenar los datos del contacto");
		lblNewLabel_6.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblNewLabel_6.setForeground(new Color(51, 102, 204));
		lblNewLabel_6.setBounds(60, 75, 350, 35);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Los datos marcados con   *   son obligatorios");
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNewLabel_7.setForeground(new Color(51, 102, 204));
		lblNewLabel_7.setBounds(75, 105, 350, 35);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("* Nombre");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(125, 210, 114, 17);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(440, 210, 92, 17);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("* Numero");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(125, 315, 72, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(395, 315, 250, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(125, 420, 84, 14);
		add(lblNewLabel_1);
		
		//BOTONES
		btnVolver = new JButton();
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/ContactosV1.png")));
		btnVolver.setBounds(250, 500, 130, 50);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(Panel3.class.getResource("/botones/ContactosV2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(Panel3.class.getResource("/botones/ContactosV1.png")));//
			}
			
		});
		add(btnVolver);
		
		btnGuardar = new JButton();
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonCrearC.png")));
		btnGuardar.setBounds(450,500,130,50);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGuardar.setIcon(new ImageIcon(Panel3.class.getResource("/botones/botonCrearC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnGuardar.setIcon(new ImageIcon(Panel3.class.getResource("/botones/botonCrearC.png")));//
			}
			
		});
		add(btnGuardar);	
	}
}
