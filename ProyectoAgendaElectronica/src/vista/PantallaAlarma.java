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


public class PantallaAlarma extends JFrame {

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
		getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 261);
		contentPane = new JPanel();
		contentPane.setToolTipText("ALARMA");
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setForeground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HORA");
		lblNewLabel.setBounds(95, 11, 117, 19);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		HORA = new JTextField();
		HORA.setBackground(new Color(51, 255, 255));
		HORA.setBounds(75, 47, 42, 19);
		contentPane.add(HORA);
		HORA.setColumns(10);
		
		MINUTOS = new JTextField();
		MINUTOS.setBackground(new Color(102, 255, 255));
		MINUTOS.setBounds(127, 47, 42, 19);
		contentPane.add(MINUTOS);
		MINUTOS.setColumns(10);
		
//		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(318, 90, 79, 23);
		btnNewButton.addActionListener(new ActionListener() {
			private int h;
			private int m;
			private int s;	
			private String am;
            private int aux;
      
			public void actionPerformed(ActionEvent e) {
				
				
				String hora=HORA.getText(); 
				String min=MINUTOS.getText();
				String seg=SEGUNDOS.getText();
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
		contentPane.add(btnNewButton);
		
		
		SEGUNDOS = new JTextField();
		SEGUNDOS.setBackground(new Color(102, 255, 255));
		SEGUNDOS.setBounds(179, 47, 42, 20);
		contentPane.add(SEGUNDOS);
		SEGUNDOS.setColumns(10);
		
        JTextPane textPane = new JTextPane();
		textPane.setBounds(67, 195, -53, 109);
		contentPane.add(textPane);
		
		JButton nuevo = new JButton("AM");
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AMPM.setText("AM");
			}
		});
		nuevo.setBounds(267, 27, 62, 23);
		contentPane.add(nuevo);
		
		AMPM = new JTextField();
		AMPM.setEditable(false);
		AMPM.setBackground(new Color(255, 0, 0));
		AMPM.setBounds(231, 47, 26, 20);
		contentPane.add(AMPM);
		AMPM.setColumns(10);
		
		PM = new JButton("PM");
		PM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AMPM.setText("PM");
				
			}
		});
		PM.setBounds(267, 58, 62, 23);
		contentPane.add(PM);
		
		JList list = new JList();
		list.setBounds(98, 93, 1, 1);
		contentPane.add(list);

		
	}
}
