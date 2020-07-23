package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Esta clase es la mas importante por que genera la estructura del mes en el calendario
 * @author Karen Choquecallata Mancilla
 * @version 22/07/2020
 * @see < a href = "https://github.com/JhosepTinta/TallerDeProgramacion">Enlace repositorio</a>
 */
public class CalendarioMensual {
	// campos de clase
    Calendar calendar;
    int contador;
    int mes,anio;
	/**
	 * Constructor de la clase
	 * @param mes mes que se generara
	 * @param anio anio del mes que se generara
	 */
    public CalendarioMensual(int mes , int anio) {
	    this.mes = mes ;
	    this.anio = anio;
		calendar = new GregorianCalendar(anio,mes,1);
	}
    //cierre del constructor
    
    /**
     * 
     * @return un array generalmente de ordenado, contiene un cero como espacio del mes anterio o posterior
     */
	public Integer[] generarMes() {
		/**
		 * Metodo que genera el mes que se desea con sus espacios como ceros
		 */
		int diaInicio = calendar.get(Calendar.DAY_OF_WEEK)-2;
    	int ultimoDia = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	contador = 1;
    	if(diaInicio == -1) {
			diaInicio = 6;
		}
    	Integer[] a = new Integer[42];
    	for(int i = 0;i < a.length; i++) {
    		
    		if(diaInicio != 0) {
    			a[i] = 0;
    			diaInicio--;
    		}else {
    			if(contador < ultimoDia + 1) {
    		      a[i] = contador;
    		      contador++;
    		     }else {
    		    	 
    		    	 a[i] = 0;
    		     }
    		}
    	}
  
    	return a;
    	
    }
	// cierre metodo
	/**
	 * 
	 * @return mes
	 */
	public int getMes() {
		return mes;
	}
	
	/**
	 * 
	 * @param mes numero del mes set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * 
	 * @return el año con el que ha sido creado la instancia
	 */
	public int getAnio() {
		return anio;
	}
	
	/**
	 * 
	 * @param anio que se desea cambiar 
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
// cierre de la clase 