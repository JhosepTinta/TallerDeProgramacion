package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.*;

public class ControladorAgenda {
	private Agenda agendaControlada;
	// private VistaAgenda agendaVista;

	public ControladorAgenda(Agenda agendaControlada) {
		this.agendaControlada = agendaControlada;
	}

	public void guardarDatosAgenda() {
		try {
			System.out.println("Guardando lista en el fichero objetos.dat");
			ObjectOutputStream escribiendo = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\IBM LENOVO\\Desktop\\datos generados\\datosAgenda.dat"));
			escribiendo.writeObject(agendaControlada);
			escribiendo.close();
		} catch (Exception e) {
			System.out.println(e.getMessage()+"ocurrio algo");
		}
	}

	public Agenda leerDatosGuardadosAgenda() {
		Agenda datosRecogidos = null;
		try {

			System.out.println("Leyendo lista en el fichero datosAgenda.dat");
			ObjectInputStream leendo = new ObjectInputStream(
					new FileInputStream("C:\\Users\\IBM LENOVO\\Desktop\\datos generados\\datosAgenda.dat"));
			datosRecogidos = (Agenda) leendo.readObject();
			leendo.close();
			System.out.println("Se a leido los datos guardados");

		} catch (Exception e) {
			System.out.println("No se encontro el archivo datosAgenda.dat");
			System.out.println(e.getMessage());
		}
		return datosRecogidos;
	}

	public Agenda getAgendaControlada() {
		return agendaControlada;
	}

	public void setAgendaControlada(Agenda agendaControlada) {
		this.agendaControlada = agendaControlada;
	}
	
}
