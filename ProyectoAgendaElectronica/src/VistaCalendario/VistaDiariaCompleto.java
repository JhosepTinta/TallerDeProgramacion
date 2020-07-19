package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
       Calendar cal;
       int dia;
       int diapos;
       int diapos2;
       int mes;
       int anio;
       Integer[] diasmes;
       int diaMaximo;
       
	public VistaDiariaCompleto(Agenda agenda,int day, int month,int year) {
		this.agenda = agenda;
		mes = month;
        anio = year;
		cal = new GregorianCalendar(anio,mes,day);
		
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
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			    next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente1.png")));//
			}
			
		});
		
		back = new JButton();
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
		
		contenedorbotones.add(back);
		contenedorbotones.add(next);
		
		definirHoy();
		
		cabecera.add(contenedorbotones,BorderLayout.EAST);
		add(cabecera,BorderLayout.NORTH);
		
	}
	public int calcularDiaMax(int mesahora) {
		int res ;
		Calendar a = new GregorianCalendar(anio, mesahora, 1);
		res = a.getActualMaximum(Calendar.DAY_OF_MONTH);
		return res;
	}
	
	public void definirHoy() {
		
		listacitashoy = agenda.buscarCitasHoy();
		vistadiaria = new VistaDiaria(listacitashoy,dia,mes,anio);
		add(vistadiaria,BorderLayout.CENTER);
	}
	
    public void definirSiguiente() {
    	diaMaximo = calcularDiaMax(mes);
    	if(mes == 11 && dia == diaMaximo) {
    		anio++;
    		mes = -1;
    	}
    	
    	if(dia == diaMaximo) {
      	  dia = 1;
      	  mes = mes + 1;
      	  
      	  listacitashoy = agenda.buscarFecha(new Fecha(dia, mes + 1, anio));
    	  siguiente = new VistaDiaria(listacitashoy,dia,mes,anio);	
      	}else {
      	  dia = dia + 1;
      	  listacitashoy = agenda.buscarFecha(new Fecha(dia, mes + 1, anio));
  	      siguiente = new VistaDiaria(listacitashoy,dia,mes,anio);
  	    
  	    }
      	
      	add(siguiente,BorderLayout.CENTER);
    	
	}
    
    public void definirAnterior() {
    	diaMaximo = calcularDiaMax(mes-1);
    	if(mes == 0 && dia == 1) {
    		anio--;
    		mes = 11;
    	}
    	if(dia == 1) {
    		dia = diaMaximo;
    		mes = mes - 1;
    		listacitashoy = agenda.buscarFecha(new Fecha(dia, mes + 1, anio));
    	    anterior = new VistaDiaria(listacitashoy,dia,mes,anio);
    		
    	}else {   	
       	    dia = dia-1;
		    listacitashoy = agenda.buscarFecha(new Fecha(dia, mes + 1, anio));
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
