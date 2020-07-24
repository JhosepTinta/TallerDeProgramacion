package vistaAgenda;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgenda;

public class VistaCrearCitaContactos extends JPanel {
	
	public JTextField textoBusqueda;
	public JButton 	buscar;
	public JButton  cerrar;
	public JScrollPane contenedor;
	public JPanel listaContactos;
	
	public VistaCrearCitaContactos() {
		Border bordePanel = new TitledBorder(new EtchedBorder());
		setBorder(bordePanel);
		setBackground(Color.white);
		textoBusqueda = new JTextField("Busca algun contacto");
		buscar = new JButton("Buscar");
		cerrar = new JButton("x");
		cerrar.setBackground(Color.red);
		cerrar.setBorder(null);
		listaContactos = new JPanel();
		contenedor = new JScrollPane(listaContactos);
		listaContactos.setLayout(new  GridLayout(30,0));
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null); //listaContactos.setBounds(120, 435, 399, 75);
		textoBusqueda.setBounds(2, 2, 260, 20);
		buscar.setBounds(270, 2, 80, 20);
		cerrar.setBounds(353, 2, 44, 20);
		contenedor.setBounds(2,23,394,75);
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
