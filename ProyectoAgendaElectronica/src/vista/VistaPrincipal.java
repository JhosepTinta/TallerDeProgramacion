package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import VistaCalendario.VistaCalendarioMensual;
import modelo.Agenda;
import modelo.CalendarioMensual;
import vistaAgenda.VistaAgendaPrueba;

public class VistaPrincipal extends JFrame {

	VistaAgendaPrueba a = new VistaAgendaPrueba();
	VistaMemo b = new VistaMemo();
	LaminaPrincipal laminaprincipal;

	public VistaPrincipal() {
		laminaprincipal = new LaminaPrincipal();
		
		setSize(950, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(laminaprincipal);
		
		
	}

	private class LaminaPrincipal extends JPanel {
		LaminaDeBotones laminaBotones;
		JScrollPane contenedorDePaneles;
		VistaCalendarioMensual calendario;
		Agenda agenda;
		PantallaAlarma alar;
	   
		public LaminaPrincipal() {
			contenedorDePaneles = new JScrollPane();
			alar = new PantallaAlarma();
			CalendarioMensual calendarioMensual = new CalendarioMensual(5, 2020);
			agenda = new Agenda();
			setLayout(new BorderLayout());
			laminaBotones = new LaminaDeBotones();
			calendario = new VistaCalendarioMensual(calendarioMensual, agenda);
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
		
		public void definirPanel(JPanel panel) {
			contenedorDePaneles.setViewportView(panel);
		}

		public class LaminaDeBotones extends JPanel {
			JButton inicio;
			JButton contactos;
			JButton alarma;
			JButton memo;
			JButton agenda;
			JButton tareasPendientes;

			public LaminaDeBotones() {
				inicio = new JButton("     Inicio                     ");
				contactos = new JButton("     Contactos            ");
				alarma = new JButton("     Alarma                  ");
				memo = new JButton("     Memo                    ");
				agenda = new JButton("     Agenda                 ");
				tareasPendientes = new JButton("Tareas Pendientes ");
				contactos.setSize(900, 30);
				alarma.setSize(100, 30);
				memo.setSize(100, 30);
				agenda.setSize(100, 30);
				tareasPendientes.setSize(100, 30);
				BoxLayout nuevo = new BoxLayout(this, BoxLayout.Y_AXIS);
				setLayout(nuevo);
				add(inicio);
				add(contactos);
				add(alarma);
				add(memo);
				add(agenda);
				add(tareasPendientes);

				agenda.addActionListener(new AccionDeBoton());
				inicio.addActionListener(new AccionDeBoton());
				memo.addActionListener(new AccionDeBoton());
				alarma.addActionListener(new AccionDeBoton());
			}
			private class AccionDeBoton implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(agenda)) {
						definirPanel(a);
					}else if(e.getSource().equals(inicio)) {
						definirPanel(calendario);
					}else if(e.getSource().equals(memo)) {

						definirPanel(b);
					}else if(e.getSource().equals(alarma)) {
						definirPanel(alar);
					}
					}
					

				}
				
			}
		}
		
	}


