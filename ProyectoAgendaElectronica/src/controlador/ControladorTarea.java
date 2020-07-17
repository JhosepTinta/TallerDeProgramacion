package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;

import lineales.ListaSE;
import modelo.Agenda;
import modelo.Cita;
import modelo.Memo;
import vista.TareaVista;


public class ControladorTarea implements ActionListener {
	
	private TareaVista vistatarea = new TareaVista ();
	private Agenda agendacontrolada;
	DefaultListModel DLM = new DefaultListModel();
	
	//auxiliar metodos
	public ArrayList<Cita> b;
	public ListaSE<Cita> nuevo;
	private ArrayList<Memo> listaMemoDeMomento = new ArrayList<>();
	
	public ControladorTarea(TareaVista  nuevo, Agenda modelo)
	{
		vistatarea = nuevo;
		agendacontrolada = modelo;
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vistatarea.actualizar)
		{
			
		   nuevo = (ListaSE<Cita>) agendacontrolada.getLista().inOrden();
		  	
		
		  //	ArrayList<Cita> b = getConvertir(nuevo);
		  	 b = getConvertir(nuevo);
	    	
		 
	       DLM.addAll(b);
	       vistatarea.list.setModel(DLM);
	
		}else if(e.getSource()==vistatarea.eliminar)
		{
			
			int eliminaralarma =  vistatarea.list.getSelectedIndex();
			
			//v.CrearAlarma(0,0,0,"AM");
		 //   Cita x = nuevo.acceder(eliminaralarma);
		   
			DLM.remove(eliminaralarma);
			nuevo.eliminar();
			System.out.println("se presiono el boton 2");
			
		}else if(e.getSource()==vistatarea.eliminartodo)
			
		{
			int elitodo = vistatarea.list.getSelectedIndex();
			//v.CrearAlarma(0,0,0,"AM");
			DLM.removeAllElements();
			//lista.listalarma.clear();
			System.out.println("se presiono el boton 3");
		}
			
			
	
		
		
	}
	
	public ArrayList<Cita> getConvertir(ListaSE<Cita> nuevo)
	{
		 ArrayList<Cita> res = new ArrayList<>();
		 for(int i=0 ; i<nuevo.longitud();i++) {
			 
	      res.add(nuevo.acceder(i));
		 }
		 return res;
	}

	
}



