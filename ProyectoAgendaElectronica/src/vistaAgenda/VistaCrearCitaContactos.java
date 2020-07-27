package vistaAgenda;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgenda;
import vistaMemo.VistaMemo;

public class VistaCrearCitaContactos extends JPanel {
	
	public JTextField textoBusqueda;
	public JButton 	buscar;
	public JButton  cerrar;
	public JScrollPane contenedor;
	public JPanel listaContactos;
	
	public VistaCrearCitaContactos() {
		Border bordePanel = new TitledBorder(new EtchedBorder());
		setBorder(bordePanel);
		setBackground(new Color(174,214,241));
		textoBusqueda = new JTextField("Busca algun contacto");
		buscar = new JButton(new ImageIcon(VistaCrearCitaContactos.class.getResource("/botones/AgendaLupaContactos.png")));
		buscar.setBackground(new Color(174,214,241));
		buscar.setBorder(null);
		cerrar = new JButton("x");
		cerrar.setBackground(Color.white);
		cerrar.setBorder(bordePanel);
		listaContactos = new JPanel();
		contenedor = new JScrollPane(listaContactos);
		listaContactos.setLayout(new  GridLayout(30,0));
		listaContactos.setBackground(new Color(233, 244, 251));
		cerrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				cerrar.setBackground(Color.red);
			}
			
			public void mouseExited(MouseEvent e) {
			    cerrar.setBackground(Color.white);
			}
		});
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null); //listaContactos.setBounds(120, 435, 399, 75);
		textoBusqueda.setBounds(2, 2, 260, 20);
		buscar.setBounds(265, 3, 20, 20);
		cerrar.setBounds(357, 2, 44, 20);
		contenedor.setBounds(2,23,399,75);
		add(textoBusqueda);
		add(buscar);
		add(cerrar);
		add(contenedor);
	}
	
	public void setControlador(ControladorAgenda control) {
		buscar.addActionListener(control);
		cerrar.addActionListener(control);
		textoBusqueda.addFocusListener(control);
	}
	
	public void actualizarPanel() {
		contenedor.setViewportView(listaContactos);
	}
	
	public void restablecerValores() {
		listaContactos.removeAll();
		textoBusqueda.setText("Busca algun contacto");
	}
	
}
