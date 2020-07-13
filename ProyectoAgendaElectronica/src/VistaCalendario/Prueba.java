
package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorAgenda;
import lineales.ListaSE;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;

import vistaAgenda.VistaAgenda;
import vistaAgenda.VistaDetalleCitaVentana;


public class Prueba extends JFrame implements ActionListener{
        VistaAgenda va;
        Navegacion nave;
	    JButton botoncalendario, botonagenda;
	public Prueba () {
		//CalendarioMensual aux = new  CalendarioMensual(1,2020);
		/*Agenda a = new Agenda();
		Cita cita1 = new Cita("dormir","a",new Reloj(11,0,0),new Reloj(14,50,0),new Fecha(16,5,2020),"asunto");
		Cita cita2 = new Cita("asunto","b",new Reloj(15,0,0),new Reloj(16,30,0),new Fecha(16,5,2020),"asunto2");
		Cita cita3 = new Cita("asunto","c",new Reloj(17,0,0),new Reloj(20,0,0),new Fecha(1,5,2020),"clases");
		Cita cita4 = new Cita("cenar","d",new Reloj(9,10,0),new Reloj(10,59,0),new Fecha(12,5,2020),"cenar");
		Cita cita5 = new Cita("golpear","e",new Reloj(15,20,0),new Reloj(16,0,0),new Fecha(13,5,2020),"dormir");
		Cita cita6 = new Cita("dormir","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(12,5,2020),"b");
		Cita cita7 = new Cita("nvkfnvkfkvnfnvkfnjvnfjb","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(12,6,2020),"b");
		a.agregarCita(cita1);
		a.agregarCita(cita2);
		a.agregarCita(cita3);
		a.agregarCita(cita4);
		a.agregarCita(cita5);
		a.agregarCita(cita6);
		a.agregarCita(cita7);
	
		System.out.println(a.buscarFecha(new Fecha(16,5,2020)).acceder(0).getAsunto());
		ControladorAgenda prueba = new ControladorAgenda(a,new VistaAgenda());
		prueba.guardarDatosAgenda();
		prueba.setAgendaControlada(null);
		System.out.println(prueba.getAgendaControlada());
		Agenda recuperada = prueba.leerDatosGuardadosAgenda();
		System.out.println(recuperada.mostrar());
		prueba.setAgendaControlada(prueba.leerDatosGuardadosAgenda());
		System.out.println(prueba.getAgendaControlada().mostrar());
		ListaSE<Cita> cit= a.buscarFecha(new Fecha(16, 5, 2020));
		System.out.println(cit.longitud());
		//VistaCalendarioCompleto ac = new VistaCalendarioCompleto(new CalendarioMensual(6,2020),a);
		VistaDiaria diaria = new VistaDiaria(cit, 16, 5);
		
		*/  
		//VistaDiaria ab = new VistaDiaria(a);
		
		JPanel ventana = new JPanel();
		ventana.setLayout(new BorderLayout());
		
		JPanel cabecera = new JPanel();
		botoncalendario = new JButton("Calendario");
		botonagenda = new JButton("Agenda");
		
		botoncalendario.addActionListener(this);
		botonagenda.addActionListener(this);
		
		cabecera.add(botoncalendario);
		cabecera.add(botonagenda);
		
		Agenda a = new Agenda();
	    va = new VistaAgenda();
		ControladorAgenda ca = new ControladorAgenda(a,va);
		va.setControlador(ca);
		
		CalendarioMensual mensual = new CalendarioMensual(5, 2020);
	
	    nave = new Navegacion(a, mensual);
	  //  VistaCalendarioCompletoCita citacalen= new VistaCalendarioCompletoCita(new CalendarioMensual(7, 2020));
		setSize(350,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(va, BorderLayout.CENTER);
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		Prueba prueba1 = new Prueba();
	//	VentanaCalendarioCita ventanacalendariocita = new VentanaCalendarioCita();
		//VistaAgenda vista= new VistaAgenda() ;
		//Cita cita1 = new Cita("dormir","a",new Reloj(11,0,0),new Reloj(14,50,0),new Fecha(16,5,2020),"asunto");
		//VistaDetalleCitaVentana a = new VistaDetalleCitaVentana(cita1, Color.BLUE, Color.BLUE);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botoncalendario)) {
			add(nave, BorderLayout.CENTER);	
			nave.setVisible(true);
			va.setVisible(false);
		}else {
			if(e.getSource().equals(botonagenda)) {
				add(va, BorderLayout.CENTER);
				va.setVisible(true);
				nave.setVisible(false);
			}
			
		}
		
	}

}

