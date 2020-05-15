package modelo;

import java.util.*;

public class Fecha {
    
    private int dia;
    private int mes;
    private int a�o;
    private Calendar fechaActual = new GregorianCalendar();

    public Fecha(int dia, int mes, int a�o){
        this.a�o = a�o;
        this.mes = mes;
        this.dia = dia;
    }

    public Fecha(){
        dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        mes = fechaActual.get(Calendar.MONTH);
        a�o = fechaActual.get(Calendar.YEAR);
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getA�o(){
        return a�o;
    }

    public void setDia(int d){
        dia = d;
    }

    public void setMes(int d){
        mes = d;
    }

    public void setA�o(int d){
        a�o = d;
    }
 
    public Fecha getFechaActual(){
        return new Fecha();
    }
    
    public int compareTo(Fecha otra) {
    	int res = 0;
    	
    	if(a�o == otra.getA�o()) {
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
    	}else if(a�o > otra.getA�o()) {
    		res = 1;
    	}else if(a�o < otra.getA�o()) {
    		res = -1;
    	}
    	
    	return res;
    }

    public String toString(){
        return dia+"/"+mes+"/"+a�o;
    }
}