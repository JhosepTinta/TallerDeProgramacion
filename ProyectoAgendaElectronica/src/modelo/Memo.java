package modelo;

public class Memo {
	private String titulo;
	private String texto;
	private Fecha fechaCreacion;
	private Reloj horaCreacion;
	private Fecha fechaModificacion;
 
	public Memo(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
		fechaCreacion = new Fecha();
		fechaModificacion = new Fecha();
		horaCreacion = new Reloj();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		fechaModificacion = new Fecha();
		return texto;
	}

	public void setTexto(String texto) {
		fechaModificacion = new Fecha();
		this.texto = texto;
	}
}
