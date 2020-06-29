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
      Agenda agenda;
      ListaSE<Cita> citas;
      JScrollPane ventana;
      Objeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x;
      int contador ;
      int contador2;
      Box box;
	public VistaDiaria(Agenda agenda) {
		citas = agenda.buscarCitasHoy();
		this.agenda = agenda;
		contador =0;
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
	    
	    
		//Cita cita1 = new Cita("dormir vhiigbgi","a",new Reloj(11,00,00),new Reloj(14,50,0),new Fecha(16,5,2020),"asunto");
        //Objeto objeto1 = new Objeto(cita1);
       
		
        //add(ventana);
	}
	public void addCitas(Objeto objeto) {
		if(contador2< 10) {
			objeto = new Objeto("0"+contador2+":00:00");
	        contador2++;
		}else {
		objeto = new Objeto(contador2+":00:00");
        contador2++;
        }
		add(objeto);
	}
	
	 private class Objeto extends JPanel{
		 JButton hora;
		 JButton tituloCita;
		 Cita cita;
		 public Objeto(Cita cita) {
			 setLayout(new BorderLayout());
			 hora = new JButton("           "+ cita.getHoraInicio());
			 tituloCita = new JButton("                                                 "+ cita.getAsunto()+"                                               ");
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 public Objeto(String horario) {
			 setLayout(new BorderLayout());
			 hora = new JButton(horario);
			 
			 tituloCita = new JButton("     "+ "           ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 
	 }

}
