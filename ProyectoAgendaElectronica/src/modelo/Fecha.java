package modelo;

import java.util.*;

public class Fecha {
    
    private int dia;
    private int mes;
    private int año;
    private Calendar fechaActual = new GregorianCalendar();

    public Fecha(int dia, int mes, int año){
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public Fecha(){
        dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        mes = fechaActual.get(Calendar.MONTH);
        año = fechaActual.get(Calendar.YEAR);
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAño(){
        return año;
    }

    public void setDia(int d){
        dia = d;
    }

    public void setMes(int d){
        mes = d;
    }

    public void setAño(int d){
        año = d;
    }
 
    public Fecha getFechaActual(){
        return new Fecha();
    }
    
    public int compareTo(Fecha otra) {
    	int res = 0;
    	
    	if(año == otra.getAño()) {
    		if(mes == otra.getMes()) {
    			if(dia == otra.getDia()) {
    				res = 0;
    			}else if(dia > otra.getDia()) {
    				res = 1;
    			}else if(dia < otra.getDia()) {
    				res = -1;
    			}
    		}else if(mes > otra.getMes()) {
    			res = 1;
    		}else if(mes < otra.getMes()) {
    			res = -1;
    		}
    	}else if(año > otra.getAño()) {
    		res = 1;
    	}else if(año < otra.getAño()) {
    		res = -1;
    	}
    	
    	return res;
    }

    public String toString(){
        return dia+"/"+mes+"/"+año;
    }
}