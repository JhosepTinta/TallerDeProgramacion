package modelo;

import java.util.ArrayList;
import java.util.Date;

import lineales.ListaSE;




public class ListaTareaPendiente {

	
	    
	 private ArrayList<Memo> memos;

	 
	    public ListaTareaPendiente(Agenda lista1) {
	    	
	    	ListaSE<Cita> nuevo = (ListaSE<Cita>) lista1.getLista().inOrden();
	    	memos = new ArrayList<>();
	    	
	    	
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
