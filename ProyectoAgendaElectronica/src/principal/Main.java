package principal;


import controlador.ControladorG;
import vista.VistaPrincipal;

public class Main {

	public static void main(String[] args) {
	VistaPrincipal window = new VistaPrincipal();
	ControladorG ctrlg=new ControladorG(window);
	window.setVisible(true);
    
	}

}
