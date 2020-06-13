package modelo;

import lineales.ListaSE;
import modelo.*;
import noLineales.*;
public class ObjetoDiaCitas {
    int dia;
    Cita cita1;
    Cita cita2;
    ListaSE<Cita> lista;
	public ObjetoDiaCitas(int dia, Cita cita1, Cita cita2) {
		lista = new ListaSE<Cita>();
		this.dia = dia;
		this.cita1 = cita1;
		this.cita2 = cita2;
	}
    public ObjetoDiaCitas() {
    	
    	
    }
	

	public ListaSE<Cita> getLista() {
		return lista;
	}
	public void setLista(ListaSE<Cita> lista) {
		this.lista = lista;
	}
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Cita getCita1() {
		return cita1;
	}

	public void setCita1(Cita cita1) {
		this.cita1 = cita1;
	}

	public Cita getCita2() {
		return cita2;
	}

	public void setCita2(Cita cita2) {
		this.cita2 = cita2;
	}
  
}
