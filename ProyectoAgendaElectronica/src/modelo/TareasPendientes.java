package controlador;

import java.util.ArrayList;



public class TareasPendientes {

	 private ArrayList<Lista> guardartarea;
	    
	    public TareasPendientes() {
	    	guardartarea = new ArrayList<>();
	    }

	    public void eliminarTarea(String codigo){
	        for (int i = 0; i < guardartarea.size(); i++) {
	            if(codigo.equals(guardartarea.get(i).getTarea())){
	            	guardartarea.remove(i);
	            }
	        }
	    }
	    
	    public void buscarTarea(String codigo){
	        for (int i = 0; i < guardartarea.size(); i++) {
	            if (codigo.equals(guardartarea.get(i).getTarea())) {
	                System.out.println(guardartarea.get(i).getTarea());
	            }
	        }
	    }
	    
	    public void agregarTarea(String Tarea){
	       Lista nuevo = new Lista(Tarea);
	       guardartarea.add(nuevo);
	    }
	    public void generarcodigo()
	    {
	    	
	    }
	    
	    
	    
	    public void visualizarTarea(){
	        for(int i = 0 ;i<guardartarea.size();i++){
	            System.out.println(i+"="+guardartarea.get(i).getTarea());
	        }
	    }

}
