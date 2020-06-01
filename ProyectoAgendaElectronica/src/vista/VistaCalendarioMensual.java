package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import modelo.*;

public class VistaCalendarioMensual extends JPanel {
    CalendarioMensual aux;
	
	public VistaCalendarioMensual(CalendarioMensual aux) {
    this.aux = aux;		
	setLayout(new BorderLayout());	
       LaminaMes mes= new LaminaMes(aux);
       add(mes,BorderLayout.CENTER);
       

	}

	private class LaminaMes extends JPanel{
		Agenda agenda ;
		Integer[] arrayMes;
		LaminaObjeto[] objetos;
		CalendarioMensual calendario;
		int contador;
		int contadoraux;
	    LaminaObjeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,b1,b2,b3,b4,b5,b6;
		
		public LaminaMes(CalendarioMensual calendario) {
			
			this.calendario = calendario;
			setLayout(new GridLayout(6,7,10,10));
			contador = 0;
			
			pedirArrayMes();
			
			LaminaObjeto a = new LaminaObjeto(arrayMes[0]);
			LaminaObjeto b = new LaminaObjeto(arrayMes[1]);
			LaminaObjeto c = new LaminaObjeto(arrayMes[2]);
			LaminaObjeto d = new LaminaObjeto(arrayMes[3]);
			LaminaObjeto e = new LaminaObjeto(arrayMes[4]);
			LaminaObjeto f = new LaminaObjeto(arrayMes[5]);
			LaminaObjeto g = new LaminaObjeto(arrayMes[6]);
			LaminaObjeto h = new LaminaObjeto(arrayMes[7]);
			LaminaObjeto i = new LaminaObjeto(arrayMes[8]);
			LaminaObjeto j = new LaminaObjeto(arrayMes[9]);
			LaminaObjeto k = new LaminaObjeto(arrayMes[10]);
			LaminaObjeto l = new LaminaObjeto(arrayMes[11]);
			LaminaObjeto m = new LaminaObjeto(arrayMes[12]);
			LaminaObjeto n = new LaminaObjeto(arrayMes[13]);
			LaminaObjeto o = new LaminaObjeto(arrayMes[14]);
			LaminaObjeto p = new LaminaObjeto(arrayMes[15]);
			LaminaObjeto q = new LaminaObjeto(arrayMes[16]);
			LaminaObjeto r = new LaminaObjeto(arrayMes[17]);
			LaminaObjeto s = new LaminaObjeto(arrayMes[18]);
			LaminaObjeto t = new LaminaObjeto(arrayMes[19]);
			LaminaObjeto u = new LaminaObjeto(arrayMes[20]);
			LaminaObjeto v = new LaminaObjeto(arrayMes[21]);
			LaminaObjeto w = new LaminaObjeto(arrayMes[22]);
			LaminaObjeto x = new LaminaObjeto(arrayMes[23]);
			LaminaObjeto y = new LaminaObjeto(arrayMes[24]);
			LaminaObjeto z = new LaminaObjeto(arrayMes[25]);
			LaminaObjeto a1 = new LaminaObjeto(arrayMes[26]);
			LaminaObjeto a2 = new LaminaObjeto(arrayMes[27]);
			LaminaObjeto a3 = new LaminaObjeto(arrayMes[28]);
			LaminaObjeto a4 = new LaminaObjeto(arrayMes[29]);
			LaminaObjeto a5 = new LaminaObjeto(arrayMes[30]);
			LaminaObjeto a6 = new LaminaObjeto(arrayMes[31]);
			LaminaObjeto a7 = new LaminaObjeto(arrayMes[32]);
			LaminaObjeto a8 = new LaminaObjeto(arrayMes[33]);
			LaminaObjeto a9 = new LaminaObjeto(arrayMes[34]);
			LaminaObjeto a0= new LaminaObjeto(arrayMes[35]);
			LaminaObjeto b1 = new LaminaObjeto(arrayMes[36]);
			LaminaObjeto b2= new LaminaObjeto(arrayMes[37]);
			LaminaObjeto b3= new LaminaObjeto(arrayMes[38]);
			LaminaObjeto b4 = new LaminaObjeto(arrayMes[39]);
			LaminaObjeto b5= new LaminaObjeto(arrayMes[40]);
			//LaminaObjeto b6 = new LaminaObjeto(arrayMes[41]);
		
			
			
		
			inicializarLaminaObjeto (a);
			inicializarLaminaObjeto (b);
			inicializarLaminaObjeto (c);
			inicializarLaminaObjeto (d);
			inicializarLaminaObjeto (e);
			inicializarLaminaObjeto (f);
			inicializarLaminaObjeto (g);
			inicializarLaminaObjeto (h);
			inicializarLaminaObjeto (i);
			inicializarLaminaObjeto (j);
			
			inicializarLaminaObjeto (k);
			inicializarLaminaObjeto (l);
			inicializarLaminaObjeto (m);
			inicializarLaminaObjeto (n);
			inicializarLaminaObjeto (o);
			inicializarLaminaObjeto (p);
			inicializarLaminaObjeto (q);
			inicializarLaminaObjeto (r);
			inicializarLaminaObjeto (s);
			inicializarLaminaObjeto (t);
			
			inicializarLaminaObjeto (u);
			inicializarLaminaObjeto (w);
			inicializarLaminaObjeto (v);
			inicializarLaminaObjeto (x);
			inicializarLaminaObjeto (y);
			inicializarLaminaObjeto (z);
			inicializarLaminaObjeto (a1);
			inicializarLaminaObjeto (a2);
			inicializarLaminaObjeto (a3);
			inicializarLaminaObjeto (a4);
			
			inicializarLaminaObjeto (a5);
			inicializarLaminaObjeto (a6);
			inicializarLaminaObjeto (a7);
			inicializarLaminaObjeto (a8);
			inicializarLaminaObjeto (a9);
			inicializarLaminaObjeto (a0);
			inicializarLaminaObjeto (b1);
			inicializarLaminaObjeto (b2);
			inicializarLaminaObjeto (b3);
			inicializarLaminaObjeto (b4);
			
			inicializarLaminaObjeto (b5);
			inicializarLaminaObjeto (b6);
			
			
		}
		public void llenarArray(LaminaObjeto objeto) {
			if(contador != objetos.length ) 
			{objetos[contador]= objeto;
			contador++;
			}
		}
		public void inicializar() {
			for(int i = 0; i<= arrayMes.length;i++) {
				
				LaminaObjeto aux= objetos[i];
				aux.setNumeroDia(arrayMes[i]);
                add(objetos[i]);
			}
			
		}
		public void inicializarLaminaObjeto(LaminaObjeto objeto) {
			
				add(objeto);
		}

