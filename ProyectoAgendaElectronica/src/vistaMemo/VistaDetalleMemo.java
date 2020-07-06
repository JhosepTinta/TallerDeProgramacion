package vistaMemo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorAgenda;

public class VistaDetalleMemo extends JPanel{
	JLabel titulo = new JLabel("El titulo del memo es:");
	JLabel texto = new JLabel("Recordatorio:");
	JLabel tituloC;
	JLabel textoC;
	public JButton editar = new JButton("Editar");
	public JButton cancelar = new JButton("Cancelar");
	public VistaDetalleMemo() {
		tituloC = new JLabel();
		textoC = new JLabel();
		agregarElementos();
	}
	
	private void agregarElementos() {
		setLayout(null);
		titulo.setBounds(5, 10, 180, 20);
		tituloC.setBounds(5,40,237,20);
		texto.setBounds(5, 80, 150, 20);
		textoC.setBounds(5, 110, 237, 110);
		editar.setBounds(5, 245, 90, 20);
		cancelar.setBounds(150, 245, 90, 20);
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
