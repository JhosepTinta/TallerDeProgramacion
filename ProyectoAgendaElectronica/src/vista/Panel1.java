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
		setBackground(SystemColor.inactiveCaptionBorder);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {

		JLabel lblT = new JLabel("Buscar en Contactos");
		lblT.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblT.setForeground(SystemColor.desktop);
		lblT.setBounds(15, 15, 500, 30);
		add(lblT);
		
		txtNB = new JTextField();
		txtNB.setBounds(110, 80, 250, 32);
		txtNB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtNB);
		txtNB.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setBounds(410, 80, 250, 32);
		txtAB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtAB);
		txtAB.setColumns(10);
		
		JLabel lblNo = new JLabel("Ingresar Nombre");
		lblNo.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNo.setForeground(Color.BLACK);
		lblNo.setBounds(145, 115, 219, 30);
		add(lblNo);
		
		JLabel lblA = new JLabel("Ingresar Apellido");
		lblA.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblA.setForeground(Color.BLACK);
		lblA.setBounds(445, 115, 200, 30);
		add(lblA);
		
		
		btnBuscar = new JButton();
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/ContactosB1.png")));
		btnBuscar.setBounds(700, 70, 50, 50);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBuscar.setIcon(new ImageIcon(Panel1.class.getResource("/botones/ContactosB2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnBuscar.setIcon(new ImageIcon(Panel1.class.getResource("/botones/ContactosB1.png")));//
			}
			
		});
		add(btnBuscar);
		
		txtMosN = new JTextField();
		txtMosN.setBounds(130, 300, 215, 32);
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
		
		JLabel lblNewLabel_2 = new JLabel("Datos del contacto buscado:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 29));
		lblNewLabel_2.setForeground(new Color(51, 102, 204));
		lblNewLabel_2.setBounds(100, 180, 350, 35);
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
		
		btnCrear = new JButton();
		btnCrear.setOpaque(false);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBorderPainted(false);
		btnCrear.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonCrearC.png")));	
		btnCrear.setBounds(50, 500, 130, 50);
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCrear.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonCrearC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnCrear.setIcon(new ImageIcon(Panel1.class.getResource("/botones/botonCrearC.png")));//
			}
			
		});
		add(btnCrear);
		
		
		btnIrEditar = new JButton();
		btnIrEditar.setOpaque(false);
		btnIrEditar.setContentAreaFilled(false);
		btnIrEditar.setBorderPainted(false);
		btnIrEditar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonIrEd.png")));	
		btnIrEditar.setBounds(240, 500, 130, 50);
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
		btnEliminarC.setBounds(450, 500, 130, 50);
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
		btnSalir.setBounds(640, 500, 130, 50);
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
