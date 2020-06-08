package Modelo;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Control_Memo implements ActionListener{

	Ventana_Memo ventana;
	Modelo_Memo modelo;
	InterfazVista vista;	
	
	
	public Control_Memo(Modelo_Memo modelo,InterfazVista vista) {
		this.modelo=modelo;
		this.vista=vista;
		ventana=new Ventana_Memo();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(InterfazVista.EDITAR)) {
			JOptionPane.showMessageDialog(null, "Elige un archivo para editarlo");
			modelo.abrirArchivo();
			vista.setTexto(modelo.getTexto());
			
			System.out.println("presionaste Abrir");
			
			
		}else {
			
			   if(e.getActionCommand().equals(InterfazVista.NUEVO)) {
				
				vista.limpiartexto();
				
			   }else {
			       	if(e.getActionCommand().equals(InterfazVista.GUARDAR)) {
					
					
					guardarArchivo();
					//JOptionPane.showMessageDialog(null,"");
					vista.limpiartexto();
					
			
					
			      	}else 
					
					   System.out.println("no seas puto ");
				
				
			  }
			
		}
			
			
	}
	//guarda el texto que se escriba
	private void guardarArchivo() {  
        System.out.println("Guardar Archivo!!");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// crea la venta emergente para guardar el archivo

        if (fileChooser.showSaveDialog(ventana) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();//recuperamos la ruta 
            FileWriter escritor = null;

            try {
                escritor = new FileWriter(archivo); //creamos un archivo  en la ruta selecionada
                escritor.write(vista.getTexto()); //guardamos el texto escrito por el usuario dentro del archivo
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    escritor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
		
		
	}
