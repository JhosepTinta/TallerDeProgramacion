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

public class VEditar extends JFrame {

	private JPanel contentPane;
	public JTextField txtNE;
	public JTextField txtAE;
	public JTextField txtNuE;
	public JTextField txtCE;
	public JTextField txtDE;
	public JButton btnEditar;
	public JButton btnVolver2;
	public JTextField txtNP;
	public JTextField txtAP;

	
	public VEditar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 393);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNE = new JTextField();
		txtNE.setBounds(72, 116, 186, 29);
		contentPane.add(txtNE);
		txtNE.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.control);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditar.setBounds(300,298,114,29);
		contentPane.add(btnEditar);		
		
		txtAE = new JTextField();
		txtAE.setBounds(268, 116, 186, 29);
		contentPane.add(txtAE);
		txtAE.setColumns(10);
		
		txtNuE = new JTextField();
		txtNuE.setBounds(72, 180, 138, 29);
		contentPane.add(txtNuE);
		txtNuE.setColumns(10);
		
		txtCE = new JTextField();
		txtCE.setBounds(220, 180, 234, 29);
		contentPane.add(txtCE);
		txtCE.setColumns(10);
		
		txtDE = new JTextField();
		txtDE.setBounds(72, 241, 382, 29);
		contentPane.add(txtDE);
		txtDE.setColumns(10);
		
		btnVolver2 = new JButton("Volver");
		btnVolver2.setBackground(SystemColor.control);
		btnVolver2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver2.setBounds(128, 298, 114, 26);
		contentPane.add(btnVolver2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 531, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Contacto");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel.setBounds(44, 11, 203, 32);
		panel.add(lblNewLabel);
		
		txtNP = new JTextField();
		txtNP.setBounds(215, 20, 128, 20);
		panel.add(txtNP);
		txtNP.setColumns(10);
		
		txtAP = new JTextField();
		txtAP.setBounds(369, 20, 128, 20);
		panel.add(txtAP);
		txtAP.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(82, 270, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("* Numero");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(82, 209, 72, 14);
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
		
		JLabel lblNewLabel_6 = new JLabel("Llenar los nuevos datos del contacto");
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

