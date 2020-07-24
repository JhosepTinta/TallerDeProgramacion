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
		//Botones PanelC (lista)
		window.miPanelC.btnBorrar.addActionListener(this);
		window.miPanelC.btnBuscar.addActionListener(this);
		window.miPanelC.btnCrear.addActionListener(this);
		window.miPanelC.btnEdicion.addActionListener(this);
		window.miPanelC.btnVer.addActionListener(this);
		//Botones Panel1 (visualizar Contacto)
		window.miPanel1.btnEliminarC.addActionListener(this);
		window.miPanel1.btnIrEditar.addActionListener(this);
		window.miPanel1.btnSalir.addActionListener(this);     //boton ir a Lista de Contactos		
		//Botones Panel2 (editar contacto)
		window.miPanel2.btnEditar.addActionListener(this);
		window.miPanel2.btnVolver2.addActionListener(this);
		//Botones Panel3 (crear contacto)
        window.miPanel3.btnGuardar.addActionListener(this);
		window.miPanel3.btnVolver.addActionListener(this);	
	}
	public void actionPerformed (ActionEvent e) {
	
		//PanelC/////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(e.getSource()==window.miPanelC.btnBorrar) {
			 Archivo a =new Archivo();
			int fila=window.miPanelC.table.getSelectedRow();		 
			if(fila>=0) {
			if(a.existeC(window.miPanelC.model.getValueAt(fila,0),window.miPanelC.model.getValueAt(fila,1))){
				 int v= JOptionPane.showConfirmDialog(window.miPanelC, "Se eliminara a "+window.miPanelC.model.getValueAt(fila,0)+window.miPanelC.model.getValueAt(fila,1));
				if(v==0) { 
				a.eliminarC(window.miPanelC.model.getValueAt(fila,0), window.miPanelC.model.getValueAt(fila,1));
				JOptionPane.showMessageDialog(window.miPanelC, "Contacto Eliminado");
				 ///
				for(int i=0;i<a.numeroC()+1;i++) {
					for(int j=0;j<5;j++) {
						window.miPanelC.table.setValueAt("", i, j);
					}
				}
				String mat[][]=a.mC();
					for(int i=0;i<a.numeroC();i++) {
						for(int j=0;j<5;j++) {
					      window.miPanelC.table.setValueAt(mat[i][j], i, j);					      
						}
					}
				 ///
					window.definirPanel(window.miPanelC);	
				}
			 }
		   }
		}
		//-----------------------------------------------------------------------------
		if(e.getSource()==window.miPanelC.btnBuscar) {
			Archivo a = new Archivo();
			window.definirPanel(window.miPanelC);				
			if(window.miPanelC.busqueda.getText().contentEquals("")) {
				window.definirPanel(window.miPanelC);				
				String matriz[][]=a.mC();
				for(int i=0;i<a.numeroC();i++) {
					for(int j=0;j<5;j++) {
				      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
					}
				}
				
			}
			
			else if(a.eCaracter(window.miPanelC.busqueda.getText())){
			String matriz[][]=a.MatrizBusqueda(window.miPanelC.busqueda.getText());
			for(int i=0;i<a.numeroC();i++) {
				for(int j=0;j<5;j++) {
			      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
				}
			}
			}
			
			else {
				window.definirPanel(window.miPanelC);				
				String matriz[][]=a.mC();
				for(int i=0;i<a.numeroC();i++) {
					for(int j=0;j<5;j++) {
				      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
					}
				}
			}
		}
		//------------------------------------------------------------------------------
		if(e.getSource()==window.miPanelC.btnCrear) {
			window.definirPanel(window.miPanel3);
		}
		//-------------------------------------------------------------------------------
		if(e.getSource()==window.miPanelC.btnEdicion) {
			 Archivo a=new Archivo();
			int fila=window.miPanelC.table.getSelectedRow();
			if(fila>=0) {
			if(a.existeC(window.miPanelC.model.getValueAt(fila,0), window.miPanelC.model.getValueAt(fila,1))) {
			window.miPanel2.txtNE.setText((String) window.miPanelC.model.getValueAt(fila,0));
			window.miPanel2.txtAE.setText((String) window.miPanelC.model.getValueAt(fila,1));
			window.miPanel2.txtNP.setText((String) window.miPanelC.model.getValueAt(fila,0));
			window.miPanel2.txtAP.setText((String) window.miPanelC.model.getValueAt(fila,1));
			window.miPanel2.txtNuE.setText((String) window.miPanelC.model.getValueAt(fila,2));
			window.miPanel2.txtCE.setText((String) window.miPanelC.model.getValueAt(fila,3));
			window.miPanel2.txtDE.setText((String) window.miPanelC.model.getValueAt(fila,4));
			window.definirPanel(window.miPanel2);}}
		}
		//-------------------------------------------------------------------------------
		if(e.getSource()==window.miPanelC.btnVer) {
			 Archivo a =new Archivo();
				int fila=window.miPanelC.table.getSelectedRow();
				if(fila>=0) {
				if(a.existeC(window.miPanelC.model.getValueAt(fila,0), window.miPanelC.model.getValueAt(fila,1))) {
				window.miPanel1.txtNB.setText((String) window.miPanelC.model.getValueAt(fila,0));
				window.miPanel1.txtAB.setText((String) window.miPanelC.model.getValueAt(fila,1));
				window.miPanel1.txtMosN.setText((String) window.miPanelC.model.getValueAt(fila,2));
				window.miPanel1.txtMosC.setText((String) window.miPanelC.model.getValueAt(fila,3));
				window.miPanel1.txtMosD.setText((String) window.miPanelC.model.getValueAt(fila,4));
				window.definirPanel(window.miPanel1);}}
		}
		//Panel1////////////////////////////////////////////////////////////////////////////
		if(e.getSource()==window.miPanel1.btnEliminarC) {
			Archivo a=new Archivo();
			if(a.existeC(window.miPanel1.txtNB.getText(), window.miPanel1.txtAB.getText())) {
			int v=JOptionPane.showConfirmDialog(window.miPanel1, "Se eliminara a "+window.miPanel1.txtNB.getText()+" "+window.miPanel1.txtAB.getText());
			if(v==0) {
			a.eliminarC(window.miPanel1.txtNB.getText(), window.miPanel1.txtAB.getText());
			window.miPanel1.txtMosN.setText(null);
			window.miPanel1.txtMosC.setText(null);
			window.miPanel1.txtMosD.setText(null);
			window.miPanel1.txtNB.setText(null);
			window.miPanel1.txtAB.setText(null);
			JOptionPane.showMessageDialog(window.miPanelC, "Contacto Eliminado");
			for(int i=0;i<a.numeroC()+1;i++) {
				for(int j=0;j<5;j++) {
					window.miPanelC.table.setValueAt("", i, j);
				}
			}
			}
			}
			else JOptionPane.showMessageDialog(window.miPanelC, "Contacto mal ingresado");
			
		}
		//---------------------------------------------------------------------------------
		
		if(e.getSource()==window.miPanel1.btnIrEditar) {
			window.miPanel2.txtNE.setText(window.miPanel1.txtNB.getText());
			window.miPanel2.txtAE.setText(window.miPanel1.txtAB.getText());
			window.miPanel2.txtNuE.setText(window.miPanel1.txtMosN.getText());
			window.miPanel2.txtCE.setText(window.miPanel1.txtMosC.getText());
			window.miPanel2.txtDE.setText(window.miPanel1.txtMosD.getText());
			window.miPanel2.txtNP.setText(window.miPanel1.txtNB.getText());
			window.miPanel2.txtAP.setText(window.miPanel1.txtAB.getText());
			window.definirPanel(window.miPanel2);
	      }
		//------------------------------------------------------------------------------------
		if(e.getSource()==window.miPanel1.btnSalir) {			
			Archivo a = new Archivo();
			window.definirPanel(window.miPanelC);				
			String matriz[][]=a.mC();
			for(int i=0;i<a.numeroC();i++) {
				for(int j=0;j<5;j++) {
			      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
				}
			}
		  }
		
		//Panel2//////////////////////////////////////////////////////////////////////////////
		
		if(e.getSource()==window.miPanel2.btnVolver2) {
			Archivo a = new Archivo();
			window.definirPanel(window.miPanelC);				
			String matriz[][]=a.mC();
			for(int i=0;i<a.numeroC();i++) {
				for(int j=0;j<5;j++) {
			      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
				}
			}		
	    }
		//-------------------------------------------------------------------------------------
		if(e.getSource()==window.miPanel2.btnEditar) {
            
			Archivo a=new Archivo();
			a.eliminarC(window.miPanel2.txtNP.getText(), window.miPanel2.txtAP.getText());			
			if(a.existeC(window.miPanel2.txtNE.getText(), window.miPanel2.txtAE.getText())) {
				JOptionPane.showMessageDialog(window, "El contacto ya existe");
			}else{
			String Vno=window.miPanel2.txtNE.getText();
			String Vap=window.miPanel2.txtAE.getText();
			String Vnu=window.miPanel2.txtNuE.getText();
			try {
				Integer.parseInt(Vnu);
				String Vco=window.miPanel2.txtCE.getText();
			String Vdi=window.miPanel2.txtDE.getText();
			if(Vno.equals("")) {
				JOptionPane.showMessageDialog(window, "Ingresar un nombre es obligatorio");
			}else {
			if(Vap.equals("")) {
				Vap=".";
			}
			if(Vnu.equals("")) {
				Vnu="Sin numero";
			}
			if(Vco.equals("")) {
				Vco="Sin Correo";
			}
			if(Vdi.equals("")) {
				Vdi="Sin Direccion";
			}
			
			a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
			JOptionPane.showMessageDialog(window, "Contacto "+window.miPanel3.txtNombre.getText()+" "+window.miPanel3.txtApellido.getText()+" "+"Guardado Correctamente");			
			window.miPanel2.txtNP.setText(window.miPanel2.txtNE.getText());
			window.miPanel2.txtAP.setText(window.miPanel2.txtAE.getText());			
			}
				
		   	   }catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(window, "Asegurese de que el numero sea correcto");
			 }
		   }
	     }

		
		//Panel3////////////////////////////////////////////////////////////////////////////
		
		if(e.getSource()==window.miPanel3.btnGuardar) {
                   
			Archivo a=new Archivo();
			
			if(a.existeC(window.miPanel3.txtNombre.getText(), window.miPanel3.txtApellido.getText())) {
				JOptionPane.showMessageDialog(window, "El contacto ya existe");
			}else{
			String Vno=window.miPanel3.txtNombre.getText();
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
				Vnu="Sin numero";
			}
			if(Vco.equals("")) {
				Vco="Sin Correo";
			}
			if(Vdi.equals("")) {
				Vdi="Sin Direccion";
			}
			a.escribirPersona(new Contacto(Vno,Vap,Vnu,Vco,Vdi));
			JOptionPane.showMessageDialog(window, "Contacto "+window.miPanel3.txtNombre.getText()+" "+window.miPanel3.txtApellido.getText()+" "+"Guardado Correctamente");
			window.miPanel3.txtNombre.setText(null);
			window.miPanel3.txtApellido.setText(null);
			window.miPanel3.txtNumero.setText(null);
			window.miPanel3.txtCorreo.setText(null);
			window.miPanel3.txtDireccion.setText(null);
			}
				
		   	   }catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(window, "Asegurese de que el numero sea correcto");
			 }
		   }
	     }
		//---------------------------------------------------------------------------------------------------
		if(e.getSource()==window.miPanel3.btnVolver) {
			Archivo a = new Archivo();
			window.definirPanel(window.miPanelC);				
			String matriz[][]=a.mC();
			for(int i=0;i<a.numeroC();i++) {
				for(int j=0;j<5;j++) {
			      window.miPanelC.table.setValueAt(matriz[i][j], i, j);
				}
			}
		  }
		
		/////////////////////////////////////////////////////////////////////////////////////	    
  }
}




