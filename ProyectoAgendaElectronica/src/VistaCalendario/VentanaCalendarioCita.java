package VistaCalendario;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import modelo.CalendarioMensual;

public class VentanaCalendarioCita extends JFrame {
     Calendar calendar;
     int mes ;
     int anio;
     public VistaCalendarioCompletoCita calen;
	public VentanaCalendarioCita() {
		calendar = new GregorianCalendar();
		mes = calendar.get(Calendar.MONTH);
		anio = calendar.get(Calendar.YEAR);
	    calen = new VistaCalendarioCompletoCita(new CalendarioMensual(mes,anio));
		setBounds(822,375,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(calen);
	}

}
