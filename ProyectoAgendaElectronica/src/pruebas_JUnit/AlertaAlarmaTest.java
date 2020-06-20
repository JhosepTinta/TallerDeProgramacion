package pruebas_JUnit;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import modelo.AlertaAlarma;

class AlertaAlarmaTest {

	@Test
	void test() {
		
		AlertaAlarma aux = new AlertaAlarma();
		aux.CrearAlarma(9,7, 0,"PM");
		
		aux.cortar(4);
	}

}