		public void pedirArrayMes() {
			arrayMes = calendario.generarMes();
		}
		
		
	}
	
	private class LaminaObjeto extends JPanel{
		
		ObjetoDiaCitas objeto;
		int numeroDia;
		
		JButton numero,cita1,cita2;
		
		public LaminaObjeto(int numeroDia) {
			
			this.numeroDia = numeroDia;
			numero = new JButton("   "+numeroDia+"   ");
			cita1 = new JButton();
			cita2 = new JButton();
		
			
			Box box = Box.createVerticalBox();
			
			box.add(numero);
			box.add(cita1);
			box.add(cita2);
			add(box);
			
		}

		public ObjetoDiaCitas getObjeto() {
			return objeto;
		}

		public int getNumeroDia() {
			return numeroDia;
		}

		public void setNumeroDia(int numeroDia) {
			this.numeroDia = numeroDia;
		}

		public void setObjeto(ObjetoDiaCitas objeto) {
			this.objeto = objeto;
		}

		public JButton getNumero() {
			return numero;
		}

		public void setNumero(JButton numero) {
			this.numero = numero;
		}

		public JButton getCita1() {
			return cita1;
		}

		public void setCita1(JButton cita1) {
			this.cita1 = cita1;
		}

		public JButton getCita2() {
			return cita2;
		}

		public void setCita2(JButton cita2) {
			this.cita2 = cita2;
		}
		
	}


	
	
}
