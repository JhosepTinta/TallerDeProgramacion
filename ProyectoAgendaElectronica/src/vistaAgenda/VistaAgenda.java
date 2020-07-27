package vistaAgenda;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import controlador.*;
import vista.VistaPrincipal;

public class VistaAgenda extends JPanel {

	public JPanel panelCitas;
	public JScrollPane listaCitas ;
	public JTextField buscar = new JTextField("buscar");
	public JButton agregar;
	
	JLabel texto = new JLabel("");
	public JButton buscarBoton;
	public JButton volver = new JButton("Volver ...");
	public JButton eliminar = new JButton("Eliminar");
	public JRadioButton seleccion = new JRadioButton("Seleccionar todo", false);
	
	public VistaAgenda() {
		setLayout(null);
		setBackground(Color.white);
		volver = new JButton(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaVolver1.png")));
		volver.setBackground(Color.white);
		volver.setBorder(null);
		eliminar = new JButton(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaEliminar1.png")));
		eliminar.setBackground(Color.white);
		eliminar.setBorder(null);
		buscarBoton = new JButton(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaLupa1.png")));
		buscarBoton.setBackground(Color.white);
		buscarBoton.setBorder(null);
		agregar = new JButton(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaAnadir1.png")));
		agregar.setBackground(Color.white);
		agregar.setBorder(null);
		seleccion.setBackground(Color.white);
		panelCitas = new JPanel();
		panelCitas.setBackground(new Color(242,239,255));
		listaCitas = new JScrollPane(panelCitas);
		panelCitas.setLayout(new GridLayout(20,0));
		agregar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				agregar.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaAnadir2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				agregar.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaAnadir1.png")));
			}
		});
		buscarBoton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buscarBoton.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaLupa2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				buscarBoton.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaLupa1.png")));
			}
		});
		eliminar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				eliminar.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaEliminar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				eliminar.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaEliminar1.png")));
			}
		});
		volver.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				volver.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaVolver2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				volver.setIcon(new ImageIcon(VistaAgenda.class.getResource("/botones/AgendaVolver1.png")));
			}
		});
		agregarElementos();
	}
	
	private void agregarElementos() {
		seleccion.setBounds(5, 10, 180, 20);
		eliminar.setBounds(650, 10, 95, 20);
		volver.setBounds(750, 10, 90, 20);
		buscarBoton.setBounds(510, 3, 37, 37);
		buscar.setBounds(5, 10, 500, 25);
		agregar.setBounds(730, 3, 110, 34);
		listaCitas.setBounds(4, 40, 845, 553);
		texto.setBounds(340, 10, 200, 20);
		texto.setVisible(false);
		volver.setVisible(false);
		eliminar.setVisible(false);
		seleccion.setVisible(false);
		add(texto);
		add(buscar);
		add(agregar);
		add(listaCitas);
		add(buscarBoton);
		add(volver);
		add(eliminar);
		add(seleccion);
	}
	// cambiar el controlador cuando este terminado
	public void setControlador(ControladorAgenda control) {
		agregar.addActionListener(control);
		buscarBoton.addActionListener(control);
		volver.addActionListener(control);
		eliminar.addActionListener(control);
		seleccion.addFocusListener(control);
		buscar.addFocusListener(control);
	}
	
	public void estadoTextoReferente(boolean estado) {
		texto.setVisible(estado);
	}
	
	public void editarTextoReferente(String rotulo) {
		texto.setText(rotulo);
	}
	
	public void visibilidadComponentes(boolean estado) {
		buscar.setVisible(estado);
		agregar.setVisible(estado);
		buscarBoton.setVisible(estado);
	}
	
	public void visibilidadVolver(boolean estado) {
		volver.setVisible(estado);
		agregar.setVisible(!estado);
	}
	
	public void visibilidadVolverDos(boolean estado) {
		volver.setVisible(estado);
		eliminar.setVisible(estado);
		agregar.setVisible(!estado);
		visibilidadBuscar(!estado);
		seleccion.setVisible(estado);
	}
	
	public void visibilidadBuscar(boolean estado) {
		buscar.setVisible(estado);
		buscarBoton.setVisible(estado);
		eliminar.setVisible(!estado);
		seleccion.setVisible(!estado);
	}
	
}
