package pruebas_JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import modelo.*;
import lineales.*;

class AgendaTest {
	
	Agenda agenda = new Agenda();

	Cita cita1 = new Cita("a","a",new Reloj(11,0,0),new Reloj(14,50,0),new Fecha(12,5,2020),"a");
	Cita cita2 = new Cita("b","b",new Reloj(11,10,0),new Reloj(16,30,0),new Fecha(12,5,2020),"b");
	Cita cita3 = new Cita("c","c",new Reloj(17,0,0),new Reloj(20,0,0),new Fecha(12,4,2020),"c");
	Cita cita4 = new Cita("d","d",new Reloj(9,10,0),new Reloj(10,59,0),new Fecha(12,5,2020),"d");
	Cita cita5 = new Cita("e","e",new Reloj(15,20,0),new Reloj(16,0,0),new Fecha(12,4,2020),"e");
	Cita cita6 = new Cita("b","b",new Reloj(11,6,0),new Reloj(15,30,0),new Fecha(12,9,2020),"b");

	@Test
	void eliminarCitaTest() {

		agenda.agregarCita(cita1);
		agenda.agregarCita(cita2);
		agenda.agregarCita(cita3);
		agenda.agregarCita(cita4);
		agenda.agregarCita(cita5);
		
		assertEquals(true,agenda.eliminarCita(cita1));
		assertEquals(4,agenda.cantidadCitas());
	}
	@Test
	void buscarPorFechaTest() {

		agenda.agregarCita(cita1);
		agenda.agregarCita(cita2);
		agenda.agregarCita(cita3);
		agenda.agregarCita(cita4);
		agenda.agregarCita(cita5);
		
		assertEquals(2,agenda.buscarFecha(new Fecha(12,4,2020)).longitud());
	}
	@Test
	void buscarPorHoraTest() {
		assertEquals(true,agenda.getLista().vacia());
		agenda.agregarCita(cita1);
		agenda.agregarCita(cita2);
		agenda.agregarCita(cita3);
		agenda.agregarCita(cita4);
		agenda.agregarCita(cita6);
		
		assertEquals(3,agenda.buscarHora(new Reloj(11,0,0)).longitud());
	}
	@Test
	void buscarPorAsuntoTest() {
		assertEquals(true,agenda.getLista().vacia());
		agenda.agregarCita(cita1);
		agenda.agregarCita(cita2);
		agenda.agregarCita(cita3);
		agenda.agregarCita(cita4);
		agenda.agregarCita(cita6);
		
		assertEquals(3,agenda.buscarLugarAsunto("a","b").longitud());
	}

}
