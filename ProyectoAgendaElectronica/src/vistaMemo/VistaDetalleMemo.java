package vistaMemo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorAgenda;
import vistaAgenda.VistaCrearCitaContactos;

public class VistaDetalleMemo extends JPanel{
	JLabel titulo = new JLabel("El titulo del memo es:");
	JLabel texto = new JLabel("Recordatorio:");
	JLabel tituloC;
	JLabel textoC;
	public JButton editar;
	public JButton cancelar;
	public VistaDetalleMemo() {
		setBackground(new Color(244, 247, 252));
		cancelar = new JButton(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoCancelar1.png")));
		cancelar.setBackground(new Color(244, 247, 252));
		editar = new JButton(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoEditar1.png")));
		editar.setBackground(new Color(244, 247, 252));
		editar.setBorder(null);
		titulo.setForeground(new Color(78,165,224));
		texto.setForeground(new Color(78,165,224));
		cancelar.setBorder(null);
		tituloC = new JLabel();
		textoC = new JLabel();
		editar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				editar.setIcon(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoEditar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				editar.setIcon(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoEditar1.png")));
			}
		});
		
		cancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoCancelar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaDetalleMemo.class.getResource("/botones/MemoCancelar1.png")));
			}
		});
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null);
		titulo.setBounds(5, 10, 180, 20);
		tituloC.setBounds(5,40,237,20);
		texto.setBounds(5, 80, 150, 20);
		textoC.setBounds(5, 110, 237, 110);
		editar.setBounds(3, 240, 90, 30);
		cancelar.setBounds(150, 240, 100, 30);
		add(titulo);
		add(tituloC);
		add(texto);
		add(textoC);
		add(editar);
		add(cancelar);
	}
	
	public void setControlador(ControladorAgenda control) {
		editar.addActionListener(control);
		cancelar.addActionListener(control);
	}
	
	public void vaciarEspacios() {
		tituloC.setText("");
		textoC.setText("");
	}
	
	public void darValores(String tituloMemo,String textoMemo) {
		tituloC.setText(tituloMemo);
		textoC.setText(textoMemo);
	}
}
