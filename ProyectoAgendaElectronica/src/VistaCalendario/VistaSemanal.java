package VistaCalendario;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.CalendarioSemanal;

public class VistaSemanal extends JPanel {
	public static void main(String[] args) {
		JFrame prueba = new JFrame();
        VistaSemanal a= new VistaSemanal(2020,5,6);
        prueba.add(a);
        prueba.setVisible(true);
        prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prueba.setSize(1000,700);
	}
   
	CalendarioSemanal semanal;
	JButton a,b,c,d,e,f,g;
	Integer[] arraydias;
	int contador; 
	public VistaSemanal(int year, int month, int dia) {
		contador =0;
		semanal = new CalendarioSemanal(year, month, dia);
		arraydias = semanal.generarSemana();
	    inicializarBotones(a);
	    inicializarBotones(b);
	    inicializarBotones(c);
	    inicializarBotones(d);
	    inicializarBotones(e);
	    inicializarBotones(f);
	    inicializarBotones(g);
	    
	}

	public void inicializarBotones(JButton a) {
		
		a= new JButton("            "+arraydias[contador]+"            ");
		add(a);
		contador++;
	}

}
