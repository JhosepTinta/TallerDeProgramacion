package modelo;

import java.util.ArrayList;
import java.util.Date;

import lineales.ListaSE;




public class ListaTareaPendiente {

	 private ArrayList<TareaPendiente> listadetareas;
	    
	 private ArrayList<Memo> memos;
	 
	    public ListaTareaPendiente(Agenda lista1) {
	    	listadetareas = new ArrayList<>();
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
        public void eliminarTarea(String codigo){
	        for (int i = 0; i < listadetareas.size(); i++) {
	            if(codigo.equals(listadetareas.get(i).getTarea())){
	            	listadetareas.remove(i);
	            }
	        }
	    }
	    

	    public void agregarTarea(String tarea, Date fechalimite,  String categoria){
	        TareaPendiente nuevo = new TareaPendiente(tarea,fechalimite,categoria);
	        listadetareas.add(nuevo);;
	    }
	    
	   
	/*
	    public void agregarTarea(TareaPendiente tarea){
		      listadetareas.add(tarea);
		    }
	    
	    
	    public void visualizarTarea(){
	        
	            System.out.println(listadetareas);
	        
	    }*/

	

	

	    

}
