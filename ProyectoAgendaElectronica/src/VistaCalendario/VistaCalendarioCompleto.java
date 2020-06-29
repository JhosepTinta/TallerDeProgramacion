package VistaCalendario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Fecha;





public class VistaCalendarioCompleto extends JPanel implements ActionListener{
 
	Agenda agenda;
	VistaCalendarioMensual anterior;
	VistaCalendarioMensual actual;
	VistaCalendarioMensual siguiente;
	CalendarioMensual calendario;
	JButton back,next;
	int mes;
	int anio;
	
    public VistaCalendarioCompleto(CalendarioMensual calendario,Agenda agenda) {
       
    	this.agenda = agenda;
    	this.calendario = calendario;
    	mes= calendario.getMes();
    	anio= calendario.getAnio();
		setLayout(new BorderLayout());
	   
	    JPanel botones =new JPanel();
	    JPanel cabecera = new JPanel();
	    cabecera.setLayout(new BorderLayout());
	    cabecera.add(botones, BorderLayout.EAST);
		next = new JButton(">");
		back = new JButton("<") ;
		next.addActionListener(this);
		back.addActionListener(this);
		botones.add(back);
		
		botones.add(next);
		addMesActual();
		add(cabecera,BorderLayout.NORTH);
		
		
		
		
	}
    public void addMesSiguiente() {
		if(mes == 12) {
			anio = anio+1;
			mes = 0;
			
			CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			
			siguiente = new VistaCalendarioMensual(nuevo,agenda);
		 } else {
			 mes++;
			 CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			
			siguiente = new VistaCalendarioMensual(nuevo, agenda);
	     }
		add(siguiente,BorderLayout.CENTER);
	
	}
    
    public void addMesActual() {
		actual = new VistaCalendarioMensual(calendario,agenda);
		
		add(actual,BorderLayout.CENTER);
		
	}
    public void addMesAnterior() {
		if(mes == -1) {
			anio--;
			mes = 11;
			CalendarioMensual nuevo = new CalendarioMensual(mes--,anio);
			anterior = new VistaCalendarioMensual(nuevo,agenda);
		}else{
			mes--;
			CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			anterior = new VistaCalendarioMensual(nuevo,agenda);
		}
		add(anterior,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a.equals(next)) {
			System.out.println("ha sido presionado next");
			actual.setVisible(false);
			addMesSiguiente();
			actual = siguiente;
		
		}else {
			if(a.equals(back) ){
				actual.setVisible(false);
				addMesAnterior();
				actual = anterior;
			 		}else {
			 			
			 			
			 		}
			
			
		}
		
	}
   
    	
    	
    
}








