package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTarea;
import modelo.Agenda;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;

public class TareaVista extends JPanel {
	private JTextField texto1;
	public DefaultListModel DLM = new DefaultListModel();

	public JList list;
	public JScrollPane scrollPane;
	public JButton actualizar;
	public JLabel texto;
	public JButton eliminar;
	public JButton eliminartodo;
	
	public TareaVista() {
		
		setBackground(Color.WHITE);
		setBounds(181, 0, 753, 561);
		setLayout(null);
		
		list = new JList();
		scrollPane = new JScrollPane();
		actualizar = new JButton("ACTUALIZAR");
		texto = new JLabel("TAREAS PENDIENTES");
		eliminar = new JButton("ELIMINAR");
		eliminartodo = new JButton("ELIMINAR TODO");
		
		texto.setFont(new Font("Arial Black", Font.PLAIN, 18));

		texto1 = new JTextField();
		texto1.setColumns(10);
		
	
		scrollPane.setViewportView(list);
		AgregarElementos();
		
	}
	
	private void AgregarElementos()
	{
		scrollPane.setBounds(298, 69, 426, 424);
		texto.setBounds(10, 11, 278, 66);
		actualizar.setBounds(86, 126, 132, 40);
		eliminar.setBounds(104, 231, 89, 23);
		eliminartodo.setBounds(79, 337, 139, 23);
		texto1.setBounds(68, 434, 188, 23);
		add(scrollPane);
		add(texto);
		add(actualizar);
		add(eliminar);
		add(eliminartodo);
		add(texto1);
	}
	
	public void setControlador(ControladorTarea entrar)
	{
		actualizar.addActionListener(entrar);
		eliminar.addActionListener(entrar);
		eliminartodo.addActionListener(entrar);
	}


}

	



