package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import VistaCalendario.Navegacion;
import modelo.Agenda;
import modelo.CalendarioMensual;
import vistaAgenda.VistaAgendaPrueba;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VistaPrincipal extends JFrame {

	public Panel1 miPanel1;
	public Panel2 miPanel2;
	public Panel3 miPanel3;
	public VistaAgendaPrueba a;
	public VistaMemo b;
    public PantallaAlarma alar;
	public Navegacion calendario;
	public Agenda agenda;
	
	public JButton btnC,btnA,btnCa,btnAg,btnM,btnP;
	JScrollPane scrollPaneles;

	public VistaPrincipal() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(970,650);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
		}
		
		private void iniciarComponentes() {
		
		miPanel1=new Panel1();
		miPanel2=new Panel2();
		miPanel3=new Panel3();
		a = new VistaAgendaPrueba();
		b = new VistaMemo();
	    alar= new PantallaAlarma();
	    agenda = new Agenda();
	    CalendarioMensual calendarioMensual = new CalendarioMensual(5, 2020);
		calendario=new Navegacion(agenda,calendarioMensual);
		
		scrollPaneles=new JScrollPane();
		scrollPaneles.setBounds(175, 0, 775, 600);
		
		btnCa = new JButton("New button");
		btnCa.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Calendario.png")));
		btnCa.setBounds(0, 0, 175, 100);
		add(btnCa);
		
		btnM = new JButton("New button");
		btnM.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Memo.png")));
		btnM.setBounds(0, 100, 175, 100);
		add(btnM);
		
		btnC = new JButton("New button");
		btnC.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Contactos.png")));
		btnC.setBounds(0, 200, 175, 100);
		add(btnC);
		
		btnAg = new JButton("New button");
		btnAg.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Agenda.png")));
		btnAg.setBounds(0, 300, 175, 100);
		add(btnAg);
		
		btnA = new JButton("New button");
		btnA.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Alarma.png")));
		btnA.setBounds(0, 400, 175, 100);
		add(btnA);
	
		btnP = new JButton("New button");
		btnP.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/Pendientes.png")));
		btnP.setBounds(0, 500, 175, 100);
		add(btnP);
		
		add(scrollPaneles);
		definirPanel(calendario);
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
		public void definirPanel(JPanel miPanel) {
			scrollPaneles.setViewportView(miPanel);
		}
	}
