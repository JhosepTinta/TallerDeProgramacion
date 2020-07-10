package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;

public class VistaDiaria extends JPanel {
     
	ListaCitas listacitas;
     int dia,mes, anio;
     JButton botonmes,botonanio,botondia;
	 Calendar calendar;
     public VistaDiaria(ListaSE<Cita> lista,int dia, int mes, int anio) {
 		this.dia = dia;
 		this.mes = mes;
 		this.anio = anio;
 		calendar = new GregorianCalendar(anio,mes,dia);
 		int diasemana = calendar.get(Calendar.DAY_OF_WEEK);
 		JLabel informacionfecha = new JLabel(preguntarDia(diasemana)+ " "+dia + " de "+ nombrarMes(mes)+ " " + anio);
 	    Font fuente = new Font("Calibri", 3, 20);
 	    informacionfecha.setFont(fuente);
 	    informacionfecha.setForeground(new Color(52, 152, 219 ));
 		//String textodeldia = preguntarDia(diasemana);
 		setLayout(new BorderLayout());
 		listacitas = new ListaCitas(lista,dia,mes) ;
 		//botonmes = new JButton(nombrarMes(mes)+"");
 		//botonanio= new JButton(anio + "");
 	    //botondia = new JButton(textodeldia+"    "+dia+ "");
 	    JPanel cabecera = new JPanel();
 	    cabecera.setBackground(Color.WHITE);
 	   // cabecera.add(botondia);
 	    //cabecera.add(botonmes);
 	    cabecera.add(informacionfecha);
 		add(listacitas,BorderLayout.CENTER);
 		add(cabecera,BorderLayout.NORTH);
 		
 	}
 	 
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
      
      public String preguntarDia(int numerodia) {
     	 String textodia;
     	 switch (numerodia) {
 		case 1:
 			textodia = "Lunes"; 
 			break;
         case 2:
 			textodia = "Martes";
 			break;
         case 3:
 			textodia = "Miercoles";
 			break;
 		case 4:
 			textodia = "Jueves";
 			break;
 		case 5:
 			textodia = "Viernes";
 			break;
 		case 6:
 			textodia = "Sabado";
 			break;
 		case 7:
 			textodia = "Domingo";
 			
 			break;	
 		default:
 			textodia = "dianoexiste";
 			break;
 		}
     	 
     	 return textodia;
      }

 


   private class ListaCitas extends JPanel{
	
	ListaSE<Cita> citas;
    JScrollPane ventana;
    Objeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x;
    int contador2 ;
    int tamaniolista;
    int contadorpos;
    Box box;
    int dia,mes;
	
    public ListaCitas(ListaSE<Cita> lista,int dia, int mes) {
		this.citas = lista;
		this.dia = dia;
		this.mes = mes;
		tamaniolista = lista.longitud();
		contadorpos = 0;
		contador2 = 1;
		setLayout(new GridLayout(24,1,5,5 ));
	   
	    addCitas(a);
	    addCitas(b);
	    addCitas(c);
	    addCitas(d);
	    addCitas(e);
	    addCitas(f);
	    addCitas(g);
	    addCitas(h);
	    addCitas(i);
	    addCitas(j);
	    addCitas(k);
	    addCitas(l);
	    addCitas(m);
	    addCitas(n);
	    addCitas(o);
	    addCitas(p);
	    addCitas(q);
	    addCitas(r);
	    addCitas(s);
	    addCitas(t);
	    addCitas(u);
	    addCitas(v);
	    addCitas(w);
	    addCitas(x);
	    
	    
		
	}
    
	public void addCitas(Objeto objeto) {
		 
		if(contadorpos< tamaniolista) {
		  
		  Cita citaahora = citas.acceder(contadorpos);
		  int horaini = citaahora.getHoraInicio().getHora();
		  int horafi = citaahora.getHoraFin().getHora();
		  if(horaini == contador2) {
			         objeto = new Objeto(citaahora);
			         contadorpos++;
			         contador2++;
		  }else {
			  if(contador2 < 10) {
					objeto = new Objeto("0"+contador2+":00:00");
			        contador2++;
				}else {
				    objeto = new Objeto(contador2+":00:00");
		            contador2++;
		      }
			  
		  }
		  
		  
		}else {
			 if(contador2 < 10) {
					objeto = new Objeto("0"+contador2+":00:00");
			        contador2++;
				}else {
				    objeto = new Objeto(contador2+":00:00");
		            contador2++;
		      }
			
		}
		
		add(objeto);
	}
	
	 private class Objeto extends JPanel{
		 
		 JButton hora;
		 JButton tituloCita;
		 Cita cita;
		 
		 public Objeto(Cita cita) {
			 setLayout(new BorderLayout());
			 hora = new JButton( cita.getHoraInicio()+"");
			 
			 tituloCita = new JButton(cita.getAsunto()+"                       ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 
		 public Objeto(String horario) {
			 setLayout(new BorderLayout());
			 hora = new JButton(horario);
			 
			 tituloCita = new JButton("     "+"    ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 
	 }

	
  }
}