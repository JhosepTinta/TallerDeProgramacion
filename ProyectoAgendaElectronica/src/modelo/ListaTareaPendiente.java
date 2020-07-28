package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

//@autor  Vladimir Orellana Luizaga

import java.util.ArrayList;
import java.util.Date;

import lineales.ListaSE;




public class ListaTareaPendiente {

	
	    
	 private ArrayList<Memo> memos;

	 //La clase lista tarea pendiente en general  recupera lo que se creo en memo.
	 
	 //Aquí le estamos mandando como parámetro lo que sería la clase agenda en el constructor.
	    public ListaTareaPendiente(Agenda lista1) {
	    	
	    	ListaSE<Cita> nuevo = (ListaSE<Cita>) lista1.getLista().inOrden();
	    	memos = new ArrayList<>();
	    	
	    	//Está recorriendo toda la lista de citas para obtener si hay memos disponibles.
	    	
	    	
	      for(int i=0 ; i<nuevo.longitud(); i++)
	      {
	    	  Cita buscar = nuevo.acceder(i);
	    	  for(int j=0 ; j<buscar.getListaRecordatorios().size() ; j++)
	    	  {
	    		  memos.addAll(buscar.getListaRecordatorios());
	    	  }
	    	  
	      }
	    }
   

		public ArrayList<Memo> getListarecordatorios(){
	   
       		return memos;
       
       }
		
		

	    
	

}
