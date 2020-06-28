package modelo;

import java.io.Serializable;
import java.util.*;

public class Fecha implements Serializable{
    
    private int dia;
    private int mes;
    private int a�o;
    private Calendar fechaActual = new GregorianCalendar();

    public Fecha(int dia, int mes, int a�o){
        this.a�o = a�o;
        this.mes = mes;
        this.dia = dia;
    }
    
    public Fecha(String fecha) {
    	int d = 0;
		int m = 0;
		int a= 0;
		boolean bandera1 = false;
		boolean bandera2 = false;
		String numero = "";
		
		for(int i=0; i<fecha.length(); i++) {
			char aux = fecha.charAt(i);
			if(aux != '/') {
				numero +=aux;
				
			}else {
				if(!bandera1) {
					d = Integer.parseInt(numero);
					bandera1 = true;
				}
				else if(!bandera2) {
					m = Integer.parseInt(numero);
					bandera2 = true;
				}
				numero = "";
			}
			if(i == fecha.length()-1) {
				a = Integer.parseInt(numero);
			}
		}
		
		dia = d;
		mes = m;
		a�o = a;
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
    	String diaM = ""+dia;
		String mesM = ""+mes;
		String a�oM = ""+a�o;
		
		if(diaM.length() == 1) { diaM = "0"+dia;}else if(diaM.length() > 2) {diaM = "00";}
		if(mesM.length() == 1) { mesM = "0"+mes;}else if(mesM.length() > 2) {mesM = "00";}
		if(a�oM.length() !=  4) { a�oM = ""+fechaActual.get(Calendar.YEAR);}
        return diaM+"  /  "+mesM+"  /  "+a�oM;
    }
}