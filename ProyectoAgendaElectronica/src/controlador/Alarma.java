package controlador;




import modelo.AlertaAlarma;

import vista.PantallaAlarma;



public class Alarma{
	
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
		
		new Alarma();
          
	}


	
	
	
	

}
