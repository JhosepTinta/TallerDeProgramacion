package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Cita implements Comparable<Cita>, Serializable{
	
	private String asunto;
	private String descripcion;
	private Reloj  horaInicio;
	private Reloj  horaFin;
	private Fecha  fecha;
	private String lugar;
	private AlertaAlarma alarmaCita;
	private String contactosEnCita;
	private ArrayList<Memo> listaRecordatorios;
	
	public Cita(String asunto, String descripcion, Reloj horaInicio, Reloj horaFin, Fecha fecha, String lugar) {
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
		this.lugar = lugar;
		contactosEnCita = "";
		listaRecordatorios = new ArrayList<Memo>();
	}

	public String getAsunto() {
		return asunto;
	}
///____
	public ArrayList<Memo> getListaRecordatorios() {
		return listaRecordatorios;
	}

	public void setListaRecordatorios(ArrayList<Memo> listaRecordatorios) {
		this.listaRecordatorios = listaRecordatorios;
	}
////------
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String asunto) {
		this.descripcion = asunto;
	}
	
	public Reloj getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Reloj hora) {
		this.horaInicio = hora;
	}
	
	public Reloj getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Reloj hora) {
		this.horaFin = hora;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	/**
	 * El compareTo de una cita solo considera el asunto ni la descripcion
	 * solo la fecha y la hora
	 * los valores son:
	 * 		1 la cita a comparar ocurre despues
	 * 		0 la cita a comparar es igual
	 * 	   -1 la cita a comparar ocurre antes
	 * 		2 la cita a comparar choca en horarios
	 */
	public int compareTo(Cita otra) {
		int res = 2;
		if(fecha.compareTo(otra.getFecha()) == 0) {
			if(horaInicio.compareTo(otra.getHoraInicio())==0) {
				if(horaFin.compareTo(otra.getHoraFin())==0) {
					res = 0;
				}
			}else if(horaInicio.compareTo(otra.getHoraFin())==1) {
				res = 1;
				
			}else if(horaFin.compareTo(otra.getHoraInicio())==-1) {
				res = -1;
			}
		}else if(fecha.compareTo(otra.getFecha())==1) {
			res = 1;
		}else if(fecha.compareTo(otra.getFecha())==-1) {
			res = -1;
		}
		return res;
	}
	
	public AlertaAlarma getAlarmaCita() {
		return alarmaCita;
	}

	public void setAlarmaCita(AlertaAlarma alarmaCita) {
		this.alarmaCita = alarmaCita;
	}

	public String getContactosEnCita() {
		return contactosEnCita;
	}

	public void setContactosEnCita(String contactosEnCita) {
		this.contactosEnCita = contactosEnCita;
	}

	@Override
	public String toString() {
		return " ASUNTO  =  " + asunto + "  ,  DESCRIPCION  =  " +  descripcion +  "  , FECHA  =  " + fecha + "  ,  LUGAR  =  " + lugar ;
	}

	
}
