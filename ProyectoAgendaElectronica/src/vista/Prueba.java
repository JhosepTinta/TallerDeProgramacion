package vista;

import javax.swing.JFrame;

import controlador.ControladorAgenda;
import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;


public class Prueba extends JFrame {

	
	public Prueba () {
		CalendarioMensual aux = new  CalendarioMensual(5,2020);
		Agenda a = new Agenda();
		Cita cita1 = new Cita("dormir","a",new Reloj(11,0,0),new Reloj(14,50,0),new Fecha(16,5,2020),"asunto");
		Cita cita2 = new Cita("asunto","b",new Reloj(15,0,0),new Reloj(16,30,0),new Fecha(16,5,2020),"asunto2");
		Cita cita3 = new Cita("asunto","c",new Reloj(17,0,0),new Reloj(20,0,0),new Fecha(13,5,2020),"clases");
		Cita cita4 = new Cita("cenar","d",new Reloj(9,10,0),new Reloj(10,59,0),new Fecha(12,5,2020),"cenar");
		Cita cita5 = new Cita("golpear","e",new Reloj(15,20,0),new Reloj(16,0,0),new Fecha(13,5,2020),"dormir");
		Cita cita6 = new Cita("dormir","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(12,5,2020),"b");
		/*Cita cita7 = new Cita("b","b",new Reloj(11,0,0),new Reloj(7,30,0),new Fecha(12,5,2020),"b");
		Cita cita8 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(11,7,2020),"b");
		Cita cita9 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(19,5,2020),"b");
		Cita cita10 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(19,5,2020),"b");
		Cita cita11 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(11,7,2020),"b");
		Cita cita12 = new Cita("b","b",new Reloj(11,0,0),new Reloj(10,30,0),new Fecha(23,5,2020),"ver pelicula");
		Cita cita13 = new Cita("b","b",new Reloj(11,0,0),new Reloj(23,30,0),new Fecha(16,5,2020),"b");
		Cita cita14 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(16,5,2020),"b");
		Cita cita15 = new Cita("b","b",new Reloj(11,0,0),new Reloj(12,30,0),new Fecha(22,5,2020),"b");
		Cita cita16 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(22,5,2020),"comer ");
		Cita cita17 = new Cita("b","b",new Reloj(11,0,0),new Reloj(9,30,0),new Fecha(1,5,2020),"b");
		Cita cita18 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(1,5,2020),"estudiar");
		Cita cita19 = new Cita("b","b",new Reloj(11,0,0),new Reloj(15,30,0),new Fecha(23,5,2020),"ir a reunion ");
		*/
		
		a.agregarCita(cita1);
		a.agregarCita(cita2);
		a.agregarCita(cita3);
		a.agregarCita(cita4);
		a.agregarCita(cita5);
		a.agregarCita(cita6);
		/*a.agregarCita(cita7);
		a.agregarCita(cita8);
		a.agregarCita(cita9);
		a.agregarCita(cita10);
		a.agregarCita(cita11);
		a.agregarCita(cita12);
		a.agregarCita(cita13);
		a.agregarCita(cita14);
		a.agregarCita(cita15);
		a.agregarCita(cita16);
		a.agregarCita(cita17);
		a.agregarCita(cita18);
		a.agregarCita(cita19);*/
		//a.agregarCita(cita5);
		System.out.println(a.buscarFecha(new Fecha(16,5,2020)).acceder(0).getAsunto());
		ControladorAgenda prueba = new ControladorAgenda(a);
		prueba.guardarDatosAgenda();
		prueba.setAgendaControlada(null);
		System.out.println(prueba.getAgendaControlada());
		Agenda recuperada = prueba.leerDatosGuardadosAgenda();
		System.out.println(recuperada.mostrar());
		prueba.setAgendaControlada(prueba.leerDatosGuardadosAgenda());
		System.out.println(prueba.getAgendaControlada().mostrar());
        
		VistaCalendarioMensual ac = new VistaCalendarioMensual(aux,a);
		setVisible(true);
		
		  add(ac);
		setSize(1400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Prueba prueba1 = new Prueba();
		
		
		
	}

}
