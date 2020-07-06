package vistaAgenda;

import java.awt.*;
import javax.swing.*;
import controlador.*;

public class VistaAgenda extends JPanel {

	public JPanel panelCitas;
	public JScrollPane listaCitas ;
	public JTextField buscar = new JTextField("buscar");
	public JButton agregar = new JButton("añadir");
	public JButton mas_opciones = new JButton("mas...");
	JLabel texto = new JLabel("");
	public JButton buscarBoton;
	public JButton volver = new JButton("Volver ...");
	
	public VistaAgenda() {
		setLayout(null);
		buscarBoton = new JButton(new ImageIcon("iconos\\buscar.gif"));
		panelCitas = new JPanel();
		listaCitas = new JScrollPane(panelCitas);
		panelCitas.setLayout(new GridLayout(20,0));
		agregarElementos();
	}
	
	private void agregarElementos() {
		volver.setBounds(650, 10, 190, 20);
		buscarBoton.setBounds(510, 10, 20, 20);
		buscar.setBounds(5, 10, 500, 20);
		agregar.setBounds(645, 10, 95, 20);
		mas_opciones.setBounds(748, 10, 95, 20);
		listaCitas.setBounds(5, 35, 840, 556);
		texto.setBounds(340, 10, 200, 20);
		texto.setVisible(false);
		volver.setVisible(false);
		add(texto);
		add(buscar);
		add(agregar);
		add(mas_opciones);
		add(listaCitas);
		add(buscarBoton);
		add(volver);
	}
	// cambiar el controlador cuando este terminado
	public void setControlador(ControladorAgenda control) {
		agregar.addActionListener(control);
		mas_opciones.addActionListener(control);
		buscarBoton.addActionListener(control);
		volver.addActionListener(control);
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
		mas_opciones.setVisible(estado);
		buscarBoton.setVisible(estado);
	}
	
	public void visibilidadVolver(boolean estado) {
		volver.setVisible(estado);
		agregar.setVisible(!estado);
		mas_opciones.setVisible(!estado);
	}
	
}
