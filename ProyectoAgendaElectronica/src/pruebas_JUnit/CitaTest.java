package pruebas_JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modelo.*;

class CitaTest {

	@Test
	void compareToCitaTest() {
		Cita cita = new Cita("a","d",new Reloj(15,30,0),new Reloj(17,30,0),new Fecha(19,1,2020),"l");
		
		assertEquals(0,cita.compareTo(cita));
		
		// presicion de fecha
		assertEquals(1, cita.compareTo(new Cita("a","d",new Reloj(15,30,0),new Reloj(17,30,0),new Fecha(18,1,2020),"l")));
		assertEquals(-1, cita.compareTo(new Cita("a","d",new Reloj(15,30,0),new Reloj(17,30,0),new Fecha(20,1,2020),"l")));
		// presicion de horaInicio y horaFin
		assertEquals(1, cita.compareTo(new Cita("a","d",new Reloj(15,0,0),new Reloj(15,29,0),new Fecha(19,1,2020),"l")));
		assertEquals(-1, cita.compareTo(new Cita("a","d",new Reloj(17,31,0),new Reloj(17,38,0),new Fecha(19,1,2020),"l")));
		// conflicto de horas, cuando chocan los horaios al compararse
		assertEquals(2, cita.compareTo(new Cita("a","d",new Reloj(14,30,0),new Reloj(15,40,0),new Fecha(19,1,2020),"l")));
		assertEquals(2, cita.compareTo(new Cita("a","d",new Reloj(17,0,0),new Reloj(18,30,0),new Fecha(19,1,2020),"l")));
		assertEquals(2, cita.compareTo(new Cita("a","d",new Reloj(14,0,0),new Reloj(18,30,0),new Fecha(19,1,2020),"l")));
	}

	@Test
	void compareToFechaTest() {
		Fecha fecha = new Fecha(4, 7, 2001);

		assertEquals(0, fecha.compareTo(new Fecha(4, 7, 2001)));

		// presicion en años
		assertEquals(1, fecha.compareTo(new Fecha(15, 7, 2000)));
		assertEquals(-1, fecha.compareTo(new Fecha(15, 9, 2002)));
		// Presicion en meses
		assertEquals(1, fecha.compareTo(new Fecha(15, 4, 2001)));
		assertEquals(-1, fecha.compareTo(new Fecha(15, 9, 2001)));
		// Presicion en dias
		assertEquals(1, fecha.compareTo(new Fecha(3, 7, 2001)));
		assertEquals(-1, fecha.compareTo(new Fecha(18, 7, 2001)));
	}

	@Test
	void compareToRelojTest() {
		Reloj hora = new Reloj(15, 8, 0);

		assertEquals(0, hora.compareTo(new Reloj(15, 8, 0)));

		// presicion en minutos
		assertEquals(1, hora.compareTo(new Reloj(15, 7, 0)));
		assertEquals(-1, hora.compareTo(new Reloj(15, 9, 0)));
		hora.setSegundos(12);
		// Presicion en segudos
		assertEquals(1, hora.compareTo(new Reloj(15, 8, 11)));
		assertEquals(-1, hora.compareTo(new Reloj(15, 8, 13)));
		// Presicion en horas
		assertEquals(1, hora.compareTo(new Reloj(13, 8, 11)));
		assertEquals(-1, hora.compareTo(new Reloj(18, 9, 13)));
	}

}
