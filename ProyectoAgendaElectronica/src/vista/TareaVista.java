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
//	private JTextField texto1;
	public DefaultListModel DLM = new DefaultListModel();

	public JList list;
	public JScrollPane scrollPane;
	public JButton actualizar;
	public JLabel texto;
	
//	public JLabel tex;
	public JButton realizada;
	public JButton realizadatodos;
	
//NUEVOS BOTONES
	public JList list1;
	public JScrollPane scrollPane_1;
	public JButton marcar;
    public JButton marcar1;
    public JLabel recordatorio;

	
	public TareaVista() {
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(181, 0, 753, 561);
		setLayout(null);
		
		list = new JList();
		list.setSelectionBackground(Color.orange);
		scrollPane = new JScrollPane();
		
		actualizar = new JButton();
		actualizar.setOpaque(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setBorderPainted(false);
		actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar1.png")));
		
		texto = new JLabel("TAREAS PENDIENTES");
	//	tex = new JLabel("Ingresar Tarea : ");
	//	tex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		realizada = new JButton();
		realizada.setOpaque(false);
		realizada.setContentAreaFilled(false);
		realizada.setBorderPainted(false);
		realizada.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada1.png")));
		
		realizadatodos = new JButton();
		realizadatodos.setOpaque(false);
		realizadatodos.setContentAreaFilled(false);
		realizadatodos.setBorderPainted(false);
		realizadatodos.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas1.png")));
		
		texto.setFont(new Font("Agency FB", Font.BOLD, 35));
		
		
//NUEVOS BOTONES	
		marcar = new JButton("SELECCIONE DE LA CITA");
		marcar1 = new JButton("MARCAR");
		recordatorio = new JLabel("LISTA DE RECORDATORIO DE LA CITA");

		scrollPane_1 = new JScrollPane();
		
		list1 = new JList();
		scrollPane_1.setViewportView(list1);
		
		list1.setSelectionBackground(Color.orange);
//NUEVOS BOTONES
		
		scrollPane.setViewportView(list);
		AgregarElementos();
		
		
		
	}
	
	private void AgregarElementos()
	{
		scrollPane.setBounds(70, 100, 480, 350);
		texto.setBounds(15, 15, 278, 66);
	//	tex.setBounds(70, 90, 250, 35);
		actualizar.setBounds(580, 117, 200, 50);
		actualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				actualizar.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesActualizar1.png")));//
			}
			
		});
		realizada.setBounds(580, 300, 200, 50);
		realizada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				realizada.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				realizada.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendientesRealizada1.png")));//
			}
			
		});
		realizadatodos.setBounds(580, 400, 200, 50);
		realizadatodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				realizadatodos.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				realizadatodos.setIcon(new ImageIcon(TareaVista.class.getResource("/botones/PendintesTodas1.png")));//
			}
			
		});
	//NUEVOS BOTONES 	
		marcar.setBounds(580, 490, 200, 50);
		marcar1.setBounds(580, 550, 200, 30);
		recordatorio.setBounds(20, 440, 300, 50);
		scrollPane_1.setBounds(70, 480, 480, 100);
   //NUEVOS BOTONES
		
		add(scrollPane);
		add(texto);
		add(actualizar);
		add(realizada);
		add(realizadatodos);
	//NUEVOS BOTONES
		add(marcar);
		add(marcar1);
		add(scrollPane_1);
		add(recordatorio);
    //NUEVOS BOTONES
		
	}
	
	public void setControlador(ControladorTarea entrar)
	{
		actualizar.addActionListener(entrar);
		realizada.addActionListener(entrar);
		realizadatodos.addActionListener(entrar);
		marcar.addActionListener(entrar);
		marcar1.addActionListener(entrar);
	}


}
