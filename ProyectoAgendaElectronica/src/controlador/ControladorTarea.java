package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import controlador.ControladorAgenda.ElementoCitaDos;
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
	public ArrayList<Cita> x=null;
	public ListaSE<Cita> nuevo;
	private ArrayList<Memo> listaMemoDeMomento = new ArrayList<>();
	
	public ControladorTarea(TareaVista  nuevo, Agenda modelo)
	{
		vistatarea = nuevo;
		agendacontrolada = modelo;
	
		
	}
int z =0;
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
		    
		       ArrayList<Cita> c= getConvertir(nuevo);
		       x=c;
		      
		       JOptionPane.showMessageDialog(null, "ACTUALIZADO");
		      
			// }
			// else {
				 
				// JOptionPane.showMessageDialog(null, "NO HAY NUEVAS TAREAS");
				 
				 
			// }
			
			
//boton para marcar
			
		}else if(e.getSource()==vistatarea.realizada)
		{
			
			Cita elitodo = (Cita) vistatarea.list.getSelectedValue();
			
			System.out.println("se presiono el boton 3"+elitodo);
			if (JOptionPane.showConfirmDialog(vistatarea ,"Esta seguro de eliminar la Cita", "Titulo", 2,
					2) == 0) {
				agendacontrolada.eliminarCita(elitodo);
				llenarPanelCitas((ListaSE<Cita>) agendacontrolada.getLista().inOrden());
				definirPanel(vistatarea.list);
				int eliminaralarma =  vistatarea.list.getSelectedIndex();
				DLM.remove(eliminaralarma);
			}
			agendacontrolada.guardarDatosAgenda();
			
			System.out.println("se presiono el boton 2");
			
//boton para todas como realizadas 
			
		}
		else if(e.getSource()==vistatarea.realizadatodos)
			
		{
			
			//v.CrearAlarma(0,0,0,"AM");
		//	DLM.removeAllElements();
		  //  q.clear();
			//lista.listalarma.clear();
			if (JOptionPane.showConfirmDialog(vistatarea, "Seguro de eliminar las citas seleccionadas", "Titulo",
					2, 2) == 0) {
				
					int i = 0;
					System.out.println("SSSSSSSSSSSSSSS"+vistatarea.list.getComponentCount());
					while (i < vistatarea.list.getComponentCount()) {
						ElementoCitaDos elemento = (ElementoCitaDos) vistatarea.list.getComponent(i);
						if (elemento.elementoSeleccionado()) {
							agendacontrolada.eliminarCita(elemento.getCita());
							
						}
						i++;
						System.out.println("SSSSSSSSSSSSSSS"+ elemento);
					}
					llenarPanelCitasDos((ListaSE<Cita>) agendacontrolada.getLista().inOrden(), false);
					definirPanel(vistatarea.list);
					DLM.removeAllElements();
				}

			//agendacontrolada.guardarDatosAgenda();	
			System.out.println("se presiono el boton 3");
		}
			
		//agendacontrolada.guardarDatosAgenda();	
	
	}	
		
	
	
	public ArrayList<Cita> getConvertir(ListaSE<Cita> nuevo)
	{
		 ArrayList<Cita> res = new ArrayList<>();
		 for(int i=0 ; i<nuevo.longitud();i++) {
			 
	      res.add(nuevo.acceder(i));
		 }
		 return res;
	}
	
	// metodo que permite actualizar las citas mostradas en el panel en pantalla
	private void llenarPanelCitas(ListaSE<Cita> lista) {
		vistatarea.list.removeAll();
		ListaSE<Cita> listaCitas = lista;
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			//vistatarea.list.add(new ElementoCita(aux, this));
		}
	}
	
	// metodo para cambiar de paneles
	private void definirPanel(JList panel) {
		vistatarea.scrollPane.setViewportView(panel);
	}
	
	// segundo metodo que permite actualizar las citas mostradas en el panel en
	// pantalla
	private void llenarPanelCitasDos(ListaSE<Cita> lista, boolean estado) {
		vistatarea.list.removeAll();
		ListaSE<Cita> listaCitas = lista;
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
		//	vistatarea.list.add(new ElementoCitaDos(aux, this, estado));
			// vistaControlada.panelCitas.add(new ElementoCitaDos(aux,
			// this));////////////////////////////////// borrar
		}
	}
	
	
	
}




