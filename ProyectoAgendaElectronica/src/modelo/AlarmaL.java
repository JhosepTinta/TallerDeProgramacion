package modelo;

import java.util.Date;

//@autor  Vladimir Orellana Luizaga

/**
 *
 
 */
public class AlarmaL {
	//Aquí estamos inicializando todos los atributos que son necesarios.

    
	public  int hora;
	public int minutos;
	public int segundos;
	public String ampm;
	public Date fecha;
    
    // En el constructor estamos mandado como para los que se puede observar.
    
	public AlarmaL(int hora, int minutos, int segundos, String ampm, Date fecha){
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		this.ampm = ampm;
		this.fecha = fecha;
		
	}
	
	
	// Desde aquí estamos guardado y devolviendo los datos ingresados.
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	
		public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Alarma Programada [hora=" + hora + ", minutos=" + minutos + ", segundos=" + segundos + ", ampm=" + ampm
				+ ", fecha=" + fecha + "]";
	}

	
	


   

}

