package controlador;

import VistaCalendario.*;
import modelo.*;

public class ControladorCalendario {
      Agenda agenda;
      VistaCalendarioCompleto calendariocom;
      VistaSemanal semanal;
      VistaDiaria diaria;
      CalendarioMensual modelomes;
	public ControladorCalendario(Agenda agenda,CalendarioMensual modelomes ) {
		this.agenda= agenda;
		this.modelomes = modelomes;
		calendariocom= new VistaCalendarioCompleto(modelomes,agenda);
	}

}
