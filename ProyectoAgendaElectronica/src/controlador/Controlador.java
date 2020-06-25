package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Archivo;
import modelo.Contacto;
import vista.Panel1;
import vista.Panel2;
import vista.Panel3;
import vista.VistaPrincipal;
import vista.VistaPrincipal.LaminaPrincipal;

public class Controlador implements ActionListener {

	private Panel1 miPanel1;
	private Panel2 miPanel2;
	private Panel3 miPanel3;
	private Archivo arch;	
	
	public Controlador (Panel1 miPanel1,Panel2 miPanel2,Panel3 miPanel3,Archivo arch) {
		this.miPanel1=miPanel1;
		this.miPanel2=miPanel2;
		this.miPanel3=miPanel3;
		this.arch=arch;
		
		miPanel1.btnIrEditar.addActionListener(this);
		miPanel1.btnBuscar.addActionListener(this);
		miPanel1.btnCrear.addActionListener(this);
		miPanel1.btnEliminarC.addActionListener(this);
        miPanel3.btnGuardar.addActionListener(this);
		miPanel3.btnVolver.addActionListener(this);

		miPanel2.btnEditar.addActionListener(this);
		miPanel2.btnVolver2.addActionListener(this);
	}
	public void actionPerformed (ActionEvent e) {
		//Botones de la Ventana Crear Contacto
		if(e.getSource()==miPanel1.btnIrEditar) {
			VistaPrincipal.LaminaPrincipal.definirPanel(miPanel2);
	        }
		if(e.getSource()==miPanel3.btnGuardar) {
			Archivo a=new Archivo();
			
			if(a.existeC(miPanel3.txtNombre.getText(), miPanel3.txtApellido.getText())) {
				JOptionPane.showMessageDialog(miPanel3, "El contacto ya existe");
			}
			else{String Vno=miPanel3.txtNombre.getText();
			String Vap=miPanel3.txtApellido.getText();
			String Vnu=miPanel3.txtNumero.getText();
			try {
				Integer.parseInt(Vnu);
				String Vco=miPanel3.txtCorreo.getText();
			String Vdi=miPanel3.txtDireccion.getText();
			if(Vno.equals("")) {
				JOptionPane.showMessageDialog(null, "Ingresar un nombre es obligatorio");
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
			JOptionPane.showMessageDialog(miPanel3, "Contacto "+miPanel3.txtNombre.getText()+" "+miPanel3.txtApellido.getText()+" "+"Guardado Correctamente");
			miPanel3.txtNombre.setText(null);
			miPanel3.txtApellido.setText(null);
			miPanel3.txtNumero.setText(null);
			miPanel3.txtCorreo.setText(null);
			miPanel3.txtDireccion.setText(null);}
				
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Asegurese de que el número sea correcto");
			}
		}}
		
		if(e.getSource()==miPanel3.btnVolver) {
			VistaPrincipal.LaminaPrincipal.definirPanel(miPanel1);
		}
		
		//Botones de la Ventana Principal
		if(e.getSource()==miPanel1.btnCrear) {
			Archivo a=new Archivo();
			miPanel1.txtMosN.setText(null);
			miPanel1.txtMosC.setText(null);
			miPanel1.txtMosD.setText(null);
			VistaPrincipal.LaminaPrincipal.definirPanel(miPanel3);
		}
		if(e.getSource()==miPanel1.btnSalir) {
			System.exit(0);            // DEBERÁ MODIFICARSE AL ADJUNTAR LOS DEMAS PROGRAMAS
		}
		if((e.getSource()==miPanel1.btnBuscar)) {
			Archivo a=new Archivo();
			String ap= miPanel1.txtAB.getText();
			if(miPanel1.txtAB.getText().equals(""))
			ap=".";
			else
				ap=miPanel1.txtAB.getText();
			
			if(a.existeC(miPanel1.txtNB.getText(), ap)) {
			miPanel1.txtMosN.setText(a.buscarN(miPanel1.txtNB.getText(), ap));
			miPanel1.txtMosC.setText(a.buscarC(miPanel1.txtNB.getText(), ap));
			miPanel1.txtMosD.setText(a.buscarD(miPanel1.txtNB.getText(), ap));}
			else {
				JOptionPane.showMessageDialog(null, "No existe el contacto que busca");
			}
	    }
		if(e.getSource()==miPanel1.btnEliminarC) {
			Archivo a=new Archivo();
			a.eliminarC(miPanel1.txtNB.getText(), miPanel1.txtAB.getText());
			JOptionPane.showMessageDialog(miPanel1, "Contacto Eliminado");
			miPanel1.txtMosN.setText(null);
			miPanel1.txtMosC.setText(null);
			miPanel1.txtMosD.setText(null);
			miPanel1.txtNB.setText(null);
			miPanel1.txtAB.setText(null);
			
			
		}
		if(e.getSource()==miPanel1.btnIrEditar) {
			miPanel2.txtNP.setText(miPanel1.txtNB.getText());
			miPanel2.txtAP.setText(miPanel1.txtAB.getText());
			
			miPanel2.txtNE.setText(miPanel1.txtNB.getText());
			miPanel2.txtAE.setText(miPanel1.txtAB.getText());
		    miPanel2.txtNuE.setText(miPanel1.txtMosN.getText());
			miPanel2.txtCE.setText(miPanel1.txtMosC.getText());
			miPanel2.txtDE.setText(miPanel1.txtMosD.getText());
			
			miPanel1.txtMosN.setText(null);
			miPanel1.txtMosC.setText(null);
			miPanel1.txtMosD.setText(null);
			miPanel1.txtNB.setText(null);
			miPanel1.txtAB.setText(null);
			VistaPrincipal.LaminaPrincipal.definirPanel(miPanel2);
		}
	    if(e.getSource()==miPanel2.btnVolver2) {
	    	VistaPrincipal.LaminaPrincipal.definirPanel(miPanel1);                        //Podría ir abajo
			miPanel1.txtMosN.setText(miPanel2.txtNuE.getText());
			miPanel1.txtMosC.setText(miPanel2.txtCE.getText());
			miPanel1.txtMosD.setText(miPanel2.txtDE.getText());
			miPanel1.txtNB.setText(miPanel2.txtNE.getText());
			miPanel1.txtAB.setText(miPanel2.txtAE.getText());
	    	
	    }
	    if(e.getSource()==miPanel2.btnEditar) {
	    	Archivo a = new Archivo();
	    	String Vno=miPanel2.txtNE.getText();
			String Vap=miPanel2.txtAE.getText();
			String Vnu=miPanel2.txtNuE.getText();
			String Vco=miPanel2.txtCE.getText();
			String Vdi=miPanel2.txtDE.getText();
			if(Vno.equals("")) {
				JOptionPane.showMessageDialog(null, "Ingresar un nombre es obligatorio");
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
			a.eliminarC(miPanel2.txtNP.getText(), miPanel2.txtAP.getText());
	    	a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
	    	JOptionPane.showMessageDialog(miPanel2, "Contacto Actualizado Correctamente");
	    	VistaPrincipal.LaminaPrincipal.definirPanel(miPanel1);
	    	
			}	
	    }
     
      }
	
	}

