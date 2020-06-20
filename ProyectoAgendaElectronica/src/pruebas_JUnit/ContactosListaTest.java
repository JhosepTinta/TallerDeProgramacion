package pruebas_JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Archivo;
import modelo.Contacto;

public class ContactosListaTest {

	Archivo a;
	@Before
	public void before() {
		a=new Archivo();
		a.escribirPersona(new Contacto("z","z","4227922","z@gmail.com","dir"));
	}
	
	@Test
	public void buscarNtest() {
		a = new Archivo();
		String numero=a.buscarN("z","z");
		String esperado="4227922";
		assertEquals(esperado,numero);
	}
	@Test
	public void buscarCtest() {
		a = new Archivo();
		String correo=a.buscarC("z","z");
		String esperado="z@gmail.com";
		assertEquals(esperado,correo);
	}
	@Test
	public void buscarDtest() {
		a = new Archivo();
		String direccion=a.buscarD("z","z");
		String esperado="dir";
		assertEquals(esperado,direccion);
	}
	@Test
	public void existeCtest() {
		a = new Archivo();
		boolean existe=a.existeC("z","z");
		boolean siExiste=true;
		assertEquals(siExiste,existe);
	}
	@Test
	public void eliminarCtest() {
		a = new Archivo();
		a.eliminarC("z","z");
		 boolean eliminadoCorrecto=a.existeC("z", "z");		 //Si se elimino correctamente, significa que ya no existe y devolvera Falso
		 boolean eliminado=false;                            //Por tanto se compara con False
		assertEquals(eliminado,eliminadoCorrecto);
	}
}
