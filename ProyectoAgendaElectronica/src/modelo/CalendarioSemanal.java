package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarioSemanal {
	 
	int semana;
    
	Calendar calendar;
	
	Calendar aux;
	
	Calendar aux2;
    
	int dia;
	
	int month;
	
	int year;
	
	boolean hecho ;
	
	boolean hecho2;
	
	public CalendarioSemanal(int year, int month, int dia) {
		
		this.year = year;
		
		this.month = month;
	
		this.dia= dia;
		
		boolean hecho = false;
		
		calendar = new GregorianCalendar(year, month,dia);
		
		aux = new GregorianCalendar(year, month,1);
		
		aux2 = new GregorianCalendar(year, month-1,dia);
		
	}
	
	/*public static void main(String args[]) {
		 
		 CalendarioSemanal prueba= new CalendarioSemanal(2020,9,30);
		 
		 prueba.generarSemana();
	 }
	*/
	public Integer[] generarSemana() {
		
		Integer[]a;//Array para llenar 
		
		a = new Integer[7];
		
	    int diassemanas = calendar.get(Calendar.DAY_OF_WEEK); // dia de la semana de la fecha que queremos 
	   	
	    int diasvacios = diassemanas-2;// dias vacios de cualquier pecha que quedramos
	   
        if(diasvacios == -1) {
			
			diasvacios = 6;
		}
	    
       // pone a la fecha de un lunes de la semana que queremos
        int diasupuesto = dia -diasvacios;
	   
        int diasemana= aux.get(Calendar.DAY_OF_WEEK);// para caso especial de primeros dias , saber cuantos dias vacios del anterior mes
		
        int diasvacio= diasemana-2; 
        
		if(diasupuesto < 0 && diasvacios > 0 ) {// caso especial
			
			//month = month-1;
			
			int maximoAnterior = aux2.getActualMaximum(Calendar.DAY_OF_MONTH);	
			
			int diasres = maximoAnterior + (dia) - diasvacios;
			
			for(int i=0 ; i<a.length;i++) {
				
				if(diasres == maximoAnterior+1) {
					
					diasres = 1;
				
					a[i]= diasres;
					
					
				}
				
					a[i]=diasres;
				
				    diasres++;
				
				System.out.println(a[i]);
				
			}
			
			hecho = true;
			
		
		}
		
		
		 
		
		if(hecho == false) {//caso de cualquier dia del mes
			 dia = dia-diasvacios;
			
			int maximothis = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) ;
			 
		    for(int i = 0; i< a.length;i++) {
			   if(dia == maximothis+1 ) {
				   dia =1;
				  
				   a[i] = dia;
				   
				  
				  
			   }
		    	a[i]= dia;
			
		    	dia++;
			
		    	System.out.println(a[i]);
		    	
		}
		   
		}
		
		
		return a;
	}

}
