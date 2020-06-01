package vista;

import modelo.*;

public class ObjetoDiaCitas {
    int dia;
    Cita cita1;
    Cita cita2;
	public ObjetoDiaCitas(int dia, Cita cita1, Cita cita2) {
		this.dia = dia;
		this.cita1 = cita1;
		this.cita2 = cita2;
	}
    public ObjetoDiaCitas() {
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
