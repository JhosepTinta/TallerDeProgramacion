package controlador;

public class Lista {
	  private int codigo;
	    private String tarea;

	    public Lista( String tarea) {
	      
	        this.tarea = tarea;
	    }

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }

	    public String getTarea() {
	        return tarea;
	    }

	    public void setTarea(String tarea) {
	        this.tarea = tarea;
	    }

}
