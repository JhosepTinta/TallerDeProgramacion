package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lineales.ListaSE;
import modelo.*;
import vista.VistaPrincipal;
/**
 * Explicacion: esta clase es como un controlador de los componenetes calendario y lista hora por que 
 * relaciona a ambos y  gestiona las acciones principales
 * @author Karen Choquecallata Mancilla
 *
 */
public class Navegacion extends JPanel {
       
	   VistaCalendarioCompleto completo;
      
       public VistaDiariaCompleto diaria;
       JScrollPane contenedorDePaneles;
       JButton botonmensual,botondiario;
       ListaSE<Cita> citashoy;
	   Calendar calendar;
	   int day, mes, year;
	   Agenda agenda;
	   CalendarioMensual calen;
	   JPanel estado;
       
       public Navegacion(Agenda agenda, CalendarioMensual calen) {
		
		this.agenda = agenda;
		this.calen  = calen;
		estado      = completo;
		setLayout(new BorderLayout());
		
		calendar    = new GregorianCalendar();
		day         = calendar.get(Calendar.DAY_OF_MONTH);
		mes         = calendar.get(Calendar.MONTH);
		year        = calendar.get(Calendar.YEAR);
		contenedorDePaneles = new JScrollPane();
		contenedorDePaneles.setBorder(null);
		completo    = new VistaCalendarioCompleto(calen,agenda);
		diaria      = new VistaDiariaCompleto(agenda,day-1,mes,year);
		Box box     = Box.createHorizontalBox();
		// --------
	    botonmensual = new JButton();
	    botonmensual.setBorder(null);
	    botonmensual.setBackground(Color.WHITE);
	    botonmensual.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioMensual1.png")));
	    botonmensual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				botonmensual.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioMensual2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				botonmensual.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioMensual1.png")));//
			}
			
		});
	    //----------
	    botondiario = new JButton();
	    botondiario.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioDiaria1.png")));
	    botondiario.setBorder(null);
	    botondiario.setBackground(Color.WHITE);
	    botondiario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				botondiario.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioDiaria2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				botondiario.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioDiaria1.png")));//
			}
			
		});
		//--------
	    botonmensual.addActionListener(new AccionBoton());
		botondiario.addActionListener(new AccionBoton());
		setBackground(Color.WHITE);
		box.add(botonmensual);
		box.add(botondiario);
		
		contenedorDePaneles.setAutoscrolls(false);
		definirPanel(completo);
		add(box, BorderLayout.NORTH);
		
		add(contenedorDePaneles, BorderLayout.CENTER);
		
	

	} 
       
	public void setEstado() {
		estado = completo;
	} 
	
	public void arrancarDia(Agenda modelo) {
		estado      = completo;
		this.diaria = new VistaDiariaCompleto(modelo, day, mes, year);
	}   
    /**
     * Este metodo define el panel acutal, asi gestionando la interaccion de los paneles 
     * con los botones
     * @param panel
     */
	public void definirPanel(JPanel panel) {
		contenedorDePaneles.setViewportView(panel);
	}
	/**
	 * Esta clase es la encargada de dar accion a los botones (mensual) y (diaria)
	 * @author KarenChoquecallataMancilla
	 *
	 */
	private class AccionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(botonmensual)) {
				   estado = completo;
				   definirPanel(completo);
			}else {
				if(e.getSource().equals(botondiario)) {
				   VistaDiariaCompleto nuevo = new VistaDiariaCompleto(agenda,day-1,mes,year);
				  
				   if(estado == completo ) {
					   nuevo.next.doClick();;
				   }
				   estado = diaria;
				   definirPanel(nuevo);	
				}	
			}
		} 
	 }		
}
