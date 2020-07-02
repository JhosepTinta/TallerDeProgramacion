package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarioMensual {
    Calendar calendar;
    int contador;
    int mes;
    int anio;
	
    public CalendarioMensual(int mes , int anio) {
	    this.mes = mes ;
	    this.anio = anio;
		calendar= new GregorianCalendar(anio,mes,1);
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
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
