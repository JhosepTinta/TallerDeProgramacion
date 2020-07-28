package modelo;

//@autor  Vladimir Orellana Luizaga

import java.io.Serializable;
import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class AlertaAlarma implements Serializable {
	
	//También tenemos los atributos y estamos utilizando los hilo que los nos facilita la arte para crear la clase AlertaAlarma.	

	Thread hilo;
	int partida = 0;
	//Aquí tenemos un método que los permite recibir como parámetro los que seria la hora, minutos, segundos y también si es AM o PM.
	
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
			        			//En esta parte es cuando la hora si cumple y te muestra un mensaje.
			        			
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
		   //En esta parte estamos diciendo si tiene la hora el formato establecido se va mandar un error.
		   
		   JOptionPane.showMessageDialog(null, "error , formato 0;0;0  "+   "!!!corregirÂ¡Â¡Â¡");
	   }
				
		
	}
	 
 //Como este método estamos permitiendo a que el programa solo deje 
 //ingresar dos dígitos y te devuelve esos dígitos si ve que es mayor no permite ingresar el codigo.
	 
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
