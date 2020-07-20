package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import lineales.ListaSE;
import modelo.*;
import vista.VistaPrincipal;
import vistaAgenda.VistaDetalleCitaVentana;

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
	       setBackground(Color.WHITE);
	       LaminaMes mes = new LaminaMes(this.aux,agenda);
	      
	      //Encabezado para el mes
	       mesElegido = nombrarMes(month);
		  


	       JPanel encabezado = new JPanel(new GridLayout(1,7,5,5));
	        encabezado.setBackground(new Color(174, 214, 241 ));
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
			tituloMes.setOpaque(false);
		    JLabel textoanio = new JLabel("    " +mesElegido+"   "+anio+"");
		    Font fuente = new Font("Calibri", 3, 20);
		    textoanio.setFont(fuente);
		    textoanio.setForeground(new Color(52, 152, 219 ));
			
		    JButton tituloanio= new JButton("     " + anio+"    ");
			tituloanio.setBackground(Color.WHITE);
			tituloanio.setBorder(new MatteBorder(2,2,2,2,new Color(52, 152, 219 ) ));
		    tituloanio.setOpaque(false);
		    
		    todo.setLayout(nuevo);
		    JPanel contenedorAM = new JPanel();
		    contenedorAM.setBackground(Color.WHITE);
		    contenedorAM.setLayout(new BorderLayout());
		    JPanel contenedorwest = new JPanel();
		    contenedorwest.setBackground(Color.WHITE);
		    contenedorwest.add(textoanio);
		  //  contenedorwest.add(tituloMes);
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
		Calendar calendar;
		int contador, contadormaximo;
	    int anio, month;
	    int contadorPrimerosDias;
	    int maximo, diaprimero;
	    LaminaObjeto a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,b1,b2,b3,b4,b5,b6;
		
		public LaminaMes(CalendarioMensual calendario,Agenda agenda) {
	
			this.agenda = agenda;
			this.calendario = calendario;
			agenda = new Agenda();
			anio = calendario.getAnio();
			month = calendario.getMes();
			fecha = new Fecha(1, month, anio);
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
       public void inicializarDia(LaminaObjeto objeto) {
			if(arrayMes[contador] == 0) {
				
				objeto = new LaminaObjeto( "");
				objeto.setBorder(null);
				contador++;
				/*if(contador < 10) {
				   
					if(diaprimero == -1) {
						diaprimero = 6;
					}
					
					System.out.println(contadormaximo);
					objeto = new LaminaObjeto(contadormaximo + "");
					
					contadormaximo++;
					contador++;
					
				}else {
					if(contador>20) {
						String numeroVacio = "";
						objeto = new LaminaObjeto(contadorPrimerosDias + "");
						contadorPrimerosDias++;
						contador++;
					}
					
				}*/
				
			}else {
			     objeto = new LaminaObjeto( arrayMes[contador]+"                        ");
			     Fecha fecha = new Fecha(arrayMes[contador], month + 1, anio);
			     ListaSE<Cita> lista = agenda.buscarFecha(fecha);
			     int tamanio = lista.longitud();
			     
			     if(lista.vacia() == false && tamanio >= 2) {
			         objeto.setTextoCita1(lista.acceder(0).getAsunto());
			         objeto.setpCita(lista.acceder(0));
			         
			         objeto.setTextoCita2(lista.acceder(1).getAsunto());
			         objeto.setsCita(lista.acceder(1));
			         objeto.cita2Bordenull();
			      }
			     if(lista.vacia() == false && tamanio == 1) {
			    	 objeto.setTextoCita1(lista.acceder(0).getAsunto());
			    	 objeto.setpCita(lista.acceder(0));
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
		Cita pcita,scita;
		JButton numero,cita1,cita2;
		
		public LaminaObjeto(String numeroDia) {
			
			this.numeroDia = numeroDia;
			numero = new JButton("   " + numeroDia + "   ");
			cita1 = new JButton("");
			cita2 = new JButton("");
			
			AccionCitas accion = new AccionCitas();
			cita1.addActionListener(accion);
			cita2.addActionListener(accion);
			
		    numero.setBorder(null);
		    cita1.setBorder(null);
		    cita2.setBorder(null);
		    numero.setBackground(Color.WHITE);
		   
		    addMouseListener(new AccionesBoton());
		    setBackground(Color.WHITE);
			Box box = Box.createVerticalBox();
			
			setBorder(new LineBorder(new Color(36, 113, 163), 1, true));
			box.add(numero);
			box.add(cita1);
			box.add(cita2);
			add(box);
			
		}
		public void cita1Bordenull() {
			
			if(cita1.getText().equals("")) {
				Border border = LineBorder.createGrayLineBorder();
				cita1.setBorder(border);
				
			}
			
		}
        public void cita2Bordenull() {
			
			if(cita2.getText().equals("")) {
				Border border = LineBorder.createGrayLineBorder();
				cita2.setBorder(border);
			}
			
		}
		public void setpCita(Cita cita) {
			this.pcita = cita;
		}
        public void setsCita(Cita cita) {
        	this.scita = cita;
        	
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
		public String getTextonumero() {
			return  numero.getText();
		}
		public void setTextoCita1(String text) {
			cita1.setMinimumSize(new Dimension(30,10));
			cita1.setMaximumSize(new Dimension(130,50));
			cita1.setPreferredSize(new Dimension(95,25));
			cita1.setBackground(new Color(174, 214, 241 ));
			Border border = new LineBorder(new Color(127, 179, 213));
			cita1.setBorder(border);
			cita1.setText(text);
			
		}
		public void setTextoCita2(String text) {
			cita2.setMinimumSize(new Dimension(30,10));
			cita2.setMaximumSize(new Dimension(130,50));
			cita2.setPreferredSize(new Dimension(95,25));
			cita2.setBackground(new Color(174, 214, 241 ));
			Border border = new LineBorder(new Color(127, 179, 213));
			cita2.setBorder(border);
			cita2.setText(text);
		}
		
        private class AccionesBoton extends MouseAdapter implements MouseListener {
        	
            @Override
			public void mouseEntered(MouseEvent e) {
			//numero.setBackground(new Color(133, 193, 233 ));
			
				if(getTextonumero().equals("")) {
					
				}else {
					setBorder(new LineBorder(Color.BLACK, 2, true));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
		     //numero.setBackground(Color.WHITE);
				LaminaObjeto a = (LaminaObjeto)e.getSource();
				if(a.getTextonumero().equals("   " + "" + "   ")) {
					setBorder(null);
				}else {
		            setBorder(new LineBorder(new Color(36, 113, 163 ), 1,false));
		        }
			}


			
        }
		
		private class AccionCitas implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(cita1)) {
				VistaDetalleCitaVentana  ventana = new VistaDetalleCitaVentana(pcita, new Color(36, 113, 163 ), new Color(36, 113, 163));
				}else {
					if(e.getSource().equals(cita2)) {
						VistaDetalleCitaVentana  ventana = new VistaDetalleCitaVentana(scita, new Color(36, 113, 163 ), new Color(36, 113, 163));
					}
					
					
				}
			}
			
			
		}
		
		
	}


	
	
}


