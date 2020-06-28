package modelo;

import java.io.Serializable;
import java.time.LocalDateTime; ////hace falta implementar la busca de horas de otros paises

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
	
	public Reloj(String tiempo) {
		int h = 0;
		int m = 0;
		int s = 0;
		boolean bandera1 = false;
		boolean bandera2 = false;
		String numero = "";
		
		for(int i=0; i<tiempo.length(); i++) {
			char aux = tiempo.charAt(i);
			if(aux != ':') {
				numero +=aux;
				
			}else {
				if(!bandera1) {
					h = Integer.parseInt(numero);
					bandera1 = true;
				}
				else if(!bandera2) {
					m = Integer.parseInt(numero);
					bandera2 = true;
				}
				numero = "";
			}
			if(i == tiempo.length()-1) {
				s = Integer.parseInt(numero);
			}
		}
		
		hora = h;
		minutos = m;
		segundos = s;
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
		
		if(horaM.length() == 1) { horaM = "0"+hora;}else if(horaM.length() > 2) {horaM = "00";}
		if(minutosM.length() == 1) { minutosM = "0"+minutos;}else if(minutosM.length() > 2) {minutosM = "00";}
		if(segundosM.length() == 1) { segundosM = "0"+segundos;}else if(segundosM.length() > 2) {segundosM = "00";}
		
		return horaM + "  :  " + minutosM + "  :  " + segundosM;
	}
	
	
}
