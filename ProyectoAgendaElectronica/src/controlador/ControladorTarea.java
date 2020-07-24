package controlador;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import controlador.ControladorAgenda.ElementoCitaDos;
import lineales.Lista;
import lineales.ListaSE;
import modelo.Agenda;
import modelo.AlarmaL;
import modelo.Cita;
import modelo.Memo;
import noLineales.ArbolBB;
import vista.TareaVista;


public class ControladorTarea implements ActionListener {
	
	private TareaVista vistatarea = new TareaVista ();
	private Agenda agendacontrolada;
	DefaultListModel DLM = new DefaultListModel();
	DefaultListModel DLME = new DefaultListModel();
	
	//auxiliar metodos
	
	public ArrayList<Cita> b;
	public ArrayList<Memo> mar;
	public ArrayList<Cita> x=null;
	public ListaSE<Cita> nuevo;
	public ArrayList<Memo> memo= new ArrayList<>();
	
	public ControladorTarea(TareaVista  nuevo, Agenda modelo)
	{
		vistatarea = nuevo;
		agendacontrolada = modelo;
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
// boton para actualizar
		if(e.getSource()==vistatarea.actualizar)
		{
			
				
				
			DLM.removeAllElements();
			
			
		     nuevo = (ListaSE<Cita>) agendacontrolada.getLista().inOrden();
		  	
		  	 b = getConvertir(nuevo);
		  
		  	
		
			   System.out.println(b);
		
		//	if(!b.equals(x)) {
			
			   for(int i=0 ; i<b.size(); i++)
			   {
				   DLM.addElement(b.get(i));
	                vistatarea.list.setModel(DLM);
			   }
		    
		   
		      
		       JOptionPane.showMessageDialog(null, "ACTUALIZADO");
		      
	
			
			
//boton para marcar
			
		}else if(e.getSource()==vistatarea.realizada)
		{
			
			Cita elitodo = (Cita) vistatarea.list.getSelectedValue();
			
			System.out.println("se presiono el boton 3"+elitodo);
			if (JOptionPane.showConfirmDialog(vistatarea ,"Esta seguro de poner realizado la cita", "Titulo", 2,
					2) == 0) {
			
				agendacontrolada.eliminarCita(elitodo);
				int eliminaralarma =  vistatarea.list.getSelectedIndex();
				DLM.remove(eliminaralarma);
			}
			agendacontrolada.guardarDatosAgenda();
			
			System.out.println("se presiono el boton 2");
			
//boton para todas como realizadas o borrar todas las citas
			
		}
		else if(e.getSource()==vistatarea.realizadatodos)
			
		{
			
		//	agendacontrolada = new Agenda();
	
			if (JOptionPane.showConfirmDialog(vistatarea, "Seguro que todas las citas estan realizadas", "Titulo",
					2, 2) == 0) {
				
					
					agendacontrolada.setLista(new ArbolBB<Cita>());
					DLM.removeAllElements();
				}

			agendacontrolada.guardarDatosAgenda();	
			
			

			
// NUEVOS BOTONES 
			
		}else if(e.getSource()==vistatarea.marcar)
		{
			vistatarea.list1.setCellRenderer(new CheckboxListCellRenderer());
			DLME.removeAllElements();
			 int n =  vistatarea.list.getSelectedIndex();
			 
			mar = getMemo(nuevo,n);
       		if(n==0 || n==1 || n==2 || n==3 || n==4 || n==5 || n==6 || n==7 || n==8 ||n==9 || n==10 || n==11 || n==12 || n==13 || n==14 || n==15|| n==16 || n==17 ||n==18 || n==19 || n==20)
		    for(int i=0 ; i<mar.size(); i++)
			   {
         	   
         	   DLME.addElement(mar.get(i));
                vistatarea.list1.setModel(DLME);;
			   }
		}else if(e.getSource()==vistatarea.marcar1)
		{
			int l =  vistatarea.list.getSelectedIndex();
			Cita m= nuevo.acceder(l);
			int n =  vistatarea.list1.getSelectedIndex();
			Memo c = (Memo) vistatarea.list1.getSelectedValue();
			System.out.println("rata"+c+n);
			DLME.remove(n);
			
			System.out.println("rata"+m);
			m.getListaRecordatorios().remove(n);
			//agendacontrolada.guardarDatosAgenda();
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
	
	public void eleminar(int n)
	{
		ArrayList<Memo> res = new ArrayList<>();
		  for(int j=0 ; j<res.size() ; j++)
    	  {
			  System.out.println("guardao" + res.get(j));
			
    	  }
		
		
	}

	public ArrayList<Memo> getMemo(ListaSE<Cita> nuevo2,int i)
	{
		 ArrayList<Memo> res = new ArrayList<>();
	     // for(int i=0 ; i<nuevo.longitud(); i++)
	     // {
	    	  Cita buscar = nuevo.acceder(i);
	    	  for(int j=0 ; j<buscar.getListaRecordatorios().size() ; j++)
	    	  {
	    		  res.add(buscar.getListaRecordatorios().get(j));
	    		  
	    	  }
	    	  
	    //  }
	    
		 return res;
	}
	
	
	public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer {

	    public Component getListCellRendererComponent(JList list, Object value, int index, 
	            boolean isSelected, boolean cellHasFocus) {

	        setComponentOrientation(list.getComponentOrientation());
	        setFont(list.getFont());
	        setBackground(list.getBackground());
	        setForeground(list.getForeground());
	        setSelected(isSelected);
	        setEnabled(list.isEnabled());

	        setText(value == null ? "" : value.toString());  

	        return this;
	    }
	}
	
	
	   
    public ArrayList<Memo> getAlarmaL(){
    	   
    	return memo;
    }
}




