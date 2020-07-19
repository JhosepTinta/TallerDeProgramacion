package VistaCalendario;

import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import modelo.CalendarioMensual;
import vista.VistaPrincipal;
import vistaAgenda.VistaCrearCita;

public class VentanaCalendarioCita extends JFrame {
     Calendar calendar;
     int mes ;
     int anio;
     public VistaCalendarioCompletoCita calen;

	public VentanaCalendarioCita(VistaCrearCita crearcita) {
		calendar = new GregorianCalendar();
		mes = calendar.get(Calendar.MONTH);
		anio = calendar.get(Calendar.YEAR);
	    calen = new VistaCalendarioCompletoCita(new CalendarioMensual(mes,anio),crearcita);
	    Image icon = new ImageIcon(getClass().getResource("/botones/iconcalendario.png")).getImage();
	    setIconImage(icon);
		setResizable(false);
	
	    setTitle("CALENDARIO");
		setBounds(822,375,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(calen);
	}

}
