package modelo;

import noLineales.*;

import java.io.Serializable;

import lineales.*;

public class Agenda implements Serializable {
	private ArbolBB<Cita> listaCita;

	public Agenda() {
		listaCita = new ArbolBB<Cita>();
	}

	public void agregarCita(Cita otra) {
		listaCita.insertar(otra);
	}

	public String mostrar() {
		return toString();
	}

	public ArbolBB<Cita> getLista() {
		return listaCita;
	}

	public boolean eliminatCita(Cita otra) {
		Cita aux = listaCita.eliminar(otra);
		return aux != null ? false : true;
	}

	public ListaSE<Cita> buscarHora(Reloj hora) {
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for (int i = 0; i < citasCompletas.longitud(); i++) {
			Cita aux = citasCompletas.acceder(i);
			if (aux.getHoraInicio().compareTo(hora) == 0) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}

	public ListaSE<Cita> buscarFecha(Fecha fechaElegida) {
		return darCitasPorEstado(0,fechaElegida);
	}

	public ListaSE<Cita> buscarCitasHoy() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(0,fechaHoy);
	}

	public ListaSE<Cita> buscarLugarAsunto(String lugar, String asunto) {
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for(int i=0; i<citasCompletas.longitud();i++) {
			Cita aux = citasCompletas.acceder(i);
			if(buscarPalabra(aux.getLugar(),lugar) || buscarPalabra(aux.getAsunto(),asunto)) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}

	public ListaSE<Cita> darCitasPrevias() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(1,fechaHoy);
	}

	public ListaSE<Cita> darCitasVencidas() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(-1,fechaHoy);
	}
	
	private ListaSE<Cita> darCitasPorEstado(int estado,Fecha fecha){
		Fecha fechaElegida = fecha;
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for (int i = 0; i < citasCompletas.longitud(); i++) {
			Cita aux = citasCompletas.acceder(i);
			if (aux.getFecha().compareTo(fechaElegida) == estado) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}
	
	private boolean buscarPalabra(String frase,String palabra) {
		boolean encontrado = false;
		int i = 0;
		int c = 0;
		while(i<frase.length() && !encontrado) {
			char letraFrase = frase.charAt(i);
			if(letraFrase == palabra.charAt(c)) {
				c++;
				encontrado = c == palabra.length()?true:false;
				
			}else {
				c = 0;
			}
			i++;
		}
		return encontrado;
	}
	
	public String toString() {
		return listaCita.inOrden().toString();
	}
}
