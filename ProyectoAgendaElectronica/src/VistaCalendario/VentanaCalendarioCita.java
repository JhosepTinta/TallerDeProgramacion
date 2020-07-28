package VistaCalendario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.sun.imageio.stream.StreamCloser.CloseAction;
import com.sun.javafx.scene.paint.GradientUtils.Point;


import modelo.CalendarioMensual;
import vista.VistaPrincipal;
import vistaAgenda.VistaCrearCita;
/**
 * Explicacion: esta clase es el minicalendario del panel crar cita,para ayudar con 
 * la interfaz y de este modo sea mas comoda para el usuario
 * @author KarenChoquecallataMancilla
 *
 */
public class VentanaCalendarioCita extends JFrame {
     Calendar calendar;
     int mes,anio;
     public VistaCalendarioCompletoCita calen;
     
	public VentanaCalendarioCita(VistaCrearCita crearcita) {
		setUndecorated(true);
		calendar = new GregorianCalendar();
		mes      = calendar.get(Calendar.MONTH);
		anio     = calendar.get(Calendar.YEAR);
		
	    calen    = new VistaCalendarioCompletoCita(new CalendarioMensual(mes,anio),crearcita);
	    
	    Image icon = new ImageIcon(getClass().getResource("/botones/iconcalendario.png")).getImage();
	    setIconImage(icon);
		setResizable(false);
	
	    setTitle("CALENDARIO");
		setBounds(822,375,300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(calen);
	}
	/**
	 * Explicacion:
	 * esta clase interna ayuda a tener una estructura en cascada al minicalendario
	 * @author KarenChoquecallataMancilla
	 *
	 */
	protected class VistaCalendarioCompletoCita extends JPanel implements ActionListener{
		 
		VistaCalendarioCita anterior,actual,siguiente;
		CalendarioMensual calendario;
		JButton back,next;
		int mes, anio;
		VistaCrearCita crearcita;
		
	    public VistaCalendarioCompletoCita(CalendarioMensual calendario, VistaCrearCita vistacrear) {
	       
	    	this.crearcita = vistacrear;
	    	this.calendario = calendario;
	    	mes = calendario.getMes();
	    	anio = calendario.getAnio();
			setLayout(new BorderLayout());
			setBackground(Color.WHITE);
			
		    JPanel botones = new JPanel();
		    botones.setBackground(Color.WHITE);
		    JPanel cabecera = new JPanel();
		    cabecera.setBackground(Color.WHITE);
		    cabecera.setLayout(new BorderLayout());
		    cabecera.add(botones, BorderLayout.EAST);
		    
		    //-----------------------
			next = new JButton();
			next.setBackground(Color.WHITE);
			next.setBorder(null);
			next.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioSiguiente1.png")));
			next.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
				    next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente2.png")));
				}
				public void mouseExited(MouseEvent arg0) {
					next.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioSiguiente1.png")));//
				}
				
			});
			//-----------------------
			back = new JButton() ;
			back.setBackground(Color.WHITE);
			back.setBorder(null);
			back.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/CalendarioAnterior1.png")));
			back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					back.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioAnterior2.png")));
				}
				public void mouseExited(MouseEvent arg0) {
					back.setIcon(new ImageIcon(this.getClass().getResource("/botones/CalendarioAnterior1.png")));//
				}
				
			});
			
			next.addActionListener(this);
			back.addActionListener(this);
			
			botones.add(back);
			botones.add(next);
			
			addMesActual();
			add(cabecera,BorderLayout.NORTH);
		
		}
	    
	    public VistaCalendarioCita getActual() {
	    	return actual;
	    }
	    
	    public void addMesSiguiente() {
			if(mes == 11) {
				anio = anio + 1;
				mes  = 0;
				
				CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
				siguiente = new VistaCalendarioCita(nuevo,crearcita);
			 
			} else {
				 mes++;
			    CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
				siguiente = new VistaCalendarioCita(nuevo,crearcita);
		    }
			
			add(siguiente,BorderLayout.CENTER);
		
		}
	    
	    public void addMesActual() {
			actual = new VistaCalendarioCita(calendario,crearcita);
		    add(actual,BorderLayout.CENTER);
			
		}
	    
	    public void addMesAnterior() {
			if(mes == 0) {
				anio--;
				mes = 11;
				CalendarioMensual nuevo = new CalendarioMensual(mes--,anio);
				anterior = new VistaCalendarioCita(nuevo,crearcita);
			}else{
				mes--;
				CalendarioMensual nuevo = new CalendarioMensual(mes,anio);
				anterior = new VistaCalendarioCita(nuevo,crearcita);
			}
			add(anterior,BorderLayout.CENTER);
		}
	    
	    public String getFechaMarcada() {
	    	String res;
	    	res = actual.diaapretado;
	    	return res;
	    	
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			Object a = e.getSource();
			if(a.equals(next)) {
				
				actual.setVisible(false);
				addMesSiguiente();
				actual = siguiente;
			
			}else {
				if(a.equals(back) ){
					actual.setVisible(false);
					addMesAnterior();
					actual = anterior;
				 		}else {
				 			
				 			
				 		}
			}
			
		}
	   /**
	    * Explicacion:
	    * Esta clase  genera solo el mes, de una version abreviada del calendario 
	    * @author KarenChoquecallataMancilla
	    *
	    */
		
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
		       encabezado.setBackground(new Color(174, 214, 241 ));
				JLabel a1 = new JLabel("    L ");
				JLabel a2 = new JLabel("    M  ");
				JLabel a3 = new JLabel("    M  ");
				JLabel a4 = new JLabel("    J  ");
				JLabel a5 = new JLabel("    V  ");
				JLabel a6 = new JLabel("    S  ");
				JLabel a7 = new JLabel("    D  ");
				JPanel todo = new JPanel();
				BoxLayout nuevo = new BoxLayout(todo, BoxLayout.Y_AXIS);
			    
			    JLabel tituloanio= new JLabel("     " +mesElegido+" DE "+ anio+"    ");
			    Font fuente = new Font("Calibri", 3, 20);
			    tituloanio.setFont(fuente);
			    tituloanio.setForeground(new Color(52, 152, 219 ));
			    todo.setLayout(nuevo);
			    
			    JPanel contenedorAM = new JPanel();
			    contenedorAM.setBackground(Color.WHITE);
			    contenedorAM.setLayout(new BorderLayout());
			    
			    JPanel contenedorwest = new JPanel();
			    contenedorwest.setBackground(Color.WHITE);
			    contenedorwest.add(tituloanio);
			    
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
/**
 * Explicacion:
 * Es una clase aun mas interna que solo genera el mes sin nombre y sin anio
 * @author KarenCh
 *
 */
			private class LaminaMes extends JPanel implements MouseListener{
				
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
					     objeto.addMouseListener(this);
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
			   
			  /**
			   * Explicacion:
			   * Es la clase encargada de la accion de cerrado al apretar una fecha en el 
			   * minicalendario
			   * @author KarenCh
			   *
			   */
				private class Accion implements ActionListener{
		            
					@Override
					public void actionPerformed(ActionEvent e) {
						String evento = e.getActionCommand();
						diaapretado = "  "+evento + " / "+ (month + 1) +" / "+anio;
						vistaagen.fechaC.setText(diaapretado);
					    dispose();
						
					}
					
					

				}


				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					if(e.getSource() instanceof JButton) {
					 JButton evento = (JButton)e.getSource();
					 evento.setBorder(new LineBorder(new Color(52, 152, 219 )));
					 evento.setBackground(new Color(52, 152, 219 ));
					}
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					
					if(e.getSource() instanceof JButton) {
						 JButton evento = (JButton)e.getSource();
						 evento.setBorder(null);
						 evento.setBackground(Color.WHITE);
						}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			}	
		}  
	}








  


	
}
