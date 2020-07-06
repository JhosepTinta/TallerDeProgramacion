package vistaMemo;

import java.awt.GridLayout;

import javax.swing.*;

import controlador.*;

public class VistaMemo extends JPanel {
	
	public JPanel panelMemos;
	public JScrollPane listaMemos;
	JLabel textoMemos = new JLabel("Lista de recordatorios:");
	public JLabel textoSuperior = new JLabel();
	public JButton agregar = new JButton("Agregar");
	public JButton mas_opciones = new JButton("mas...");
	
	public VistaMemo() {
		panelMemos = new JPanel();
		listaMemos = new JScrollPane(panelMemos);
		panelMemos.setLayout(new GridLayout(5,0));
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null);
		textoMemos.setBounds(0, 0, 250, 20);
		textoSuperior.setBounds(0, 0, 190, 20);
		listaMemos.setBounds(0, 25, 250, 275);
		agregar.setBounds(90, 305, 80, 20);
		mas_opciones.setBounds(170, 305, 80, 20);
		textoSuperior.setVisible(false);
		add(listaMemos);
		add(agregar);
		add(mas_opciones);
		add(textoMemos);
		add(textoSuperior);
		
	}
	
	public void setControlador(ControladorAgenda control) {
		agregar.addActionListener(control);
		mas_opciones.addActionListener(control);
	}
	
	public void definirPanel(JPanel panel) {
		listaMemos.setViewportView(panel);
	}
	
	public void visibilidadTextoSuperior(boolean estado, String texto) {
		textoSuperior.setText(texto);
		textoMemos.setVisible(!estado);
		textoSuperior.setVisible(estado);
	}
	
	public void visibilidadComponentesInferiores(boolean estado) {
		agregar.setVisible(estado);
		mas_opciones.setVisible(estado);
	}

}
