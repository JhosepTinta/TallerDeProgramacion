package vista;

import java.awt.BorderLayout;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.AlertaAlarma;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;


/*public class PantallaAlarma extends JFrame {
	private JPanel contentPane;
	private JTextField HORA;
	private JTextField MINUTOS;
	private JTextField SEGUNDOS;
	AlertaAlarma v = new AlertaAlarma();
	ButtonGroup g1 = new ButtonGroup();
	private final JTextField textField = new JTextField();
	private JTextField AMPM;
	private JButton PM;
	JButton btnNewButton = new JButton("ACEPTAR");
		

	public PantallaAlarma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ALARMA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VistaAlarma alarma = new VistaAlarma();
			    getLayeredPane().add(alarma);
			
			}
		});
		btnNewButton.setBounds(10, 50, 117, 23);
		contentPane.add(btnNewButton);
	}*/
	
	public class PantallaAlarma extends JPanel {
		
		private JTextField HORA;
		private JTextField MINUTOS;
		private JTextField SEGUNDO;
		private JTextField AMPM;
		AlertaAlarma v = new AlertaAlarma();

		/**
		 * Create the panel.
		 */
		public PantallaAlarma() {
			setBackground(Color.WHITE);
			setBounds(181, 0, 753, 561);
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ALARMA");
			lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
			lblNewLabel.setBounds(257, 60, 171, 47);
			add(lblNewLabel);
			
			MINUTOS = new JTextField();
			MINUTOS.setBounds(206, 220, 86, 34);
			add(MINUTOS);
			MINUTOS.setColumns(10);
			
			SEGUNDO = new JTextField();
			SEGUNDO.setBounds(331, 220, 93, 34);
			add(SEGUNDO);
			SEGUNDO.setColumns(10);
			
			AMPM = new JTextField();
			AMPM.setBounds(500, 220, 86, 34);
			AMPM.setEditable(false);
			add(AMPM);
			AMPM.setColumns(10);
			
			JButton btnNewButton = new JButton("AM");
			btnNewButton.setBounds(611, 181, 93, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 AMPM.setText("AM");
				}
			});
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("PM");
			btnNewButton_1.setBounds(611, 266, 93, 23);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 AMPM.setText("PM");
				}
			});
			
			HORA = new JTextField();
			HORA.setBounds(45, 220, 101, 34);
			add(HORA);
			HORA.setColumns(10);
			add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("ACEPTAR");
			btnNewButton_2.setBounds(232, 352, 299, 42);
			btnNewButton_2.addActionListener(new ActionListener() {
				
				private int h;
				private int m;
				private int s;	
				private String am;
	            private int aux;
	            
				public void actionPerformed(ActionEvent e) {
					String hora=HORA.getText(); 
					String min=MINUTOS.getText();
					String seg=SEGUNDO.getText();
			        String ampm=AMPM.getText();
			
					 h= Integer.valueOf(hora);
		      	     m  = Integer.valueOf(min);
		      	     s = Integer.valueOf(seg);
		      	     am = ampm;
		      	     aux=v.cortar(h);
			
				   
			  
				   v.CrearAlarma(h,m,s,am);
				   System.out.println(h+" "+m+" "+s+" "+" "+am+""+aux);
				}
			});
			add(btnNewButton_2);

		}
	}
