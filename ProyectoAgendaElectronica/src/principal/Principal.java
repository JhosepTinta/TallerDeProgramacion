package principal;

import controlador.Controlador;
import modelo.Archivo;
import vista.VEditar;
import vista.VPrin;
import vista.Ventana;

public class Principal {

	public static void main(String[] args) {
		Ventana window = new Ventana();
		VEditar window2= new VEditar();
		VPrin windowP= new VPrin();
		Archivo a= new Archivo();
		
		Controlador ctrl= new Controlador(window,a,window2,windowP);
		windowP.setVisible(true);
		

	}

}
