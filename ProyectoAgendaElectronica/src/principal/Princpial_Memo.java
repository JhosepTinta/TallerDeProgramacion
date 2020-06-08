package Modelo;

public class Princpial_Memo {

	public static void main(String args[]) {
		
		Modelo_Memo modelo = new Modelo_Memo();
		// la vista:
		   InterfazVista vista = new Ventana_Memo();
		// y el control:
		    Control_Memo control = new Control_Memo(modelo,vista);
		         
		// configura la vista
		   vista.setControlador(control);
		// y arranca la interfaz (vista):
		    vista.arranca();
		}
	
		
	}


