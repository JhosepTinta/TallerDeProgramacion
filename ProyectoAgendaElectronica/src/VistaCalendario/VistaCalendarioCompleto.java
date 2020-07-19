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





public class VistaCalendarioCompleto extends JPanel implements ActionListener{
 
	Agenda agenda;
	VistaCalendarioMensual anterior,actual,siguiente;
	CalendarioMensual calendario;
	JButton back,next;
	int mes, anio;
	ListaSE<Cita> lista;
    public VistaCalendarioCompleto(CalendarioMensual calendario,Agenda agenda) {
       
    	this.agenda = agenda;
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
    public void addMesSiguiente() {
		if(mes == 11) {
			anio = anio + 1;
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
		if(mes == 0) {
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








