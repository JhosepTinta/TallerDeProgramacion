 package vistaMemo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import controlador.ControladorAgenda;
import vistaAgenda.VistaCrearCita;

public class VistaCrearMemo extends JPanel {
	JLabel titulo = new JLabel("Añade un titulo");
	JLabel texto = new JLabel("Texto para recordar:");
	public JTextField tituloC;
	public JTextArea textoC;
	public JButton aceptar;
	public JButton cancelar;
	
	public VistaCrearMemo() {
		aceptar = new JButton(new ImageIcon(VistaMemo.class.getResource("/botones/MemoAceptar1.png")));
		aceptar.setBackground(new Color(212,233,248));
		aceptar.setBorder(null);
		cancelar = new JButton(new ImageIcon(VistaMemo.class.getResource("/botones/MemoCancelar1.png")));
		cancelar.setBackground(new Color(212,233,248));
		cancelar.setBorder(null);
		textoC = new JTextArea();
		tituloC = new JTextField();
		
		cancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaMemo.class.getResource("/botones/MemoCancelar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaMemo.class.getResource("/botones/MemoCancelar1.png")));
			}
		});
		
		aceptar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				aceptar.setIcon(new ImageIcon(VistaMemo.class.getResource("/botones/MemoAceptar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				aceptar.setIcon(new ImageIcon(VistaMemo.class.getResource("/botones/MemoAceptar1.png")));
			}
		});
		agregarElementos();
	}
	
	private void agregarElementos() {
		setBackground(new Color(212,233,248));
		setLayout(null);
		titulo.setBounds(5, 10, 100, 20);
		tituloC.setBounds(5,40,237,20);
		texto.setBounds(5, 80, 150, 20);
		textoC.setBounds(5, 110, 237, 110);
		aceptar.setBounds(5, 240, 100, 30);
		cancelar.setBounds(150, 240, 100, 30);
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
