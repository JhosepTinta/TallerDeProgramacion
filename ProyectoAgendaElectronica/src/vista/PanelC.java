package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Archivo;

public class PanelC extends JPanel {

	public JButton btnG;
	public JTable table;
	private JLabel txtListaDeContactos;
	
	public PanelC() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(new BorderLayout(0, 0));
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		Archivo a = new Archivo();
		
		btnG = new JButton("Gestionar Contactos");
		add(btnG, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBackground(new Color(255, 255, 255));
		int numC = a.numeroC();                                       //Remplazar 3 por numero de Contactos
		mostrarMatriz(darMatriz(numC),numC);              
		add(table, BorderLayout.CENTER);
		
		txtListaDeContactos = new JLabel("Lista de Contactos");
		txtListaDeContactos.setBackground(SystemColor.inactiveCaptionBorder);
		txtListaDeContactos.setFont(new Font("Agency FB", Font.BOLD, 35));
		add(txtListaDeContactos, BorderLayout.NORTH);
		
	}
	
	public void mostrarMatriz(String matriz[][],int tamano) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setRowCount(tamano);                //filas
		model.setColumnCount(5);             //Columnas
		for(int i=0;i<tamano;i++) {
		for(int j=0;j<5;j++) {
			table.setValueAt(matriz[i][j], i, j);
		}
	}
	}
	public String[][] darMatriz(int numC){
		Archivo a = new Archivo();
		 String matrix[][]=new String[numC][5];//Remplazar 3 por numero de Contactos
		  return a.enviarMatriz(matrix);     //Dará de Archivo
         
	}

}
