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

	public JButton btnG;
	public JTable table;
	private JLabel txtListaDeContactos;
	DefaultTableModel model;
	int numeroContactos=100;
	Object[][]data=new Object[numeroContactos][5];               
	Object[] fila=new Object[5];
	String titulos[]= {"Nombre","Apellido","Número","Correo","Dirección"};
	
	public PanelC() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(new BorderLayout(0, 0));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		//TITULO
		txtListaDeContactos = new JLabel("Lista de Contactos");
		txtListaDeContactos.setBackground(SystemColor.inactiveCaptionBorder);
		txtListaDeContactos.setFont(new Font("Agency FB", Font.BOLD, 35));
		add(txtListaDeContactos, BorderLayout.NORTH);
		
		//TABLA DE CONTACTOS
		model=new DefaultTableModel(data,titulos);
		table=new JTable(model);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JScrollPane scroll=new JScrollPane(table);
		table.setBackground(new Color(255, 255, 255));	
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowHeight(28);
               
		add(scroll, BorderLayout.CENTER);
		
		//BOTON
		btnG = new JButton();
		btnG.setOpaque(false);
		btnG.setContentAreaFilled(false);
		btnG.setBorderPainted(false);
		btnG.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC.png")));	
		btnG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnG.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC-presionado.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnG.setIcon(new ImageIcon(PanelC.class.getResource("/botones/botonGestionarC.png")));//
			}			
		});
		add(btnG, BorderLayout.SOUTH);
	}
}

