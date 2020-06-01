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

}
