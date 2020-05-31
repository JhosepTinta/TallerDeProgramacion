package modelo;

import java.io.Serializable;
import java.time.LocalDateTime; 

public class Reloj implements Serializable{
	
	private int hora;
	private int minutos;
	private int segundos;
	
	public Reloj(int hora, int minutos, int segundos) {
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public Reloj() {
		LocalDateTime tiempo= LocalDateTime.now();
    	hora = tiempo.getHour();
    	minutos = tiempo.getMinute();
    	segundos = tiempo.getSecond();
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public Reloj getHoraActual() {
		return new Reloj();
	}
	
	public int compareTo(Reloj otra) {
		int res = 0;
		if(hora == otra.getHora()) {
			if(minutos == otra.getMinutos()) {
				if(segundos == otra.getSegundos()) {
					res = 0;
				}else if(segundos > otra.getSegundos()) {
					res = 1;
				}else if(segundos < otra.getSegundos()) {
					res = -1;
				}
			}else if(minutos > otra.getMinutos()) {
				res = 1;
			}else if(minutos < otra.getMinutos()) {
				res = -1;
			}
		}else if(hora > otra.getHora()) {
			res = 1;
		}else if(hora < otra.getHora()) {
			res = -1;
		}
		return res;
	}
	
	public String toString() {
		
		String horaM = ""+hora;
		String minutosM = ""+minutos;
		String segundosM = ""+segundos;
		
		if(horaM.length() == 0) { horaM = "0"+hora;}
		if(minutosM.length() == 0) { horaM = "0"+minutos;}
		if(segundosM.length() == 0) { horaM = "0"+segundos;}
		
		return horaM + ":" + minutosM + ":" + segundosM;
	}
	
	
}
