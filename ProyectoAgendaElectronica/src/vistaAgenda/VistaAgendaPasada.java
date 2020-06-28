package vistaAgenda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;
import controlador.ControladorAgenda;
import lineales.ListaSE;
import modelo.*;

public class VistaAgendaPasada extends JFrame {
	/*PanelAgenda panel = new PanelAgenda();
	public VistaAgendaPasada() {
		
		/*ControladorAgenda agendaControl= new ControladorAgenda(new Agenda());
		agendaControl.getAgendaControlada().agregarCita(new Cita("asunto a","a",new Reloj(11,0,0),new Reloj(12,0,0),new Fecha(12,5,2020),"a"));
		agendaControl.getAgendaControlada().agregarCita(new Cita("asunto b","a",new Reloj(13,0,0),new Reloj(14,0,0),new Fecha(12,5,2020),"a"));
		agendaControl.getAgendaControlada().agregarCita(new Cita("asunto c","a",new Reloj(15,0,0),new Reloj(16,50,0),new Fecha(12,5,2020),"a"));
		System.out.println(agendaControl.getAgendaControlada().getLista().inOrden().longitud());
		
		setBounds(450,150,450,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);
		
	}
	
	public PanelAgenda getPanel() {
		return panel;
	}
}

class PanelAgenda extends JPanel{
	ControladorAgenda controlAgenda;
	//JPanel panelCitas = new JPanel();
	JPanel panelCitas;
    //JScrollPane listaCitas = new JScrollPane(panelCitas);
	JScrollPane listaCitas ;
	JTextField buscar = new JTextField("buscar");
	JButton agregar = new JButton("añadir");
	JButton mas_opciones = new JButton("mas...");
	
	public PanelAgenda() {
		setLayout(null);
		panelCitas = new JPanel();
		listaCitas = new JScrollPane(panelCitas);
		panelCitas.setLayout(new GridLayout(20,0));
		controlAgenda = new ControladorAgenda(new Agenda());
		this.controlAgenda = controlAgenda;
		agregarElementos();
		llenarPanelCitas();
		
	}
	
	public void agregarCitaEnPanel(Cita cita) {
		controlAgenda.getAgendaControlada().agregarCita(cita);
		System.out.println(controlAgenda.getAgendaControlada().getLista().inOrden().longitud());
	}
	
	private void agregarElementos() {
		buscar.setBounds(5, 10, 250, 20);
		agregar.setBounds(260, 10, 95, 20);
		mas_opciones.setBounds(360, 10, 70, 20);
		listaCitas.setBounds(5, 35, 425, 320);
		add(buscar);
		add(agregar);
		add(mas_opciones);
		add(listaCitas);
	}
	
	private void llenarPanelCitas() {
		//panelCitas.removeAll();
		ListaSE<Cita> listaCitas = (ListaSE<Cita>) controlAgenda.getAgendaControlada().getLista().inOrden();
		for(int i=0;i<listaCitas.longitud();i++) {
			Cita aux = listaCitas.acceder(i);
			panelCitas.add(new ElementoCita(aux.getAsunto(),aux.getDescripcion(),
					aux.getHoraInicio().toString(),aux.getHoraFin().toString(),aux.getFecha().toString()));
		}
	}
	
	/*public void setControlador(ControladorAgenda control) {
		agregar.addActionListener(control);
	}

}

class ElementoCita extends JButton {
	private JLabel asuntoCita;
	private JLabel descripcionCita;
	private JLabel horaInicioCita;
	private JLabel horaFinCita;
	private JLabel fechaCita;
	public ElementoCita(String asunto,String descripcion,String horaInicio,String horaFin,String fecha) {
		Border bordePanel = new TitledBorder(new EtchedBorder());
        setBorder(bordePanel);
        setBackground(Color.white);
        //setSize(500,300);
        setLayout(new GridLayout(2,3));
		asuntoCita = new JLabel(asunto);
		descripcionCita = new JLabel(descripcion);
		horaInicioCita = new JLabel(horaInicio);
		horaFinCita = new JLabel(horaFin);
		fechaCita = new JLabel(fecha);
		//setLayout(null);
		agregarLabels();
	}
	
	private void agregarLabels() {
		asuntoCita.setBounds(3, 3, 100, 15);
		descripcionCita.setBounds(3, 16, 150, 30);
		horaInicioCita.setBounds(3, 39, 50, 20);
		horaFinCita.setBounds(56, 39, 50, 20);
 		fechaCita.setBounds(350, 39, 50, 20);
		add(asuntoCita);
		//add(descripcionCita);
		add(new JLabel(" "));
		add(new JLabel(" "));
		add(horaInicioCita);
		add(horaFinCita);
		add(fechaCita);
	}*/
}
