package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Box;
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
       JButton botondiario;
    
	public Navegacion(Agenda agenda, CalendarioMensual calen) {
		
		  
		setLayout(new BorderLayout());
		completo = new VistaCalendarioCompleto(calen,agenda);
		
		contenedorDePaneles= new JScrollPane();
		contenedorDePaneles.setCursor(null);
		vistasemanal = new VistaSemanal(2020,5,2);
		diaria = new VistaDiaria(agenda);
		Box box = Box.createHorizontalBox();
	    botonmensual = new JButton("Mensual");
	    botondiario = new JButton("Diaria");
		botonmensual.addActionListener(new AccionBoton());
		botondiario.addActionListener(new AccionBoton());
		box.add(botonmensual);
		box.add(botondiario);
		
		definirPanel(completo);
		add(box, BorderLayout.NORTH);
		
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
				if(e.getSource().equals(botondiario)) {
				   definirPanel(diaria);	
				   System.out.println("se apreto semanal");
				}
				
			}
			
		}
		 
		 
	 }		
}
