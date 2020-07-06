package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Fecha;
import vista.VistaPrincipal;

public class VistaDiariaCompleto extends JPanel implements ActionListener{
       
	   VistaDiaria vistadiaria,anterior, siguiente;
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
		this.agenda = agenda;
		this.calendario = calendario;
		
		cal = new GregorianCalendar();
		diaMaximo = cal.getMaximum(Calendar.DAY_OF_MONTH);
        mes = calendario.getMes();
        anio = calendario.getAnio();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        
		setLayout(new BorderLayout());
		
		JPanel cabecera = new JPanel();
		cabecera.setBackground(Color.WHITE);
		cabecera.setLayout(new BorderLayout());
		
		JPanel contenedorbotones = new JPanel();
		contenedorbotones.setBackground(Color.WHITE);
		
		next = new JButton();
		next.setBackground(Color.WHITE);
		next.setBorder(null);
		next.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioSiguiente1.png")));
		
		back = new JButton();
		back.setBackground(Color.WHITE);
		back.setBorder(null);
		back.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioAnterior1.png")));
		
		next.addActionListener(this);
		back.addActionListener(this);
		
		contenedorbotones.add(back);
		contenedorbotones.add(next);
		
		definirHoy();
		
		cabecera.add(contenedorbotones,BorderLayout.EAST);
		add(cabecera,BorderLayout.NORTH);
		
	}
	
	public void definirHoy() {
		
		listacitashoy = agenda.buscarCitasHoy();
		vistadiaria = new VistaDiaria(listacitashoy,dia,mes,anio);
		add(vistadiaria,BorderLayout.CENTER);
	}
	
    public void definirSiguiente() {
    	
    	if(dia == diaMaximo) {
    	  dia = 1;	
    	  listacitashoy = agenda.buscarFecha(new Fecha(dia, mes+1, anio));
  	      siguiente = new VistaDiaria(listacitashoy,dia,mes,anio);	
    	}else {
    	  dia = dia + 1;
    	  listacitashoy = agenda.buscarFecha(new Fecha(dia, mes+1, anio));
	      siguiente = new VistaDiaria(listacitashoy,dia,mes,anio);
	    
	    }
    	
    	add(siguiente,BorderLayout.CENTER);
    	
	}
    
    public void definirAnterior() {
    	
    	if(dia == 1) {
    		dia = diaMaximo;
    		listacitashoy = agenda.buscarFecha(new Fecha(dia, mes+1, anio));
    	    anterior = new VistaDiaria(listacitashoy,dia,mes,anio);
    		
    	}else {   	
       	    dia = dia - 1;
		    listacitashoy = agenda.buscarFecha(new Fecha(dia, mes+1, anio));
	        anterior = new VistaDiaria(listacitashoy,dia,mes,anio);
	    
    	}
    	add(anterior,BorderLayout.CENTER);
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if (evento.equals(next)) {
			definirSiguiente();
			vistadiaria.setVisible(false);
			vistadiaria = siguiente; 
		}else {
			if(evento.equals(back)) {
				definirAnterior();
				vistadiaria.setVisible(false);
				vistadiaria = anterior; 
				
			}
			
		}
		
	}

}
