package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.*;

public class Navegacion extends JPanel {
       VistaCalendarioCompleto completo;
       VistaSemanal vistasemanal;
       VistaDiaria diaria;
       JScrollPane contenedorDePaneles;
       JButton botonmensual;
       JMenuItem semanal;
       JMenuItem dia;
       JButton botonsemanal;
	public Navegacion(Agenda agenda, CalendarioMensual calen) {
		setLayout(new BorderLayout());
		completo = new VistaCalendarioCompleto(calen,agenda);
		 contenedorDePaneles= new JScrollPane();
		vistasemanal = new VistaSemanal(2020,5,2);
		diaria = new VistaDiaria();
		JMenuBar modo = new JMenuBar();
		JMenu nombre = new JMenu("VISTA");
	    botonmensual = new JButton("Mensual");
	//JMenuItem semanal = new JMenuItem("Semanal");
		JMenuItem dia = new JMenuItem("Diaria");
		botonsemanal = new JButton("semanal");
		botonmensual.addActionListener(new AccionBoton());
		botonsemanal.addActionListener(new AccionBoton());
		dia.addActionListener(new AccionBoton());
		
		//nombre.add(semanal);
		nombre.add(dia);
		modo.add(nombre);
		
		definirPanel(completo);
		add(botonsemanal, BorderLayout.NORTH);
		add(botonmensual,BorderLayout.SOUTH);
		add(contenedorDePaneles, BorderLayout.CENTER);
		
	

	}
	public void definirPanel(JPanel panel) {
		contenedorDePaneles.setViewportView(panel);
	}
	 private class AccionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(botonmensual)) {
				definirPanel(completo);
				System.out.println("se apreto mensual");
			}else {
				if(e.getSource().equals(botonsemanal)) {
				   definirPanel(vistasemanal);	
				   System.out.println("se apreto semanal");
				}
				
			}
			
		}
		 
		 
	 }		
}
