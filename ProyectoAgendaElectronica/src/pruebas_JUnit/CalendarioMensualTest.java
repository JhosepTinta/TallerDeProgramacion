package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalendarioMensualTest {

	@Test
	void test() {
		CalendarioMensual u = new CalendarioMensual(new Integer(5),new Integer(2020));
		Integer[] mes =u.generarMes();
		int dia= mes[0];
		assertEquals(new Integer(1) , dia,0);
	}
	@Test
	public void testfinMes() {
		CalendarioMensual u = new CalendarioMensual(new Integer(5),new Integer(2020));
		Integer[] mes =u.generarMes();
		int dia= mes[29];
		assertEquals(new Integer(30) , dia,0);
	}
	@Test
	public void testInicioMes() {
		CalendarioMensual u = new CalendarioMensual(new Integer(5),new Integer(2020));
		Integer[] mes =u.generarMes();
		int dia= mes[0];
		assertEquals(new Integer(1) , dia,0);
	}
	
	@Test
	
	public void testSemanaFebrero() {
		CalendarioMensual u = new CalendarioMensual(new Integer(1),new Integer(2020));
		Integer[] mes =u.generarMes();
		int dia= mes[33];
		assertEquals(new Integer(29) , dia,0);
	}
}
