package modelo;

import lineales.ListaSE;

import modelo.*;
import noLineales.*;
/**
 * Esta clase contien el objeto que ira en el calendario como una cajita con su fecha 
 * @author Karen Choquecallta Mancilla
 *
 */
public class ObjetoDiaCitas {
    int dia;
    Cita cita1;
    Cita cita2;
    ListaSE<Cita> lista;
    /**
     * 
     * @param dia int 
     * @param cita1 class Cita()
     * @param cita2 class Cita()
     */
	public ObjetoDiaCitas(int dia, Cita cita1, Cita cita2) {
		/**
		 * Constructor de la clase objetoDiaCita
		 */
		lista = new ListaSE<Cita>();
		this.dia = dia;
		this.cita1 = cita1;
		this.cita2 = cita2;
	}
	// Cierre metodo constructor 
   
    /**
     * 
     * @return una lista de simple enlace 
     */
	public ListaSE<Cita> getLista() {
		return lista;
	}
	
	/**
	 * 
	 * @param lista como parametro una listaSE
	 */
	public void setLista(ListaSE<Cita> lista) {
		this.lista = lista;
	}
	
	/**
	 * 
	 * @return dia
	 */
	public int getDia() {
		return dia;
	}
    
	/**
	 * 
	 * @param cambiar el dia 
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}
    
	/**
	 * 
	 * @return la cita 1
	 */
	public Cita getCita1() {
		return cita1;
	}
    
	/**
	 * 
	 * @param cambia la cita 1 
	 */
	public void setCita1(Cita cita1) {
		this.cita1 = cita1;
	}
    /**
     * 
     * @return devuelve la cita2
     */
	public Cita getCita2() {
		return cita2;
	}
    /**
     * 
     * @param cita2 cambia la cita2 
     */
	public void setCita2(Cita cita2) {
		this.cita2 = cita2;
	}
  
}
