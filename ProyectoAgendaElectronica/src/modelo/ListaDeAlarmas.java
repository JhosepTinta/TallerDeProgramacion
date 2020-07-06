package modelo;


import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *

 */
public class ListaDeAlarmas {

    public ArrayList<AlarmaL> listalarma;
	
    public ListaDeAlarmas() {
    	listalarma = new ArrayList<>();
    }

    public void eliminarPersona(int hora, int minutos, int segundos, String ampm){
      
            	listalarma.remove(hora);
            
        
    }
    
    
    public void agregarAlarma(int hora, int minutos, int segundos, String ampm, Date fecha){
        AlarmaL lista = new AlarmaL(hora,minutos,segundos,ampm,fecha);
        listalarma.add(lista);;
  
    }
    
    public ArrayList<AlarmaL> getAlarmaL(){
    	   
    	    	
    	
       		return listalarma;
       	
    			
    	   
       }
    
    
}

