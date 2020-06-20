package vista;

import java.awt.BorderLayout;

import javax.swing.*;

import modelo.Agenda;
import modelo.CalendarioMensual;
import vistaAgenda.VistaAgendaPrueba;

public class VistaPrincipal extends JFrame {
	
	

	public VistaPrincipal() {
		
		
		LaminaPrincipal laminaprincipal = new LaminaPrincipal();
		setSize(950, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    add(laminaprincipal);
	}
    
	private class LaminaPrincipal extends JPanel{
    	LaminaDeBotones laminaBotones;
    	VistaCalendarioMensual calendario;
    	Agenda agenda ;
    	public LaminaPrincipal() {
    		CalendarioMensual calendarioMensual= new CalendarioMensual(5,2020);
    		agenda = new Agenda();
    		setLayout(new BorderLayout());
    	    laminaBotones= new LaminaDeBotones();
    	    calendario = new VistaCalendarioMensual(calendarioMensual,agenda);
    		add(laminaBotones,BorderLayout.WEST);
    		//add(calendario,BorderLayout.CENTER);
    		add(new VistaAgendaPrueba());
    		
    	}
    	
    public class LaminaDeBotones extends JPanel{
    	JButton inicio;
    	JButton contactos;
    	JButton alarma;
    	JButton memo;
    	JButton agenda;
    	JButton tareasPendientes;
    	public LaminaDeBotones() {
    		inicio  =          new JButton("     Inicio                     ");
    	    contactos =        new JButton("     Contactos            ");
    	    alarma =           new JButton("     Alarma                  ");
    	    memo =             new JButton("     Memo                    ");
    	    agenda =           new JButton("     Agenda                 ");
    	    tareasPendientes = new JButton("Tareas Pendientes ");
    	    contactos.setSize(900, 30);
    	    alarma.setSize(100, 30);
    	    memo.setSize(100, 30);
    	    agenda.setSize(100, 30);
    	    tareasPendientes.setSize(100, 30);
    		BoxLayout nuevo = new BoxLayout(this, BoxLayout.Y_AXIS);
    		setLayout(nuevo);
    		add(inicio);
    		add(contactos);
    		add(alarma);
    		add(memo);
    		add(agenda);
    		add(tareasPendientes);
    		
    	}
    	
    }	
    	
    	
    	
    }
	

}
