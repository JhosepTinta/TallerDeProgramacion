package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import VistaCalendario.Navegacion;
import VistaCalendario.VistaCalendarioMensual;
import controlador.Controlador;
import controlador.ControladorAgenda;
import modelo.Agenda;
import modelo.Archivo;
import modelo.CalendarioMensual;
import vistaAgenda.*;
import vistaMemo.*;

public class VistaPrincipal extends JFrame {
	
	LaminaPrincipal laminaprincipal;
	Agenda modeloAgenda = new Agenda();
	static VistaAgenda vistaAgenda = new VistaAgenda();
	ControladorAgenda controlador = new ControladorAgenda(modeloAgenda, vistaAgenda);
    static PantallaAlarma alar;
	static Navegacion calendario;
	static Panel1 miPanel1=new Panel1();
	static Panel2 miPanel2=new Panel2();
	static Panel3 miPanel3=new Panel3();
	
	public VistaPrincipal() {
		vistaAgenda.setControlador(controlador);
		laminaprincipal = new LaminaPrincipal();
		setBounds(200,80,1010,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(laminaprincipal);

	}

	public static class LaminaPrincipal extends JPanel {
		
		LaminaDeBotones laminaBotones;
		static JScrollPane contenedorDePaneles;
		Agenda agenda;
		
	   
		public LaminaPrincipal() {
			contenedorDePaneles = new JScrollPane();
			alar = new PantallaAlarma();
			CalendarioMensual calendarioMensual = new CalendarioMensual(5, 2020);
			agenda = new Agenda();
			setLayout(new BorderLayout());
			laminaBotones = new LaminaDeBotones();
			calendario = new Navegacion( agenda,calendarioMensual);
			add(laminaBotones, BorderLayout.WEST);
			//add(calendario, BorderLayout.CENTER);
			definirPanel(calendario);
			add(contenedorDePaneles, BorderLayout.CENTER);
			//add(a, BorderLayout.CENTER);
			//a.setVisible(false);
			
		}
		
		public void agregarEnPrincipal(JPanel aux) {
			add(aux,BorderLayout.CENTER);
		}
		
		public static void definirPanel(JPanel panel) {
			contenedorDePaneles.setViewportView(panel);
		}

		public class LaminaDeBotones extends JPanel {
			JButton inicio;
			JButton contactos;
			JButton alarma;
			JButton agenda;
			JButton tareasPendientes;

			public LaminaDeBotones() {
				inicio = new JButton("     Inicio                     ");
				contactos = new JButton("     Contactos            ");
				alarma = new JButton("     Alarma                  ");
				agenda = new JButton("     Agenda                 ");
				tareasPendientes = new JButton("Tareas Pendientes ");
				contactos.setSize(900, 30);
				alarma.setSize(100, 30);
				agenda.setSize(100, 30);
				tareasPendientes.setSize(100, 30);
				BoxLayout nuevo = new BoxLayout(this, BoxLayout.Y_AXIS);
				setLayout(nuevo);
				add(inicio);
				add(contactos);
				add(alarma);
				add(agenda);
				add(tareasPendientes);

				agenda.addActionListener(new AccionDeBoton());
				inicio.addActionListener(new AccionDeBoton());
				alarma.addActionListener(new AccionDeBoton());
				contactos.addActionListener(new AccionDeBoton());
			}
			private class AccionDeBoton implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(agenda)) {
						definirPanel(vistaAgenda);
					}else if(e.getSource().equals(inicio)) {
						definirPanel(calendario);
					}else if(e.getSource().equals(alarma)) {
						definirPanel(alar);
					}
					else if(e.getSource().equals(contactos)) {
						Archivo arch=new Archivo();
						Controlador ctrl = new Controlador(miPanel1,miPanel2,miPanel3,arch);
						definirPanel(miPanel1);
					}
				  }
					

				}
				
			}
		}
		
	}


