package vista;

import javax.swing.JFrame;

import modelo.CalendarioMensual;

public class Prueba extends JFrame {

	public Prueba () {
		CalendarioMensual aux = new  CalendarioMensual(4,2020);
		VistaCalendarioMensual a = new VistaCalendarioMensual(aux);
		setVisible(true);
		
		  
		
		add(a);
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Prueba prueba = new Prueba();
	  

	}

}
