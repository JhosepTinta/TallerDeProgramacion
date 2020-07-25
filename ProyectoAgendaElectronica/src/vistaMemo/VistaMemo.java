package vistaMemo;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.*;
import vistaAgenda.VistaAgenda;

public class VistaMemo extends JPanel {
	
	public JPanel panelMemos;
	public JScrollPane listaMemos;
	JLabel textoMemos = new JLabel("Lista de recordatorios:");
	public JLabel textoSuperior = new JLabel();
	public JButton agregar;
	public JButton eliminar = new JButton("Vaciar Lista");
	//private Color colorDeFondo = new Color(231, 245, 255);
	private Color colorDeFondo = Color.white;
	public VistaMemo() {
		setBackground(colorDeFondo);
		agregar = new JButton(new ImageIcon(VistaMemo.class.getResource("/botones/MemoAgregar.png")));
		agregar.setBackground(colorDeFondo);
		agregar.setBorder(null);
		eliminar = new JButton(new ImageIcon(VistaMemo.class.getResource("/botones/MemoVaciarLista.png")));
		eliminar.setBackground(colorDeFondo);
		eliminar.setBorder(null);
		panelMemos = new JPanel();
		listaMemos = new JScrollPane(panelMemos);
		panelMemos.setLayout(new GridLayout(5,0));
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null);
		panelMemos.setBackground(new Color(233, 244, 251));
		textoMemos.setBounds(7, 0, 250, 20);
		textoSuperior.setBounds(3, 0, 190, 20);
		listaMemos.setBounds(3, 25, 250, 275);
		agregar.setBounds(6, 300, 120, 40);
		eliminar.setBounds(131, 300, 120, 40);
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
