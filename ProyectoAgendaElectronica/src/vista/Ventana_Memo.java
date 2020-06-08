package Modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;


public class Ventana_Memo extends JFrame implements InterfazVista{
	
	private JMenuBar barra; //barra para el menu
	private JMenu Opciones; 
	private JMenu Herramientas; 
	private JMenuItem Guardar,Nuevo,Editar;// items de opciones
	
	 
	//ponemos el menu en la ventana
	private JPanel panel_Principal; //dentro de este panel ponemos todo los paneles necesarios
	private JPanel panelBarra; 
	private JPanel panelAreatxt;
	
	private JTextArea areaDetxt;
	


	public Ventana_Memo() {
	  super("MEMO");
		
	panelBarra=new JPanel();
	panel_Principal=new JPanel();
	panelAreatxt=new JPanel();
	panel_Principal.setLayout(new BorderLayout());
	
	areaDetxt=new JTextArea(17,55);
	panelAreatxt.add(areaDetxt);
	panelAreatxt.setBackground(Color.black);
	panel_Principal.add(panelAreatxt, BorderLayout.CENTER);
		
	 barra=new JMenuBar();
	 Opciones=new JMenu("opciones");
	 Herramientas=new JMenu("Herramientas");
	 
	 Guardar=new JMenuItem("Guardar");
	 Nuevo=new JMenuItem("Nuevo");
	 Editar=new JMenuItem("Editar");
	 
	 barra.add(Opciones); barra.add(Herramientas);
	 Opciones.add(Guardar); Opciones.add(Nuevo); Opciones.add(Editar);
	 panelBarra.add(barra);
	 panelBarra.setBackground(Color.black);
	 
	 panel_Principal.add(panelBarra, BorderLayout.NORTH);
	 
     add(panel_Principal);
     getContentPane().add(panel_Principal);

		
    }
	
	

	

	@Override
	public void setControlador(Control_Memo c) {
		Editar.addActionListener(c);
		Nuevo.addActionListener(c);
		Guardar.addActionListener(c);
		
	}
	
	

	@Override
	public void arranca() {
		pack();// coloca los componentes
		//setLocationRelativeTo(null);// centra la ventana en la pantalla
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		int alturaPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		setSize(anchoPantalla/2,alturaPantalla/2);
		setLocation(anchoPantalla/4,alturaPantalla/4);
		//setBounds(600,350,600,300);
		setVisible(true);
		
	}

	

	@Override
	public String getTexto() {
		
		return areaDetxt.getText();
	}
	public void setTexto(String mostrar) {
		
	areaDetxt.setText(mostrar);
		
	}

	@Override
	public void limpiartexto() {
		areaDetxt.setText("");
		
	}
	
	
	
}
