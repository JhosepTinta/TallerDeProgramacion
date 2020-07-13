package modelo;

import java.io.Serializable;
import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AlertaAlarma implements Serializable {
	
	

	Thread hilo;
	int partida = 0;
	
	 public void CrearAlarma(final int hora,final int min,final int seg, String ampm)
	{
	   if(cortar(hora)<=2 && cortar(min)<=2 && cortar(seg)<=2) {
		   
		
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
		
		  Thread hilo = new Thread()
				{
			        public void run()
			        {
			        	
			        	while(bandera==true)
			        	{
			        		Calendar c = new GregorianCalendar();
			        		int horas = c.get(Calendar.HOUR);
			        		int minutos = c.get(Calendar.MINUTE);
			        		int segundos = c.get(Calendar.SECOND);
			        		int partida1 = c.get(Calendar.AM_PM);
			        		
			        		if(hora==horas && min==minutos && seg == segundos && partida==partida1)
			        		{ 
			        			
			        			JOptionPane.showMessageDialog(null, "ALARMA DE TRABAJO");
			        			
			        			System.out.println("trabajo");
			        			break;
			        		}
			        		
			        	}
			        }
				};
				
				hilo.setPriority(Thread.MIN_PRIORITY);
				hilo.start();
				
	   }else
	   {
		   JOptionPane.showMessageDialog(null, "error , formato 0;0;0  "+   "!!!corregir¡¡¡");
	   }
				
		
	}
	 

	public int cortar(int  analizar)
	{
		int cantidad = 0;
		int numero = analizar;
	     while(numero > 0)
	     {
	    	numero =  numero/10;
	    	 cantidad ++;
	    	
	     }
	     return cantidad;
	
	}
	
	
	

}
