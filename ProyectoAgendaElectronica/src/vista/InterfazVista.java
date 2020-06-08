package Modelo;

public interface InterfazVista {
	
	
	void setControlador(Control_Memo c);
	void arranca(); // comienza la visualización
	
	String getTexto();
	void setTexto(String mostrar);
	
	void limpiartexto();
	
	static final String EDITAR="Editar";
	static final String NUEVO="Nuevo";
	static final String GUARDAR="Guardar";
}
