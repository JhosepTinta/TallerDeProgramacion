package VistaCalendario;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import controlador.ControladorAgenda;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;
import vistaAgenda.VistaAgenda;


public class Prueba extends JFrame {

	
	public Prueba () {
		//CalendarioMensual aux = new  CalendarioMensual(1,2020);
		Agenda a = new Agenda();
		/*Cita cita1 = new Cita("dormir","a",new Reloj(11,0,0),new Reloj(14,50,0),new Fecha(16,5,2020),"asunto");
		Cita cita2 = new Cita("asunto","b",new Reloj(15,0,0),new Reloj(16,30,0),new Fecha(16,5,2020),"asunto2");
		Cita cita3 = new Cita("asunto","c",new Reloj(17,0,0),new Reloj(20,0,0),new Fecha(1,5,2020),"clases");
		Cita cita4 = new Cita("cenar","d",new Reloj(9,10,0),new Reloj(10,59,0),new Fecha(12,5,2020),"cenar");
		Cita cita5 = new Cita("golpear","e",new Reloj(15,20,0),new Reloj(16,0,0),new Fecha(13,5,2020),"dormir");
		Cita cita6 = new Cita("dormir","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(12,5,2020),"b");
		a.agregarCita(cita1);
		a.agregarCita(cita2);
		a.agregarCita(cita3);
		a.agregarCita(cita4);
		a.agregarCita(cita5);
		a.agregarCita(cita6);
		System.out.println(a.buscarFecha(new Fecha(16,5,2020)).acceder(0).getAsunto());
		ControladorAgenda prueba = new ControladorAgenda(a);
		prueba.guardarDatosAgenda();
		prueba.setAgendaControlada(null);
		System.out.println(prueba.getAgendaControlada());
		Agenda recuperada = prueba.leerDatosGuardadosAgenda();
		System.out.println(recuperada.mostrar());
		prueba.setAgendaControlada(prueba.leerDatosGuardadosAgenda());
		System.out.println(prueba.getAgendaControlada().mostrar());
		
		VistaCalendarioCompleto ac = new VistaCalendarioCompleto(aux,a);
		Navegacion na = new Navegacion(a, aux);
		setVisible(true);
		int mes =aux.getMes();
		aux.setMes(mes++);
		  add(na);*/
		VistaDiaria ab = new VistaDiaria(a);
		setSize(1200,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(ab);
		
	}
	
	
	public static void main(String[] args) {
		Prueba prueba1 = new Prueba();
		//VistaAgenda vista= new VistaAgenda() ;
		
		
	}

}
