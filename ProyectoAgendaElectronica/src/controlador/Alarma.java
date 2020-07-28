package controlador;


//@autor  Vladimir Orellana Luizaga

import modelo.AlertaAlarma;

import vista.PantallaAlarma;



public class Alarma{
	
	//Con esta clase estamos controlando lo la ejecución de la Alarma y estamos importando las clases AlertaAlarma y PantallaAlarma.
	
  public  PantallaAlarma pantalla;
   
   public Alarma() {
	   
	   pantalla = new PantallaAlarma();
	   try {
		     PantallaAlarma pantalla  =	 new PantallaAlarma();
			pantalla.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	public static void main(String args[]) {
		
		//En esta parte se está ejecutando el programa
		
		new Alarma();
          
	}


	
	
	
	

}
