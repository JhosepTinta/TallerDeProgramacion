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

public class Panel2 extends JPanel {
        public JTextField txtNE;
		public JTextField txtAE;
		public JTextField txtNuE;
		public JTextField txtCE;
		public JTextField txtDE;
		public JButton btnEditar;
		public JButton btnVolver2;
		public JTextField txtNP;
		public JTextField txtAP;
		
	public Panel2() {
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		//TITULO
		JLabel lblNewLabel = new JLabel("Editar Contacto");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel.setBounds(15, 15, 500, 32);
		add(lblNewLabel);
		//TEXTO PREVIO
		txtNP = new JTextField();
		txtNP.setBounds(515, 20, 130, 30);
		txtNP.setColumns(10);
		
		txtAP = new JTextField();
		txtAP.setBounds(660, 20, 130, 30);
		txtAP.setColumns(10);
		
		//DATOS PARA ACTUALIZAR
		txtNE = new JTextField();
		txtNE.setBounds(120, 170, 285, 35);
		txtNE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtNE);
		txtNE.setColumns(10);

		txtAE = new JTextField();
		txtAE.setBounds(435, 170, 285, 35);
		txtAE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtAE);
		txtAE.setColumns(10);
		
		txtNuE = new JTextField();
		txtNuE.setBounds(120, 275, 240, 35);
		txtNuE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtNuE);
		txtNuE.setColumns(10);
		
		txtCE = new JTextField();
		txtCE.setBounds(390, 275, 330, 35);
		txtCE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtCE);
		txtCE.setColumns(10);
		
		txtDE = new JTextField();
		txtDE.setBounds(120, 380, 600, 35);
		txtDE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtDE);
		txtDE.setColumns(10);

		//TEXTOS
		JLabel lblNewLabel_6 = new JLabel("Llenar los nuevos datos del contacto");
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
		btnVolver2 = new JButton();
		btnVolver2.setOpaque(false);
		btnVolver2.setContentAreaFilled(false);
		btnVolver2.setBorderPainted(false);
		btnVolver2.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/ContactosV1.png")));
		btnVolver2.setBounds(250, 500, 130, 50);
		btnVolver2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnVolver2.setIcon(new ImageIcon(Panel2.class.getResource("/botones/ContactosV2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnVolver2.setIcon(new ImageIcon(Panel2.class.getResource("/botones/ContactosV1.png")));//
			}
			
		});
		add(btnVolver2);
		
		btnEditar = new JButton();
		btnEditar.setOpaque(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonIrEd.png")));
		btnEditar.setBounds(450,500,130,50);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEditar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonIrEd-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnEditar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonIrEd.png")));//
			}
			
		});
		add(btnEditar);	
	}
}
