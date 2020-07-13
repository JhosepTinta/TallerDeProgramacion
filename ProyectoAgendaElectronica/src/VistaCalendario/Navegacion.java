package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lineales.ListaSE;
import modelo.*;
import vista.VistaPrincipal;

public class Navegacion extends JPanel {
       
	   VistaCalendarioCompleto completo;
       VistaSemanal vistasemanal;
       public VistaDiariaCompleto diaria;
       JScrollPane contenedorDePaneles;
       JButton botonmensual,botondiario;
       ListaSE<Cita> citashoy;
	   Calendar calendar;
	   int day, mes, year;
	   Agenda agenda;
	   CalendarioMensual calen;
   
	   public Navegacion(Agenda agenda, CalendarioMensual calen) {
		this.agenda = agenda;
		this.calen = calen;
		setLayout(new BorderLayout());
		completo = new VistaCalendarioCompleto(calen,agenda);
		calendar = new GregorianCalendar();
		day = calendar.get(Calendar.DAY_OF_MONTH);
		mes = calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);
		contenedorDePaneles= new JScrollPane();
		contenedorDePaneles.setBorder(null);
		diaria = new VistaDiariaCompleto(agenda,day,mes,year);
		Box box = Box.createHorizontalBox();
		
	    botonmensual = new JButton();
	    botonmensual.setBorder(null);
	    botonmensual.setBackground(Color.WHITE);
	    botonmensual.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioMensual1.png")));
	    
	    botondiario = new JButton();
	    botondiario.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioDiaria1.png")));
	    botondiario.setBorder(null);
	    botondiario.setBackground(Color.WHITE);
		
	    botonmensual.addActionListener(new AccionBoton());
		botondiario.addActionListener(new AccionBoton());
		setBackground(Color.WHITE);
		box.add(botonmensual);
		box.add(botondiario);
		
		contenedorDePaneles.setAutoscrolls(false);
		definirPanel(completo);
		add(box, BorderLayout.NORTH);
		
		add(contenedorDePaneles, BorderLayout.CENTER);
		
	

	}
	public void arrancarDia() {
		
		diaria = new VistaDiariaCompleto(agenda, day, mes, year);
	}   
    
   
	public void definirPanel(JPanel panel) {
		contenedorDePaneles.setViewportView(panel);
	}
	 private class AccionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(botonmensual)) {
				definirPanel(completo);
			}else {
				if(e.getSource().equals(botondiario)) {
				   definirPanel(diaria);	
				}
				
			}
			
		}
		 
		 
	 }		
}
