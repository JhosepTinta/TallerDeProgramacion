package vista;

import java.awt.*;

import javax.swing.*;

import modelo.Agenda;
import modelo.CalendarioMensual;
import modelo.Fecha;

public class VistaCalendarioCompleto extends JPanel{
  
	VistaCalendarioMensual vistaCalendario;
	Agenda agenda;
	CalendarioMensual calendario;
	LaminaNavegacion navegacion;
    public VistaCalendarioCompleto(CalendarioMensual calendario,Agenda agenda) {
    	this.agenda = agenda;
    	this.calendario = calendario;
		setLayout(new BorderLayout());
		navegacion = new LaminaNavegacion();
		vistaCalendario = new VistaCalendarioMensual(calendario,agenda);
		
		add(vistaCalendario,BorderLayout.CENTER);
		
		add(navegacion,BorderLayout.NORTH);
		
	}
    private class LaminaNavegacion extends JPanel {
    	public LaminaNavegacion() {
    		JMenuBar modo = new JMenuBar();
    		JMenu nombre = new JMenu("VISTA");
    		JMenuItem mensual = new JMenuItem("Mensual");
    		JMenuItem semanal = new JMenuItem("Semanal");
    		JMenuItem dia = new JMenuItem("Diaria");
    		nombre.add(mensual);
    		nombre.add(semanal);
    		nombre.add(dia);
    		modo.add(nombre);
    		add(modo);
    	}
    	
    	
    }
}
