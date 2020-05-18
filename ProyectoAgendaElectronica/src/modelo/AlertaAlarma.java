package modelo;

import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AlertaAlarma {
	
	
	Thread t;
	 Object partida = 0;
	
	public void CrearAlarma(final Object hora,final Object min,final Object seg, Object ampm)
	{
	
		
		if(ampm.equals("AM"))
		{
			partida = 0;
		}else {
			
			if(ampm.equals("PM"))
			{
				partida = 1;
			}
			
			
		}
		
		final boolean bandera=true;
		
		  Thread t = new Thread()
				{
			        public void run()
			        {
			        	
			        	while(bandera==true)
			        	{
			        		Calendar c = new GregorianCalendar();
			        		Object horas = c.get(Calendar.HOUR);
			        		Object minutos = c.get(Calendar.MINUTE);
			        		Object segundos = c.get(Calendar.SECOND);
			        		Object partida1 = c.get(Calendar.AM_PM);
			        		
			        		if(hora==horas && min==minutos && seg == segundos && partida==partida1)
			        		{
			        			JOptionPane.showMessageDialog(null, "ALARMA DE TRABAJO");
			        			
			        			System.out.println("trabajo");
			        			break;
			        		}
			        	}
			        }
				};
				
				t.setPriority(Thread.MIN_PRIORITY);
				t.start();
			
		
	}


}
