package vistaMemo;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import controlador.*;

public class VistaMemo extends JPanel {
	
	public JPanel panelMemos;
	public JScrollPane listaMemos;
	JLabel textoMemos = new JLabel("Lista de recordatorios:");
	public JLabel textoSuperior = new JLabel();
	public JButton agregar = new JButton("Agregar");
	public JButton eliminar = new JButton("Vaciar Lista");
	
	public VistaMemo() {
		panelMemos = new JPanel();
		listaMemos = new JScrollPane(panelMemos);
		panelMemos.setLayout(new GridLayout(5,0));
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null);
		setBackground(new Color(167, 255, 186));
		panelMemos.setBackground(Color.white);
		textoMemos.setBounds(0, 0, 250, 20);
		textoSuperior.setBounds(0, 0, 190, 20);
		listaMemos.setBounds(0, 25, 250, 275);
		agregar.setBounds(60, 305, 80, 20);
		eliminar.setBounds(140, 305, 110, 20);
		textoSuperior.setVisible(false);
		add(listaMemos);
		add(agregar);
		add(eliminar);
		add(textoMemos);
		add(textoSuperior);
		
	}
	
	public void setControlador(ControladorAgenda control) {
		agregar.addActionListener(control);
		eliminar.addActionListener(control);
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
		eliminar.setVisible(estado);
	}

}
