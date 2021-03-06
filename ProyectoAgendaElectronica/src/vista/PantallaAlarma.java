package vista;

//@autor  Vladimir Orellana Luizaga

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.AlarmaL;
import modelo.AlertaAlarma;
import modelo.Contacto;
import modelo.ListaDeAlarmas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

	
public class PantallaAlarma extends JPanel {
	
	//En esta parte del c�digo estamos poniendo los botones lo es la parte del 
	//interfaz donde el usuario va apreciar en el controlador.
	
	//Aqu� est�n los textos los Jlabel.
	
	private JTextField HORA;
	private JTextField MINUTOS;
	private JTextField SEGUNDO;
	private JTextField AMPM;
	
	//Inicializaci�n de las clases creado para la Alarma
	
	AlertaAlarma v = new AlertaAlarma();
	ListaDeAlarmas lista = new ListaDeAlarmas();
	
	//Este inicializaci�n nos permite agregar en JlList.
	
	DefaultListModel DLM = new DefaultListModel();
	/**
	 * Create the panel.
	 
	 */
	public PantallaAlarma() {
		
		//Tenemos en tama�o del Jpanel
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(181, 0, 753, 561);
		setLayout(null);
		
//		En esta parte se lo que seria JList  dentro del JScrollPane.
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 315, 472, 228);
		
		JList list = new JList();
		/*JList list = new JList();
		list.setBounds(164, 305, 579, 230);
		add(list);*/
		
	//En esta parte est�n los texto que van aparecer en pantalla de alarma.
		
		
		JLabel lblNewLabel = new JLabel("ALARMA");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblNewLabel.setBounds(15, 15, 171, 47);
		add(lblNewLabel);
		
		HORA = new JTextField();
		HORA.setBounds(70, 120, 90, 40);
		HORA.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(HORA);
		HORA.setColumns(10);
		
		MINUTOS = new JTextField();
		MINUTOS.setBounds(185, 120, 90, 40);
		MINUTOS.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(MINUTOS);
		MINUTOS.setColumns(10);
		
		SEGUNDO = new JTextField();
		SEGUNDO.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SEGUNDO.setText("0");
		SEGUNDO.setBounds(300, 120, 90, 40);		
		add(SEGUNDO);
		SEGUNDO.setColumns(10);
		
		AMPM = new JTextField();
		AMPM.setBounds(425, 120, 90, 40);
		AMPM.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AMPM.setEditable(false);
		add(AMPM);
		AMPM.setColumns(10);
		
		//Aqu� se esta poniendo el bot�n para poner si es AM o PM.
		
		JButton btnNewButton = new JButton();
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/AlarmaAM1.png")));
		btnNewButton.setBounds(560, 123, 100, 35);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaAM2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaAM1.png")));//
			}
			
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 AMPM.setText("AM");
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/AlarmaPM1.png")));
		btnNewButton_1.setBounds(680, 123, 100, 35);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaPM2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaPM1.png")));//
			}
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 AMPM.setText("PM");
			}
		});
		
		
		add(btnNewButton_1);
		
		//En esta parte estamos aceptando la Alarma ingresda o el bot�n de programar alarma.
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/AlarmaAnadir1.png")));
		btnNewButton_2.setBounds(220, 195, 310, 50);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton_2.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaAnadir2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				btnNewButton_2.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaAnadir1.png")));//
			}
			
		});
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
	      	 
	      	   Date fecha=  new Date();
	       	  
	      	   
	      	    
			   lista.agregarAlarma(h, m, s, am,fecha);
			   DLM.removeAllElements();
			   
			   for(int i=0 ; i<lista.getAlarmaL().size(); i++)
			   {
				   DLM.addElement(lista.getAlarmaL().get(i));
	                list.setModel(DLM);
			   }
			    int z=0;
             if(h==13 || h==14 ||h==15 ||h==16 ||h==17 ||h==18 ||h==19 ||h==20 ||h==21 ||h==22 ||h==23 )
             {
            	 for(int i=13;i<=23;i++) {
            		 z=z+1;
            		 if(h==i) {
			   v.CrearAlarma(z,m,s,am);
			   System.out.println(z+" "+m+" "+s+" "+" "+am+"");
            		 }
            	 }
             }
             else
             {
            	 v.CrearAlarma(h,m,s,am); 
             }
             
			}

		
		});
		add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE ALARMAS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(70, 276, 300, 27);
		add(lblNewLabel_1);
		
		//En aqu� esta el bot�n para eliminar o desprogramar la Alarma
		
		JButton BOTON1 = new JButton();
		
		BOTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(list, "Seguro de eliminar la alarma", "Titulo",
						2, 2) == 0) {
				int eliminaralarma =  list.getSelectedIndex();
				
				v.CrearAlarma(0,0,0,"AM");
				
				DLM.remove(eliminaralarma);
			//	System.out.println(eliminaralarma);
				lista.listalarma.remove(eliminaralarma);
				}
			}
		
		});
		BOTON1.setBounds(580, 354, 200, 50);
		BOTON1.setOpaque(false);
		BOTON1.setContentAreaFilled(false);
		BOTON1.setBorderPainted(false);
		BOTON1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/AlarmaQuitar1.png")));
		BOTON1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				BOTON1.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaQuitar2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				BOTON1.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaQuitar1.png")));//
			}
			
		});
		add(BOTON1);
		
		//Aqu� es el bot�n para eliminar todo las Alarmas Programadas.

		
		JButton BOTON2 = new JButton();
		BOTON2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(list, "Seguro de eliminar todas las alarmas", "Titulo",
						2, 2) == 0) {
				int elitodo = list.getSelectedIndex();
				v.CrearAlarma(0,0,0,"AM");
				DLM.removeAllElements();
				lista.listalarma.clear();
				}
				
			}
		});
		BOTON2.setBounds(580, 424, 200, 50);
		BOTON2.setOpaque(false);
		BOTON2.setContentAreaFilled(false);
		BOTON2.setBorderPainted(false);
		BOTON2.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/botones/AlarmaQuitarTodas.png")));
		BOTON2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				BOTON2.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaQuitarTodas2.png")));
			}
			public void mouseExited(MouseEvent arg0) {
				BOTON2.setIcon(new ImageIcon(PantallaAlarma.class.getResource("/botones/AlarmaQuitarTodas.png")));//
			}
			
		});
		add(BOTON2);
		
		JLabel lblNewLabel_2 = new JLabel("HORA");
		lblNewLabel_2.setBounds(80, 95, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MINUTO");
		lblNewLabel_3.setBounds(195, 95, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SEGUNDO");
		lblNewLabel_4.setBounds(310, 95, 64, 14);
		add(lblNewLabel_4);
		
	//Aqu� estamos a�adiendo para que se haga visible.
		
		scrollPane.setViewportView(list);
		setLayout(null);
		add(lblNewLabel);
		add(lblNewLabel_2);
		add(lblNewLabel_3);
		add(lblNewLabel_4);
		add(btnNewButton);
		add(HORA);
		add(MINUTOS);
		add(SEGUNDO);
		add(AMPM);
		add(btnNewButton_2);
		add(btnNewButton_1);
		add(lblNewLabel_1);
		add(BOTON1);
		add(BOTON2);
		add(scrollPane);

	}
}		
