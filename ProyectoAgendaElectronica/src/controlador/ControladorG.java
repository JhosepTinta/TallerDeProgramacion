package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Agenda;
import modelo.Archivo;
import vista.VistaPrincipal;
import vistaAgenda.VistaAgenda;
import controlador.ControladorAgenda;

	public class ControladorG implements ActionListener {

		private VistaPrincipal window;
		
		public ControladorG (VistaPrincipal window) {
			this.window = window;
			window.btnC.addActionListener(this);
			window.btnA.addActionListener(this);
			window.btnCa.addActionListener(this);
			window.btnAg.addActionListener(this);
			window.btnP.addActionListener(this);
	
		}
		public void actionPerformed (ActionEvent e) {
			if(e.getSource() == window.btnC) {
                Archivo a = new Archivo();
				Controlador ctrl = new Controlador(window,a);
				window.definirPanel(window.miPanelC);
			}
			if(e.getSource() == window.btnA) {
				
				window.definirPanel(window.alar);	
			}
			if(e.getSource() == window.btnCa) {
				
				window.calendario.actualizar();
				window.definirPanel(window.calendario);
			}
			if(e.getSource() == window.btnAg) {

				Agenda modeloAgenda=new Agenda();
				ControladorAgenda controlador=new ControladorAgenda(modeloAgenda,window.vistaAgenda);
				window.vistaAgenda.setControlador(controlador);
				window.definirPanel(window.vistaAgenda);
			}
			if(e.getSource() == window.btnP) {
				
				JOptionPane.showMessageDialog(null, "No implementado TareasPendientes");	
			}
		}
      }
