package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JPanel;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Fecha;

public class VistaDiariaCompleto extends JPanel implements ActionListener{
       VistaDiaria vistadiaria;
       VistaDiaria anterior;
       VistaDiaria siguiente;
       JButton next,back;
       Agenda agenda;
       ListaSE listacitashoy;
       CalendarioMensual calendario;
       Calendar cal;
       int dia;
       int diapos;
       int diapos2;
       int mes;
       int anio;
       Integer[] diasmes;
       int diaMaximo;
	public VistaDiariaCompleto(Agenda agenda, CalendarioMensual calendario) {
		this.agenda= agenda;
		this.calendario = calendario;
		cal= new GregorianCalendar();
		diaMaximo= cal.getMaximum(Calendar.DAY_OF_MONTH);
        mes= cal.get(Calendar.MONTH);
        anio = cal.get(Calendar.YEAR);
        dia = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(dia);
		setLayout(new BorderLayout());
		
		JPanel cabecera = new JPanel();
		cabecera.setLayout(new BorderLayout());
		JPanel contenedorbotones = new JPanel();
		next = new JButton(">");
		back = new JButton("<");
		next.addActionListener(this);
		back.addActionListener(this);
		contenedorbotones.add(back);
		contenedorbotones.add(next);
		cabecera.add(contenedorbotones,BorderLayout.EAST);
		definirHoy();
		add(cabecera,BorderLayout.NORTH);
		
	}
	public void definirHoy() {
		
		listacitashoy = agenda.buscarCitasHoy();
		vistadiaria = new VistaDiaria(listacitashoy,dia,mes);
		add(vistadiaria,BorderLayout.CENTER);
	}
    public void definirSiguiente() {
    	if(dia == diaMaximo) {
    	  dia =1;	
    	  listacitashoy= agenda.buscarFecha(new Fecha(dia, mes, anio));
  	      siguiente = new VistaDiaria(listacitashoy,dia,mes);	
    	}else {
    	  dia= dia+1;
    	
		  listacitashoy= agenda.buscarFecha(new Fecha(dia, mes, anio));
	      siguiente = new VistaDiaria(listacitashoy,dia,mes);
	    
	    }
    	add(siguiente,BorderLayout.CENTER);
    	
	}
    public void definirAnterior() {
    	if(dia==1) {
    		dia = diaMaximo;
    		listacitashoy= agenda.buscarFecha(new Fecha(dia, mes, anio));
    	    anterior = new VistaDiaria(listacitashoy,dia,mes);
    		
    	}else {   	
       	dia = dia-1;
		listacitashoy= agenda.buscarFecha(new Fecha(dia, mes, anio));
	    anterior = new VistaDiaria(listacitashoy,dia,mes);
	    
    	}
    	add(anterior,BorderLayout.CENTER);
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		if (evento.equals(next)) {
			definirSiguiente();
			vistadiaria.setVisible(false);
			vistadiaria= siguiente; 
			System.out.println("next");
			
			
		}else {
			if(evento.equals(back)) {
				System.out.println("back");
				definirAnterior();
				vistadiaria.setVisible(false);
				vistadiaria= anterior; 
				
			}
			
		}
		
	}

}
