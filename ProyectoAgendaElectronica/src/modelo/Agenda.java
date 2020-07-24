package modelo;

import noLineales.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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

	public void setLista(ArbolBB<Cita> lista) {
		listaCita = lista;
	}

	public int cantidadCitas() {
		return listaCita.inOrden().longitud();
	}

	public boolean eliminarCita(Cita otra) {
		Cita aux = otra != null ? listaCita.eliminar(otra) : null;
		return aux == null ? false : true;
	}

	public ListaSE<Cita> buscarHora(Reloj hora) {
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for (int i = 0; i < citasCompletas.longitud(); i++) {
			Cita aux = citasCompletas.acceder(i);
			if (aux.getHoraInicio().getHora() == hora.getHora()) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}

	public ListaSE<Cita> buscarFecha(Fecha fechaElegida) {
		return darCitasPorEstado(0, fechaElegida);
	}

	public ListaSE<Cita> buscarCitasHoy() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(0, fechaHoy);
	}

	public ListaSE<Cita> buscarHorayFecha(Reloj hora, Fecha fecha) {
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for (int i = 0; i < citasCompletas.longitud(); i++) {
			Cita aux = citasCompletas.acceder(i);
			if (aux.getHoraInicio().compareTo(hora) == 0 && aux.getFecha().compareTo(fecha) == 0) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}

	public ListaSE<Cita> buscarLugarAsunto(String lugar, String asunto) {
		ListaSE<Cita> citasCompletas = (ListaSE) listaCita.inOrden();
		ListaSE<Cita> listaRespuesta = new ListaSE<Cita>();
		for (int i = 0; i < citasCompletas.longitud(); i++) {
			Cita aux = citasCompletas.acceder(i);
			if (buscarPalabra(aux.getLugar(), lugar) || buscarPalabra(aux.getAsunto(), asunto)) {
				listaRespuesta.insertar(aux);
			}
		}
		return listaRespuesta;
	}

	public ListaSE<Cita> darCitasPrevias() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(1, fechaHoy);
	}

	public ListaSE<Cita> darCitasVencidas() {
		Fecha fechaHoy = new Fecha();
		return darCitasPorEstado(-1, fechaHoy);
	}

	private ListaSE<Cita> darCitasPorEstado(int estado, Fecha fecha) {
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

	// metodo que ayuda a encontrar palabras
	private boolean buscarPalabra(String frase, String palabra) {
		boolean encontrado = false;
		int i = 0;
		int c = 0;
		while (i < frase.length() && !encontrado) {
			char letraFrase = frase.charAt(i);
			if (letraFrase == palabra.charAt(c)) {
				c++;
				encontrado = c == palabra.length() ? true : false;

			} else {
				c = 0;
			}
			i++;
		}
		return encontrado;
	}

////////////////////////////////////////////Guardar
////////////////////////////////////////////Datos///////////////////////////////////////////////
	public void guardarDatosAgenda() {
		try {
			ObjectOutputStream escribiendo = new ObjectOutputStream(
					new FileOutputStream("archivos dat\\datosAgenda.dat"));
			escribiendo.writeObject(this);
			escribiendo.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "ocurrio algun error al guardar");
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////// Leer Datos
///////////////////////////////////// Guardados///////////////////////////////////////////////
	public Agenda leerDatosGuardadosAgenda() {
		Agenda datosRecogidos = null;
		try {
			ObjectInputStream leendo = new ObjectInputStream(new FileInputStream("archivos dat\\datosAgenda.dat"));
			datosRecogidos = (Agenda) leendo.readObject();
			leendo.close();
		} catch (Exception e) {
			System.out.println("No se encontro el archivo datosAgenda.dat");
			System.out.println(e.getMessage());
		}
		return datosRecogidos;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////// Validador de Citas para evitar choques de
	//////////////////////////// horarios///////////////////////////////
	public ArrayList<Cita> validarCita(Cita nueva, Fecha fechaNueva, Cita exepcion) {
		ArrayList<Cita> listaDeProblemas = new ArrayList<>();
		ListaSE<Cita> citasParaComparar = buscarFecha(fechaNueva);
		if (exepcion != null) {
			for (int i = 0; i < citasParaComparar.longitud(); i++) {
				Cita aux = citasParaComparar.acceder(i);
				if (nueva.compareTo(aux) == 2) {
					if (aux.compareTo(exepcion) != 0) {
						listaDeProblemas.add(aux);
					}
				}
			}
		} else {
			for (int i = 0; i < citasParaComparar.longitud(); i++) {
				Cita aux = citasParaComparar.acceder(i);
				if (nueva.compareTo(aux) == 2) {
					listaDeProblemas.add(aux);
				}
			}
		}

		return listaDeProblemas;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String toString() {
		return listaCita.inOrden().toString();
	}
}
