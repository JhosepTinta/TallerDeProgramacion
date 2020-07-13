package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controlador.ControladorAgenda;
import lineales.ListaSE;
import modelo.*;

import vista.VistaPrincipal;
import vistaAgenda.VistaAgenda;
import vistaAgenda.VistaCrearCita;
import vistaAgenda.VistaDetalleCitaVentana;

public class VistaCalendarioCita extends JPanel {
    
	 CalendarioMensual aux;
	 JButton back,next;
	 String mesElegido;
	 int month,anio;
	 public String diaapretado;
     public LaminaMes mes;
     public VistaCrearCita vistaagen;
	public VistaCalendarioCita(CalendarioMensual aux,VistaCrearCita vista) {
	   vistaagen = vista;
	   month = aux.getMes();
	   anio = aux.getAnio();
	   this.aux = aux;		
       setLayout(new BorderLayout());
       setBackground(Color.WHITE);
        mes = new LaminaMes(this.aux);
      
      //Encabezado para el mes
       mesElegido = nombrarMes(month);
	  


       JPanel encabezado = new JPanel(new GridLayout(1,7,5,5));
		JLabel a1 = new JLabel("    L ");
		JLabel a2 = new JLabel("    M  ");
		JLabel a3 = new JLabel("    M  ");
		JLabel a4 = new JLabel("    J  ");
		JLabel a5 = new JLabel("    V  ");
		JLabel a6 = new JLabel("    S  ");
		JLabel a7 = new JLabel("    D  ");
		JPanel todo = new JPanel();
		BoxLayout nuevo = new BoxLayout(todo, BoxLayout.Y_AXIS);
	    JButton tituloMes = new JButton(mesElegido);
	    JButton tituloanio= new JButton("     " + anio+"    ");
	    todo.setLayout(nuevo);
	    JPanel contenedorAM = new JPanel();
	    contenedorAM.setBackground(Color.WHITE);
	    contenedorAM.setLayout(new BorderLayout());
	    JPanel contenedorwest = new JPanel();
	    contenedorwest.setBackground(Color.WHITE);
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
		
		Integer[] arrayMes;
	    
		CalendarioMensual calendario;
		Calendar calendar;
		int contador, contadormaximo;
	    int anio, month;
	    int contadorPrimerosDias;
	    int maximo, diaprimero;
	    public JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,b1,b2,b3,b4,b5,b6;
		String fecha;
		public LaminaMes(CalendarioMensual calendario) {
	
			
			this.calendario = calendario;
			
			anio = calendario.getAnio();
			month = calendario.getMes();
			
			calendar = new GregorianCalendar(anio,month,1);
			
			setBackground(Color.WHITE);
			setLayout(new GridLayout(6,7,2,2));
			
			contador = 0;
			contadorPrimerosDias = 1;
			maximo = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		    diaprimero = calendar.get(Calendar.DAY_OF_WEEK)-2;
		    contadormaximo = maximo-diaprimero + 1;
			
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
			inicializarDia(b5);inicializarDia(b6);
		
			}
		//este metodo coloca cada dia en el lugar que corresponde
       public void inicializarDia(JButton objeto) {
			if(arrayMes[contador] == 0) {
				
				objeto = new JButton( "");
				objeto.setBorder(null);
				objeto.setBackground(Color.WHITE);
				contador++;
				
				
			}else {
			     objeto = new JButton( arrayMes[contador]+"  ");
			     objeto.setBackground(Color.WHITE);
			     objeto.setBorder(null);
			     objeto.addActionListener(new Accion());
			     contador++;
			}
			add(objeto);
		}
		
		
		public void pedirArrayMes() {
			arrayMes = calendario.generarMes();
		}
	   
	  
		private class Accion implements ActionListener{
            
			@Override
			public void actionPerformed(ActionEvent e) {
				String evento = e.getActionCommand();
				diaapretado = "  "+evento + " / "+ (month+1) +" / "+anio;
				vistaagen.fechaC.setText(diaapretado);
				
				
			}
			
			

		}
		
	}



	
	
}




