package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import paquete1.*;



public class VistaCalendarioMensual extends JPanel {
    CalendarioMensual aux;
	JButton back;
	JButton next;
	public VistaCalendarioMensual(CalendarioMensual aux) {
    this.aux = aux;		
    back = new JButton("<");
    next = new JButton(">");
	setLayout(new BorderLayout());	
       LaminaMes mes= new LaminaMes(aux);
       int month = aux.getMes();
       int anio = aux.getAnio();
       CabeceraMes cabecera= new CabeceraMes(month,anio);
       add(cabecera,BorderLayout.NORTH);
       add(mes,BorderLayout.CENTER);
       
     //  add(next,BorderLayout.EAST);
       //add(back,BorderLayout.WEST);
      

	}

	private class LaminaMes extends JPanel{
		Agenda agenda ;
		Integer[] arrayMes;
	
		CalendarioMensual calendario;
		int contador;
	
	    LaminaObjeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,b1,b2,b3,b4,b5,b6;
		
		public LaminaMes(CalendarioMensual calendario) {
			
			this.calendario = calendario;
			setLayout(new GridLayout(6,7,5,5));
			contador = 0;
			
			pedirArrayMes();
			inicializarDia(a);
			inicializarDia(b);
			inicializarDia(c);
			inicializarDia(d);
			inicializarDia(e);
			inicializarDia(f);
			inicializarDia(g);
			inicializarDia(h);
			inicializarDia(i);
			inicializarDia(j);
			inicializarDia(k);
			inicializarDia(l);
			inicializarDia(m);
			inicializarDia(n);
			inicializarDia(o);
			inicializarDia(p);
			inicializarDia(q);
			inicializarDia(r);
			inicializarDia(s);
			inicializarDia(t);
			inicializarDia(u);
			inicializarDia(v);
			inicializarDia(w);
			inicializarDia(x);
			inicializarDia(y);
			inicializarDia(z);
			inicializarDia(a1);
			inicializarDia(a2);
			inicializarDia(a3);
			inicializarDia(a4);
			inicializarDia(a5);
			inicializarDia(a6);
			inicializarDia(a7);
			inicializarDia(a8);
			inicializarDia(a9);
			inicializarDia(a0);
			inicializarDia(b1);
			inicializarDia(b2);
			inicializarDia(b3);
			inicializarDia(b4);
			inicializarDia(b5);
			
			
			
			
			
		}
		
       public void inicializarDia(LaminaObjeto objeto) {
			if(arrayMes[contador]== 0) {
				String numeroVacio = " ";
				objeto = new LaminaObjeto(numeroVacio);
				contador++;
			}else {
			objeto = new LaminaObjeto(""+ arrayMes[contador]);
			contador++;
			
			}
			add(objeto);
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
		String numeroDia;
		
		JButton numero,cita1,cita2;
		
		public LaminaObjeto(String numeroDia) {
			
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

		public String getNumeroDia() {
			return numeroDia;
		}

		public void setNumeroDia(String numeroDia) {
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
//esta clase crea la parte de los dias en el calendario y pone el nombre del mes al calendario
class CabeceraMes extends JPanel{
	 String mes;
	public CabeceraMes(int month, int year) {
		JPanel encabezado = new JPanel(new GridLayout(1,7,5,5));
		JButton a1 = new JButton("   LU    ");
		JButton a2 = new JButton("   MA    ");
		JButton a3 = new JButton("   MI    ");
		JButton a4 = new JButton("   JU    ");
		JButton a5 = new JButton("   VI    ");
		JButton a6 = new JButton("   SA    ");
		JButton a7 = new JButton("   DO    ");
		JPanel todo = new JPanel();
		BoxLayout nuevo = new BoxLayout(todo, BoxLayout.Y_AXIS);
		todo.setLayout(nuevo);
	    mes = nombrarMes(month);
	    JLabel tituloMes = new JLabel(mes);
	    JLabel tituloanio= new JLabel("     " + year+"    ");
	   
		encabezado.add(a1);
		encabezado.add(a2);
		encabezado.add(a3);
		encabezado.add(a4);
		encabezado.add(a5);
		encabezado.add(a6);
		encabezado.add(a7);
		 todo.add(tituloanio);
		   todo.add(tituloMes);
		    todo.add(encabezado);
		add(todo);
		
		
	}
	//  este metodo de devuelve el nombre del mes depende al int que ingreses
	 public String nombrarMes (int month) {
			String res = "";
			
		    switch (month) {
			case 0:
				res = "ENERO";
				break;
			case 1:
				res = "FEBRERO";
				break;
			case 2:
				res = "MARZO";
				break;
			case 3:
				res = "ABRIL";
				break;
			case 4:
				res = "MAYO";
				break;
			case 5:
				res = "JUNIO";
				break;
			case 6:
				res = "JULIO";
				break;
			case 7:
				res = "AGOSTO";
				break;
			case 8:
				res = "SEPTIEMBRE";
				break;
			case 9:
				res = "OCTUBRE";
				break;
			case 10:
				res = "NOVIEMBRE";
				break;
			case 11:
				res = "DICIEMBRE";
				break;
			
			default:
				break;
			}
			
			return res;
			
		}
}
