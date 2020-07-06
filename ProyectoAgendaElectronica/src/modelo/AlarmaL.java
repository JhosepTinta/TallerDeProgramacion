package modelo;

import java.util.Date;

/**
 *
 
 */
public class AlarmaL {

    private int hora;
    private int minutos;
    private int segundos;
    private String ampm;
    private Date fecha;
	public AlarmaL(int hora, int minutos, int segundos, String ampm, Date fecha){
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		this.ampm = ampm;
		this.fecha = fecha;
	}
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

