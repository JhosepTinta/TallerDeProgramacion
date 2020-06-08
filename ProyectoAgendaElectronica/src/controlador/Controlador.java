package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Archivo;
import modelo.Contacto;
import vista.VEditar;
import vista.VPrin;
import vista.Ventana;

public class Controlador implements ActionListener {

	private Ventana window;
	private Archivo a;
	private VEditar window2;
	private VPrin windowP;
	
	
	public Controlador (Ventana window,Archivo a,VEditar window2,VPrin windowP) {
		this.window=window;
		this.a=a;
		window.btnGuardar.addActionListener(this);
		window.btnVolver.addActionListener(this);
		
		this.window2=window2;
		window2.btnEditar.addActionListener(this);
		window2.btnVolver2.addActionListener(this);
		
		this.windowP=windowP;
		windowP.btnBuscar.addActionListener(this);
		windowP.btnCrear.addActionListener(this);
		windowP.btnEliminarC.addActionListener(this);
		windowP.btnIrEditar.addActionListener(this);
		
	}
	public void actionPerformed (ActionEvent e) {
		
		//Botones de la Ventana Crear Contacto
		if(e.getSource()==window.btnGuardar) {
			Archivo a=new Archivo();
			
			if(a.existeC(window.txtNombre.getText(), window.txtApellido.getText())) {
				JOptionPane.showMessageDialog(window, "El contacto ya existe");
			}
			else{String Vno=window.txtNombre.getText();
			String Vap=window.txtApellido.getText();
			String Vnu=window.txtNumero.getText();
			try {
				Integer.parseInt(Vnu);
				String Vco=window.txtCorreo.getText();
			String Vdi=window.txtDireccion.getText();
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
			JOptionPane.showMessageDialog(window, "Contacto "+window.txtNombre.getText()+" "+window.txtApellido.getText()+" "+"Guardado Correctamente");
			window.txtNombre.setText(null);
			window.txtApellido.setText(null);
			window.txtNumero.setText(null);
			window.txtCorreo.setText(null);
			window.txtDireccion.setText(null);}
				
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(window, "Asegurese de que el número sea correcto");
			}
		}}
		
		if(e.getSource()==window.btnVolver) {
			windowP.setVisible(true);    //posibles lineas de codigo extras
			window.dispose();
		}
		
		//Botones de la Ventana Principal
		if(e.getSource()==windowP.btnCrear) {
			Archivo a=new Archivo();
			windowP.txtMosN.setText(null);
			windowP.txtMosC.setText(null);
			windowP.txtMosD.setText(null);
			window.setVisible(true);   
			windowP.dispose();
		}
		if(e.getSource()==windowP.btnSalir) {
			System.exit(0);            // DEBERÁ MODIFICARSE AL ADJUNTAR LOS DEMAS PROGRAMAS
		}
		if((e.getSource()==windowP.btnBuscar)) {
			Archivo a=new Archivo();
			String ap= windowP.txtAB.getText();
			if(windowP.txtAB.getText().equals(""))
			ap=".";
			else
				ap=windowP.txtAB.getText();
			
			if(a.existeC(windowP.txtNB.getText(), ap)) {
			windowP.txtMosN.setText(a.buscarN(windowP.txtNB.getText(), ap));
			windowP.txtMosC.setText(a.buscarC(windowP.txtNB.getText(), ap));
			windowP.txtMosD.setText(a.buscarD(windowP.txtNB.getText(), ap));}
			else {
				JOptionPane.showMessageDialog(windowP, "No existe el contacto que busca");
			}
	    }
		if(e.getSource()==windowP.btnEliminarC) {
			Archivo a=new Archivo();
			a.eliminarC(windowP.txtNB.getText(), windowP.txtAB.getText());
			JOptionPane.showMessageDialog(windowP, "Contacto Eliminado");
			windowP.txtMosN.setText(null);
			windowP.txtMosC.setText(null);
			windowP.txtMosD.setText(null);
			windowP.txtNB.setText(null);
			windowP.txtAB.setText(null);
			
			
		}
		if(e.getSource()==windowP.btnIrEditar) {
			window2.txtNP.setText(windowP.txtNB.getText());
			window2.txtAP.setText(windowP.txtAB.getText());
			
			window2.txtNE.setText(windowP.txtNB.getText());
			window2.txtAE.setText(windowP.txtAB.getText());
			window2.txtNuE.setText(windowP.txtMosN.getText());
			window2.txtCE.setText(windowP.txtMosC.getText());
			window2.txtDE.setText(windowP.txtMosD.getText());
			
			windowP.txtMosN.setText(null);
			windowP.txtMosC.setText(null);
			windowP.txtMosD.setText(null);
			windowP.txtNB.setText(null);
			windowP.txtAB.setText(null);
			window2.setVisible(true);
			windowP.dispose();
		}
	    if(e.getSource()==window2.btnVolver2) {
			windowP.setVisible(true);
			windowP.txtMosN.setText(window2.txtNuE.getText());
			windowP.txtMosC.setText(window2.txtCE.getText());
			windowP.txtMosD.setText(window2.txtDE.getText());
			windowP.txtNB.setText(window2.txtNE.getText());
			windowP.txtAB.setText(window2.txtAE.getText());
	    	window2.dispose();
	    }
	    if(e.getSource()==window2.btnEditar) {
	    	Archivo a = new Archivo();
	    	String Vno=window2.txtNE.getText();
			String Vap=window2.txtAE.getText();
			String Vnu=window2.txtNuE.getText();
			String Vco=window2.txtCE.getText();
			String Vdi=window2.txtDE.getText();
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
			a.eliminarC(window2.txtNP.getText(), window2.txtAP.getText());
	    	a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
	    	JOptionPane.showMessageDialog(window2, "Contacto Actualizado Correctamente");
	    	window2.dispose();
	    	windowP.setVisible(true);
	    	
			}	
	    }
	}
}

