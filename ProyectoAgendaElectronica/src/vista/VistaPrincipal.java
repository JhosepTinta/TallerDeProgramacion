package vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import VistaCalendario.Navegacion;
import controlador.ControladorAgenda;
import controlador.ControladorTarea;
import modelo.Agenda;
import modelo.CalendarioMensual;
import vistaAgenda.VistaAgenda;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VistaPrincipal extends JFrame {

	public Panel1 miPanel1;
	public Panel2 miPanel2;
	public Panel3 miPanel3;
	public PanelC miPanelC;
	
    public PantallaAlarma alar;
	
 
	public ControladorAgenda controlador;
	//------
	public VistaAgenda vistaAgenda;
	public Agenda modeloAgenda;
	public TareaVista mitarea;
	public ControladorTarea controladortarea;
	//-----
	public CalendarioMensual calendarioMensual;
	public Navegacion calendario;
	public Calendar calendar;
	//-----
	public JButton btnC,btnA,btnCa,btnAg,btnP;
	JScrollPane scrollPaneles;
	public JLabel contactos = new JLabel("RANDOMSOFT -->Contactos: randomsoft50@gmail.com");
	public VistaPrincipal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/imagenes/IconoP.png")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Mi Agenda - RANDOMSOFT");
		setResizable(false);
		setSize(1037,650);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		contactos.setBounds(700, 600, 350, 20);
		add(contactos);
		iniciarComponentes();
		}
		
		private void iniciarComponentes() {
		
		miPanel1 = new Panel1();
		miPanel2 = new Panel2();
		miPanel3 = new Panel3();
		miPanelC = new PanelC();
		
		alar = new PantallaAlarma();
		mitarea = new TareaVista();
	    
		vistaAgenda = new VistaAgenda();
		modeloAgenda = new Agenda();
		Agenda recuperada = modeloAgenda.leerDatosGuardadosAgenda();
		modeloAgenda = recuperada!=null?recuperada: new Agenda();
	    controlador = new ControladorAgenda(modeloAgenda, vistaAgenda);
	    vistaAgenda.setControlador(controlador);
        //-----  
	    calendar = new GregorianCalendar();
	    calendarioMensual = new CalendarioMensual(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
		calendario = new Navegacion(modeloAgenda,calendarioMensual);
		calendario.setEstado();
		//-----
		controladortarea = new ControladorTarea(mitarea, modeloAgenda);
		mitarea.setControlador(controladortarea);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(175, 0, 855, 600);
		scrollPaneles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		//Boton Calendario
		btnCa = new JButton("New button");
		btnCa.setOpaque(false);
		btnCa.setContentAreaFilled(false);
		btnCa.setBorderPainted(false);
		btnCa.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/CalendarioP.png")));
		btnCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCa.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Calendario.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnCa.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/CalendarioP.png")));//
			}
			
		});
		btnCa.setBounds(0, 0, 175, 120);
		add(btnCa);
		
		//Boton Contactos
		btnC = new JButton("New button");
		btnC.setOpaque(false);
		btnC.setContentAreaFilled(false);
		btnC.setBorderPainted(false);
		btnC.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/ContactosP.png")));		
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnC.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Contactos.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnC.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/ContactosP.png")));//
			}
			
		});
		btnC.setBounds(0, 120, 175, 120);
		add(btnC);
		
		//Boton Agenda
		btnAg = new JButton("New button");
		btnAg.setOpaque(false);
		btnAg.setContentAreaFilled(false);
		btnAg.setBorderPainted(false);
		btnAg.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Agenda.png")));
		btnAg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAg.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Agenda.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnAg.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/AgendaP.png")));//
			}
			
		});
		btnAg.setBounds(0, 240, 175, 120);
		add(btnAg);
		
		//Boton Alarma
		btnA = new JButton("New button");
		btnA.setOpaque(false);
		btnA.setContentAreaFilled(false);
		btnA.setBorderPainted(false);
		btnA.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/AlarmaP.png")));
		btnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnA.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Alarma.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnA.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/AlarmaP.png")));//
			}
			
		});
		btnA.setBounds(0, 360, 175, 120);
		add(btnA);
	
		//Boton Pendientes
		btnP = new JButton("New button");
		btnP.setOpaque(false);
		btnP.setContentAreaFilled(false);
		btnP.setBorderPainted(false);
		btnP.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/PendientesP.png")));
		btnP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnP.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Pendientes.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnP.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/PendientesP.png")));//
			}
			
		});
		btnP.setBounds(0, 480, 175, 120);
		add(btnP);
		
		add(scrollPaneles);
		definirPanel(calendario);
	}
		public void arrancarCalendario() {

			calendario = new Navegacion(modeloAgenda, calendarioMensual);
			calendario.arrancarDia(modeloAgenda);
		}
		public void definirPanel(Panel1 miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
		public void definirPanel(Panel2 miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
		public void definirPanel(Panel3 miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
		public void definirPanel(PanelC miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
		public void definirPanel(JPanel miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
	}
