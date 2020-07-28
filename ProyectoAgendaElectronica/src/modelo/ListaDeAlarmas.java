package modelo;

//@autor  Vladimir Orellana Luizaga

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *

 */
public class ListaDeAlarmas {
	
	//Aquí le estamos mandado como para metro  en el  arraylist a AlarmaL.

    public ArrayList<AlarmaL> listalarma;
	
    public ListaDeAlarmas() {
    	listalarma = new ArrayList<>();
    }

 
    
    //Lo estamos agregando en la lista con este método que recibí como parámetro hora, minutos, am o pm, y la fecha de creación. 
    
    public void agregarAlarma(int hora, int minutos, int segundos, String ampm, Date fecha){
        AlarmaL lista = new AlarmaL(hora,minutos,segundos,ampm,fecha);
        listalarma.add(lista);;
  
    }
    
    //Aquí estamos devolviendo la lista de alarmas del ArrayList.
    
    public ArrayList<AlarmaL> getAlarmaL(){
    	   
    	    	
    	
       		return listalarma;
       	
    			
    	   
       }
   


    
}

