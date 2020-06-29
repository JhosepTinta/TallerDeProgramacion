package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 extends JPanel {

	public JTextField txtNB;
	public JTextField txtAB;
	public JTextField txtMosN;
	public JTextField txtMosC;
	public JTextField txtMosD;
	public JButton btnBuscar;
    public JButton btnSalir;
    public JButton btnIrEditar;
    public JButton btnEliminarC;
    public JButton btnCrear;
    
	public Panel1() {
		setLayout(null);
		setBackground(Color.WHITE);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		txtNB = new JTextField();
		txtNB.setBounds(94, 25, 151, 25);
		add(txtNB);
		txtNB.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setBounds(252, 25, 151, 25);
		add(txtAB);
		txtAB.setColumns(10);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(411, 24, 89, 26);
		add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(32, 11, 65, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contacto");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(31, 35, 71, 22);
		add(lblNewLabel_1);
		
		txtMosN = new JTextField();
		txtMosN.setBounds(59, 152, 159, 27);
		add(txtMosN);
		txtMosN.setColumns(10);
		
		txtMosC = new JTextField();
		txtMosC.setBounds(228, 152, 246, 27);
		add(txtMosC);
		txtMosC.setColumns(10);
		
		txtMosD = new JTextField();
		txtMosD.setBounds(59, 210, 415, 27);
		add(txtMosD);
		txtMosD.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del contacto buscado:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(59, 99, 219, 22);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero telf o cel:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(69, 132, 135, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(238, 132, 135, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(69, 190, 114, 14);
		add(lblNewLabel_5);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setBounds(382, 290, 100, 30);
		add(btnSalir);
		
		btnIrEditar = new JButton("Ir a Editar");
		btnIrEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIrEditar.setBackground(SystemColor.control);
		btnIrEditar.setForeground(new Color(0, 0, 51));
		btnIrEditar.setBounds(160, 290, 99, 33);
		add(btnIrEditar);
		
		btnCrear = new JButton("Crear Contacto");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.setBounds(32, 290, 124, 32);
		add(btnCrear);
		
		btnEliminarC = new JButton("Eliminar");
		btnEliminarC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarC.setForeground(new Color(128, 0, 0));
		btnEliminarC.setBackground(SystemColor.control);
		btnEliminarC.setBounds(273, 290, 99, 33);
		add(btnEliminarC);
	}
}
