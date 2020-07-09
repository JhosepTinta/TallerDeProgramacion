package vista;

import java.awt.BorderLayout;
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

public class Panel1 extends JPanel {

	public JTextField txtNB,txtAB,txtMosN,txtMosC,txtMosD;
    public JButton btnSalir,btnIrEditar,btnEliminarC;
    
	public Panel1() {
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {

		//TITULO
		JLabel lblT = new JLabel("Contacto");
		lblT.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblT.setForeground(SystemColor.desktop);
		lblT.setBounds(15, 15, 500, 30);
		add(lblT);
		
        //ETIQUETAS
		JLabel lblNo = new JLabel("Nombre:");
		lblNo.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblNo.setForeground(new Color(51, 102, 204));
		lblNo.setBounds(140, 165, 219, 30);
		add(lblNo);
		
		JLabel lblA = new JLabel("Apellido:");
		lblA.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblA.setForeground(new Color(51, 102, 204));
		lblA.setBounds(435, 165, 200, 30);
		add(lblA);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del contacto :");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 32));
		lblNewLabel_2.setForeground(new Color(51, 102, 204));
		lblNewLabel_2.setBounds(100, 80, 350, 35);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero telf o cel:");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblNewLabel_3.setForeground(new Color(51, 102, 204));
		lblNewLabel_3.setBounds(135, 265, 200, 25);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblNewLabel_4.setForeground(new Color(51, 102, 204));
		lblNewLabel_4.setBounds(395, 265, 300, 25);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_5.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblNewLabel_5.setForeground(new Color(51, 102, 204));
		lblNewLabel_5.setBounds(135, 365, 114, 25);
		add(lblNewLabel_5);
		
		//TEXTOS
		txtNB = new JTextField();
		txtNB.setBounds(130, 200, 270, 32);
		txtNB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtNB);
		txtNB.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setBounds(430, 200, 270, 32);
		txtAB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtAB);
		txtAB.setColumns(10);
		
		txtMosN = new JTextField();
		txtMosN.setBounds(130, 300, 225, 32);
		txtMosN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtMosN);
		txtMosN.setColumns(10);
		
		txtMosC = new JTextField();
		txtMosC.setBounds(390, 300, 310, 32);
		txtMosC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtMosC);
		txtMosC.setColumns(10);
		
		txtMosD = new JTextField();
		txtMosD.setBounds(130, 400, 570, 32);
		txtMosD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(txtMosD);
		txtMosD.setColumns(10);
		
		//BOTONES
		btnIrEditar = new JButton();
		btnIrEditar.setOpaque(false);
		btnIrEditar.setContentAreaFilled(false);
		btnIrEditar.setBorderPainted(false);
		btnIrEditar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonIrEd.png")));	
		btnIrEditar.setBounds(351, 520, 130, 50);
		btnIrEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnIrEditar.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonIrEd-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnIrEditar.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonIrEd.png")));//
			}
			
		});
		add(btnIrEditar);
		
		btnEliminarC = new JButton();
		btnEliminarC.setOpaque(false);
		btnEliminarC.setContentAreaFilled(false);
		btnEliminarC.setBorderPainted(false);
		btnEliminarC.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonEliminarC.png")));
		btnEliminarC.setBounds(170, 520, 130, 50);
		btnEliminarC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEliminarC.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonElimC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnEliminarC.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonEliminarC.png")));//
			}
			
		});
		add(btnEliminarC);
		
		btnSalir = new JButton();
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonListarC.png")));
		btnSalir.setBounds(530, 520, 130, 50);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSalir.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonListaC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnSalir.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonListarC.png")));//
			}
			
		});
		add(btnSalir);
	
	}
}
