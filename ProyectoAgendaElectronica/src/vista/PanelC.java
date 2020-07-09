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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Archivo;

public class PanelC extends JPanel {

	public JButton btnCrear,btnBuscar,btnVer,btnEdicion,btnBorrar;
	public JTable table;
	public JTextField busqueda;
	private JLabel txtListaDeContactos;
	public DefaultTableModel model;
	int numeroContactos=150;
	Object[][]data=new Object[numeroContactos][5];               
	Object[] fila=new Object[5];
	String titulos[]= {"Nombre","Apellido","Numero","Correo","Direccion"};
	
	public PanelC() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		//TITULO
		txtListaDeContactos = new JLabel("Lista de Contactos");
		txtListaDeContactos.setBackground(SystemColor.inactiveCaptionBorder);
		txtListaDeContactos.setFont(new Font("Agency FB", Font.BOLD, 35));
		txtListaDeContactos.setBounds(15, 15, 350, 35);
		add(txtListaDeContactos);
		
		busqueda = new JTextField();
		busqueda.setBounds(160, 75, 400, 35);
		busqueda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(busqueda);
		busqueda.setColumns(10);
		
		//TABLA DE CONTACTOS
		model=new DefaultTableModel(data,titulos);
		table=new JTable(model);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JScrollPane scroll=new JScrollPane(table);
		table.setBackground(new Color(255, 255, 255));	
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowHeight(28);
		scroll.setBounds(15, 130, 820, 380);       
		add(scroll);
		
		//BOTON

		btnCrear = new JButton();
		btnCrear.setOpaque(false);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBorderPainted(false);
		btnCrear.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonCrearC.png")));
		btnCrear.setBounds(705, 15, 130, 50);
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCrear.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonCrearC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnCrear.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonCrearC.png")));//
			}
			
		});
		add(btnCrear);
		
		btnBuscar = new JButton();
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/ContactosB1.png")));
		btnBuscar.setBounds(600, 67, 50, 50);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBuscar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/ContactosB2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnBuscar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/ContactosB1.png")));//
			}			
		});
		add(btnBuscar);
		
		btnVer = new JButton();
		btnVer.setBounds(140, 520, 250, 50);
		btnVer.setOpaque(false);
		btnVer.setContentAreaFilled(false);
		btnVer.setBorderPainted(false);
		btnVer.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC.png")));	
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnVer.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC-presionado.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnVer.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC.png")));//
			}			
		});
		add(btnVer);
	
		btnEdicion = new JButton();
		btnEdicion.setOpaque(false);
		btnEdicion.setContentAreaFilled(false);
		btnEdicion.setBorderPainted(false);
		btnEdicion.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonIrEd.png")));
		btnEdicion.setBounds(365, 520, 130, 50);
		btnEdicion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEdicion.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonIrEd-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnEdicion.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonIrEd.png")));//
			}
			
		});
		add(btnEdicion);

		btnBorrar = new JButton();
		btnBorrar.setOpaque(false);
		btnBorrar.setContentAreaFilled(false);
		btnBorrar.setBorderPainted(false);
		btnBorrar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/botonEliminarC.png")));
		btnBorrar.setBounds(530, 520, 130, 50);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBorrar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonElimC-p.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnBorrar.setIcon(new ImageIcon(Panel2.class.getResource("/botones/botonEliminarC.png")));//
			}
			
		});
		add(btnBorrar);
	}
}


