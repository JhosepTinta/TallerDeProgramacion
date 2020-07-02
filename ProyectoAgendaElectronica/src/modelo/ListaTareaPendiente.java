package modelo;

import java.util.ArrayList;




public class ListaTareaPendiente {

	 private ArrayList<TareaPendiente> listadetareas;
	    
	    public ListaTareaPendiente() {
	    	listadetareas = new ArrayList<>();
	    }

	    public void eliminarTarea(String codigo){
	        for (int i = 0; i < listadetareas.size(); i++) {
	            if(codigo.equals(listadetareas.get(i).getTarea())){
	            	listadetareas.remove(i);
	            }
	        }
	    }
	    

	    
	
	    public void agregarTarea(TareaPendiente tarea){
		      listadetareas.add(tarea);
		    }
	    
	    
	    public void visualizarTarea(){
	        
	            System.out.println(listadetareas);
	        
	    }

	

	    

}
