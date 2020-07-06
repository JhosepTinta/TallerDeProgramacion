package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Agenda;
import modelo.ListaTareaPendiente;

/*public class TareaVista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TareaVista frame = new TareaVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	public TareaVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}*/
	
	public class TareaVista extends JPanel {
		private JTextField texto;
		DefaultListModel DLM = new DefaultListModel();
		ListaTareaPendiente mistareas = new ListaTareaPendiente(new Agenda());

		/**
		 * Create the panel.
		 */
		public TareaVista() {
		
			
			setBackground(Color.white);
			setBounds(181, 0, 753, 561);
			setLayout(null);
			

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(298, 69, 426, 424);
			add(scrollPane);
			
			JList list = new JList();
			
			JLabel lblNewLabel = new JLabel("TAREAS PENDIENTES");
			lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 11, 278, 66);
			add(lblNewLabel);
		
			
			JButton btnNewButton = new JButton("ACTUALIZAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date fecha =new  Date();
			

				
					mistareas.agregarTarea("tengo que hacer tarea", fecha, "tareas");
						
						DLM.removeAllElements();
					 for(int i=0 ; i<mistareas.getTareaPendiente().size(); i++)
						   {

							   //DLM.addElement(mistareas.getListarecordatorios().get(i));
							  DLM.addElement(mistareas.getTareaPendiente().get(i));
				                list.setModel(DLM);

						   }
						   
						 for(int i=0 ; i<mistareas.getListarecordatorios().size(); i++)
						   {

							   //DLM.addElement(mistareas.getListarecordatorios().get(i));
							  DLM.addElement(mistareas.getListarecordatorios().get(i));
				                list.setModel(DLM);

						   }
						
						//String txt = texto.getText();
					//	DLM.addElement(txt);
					
					
					
				}
			});
			btnNewButton.setBounds(86, 126, 132, 40);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("ELIMINAR");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int eliminar =  list.getSelectedIndex();
					DLM.remove(eliminar);
				}
			});
			btnNewButton_1.setBounds(104, 231, 89, 23);
			add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("ELIMINAR TODO");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int elitodo = list.getSelectedIndex();
					DLM.removeAllElements();
				}
			});
			btnNewButton_2.setBounds(79, 337, 139, 23);
			add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("SALIR");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
					
				}
			});
			btnNewButton_3.setBounds(622, 527, 98, 23);
			add(btnNewButton_3);
			
			texto = new JTextField();
			texto.setBounds(69, 395, 188, 23);
			add(texto);
			texto.setColumns(10);
			

			scrollPane.setViewportView(list);
			setLayout(null);
			
		}
	}



