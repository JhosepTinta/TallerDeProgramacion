package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.Cita;
import modelo.Fecha;
import modelo.Reloj;
import vistaAgenda.VistaDetalleCitaVentana;

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
 		JLabel informacionfecha = new JLabel(preguntarDia(diasemana)+ " "+dia + " DE "+ nombrarMes(mes)+ " " + anio);
 	    Font fuente = new Font("Calibri", 3, 20);
 	    informacionfecha.setFont(fuente);
 	    informacionfecha.setForeground(new Color(52, 152, 219 ));
 		
 		setLayout(new BorderLayout());
 		listacitas = new ListaCitas(lista,dia,mes) ;
 		
 	    JPanel cabecera = new JPanel();
 	    cabecera.setBackground(Color.WHITE);
 	  
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
 			textodia = "LUNES"; 
 			break;
         case 2:
 			textodia = "MARTES";
 			break;
         case 3:
 			textodia = "MIERCOLES";
 			break;
 		case 4:
 			textodia = "JUEVES";
 			break;
 		case 5:
 			textodia = "VIERNES";
 			break;
 		case 6:
 			textodia = "SABADO";
 			break;
 		case 7:
 			textodia = "DOMINGO";
 			
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
	int horaminutos;
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
		if(contador2 <= 24) {
			
		
		   if(contadorpos < tamaniolista) {
		  
		    Cita citaahora = citas.acceder(contadorpos);
		    int horaini = citaahora.getHoraInicio().getHora();
		    int horafi = citaahora.getHoraFin().getHora();
		    if(horaini == contador2) {
			         objeto = new Objeto(citaahora);
			         contadorpos++;
			         contador2 = horafi;
			         horaminutos = citaahora.getHoraFin().getMinutos();
		    }else {
		  	  if(contador2 < 10) {
					objeto = new Objeto("0"+contador2+"  :  00  :  00");
			        contador2++;
				 }else {
				    objeto = new Objeto(contador2+"  : 00  :  00");
		            contador2++;
		       }
			  
		     }
		  
		  
		  }else {
			  if(contador2 < 10) {
					objeto = new Objeto("0"+contador2+"  :  00  :  00");
			        contador2++;
				}else {
				    objeto = new Objeto(contador2+"  :  00  :  00");
		            contador2++;
		        }
			
		  }
		   add(objeto);
		}
		
		
	}
	
	 private class Objeto extends JPanel {
		 
		 JButton hora;
		 JButton tituloCita;
		 JButton horafin;
		 Cita cita;
		 
		 public Objeto(Cita cita) {
			 setLayout(new BorderLayout());
			 hora = new JButton("          "+ cita.getHoraInicio()+"");
             this.cita = cita;
             JPanel objetohoras = new JPanel();
             objetohoras.setLayout(new GridLayout(2,1));
			 tituloCita = new JButton(cita.getAsunto()+"                       ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 horafin = new JButton("          "+cita.getHoraFin().toString());
			 setBorder(new LineBorder(new Color(127, 179, 213 )));
			 vistaBotonHora(hora);
			 vistaBotonHora(horafin);
			 objetohoras.add(hora);
			 objetohoras.add(horafin);
			
			 
			 tituloCita.addActionListener(new AccionCita());
			 add(objetohoras,BorderLayout.WEST);
			 add(tituloCita,BorderLayout.CENTER);
			 
	
		 }
		 
		 public Objeto(String horario) {
			 setLayout(new BorderLayout());
			 hora = new JButton("          "+horario);
			 vistaBotonHora(hora);
			 tituloCita = new JButton("     "+"    ");
			 tituloCita.setBackground(Color.WHITE);
			 tituloCita.setBorder(null);
			 hora.addMouseListener(new AccionObjeto());
			 tituloCita.addMouseListener(new AccionObjeto());
			 add(tituloCita,BorderLayout.CENTER);
			 add(hora,BorderLayout.WEST);
	
		 }
		 public void vistaBotonHora(JButton boton) {
			 boton.setBackground(Color.WHITE);
			 boton.setForeground(new Color(52, 152, 219));
			 Font fuente = new Font("Calibri", 3, 17);
		 	 boton.setFont(fuente);
			 boton.setBorder(new BevelBorder(3,Color.BLACK, Color.BLUE));
		 }
        private class AccionCita implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
               
			    VistaDetalleCitaVentana ventana = new VistaDetalleCitaVentana(cita, new Color(52, 152, 219), new Color(52, 152, 219));
                   
               
			}
        	
        	
        }
		private class AccionObjeto extends MouseAdapter implements MouseListener{

			@Override
			public void mouseEntered(MouseEvent e) {
				
					tituloCita.setBorder(new LineBorder(new Color(127, 179, 213)));
				   
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
					tituloCita.setBorder(new LineBorder(Color.WHITE));
					
				
				
			}

			
			
			
		}
	 }

	
  }
}