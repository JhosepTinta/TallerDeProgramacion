package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ListaTareaPendiente;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class Tarea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea frame = new Tarea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DefaultListModel DLM = new DefaultListModel();
	private JTextField texto;
	
	
	public Tarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(404, 30, 185, 268);
		contentPane.add(list);
		
//		DefaultListModel DLM = new DefaultListModel();
		//cuando se repite
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	DefaultListModel DLM = new DefaultListModel();
		     /*	DLM.addElement("mARK");
				DLM.addElement("ZULMA");
				DLM.addElement("VLADI");
				DLM.addElement("RONIEE");*/
				 for(int i=0 ; i<lista.getListaRecordatorios().size(); i++)
				   {
					   DLM.addElement(.getListaRecordatorios().get(i));
		                list.setModel(DLM);
				   }
				    
				//list.setModel(DLM);
				
				//String txt = texto.getText();
			//	DLM.addElement(txt);
			}
		});
		btnNewButton.setBounds(41, 78, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				int eliminar =  list.getSelectedIndex();
				DLM.remove(eliminar);
				
			}
		});
		btnNewButton_1.setBounds(41, 126, 89, 23);
		contentPane.add(btnNewButton_1);
		
			JButton btnNewButton_3 = new JButton("eliminar todo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int elitodo = list.getSelectedIndex();
				DLM.removeAllElements();
			}
		});
		btnNewButton_3.setBounds(41, 177, 123, 23);
		contentPane.add(btnNewButton_3);
	
		
		JButton btnNewButton_2 = new JButton("salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(41, 290, 89, 23);
		contentPane.add(btnNewButton_2);
		
		texto = new JTextField();
		texto.setBounds(191, 79, 86, 20);
		contentPane.add(texto);
		texto.setColumns(10);
		
		
	
	}
}
