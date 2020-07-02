package modelo;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import modelo.AlertaAlarma;
import modelo.Memo;

public class TareaPendiente {
	
    private String tarea;
    private Date fechalimite;
    private String categoria;
    private AlertaAlarma notificacion;
    private boolean realizado;
    private ArrayList<Memo> listamemo;
    

	public TareaPendiente(String tarea, Date fechalimite,  String categoria) {
		super();
		this.tarea = tarea;
		this.fechalimite = fechalimite;
		this.categoria = categoria;

	}


	public String getTarea() {
		return tarea;
	}


	public void setTarea(String tarea) {
		this.tarea = tarea;
	}


	public Date getFechalimite() {
		return fechalimite;
	}


	public void setFechalimite(Date fechalimite) {
		this.fechalimite = fechalimite;
	}



	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public AlertaAlarma getNotificacion() {
		return notificacion;
	}


	public void setNotificacion(AlertaAlarma notificacion) {
		this.notificacion = notificacion;
	}


	public ArrayList<Memo> getListamemo() {
		return listamemo;
	}


	public void setListamemo(ArrayList<Memo> listamemo) {
		this.listamemo = listamemo;
	}

// emplementaciones neceserias de tarea pendiente
	
	public int compareTo(TareaPendiente otra) {
		int res = 2;
		if(fechalimite.compareTo(otra.getFechalimite()) == 0) {
				
					res = 0;
				
		}else if(fechalimite.compareTo(otra.getFechalimite())==1) {
			res = 1;
		}else if(fechalimite.compareTo(otra.getFechalimite())==-1) {
			res = -1;
		}
		return res;
	}
	

	@Override
	public String toString() {
		return "TareaPendiente [tarea=" + tarea + ", fechalimite=" + fechalimite + ", categoria=" + categoria + ", realizado=" + realizado + "]";
	}
	
	
}
