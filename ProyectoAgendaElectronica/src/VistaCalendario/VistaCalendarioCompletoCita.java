package VistaCalendario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Cita;
import modelo.Fecha;
import vista.VistaPrincipal;
import vistaAgenda.VistaCrearCita;





public class VistaCalendarioCompletoCita extends JPanel implements ActionListener{
 
	
	VistaCalendarioCita anterior,actual,siguiente;
	CalendarioMensual calendario;
	JButton back,next;
	int mes, anio;
	VistaCrearCita crearcita;
    public VistaCalendarioCompletoCita(CalendarioMensual calendario, VistaCrearCita vistacrear) {
       
    	this.crearcita = vistacrear;
    	this.calendario = calendario;
    	mes = calendario.getMes();
    	anio = calendario.getAnio();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
	    JPanel botones = new JPanel();
	    botones.setBackground(Color.WHITE);
	    JPanel cabecera = new JPanel();
	    cabecera.setBackground(Color.WHITE);
	    cabecera.setLayout(new BorderLayout());
	    cabecera.add(botones, BorderLayout.EAST);
	    
	    
		next = new JButton();
		next.setBackground(Color.WHITE);
		next.setBorder(null);
		next.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioSiguiente1.png")));
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			    next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente1.png")));//
			}
			
		});
		
		back = new JButton() ;
		back.setBackground(Color.WHITE);
		back.setBorder(null);
		back.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioAnterior1.png")));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				back.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioAnterior2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				back.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioAnterior1.png")));//
			}
			
		});
		
		next.addActionListener(this);
		back.addActionListener(this);
		
		botones.add(back);
		botones.add(next);
		
		addMesActual();
		add(cabecera,BorderLayout.NORTH);
	
	}
    public VistaCalendarioCita getActual() {
    	return actual;
    }
    public void addMesSiguiente() {
		if(mes == 11) {
			anio = anio + 1;
			mes = 0;
			
			CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			siguiente = new VistaCalendarioCita(nuevo,crearcita);
		 
		} else {
			 mes++;
		    CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			siguiente = new VistaCalendarioCita(nuevo,crearcita);
	      }
		
		add(siguiente,BorderLayout.CENTER);
	
	}
    
    public void addMesActual() {
		actual = new VistaCalendarioCita(calendario,crearcita);
	    add(actual,BorderLayout.CENTER);
		
	}
    
    public void addMesAnterior() {
		if(mes == 0) {
			anio--;
			mes = 11;
			CalendarioMensual nuevo = new CalendarioMensual(mes--,anio);
			anterior = new VistaCalendarioCita(nuevo,crearcita);
		}else{
			mes--;
			CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
			anterior = new VistaCalendarioCita(nuevo,crearcita);
		}
		add(anterior,BorderLayout.CENTER);
	}
    public String getFechaMarcada() {
    	String res;
    	res = actual.diaapretado;
    	return res;
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a.equals(next)) {
			
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








