package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Archivo;
import modelo.Contacto;
import vista.VistaPrincipal;

public class Controlador implements ActionListener {

	private VistaPrincipal window;
	private Archivo a;	
	
	public Controlador (VistaPrincipal window,Archivo a) {
		this.window=window;
		this.a=a;
		
		window.miPanel1.btnIrEditar.addActionListener(this);
		window.miPanel1.btnBuscar.addActionListener(this);
		window.miPanel1.btnCrear.addActionListener(this);
		window.miPanel1.btnEliminarC.addActionListener(this);
        window.miPanel3.btnGuardar.addActionListener(this);
		window.miPanel3.btnVolver.addActionListener(this);
		window.miPanel2.btnEditar.addActionListener(this);
		window.miPanel2.btnVolver2.addActionListener(this);
		
	}
	public void actionPerformed (ActionEvent e) {
	
		if(e.getSource()==window.miPanel1.btnIrEditar) {
			window.definirPanel(window.miPanel2);
	}
		if(e.getSource()==window.miPanel3.btnGuardar) {
			Archivo a=new Archivo();
			
			if(a.existeC(window.miPanel3.txtNombre.getText(), window.miPanel3.txtApellido.getText())) {
				JOptionPane.showMessageDialog(window, "El contacto ya existe");
			}
			else{String Vno=window.miPanel3.txtNombre.getText();
			String Vap=window.miPanel3.txtApellido.getText();
			String Vnu=window.miPanel3.txtNumero.getText();
			try {
				Integer.parseInt(Vnu);
				String Vco=window.miPanel3.txtCorreo.getText();
			String Vdi=window.miPanel3.txtDireccion.getText();
			if(Vno.equals("")) {
				JOptionPane.showMessageDialog(window, "Ingresar un nombre es obligatorio");
			}else {
			if(Vap.equals("")) {
				Vap=".";
			}
			if(Vnu.equals("")) {
				Vnu="Sin Número actualmente";
			}
			if(Vco.equals("")) {
				Vco="Sin Correo añadido actualmente";
			}
			if(Vdi.equals("")) {
				Vdi="Sin Dirección añadida actualmente";
			}
			a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
			JOptionPane.showMessageDialog(window, "Contacto "+window.miPanel3.txtNombre.getText()+" "+window.miPanel3.txtApellido.getText()+" "+"Guardado Correctamente");
			window.miPanel3.txtNombre.setText(null);
			window.miPanel3.txtApellido.setText(null);
			window.miPanel3.txtNumero.setText(null);
			window.miPanel3.txtCorreo.setText(null);
			window.miPanel3.txtDireccion.setText(null);}
				
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(window, "Asegurese de que el número sea correcto");
			}
		}}
		
		if(e.getSource()==window.miPanel3.btnVolver) {
			window.definirPanel(window.miPanel1);
		}
		
		//Botones de la Ventana Principal
		if(e.getSource()==window.miPanel1.btnCrear) {
			Archivo a=new Archivo();
			window.miPanel1.txtMosN.setText(null);
			window.miPanel1.txtMosC.setText(null);
			window.miPanel1.txtMosD.setText(null);
			window.definirPanel(window.miPanel3);
		}
		if(e.getSource()==window.miPanel1.btnSalir) {
			System.exit(0);            // DEBERÁ MODIFICARSE AL ADJUNTAR LOS DEMAS PROGRAMAS
		}
		if((e.getSource()==window.miPanel1.btnBuscar)) {
			Archivo a=new Archivo();
			String ap= window.miPanel1.txtAB.getText();
			if(window.miPanel1.txtAB.getText().equals(""))
			ap=".";
			else
				ap=window.miPanel1.txtAB.getText();
			
			if(a.existeC(window.miPanel1.txtNB.getText(), ap)) {
			window.miPanel1.txtMosN.setText(a.buscarN(window.miPanel1.txtNB.getText(), ap));
			window.miPanel1.txtMosC.setText(a.buscarC(window.miPanel1.txtNB.getText(), ap));
			window.miPanel1.txtMosD.setText(a.buscarD(window.miPanel1.txtNB.getText(), ap));}
			else {
				JOptionPane.showMessageDialog(window, "No existe el contacto que busca");
			}
	    }
		if(e.getSource()==window.miPanel1.btnEliminarC) {
			Archivo a=new Archivo();
			a.eliminarC(window.miPanel1.txtNB.getText(), window.miPanel1.txtAB.getText());
			JOptionPane.showMessageDialog(window.miPanel1, "Contacto Eliminado");
			window.miPanel1.txtMosN.setText(null);
			window.miPanel1.txtMosC.setText(null);
			window.miPanel1.txtMosD.setText(null);
			window.miPanel1.txtNB.setText(null);
			window.miPanel1.txtAB.setText(null);
			
			
		}
		if(e.getSource()==window.miPanel1.btnIrEditar) {
			window.miPanel2.txtNP.setText(window.miPanel1.txtNB.getText());
			window.miPanel2.txtAP.setText(window.miPanel1.txtAB.getText());
			
			window.miPanel2.txtNE.setText(window.miPanel1.txtNB.getText());
			window.miPanel2.txtAE.setText(window.miPanel1.txtAB.getText());
			window.miPanel2.txtNuE.setText(window.miPanel1.txtMosN.getText());
			window.miPanel2.txtCE.setText(window.miPanel1.txtMosC.getText());
			window.miPanel2.txtDE.setText(window.miPanel1.txtMosD.getText());
			
			window.miPanel1.txtMosN.setText(null);
			window.miPanel1.txtMosC.setText(null);
			window.miPanel1.txtMosD.setText(null);
			window.miPanel1.txtNB.setText(null);
			window.miPanel1.txtAB.setText(null);
			window.definirPanel(window.miPanel2);
		}
	    if(e.getSource()==window.miPanel2.btnVolver2) {
	    	window.definirPanel(window.miPanel1);                        //Podría ir abajo
			window.miPanel1.txtMosN.setText(window.miPanel2.txtNuE.getText());
			window.miPanel1.txtMosC.setText(window.miPanel2.txtCE.getText());
			window.miPanel1.txtMosD.setText(window.miPanel2.txtDE.getText());
			window.miPanel1.txtNB.setText(window.miPanel2.txtNE.getText());
			window.miPanel1.txtAB.setText(window.miPanel2.txtAE.getText());
	    	
	    }
	    if(e.getSource()==window.miPanel2.btnEditar) {
	    	Archivo a = new Archivo();
	    	String Vno=window.miPanel2.txtNE.getText();
			String Vap=window.miPanel2.txtAE.getText();
			String Vnu=window.miPanel2.txtNuE.getText();
			String Vco=window.miPanel2.txtCE.getText();
			String Vdi=window.miPanel2.txtDE.getText();
			if(Vno.equals("")) {
				JOptionPane.showMessageDialog(window, "Ingresar un nombre es obligatorio");
			}else {
			if(Vap.equals("")) {
				Vap=".";
			}
			if(Vnu.equals("")) {
				Vnu="Sin Número actualmente";
			}
			if(Vco.equals("")) {
				Vco="Sin Correo añadido actualmente";
			}
			if(Vdi.equals("")) {
				Vdi="Sin Dirección añadida actualmente";
			}
			a.eliminarC(window.miPanel2.txtNP.getText(), window.miPanel2.txtAP.getText());
	    	a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
	    	JOptionPane.showMessageDialog(window.miPanel2, "Contacto Actualizado Correctamente");
	    	window.definirPanel(window.miPanel1);
	    	
			}	
	    }
}
}
