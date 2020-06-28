package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Archivo;
import vista.VistaPrincipal;

	public class ControladorG implements ActionListener {

		private VistaPrincipal window;
		
		public ControladorG (VistaPrincipal window) {
			this.window=window;
			window.btnC.addActionListener(this);
			window.btnA.addActionListener(this);
			window.btnCa.addActionListener(this);
			window.btnAg.addActionListener(this);
			window.btnM.addActionListener(this);
			window.btnP.addActionListener(this);
	
		}
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()==window.btnC) {
                Archivo a =new Archivo();
				Controlador ctrl=new Controlador(window,a);
				window.definirPanel(window.miPanel1);
			}
			if(e.getSource()==window.btnA) {
				window.definirPanel(window.alar);	
			}
			if(e.getSource()==window.btnCa) {
				window.definirPanel(window.calendario);
			}
			if(e.getSource()==window.btnAg) {
				window.definirPanel(window.a);	
			}
			if(e.getSource()==window.btnM) {
				window.definirPanel(window.b);	
			}
			if(e.getSource()==window.btnP) {
				JOptionPane.showMessageDialog(null, "No implementado TareasPendientes");	
			}
		}
      }