package vista;

import java.awt.BorderLayout;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.AlertaAlarma;
import modelo.ListaDeAlarmas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
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
	ListaDeAlarmas lista = new ListaDeAlarmas();
	
	
	DefaultListModel DLM = new DefaultListModel();
	/**
	 * Create the panel.
	 
	 */
	public PantallaAlarma() {
		setBackground(Color.WHITE);
		setBounds(181, 0, 753, 561);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 313, 472, 208);
		
		JList list = new JList();
		/*JList list = new JList();
		list.setBounds(164, 305, 579, 230);
		add(list);*/
		
		
		
		JLabel lblNewLabel = new JLabel("ALARMA");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
		lblNewLabel.setBounds(31, 11, 171, 47);
		add(lblNewLabel);
		
		MINUTOS = new JTextField();
		MINUTOS.setBounds(180, 156, 86, 34);
		add(MINUTOS);
		MINUTOS.setColumns(10);
		
		SEGUNDO = new JTextField();
		SEGUNDO.setText("0");
		SEGUNDO.setBounds(301, 156, 93, 34);
		add(SEGUNDO);
		SEGUNDO.setColumns(10);
		
		AMPM = new JTextField();
		AMPM.setBounds(451, 156, 86, 34);
		AMPM.setEditable(false);
		add(AMPM);
		AMPM.setColumns(10);
		
		JButton btnNewButton = new JButton("AM");
		btnNewButton.setBounds(557, 123, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 AMPM.setText("AM");
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PM");
		btnNewButton_1.setBounds(557, 201, 93, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 AMPM.setText("PM");
			}
		});
		
		HORA = new JTextField();
		HORA.setBounds(31, 156, 101, 34);
		add(HORA);
		HORA.setColumns(10);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PONER");
		btnNewButton_2.setBounds(143, 213, 299, 27);
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
			    
                //lista.visualizarPersona();
		  
			   v.CrearAlarma(h,m,s,am);
			   System.out.println(h+" "+m+" "+s+" "+" "+am+""+aux);
			}
		});
		add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE ALARMAS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 266, 213, 27);
		add(lblNewLabel_1);
		
		JButton BOTON1 = new JButton("QUITAR");
		
		BOTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int eliminaralarma =  list.getSelectedIndex();
				
				v.CrearAlarma(0,0,0,"AM");
				
				DLM.remove(eliminaralarma);
			//	System.out.println(eliminaralarma);
				lista.listalarma.remove(eliminaralarma);
			     
				
				
			
			}
		
		});
		BOTON1.setBounds(55, 354, 89, 23);
		add(BOTON1);
		
		JButton BOTON2 = new JButton("QUITAR TODO");
		BOTON2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int elitodo = list.getSelectedIndex();
				v.CrearAlarma(0,0,0,"AM");
				DLM.removeAllElements();
				lista.listalarma.clear();
				
				
			}
		});
		BOTON2.setBounds(36, 424, 123, 23);
		add(BOTON2);
		
		JButton btnNewButton_3 = new JButton("SALIR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_3.setBounds(654, 11, 89, 23);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("HORA");
		lblNewLabel_2.setBounds(55, 127, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MINUTO");
		lblNewLabel_3.setBounds(195, 127, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SEGUNDO");
		lblNewLabel_4.setBounds(317, 127, 64, 14);
		add(lblNewLabel_4);
		
	
		scrollPane.setViewportView(list);
		setLayout(null);
		add(lblNewLabel);
		add(btnNewButton_3);
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
	