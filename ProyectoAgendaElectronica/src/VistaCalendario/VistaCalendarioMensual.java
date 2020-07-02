package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lineales.ListaSE;
import modelo.*;

public class VistaCalendarioMensual extends JPanel {
    
	CalendarioMensual aux;
	JButton back;
	JButton next;
	String mesElegido;
	int month;
	int anio;
	public VistaCalendarioMensual(CalendarioMensual aux,Agenda agenda) {
	   
	   month = aux.getMes();
	   anio = aux.getAnio();
	   this.aux = aux;		
       setLayout(new BorderLayout());	
       LaminaMes mes= new LaminaMes(this.aux,agenda);
      
      //Encabezado para el mes
       mesElegido = nombrarMes(month);
	  


       JPanel encabezado = new JPanel(new GridLayout(1,7,5,5));
		JLabel a1 = new JLabel("        LU  ");
		JLabel a2 = new JLabel("        MA  ");
		JLabel a3 = new JLabel("        MI  ");
		JLabel a4 = new JLabel("        JU  ");
		JLabel a5 = new JLabel("        VI  ");
		JLabel a6 = new JLabel("        SA  ");
		JLabel a7 = new JLabel("        DO  ");
		JPanel todo = new JPanel();
		BoxLayout nuevo = new BoxLayout(todo, BoxLayout.Y_AXIS);
	    JButton tituloMes = new JButton(mesElegido);
	    JButton tituloanio= new JButton("     " + anio+"    ");
	    todo.setLayout(nuevo);
	    JPanel contenedorAM = new JPanel();
	    contenedorAM.setLayout(new BorderLayout());
	    JPanel contenedorwest= new JPanel();
	    contenedorwest.add(tituloanio);
	    contenedorwest.add(tituloMes);
	    contenedorAM.add(contenedorwest,BorderLayout.WEST);
	    
		encabezado.add(a1);
		encabezado.add(a2);
		encabezado.add(a3);
		encabezado.add(a4);
		encabezado.add(a5);
		encabezado.add(a6);
		encabezado.add(a7);
		
		todo.add(contenedorAM);
	
		todo.add(encabezado);
		
		add(todo,BorderLayout.NORTH);
	    add(mes,BorderLayout.CENTER);
     

	}
	
     public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
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

	private class LaminaMes extends JPanel{
		Agenda agenda ;
		Integer[] arrayMes;
	    Fecha fecha;
		CalendarioMensual calendario;
		int contador;
	    int anio;
	    int month;
	  
	    LaminaObjeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,b1,b2,b3,b4,b5,b6;
		
		public LaminaMes(CalendarioMensual calendario,Agenda agenda) {
	
			this.agenda = agenda;
			agenda = new Agenda();
			fecha = new Fecha(1, calendario.getMes(), calendario.getAnio());
			this.calendario = calendario;
			setLayout(new GridLayout(6,7,5,5));
			contador = 0;
			anio=calendario.getAnio();
			month = calendario.getMes();
			pedirArrayMes();
			inicializarDia(a);inicializarDia(b);
			inicializarDia(c);inicializarDia(d);
			inicializarDia(e);inicializarDia(f);
			inicializarDia(g);inicializarDia(h);
			inicializarDia(i);inicializarDia(j);
			inicializarDia(k);inicializarDia(l);
			inicializarDia(m);inicializarDia(n);
			inicializarDia(o);inicializarDia(p);
			inicializarDia(q);inicializarDia(r);
			inicializarDia(s);inicializarDia(t);
			inicializarDia(u);inicializarDia(v);
			inicializarDia(w);inicializarDia(x);
			inicializarDia(y);inicializarDia(z);
			inicializarDia(a1);inicializarDia(a2);
			inicializarDia(a3);inicializarDia(a4);
			inicializarDia(a5);inicializarDia(a6);
			inicializarDia(a7);inicializarDia(a8);
			inicializarDia(a9);inicializarDia(a0);
			inicializarDia(b1);inicializarDia(b2);
			inicializarDia(b3);inicializarDia(b4);
			inicializarDia(b5);
			
			
			}
		//este metodo coloca cada dia en el lugar que corresponde
       public void inicializarDia(LaminaObjeto objeto) {
			if(arrayMes[contador]== 0) {
				String numeroVacio = " ";
				objeto = new LaminaObjeto(numeroVacio);
				contador++;
			}else {
			     objeto = new LaminaObjeto( arrayMes[contador]+"                        ");
			     Fecha fecha = new Fecha(arrayMes[contador], month, anio);
			 
			     ListaSE<Cita> lista = agenda.buscarFecha(fecha);
			     int tamanio = lista.longitud();
			     if(lista.vacia()==false && tamanio >=2) {
			         objeto.setTextoCita1(lista.acceder(0).getAsunto());
			         objeto.setTextoCita2(lista.acceder(1).getAsunto());
			     }
			     if(lista.vacia()==false && tamanio ==1) {
			    	 objeto.setTextoCita1(lista.acceder(0).getAsunto());
			     }
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
			
		    numero.setBorder(null);
		    cita1.setBorder(null);
		    cita2.setBorder(null);
		    
		    numero.setBackground(Color.WHITE);
		    cita1.setBackground(Color.WHITE);
		    cita2.setBackground(Color.WHITE);
		    
		    setBackground(Color.WHITE);
			Box box = Box.createVerticalBox();
			Border border = LineBorder.createGrayLineBorder();
			setBorder(border);
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
		public void setTextoCita1(String text) {
			cita1.setText(text);
			
		}
		public void setTextoCita2(String text) {
			cita2.setText(text);
		}
		
	}


	
	
}


