 package vistaMemo;

import java.awt.Color;

import javax.swing.*;

import controlador.ControladorAgenda;

public class VistaCrearMemo extends JPanel {
	JLabel titulo = new JLabel("Añade un titulo");
	JLabel texto = new JLabel("Texto para recordar:");
	public JTextField tituloC;
	public JTextArea textoC;
	public JButton aceptar = new JButton("Aceptar");
	public JButton cancelar = new JButton("Cancelar");
	
	public VistaCrearMemo() {
		textoC = new JTextArea();
		tituloC = new JTextField();
		agregarElementos();
	}
	
	private void agregarElementos() {
		setBackground(new Color(193, 255, 229));
		setLayout(null);
		titulo.setBounds(5, 10, 100, 20);
		tituloC.setBounds(5,40,237,20);
		texto.setBounds(5, 80, 150, 20);
		textoC.setBounds(5, 110, 237, 110);
		aceptar.setBounds(5, 245, 90, 20);
		cancelar.setBounds(150, 245, 90, 20);
		textoC.setLineWrap(true);
		add(titulo);
		add(tituloC);
		add(texto);
		add(textoC);
		add(aceptar);
		add(cancelar);
	}
	
	public void setControlador(ControladorAgenda control) {
		aceptar.addActionListener(control);
		cancelar.addActionListener(control);
	}
	
	public void limpiarEspacios() {
		tituloC.setText("");
		textoC.setText("");
	}
	
	public void darValores(String titulo, String texto) {
		tituloC.setText(titulo);
		textoC.setText(texto);
	}
}
