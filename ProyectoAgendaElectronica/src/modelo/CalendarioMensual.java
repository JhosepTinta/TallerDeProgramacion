package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarioMensual {
    Calendar calendar;
    int contador;
	
    public CalendarioMensual(int mes , int anio) {
	
		calendar= new GregorianCalendar(anio,mes,1);
	}
    public static void main(String args[]) {
    	CalendarioMensual prueba= new CalendarioMensual(6,2020);
    	Integer[] a = prueba.generarMes();
    	
    	for(int i= 0;i<a.length;i++) {
    		 
    		System.out.println(a[i]);
    		
    	}
    	System.out.println(a[1]);
    }
   
	public Integer[] generarMes() {
		int diaInicio= calendar.get(Calendar.DAY_OF_WEEK)-2;
    	int ultimoDia =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	contador = 1;
    	if(diaInicio == -1) {
			diaInicio =6;
		}
    	Integer[] a= new Integer[41];
    	for(int i = 0;i<a.length;i++) {
    		
    		if(diaInicio != 0) {
    			a[i]= 0;
    			diaInicio--;
    		}else {
    			if(contador < ultimoDia+1) {
    		      a[i]=contador;
    		      contador++;
    		     }else {
    		    	 
    		    	 a[i]=0;
    		     }
    		}
    	}
  
    	return a;
    	
    }
}
