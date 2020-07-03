package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;

public class VistaDiaria extends JPanel {
      ListaCitas listacitas;
     int dia,mes;
     JButton botonmes,botonanio,botondia;
	public VistaDiaria(ListaSE<Cita> lista,int dia, int mes) {
		this.dia = dia;
		this.mes = mes;
		setLayout(new BorderLayout());
		listacitas = new ListaCitas(lista,dia,mes) ;
		botonmes = new JButton(mes+"");
		botonanio= new JButton();
	    botondia = new JButton(dia+"");
	    JPanel cabecera = new JPanel();
	    cabecera.add(botondia);
	    cabecera.add(botonmes);
	    cabecera.add(botonanio);
		add(listacitas,BorderLayout.CENTER);
		add(cabecera,BorderLayout.NORTH);
		
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
		this.dia= dia;
		this.mes = mes;
		tamaniolista= lista.longitud();
		contadorpos=0;
		contador2=1;
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
			  if(contador2< 10) {
					objeto = new Objeto("0"+contador2+":00:00");
			        contador2++;
				}else {
				    objeto = new Objeto(contador2+":00:00");
		            contador2++;
		      }
			  
		  }
		  
		  
		}else {
			 if(contador2< 10) {
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
			 hora = new JButton(""+ cita.getHoraInicio());
			 
			 tituloCita = new JButton(""+ cita.getAsunto()+"                                               ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 public Objeto(String horario) {
			 setLayout(new BorderLayout());
			 hora = new JButton(horario);
			 
			 tituloCita = new JButton("     "+ dia+"    "+mes);
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 
	 }

	
  }
}