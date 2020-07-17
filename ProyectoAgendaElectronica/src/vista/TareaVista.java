package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTarea;
import modelo.Agenda;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;

public class TareaVista extends JPanel {
	private JTextField texto1;
	public DefaultListModel DLM = new DefaultListModel();

	public JList list;
	public JScrollPane scrollPane;
	public JButton actualizar;
	public JLabel texto;
	public JLabel tex;
	public JButton eliminar;
	public JButton eliminartodo;
	
	public TareaVista() {
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(181, 0, 753, 561);
		setLayout(null);
		
		list = new JList();
		scrollPane = new JScrollPane();
		
		actualizar = new JButton();
		actualizar.setOpaque(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setBorderPainted(false);
		actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar1.png")));
		
		texto = new JLabel("TAREAS PENDIENTES");
		tex = new JLabel("Ingresar Tarea : ");
		tex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		eliminar = new JButton();
		eliminar.setOpaque(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorderPainted(false);
		eliminar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada1.png")));
		
		eliminartodo = new JButton();
		eliminartodo.setOpaque(false);
		eliminartodo.setContentAreaFilled(false);
		eliminartodo.setBorderPainted(false);
		eliminartodo.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas1.png")));
		
		texto.setFont(new Font("Agency FB", Font.BOLD, 35));
		texto1 = new JTextField();
		texto1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto1.setColumns(10);
	
		scrollPane.setViewportView(list);
		AgregarElementos();
		
	}
	
	private void AgregarElementos()
	{
		scrollPane.setBounds(70, 210, 480, 320);
		texto.setBounds(15, 15, 278, 66);
		tex.setBounds(70, 90, 250, 35);
		actualizar.setBounds(400, 117, 200, 50);
		actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar1.png")));//
			}
			
		});
		eliminar.setBounds(580, 300, 200, 50);
		eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				eliminar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				eliminar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada1.png")));//
			}
			
		});
		eliminartodo.setBounds(580, 400, 200, 50);
		eliminartodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				eliminartodo.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				eliminartodo.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas1.png")));//
			}
			
		});
		texto1.setBounds(70, 120, 300, 45);
		add(scrollPane);
		add(texto);
		add(actualizar);
		add(eliminar);
		add(eliminartodo);
		add(texto1);
		add(tex);
	}
	
	public void setControlador(ControladorTarea entrar)
	{
		actualizar.addActionListener(entrar);
		eliminar.addActionListener(entrar);
		eliminartodo.addActionListener(entrar);
	}


}



