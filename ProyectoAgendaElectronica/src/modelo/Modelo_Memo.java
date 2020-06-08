package Modelo;




import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Modelo_Memo {
	
	Ventana_Memo ventana1;
	
	String txt;
	private JTextArea Areatxt; 

	public Modelo_Memo() {
		txt=new String();
		Areatxt=new JTextArea();
		ventana1 = new Ventana_Memo();	}
	
	public String getTexto() {
		
		txt=Areatxt.getText();
		return txt;
	}
	public void setTexto(String txt) {
		
		this.txt=txt;
	}
	
	
	
	public void abrirArchivo() {
        System.out.println("Abrir archivo!!!");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//especificamos que solo abriremos archivos

        if (fileChooser.showOpenDialog(ventana1) == JFileChooser.APPROVE_OPTION) { //cersioramos que el usuario elija un achivo 
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();  //guardamos la ruta

            try {
                List<String> lineas = Files.readAllLines(Paths.get(ruta)); //copiamos el texto que hay en la ruta elegida

                for (String linea: lineas) {
                    Areatxt.append(linea+"\n"); //	copiamos el texto recuperado en el area de texto
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	

}
