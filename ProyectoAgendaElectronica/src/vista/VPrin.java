package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class VPrin extends JFrame {

	private JPanel contentPane;
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
	
	public VPrin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 393);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 531, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNB = new JTextField();
		txtNB.setBounds(94, 25, 151, 25);
		panel.add(txtNB);
		txtNB.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setBounds(252, 25, 151, 25);
		panel.add(txtAB);
		txtAB.setColumns(10);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(411, 24, 89, 26);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 11, 65, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contacto");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(31, 35, 71, 22);
		panel.add(lblNewLabel_1);
		
		txtMosN = new JTextField();
		txtMosN.setBounds(59, 152, 159, 27);
		contentPane.add(txtMosN);
		txtMosN.setColumns(10);
		
		txtMosC = new JTextField();
		txtMosC.setBounds(228, 152, 246, 27);
		contentPane.add(txtMosC);
		txtMosC.setColumns(10);
		
		txtMosD = new JTextField();
		txtMosD.setBounds(59, 210, 415, 27);
		contentPane.add(txtMosD);
		txtMosD.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del contacto buscado:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(59, 99, 219, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero telf o cel:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(69, 132, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(238, 132, 135, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(69, 190, 114, 14);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(387, 266, 144, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setBounds(20, 26, 100, 30);
		panel_1.add(btnSalir);
		
		btnIrEditar = new JButton("Ir a Editar");
		btnIrEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIrEditar.setBackground(SystemColor.control);
		btnIrEditar.setForeground(new Color(0, 0, 51));
		btnIrEditar.setBounds(160, 290, 99, 33);
		contentPane.add(btnIrEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 266, 144, 88);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnCrear = new JButton("Crear Contacto");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.setBounds(10, 28, 124, 32);
		panel_2.add(btnCrear);
		
		btnEliminarC = new JButton("Eliminar");
		btnEliminarC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarC.setForeground(new Color(128, 0, 0));
		btnEliminarC.setBackground(SystemColor.control);
		btnEliminarC.setBounds(273, 290, 99, 33);
		contentPane.add(btnEliminarC);
	}
}
