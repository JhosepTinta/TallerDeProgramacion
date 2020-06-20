package vistaAgenda;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgenda;
import lineales.ListaSE;
import modelo.Agenda;
import modelo.Cita;

public class VistaAgendaPrueba extends JPanel{
	ControladorAgenda controlAgenda;
	//JPanel panelCitas = new JPanel();
	JPanel panelCitas;
    //JScrollPane listaCitas = new JScrollPane(panelCitas);
	JScrollPane listaCitas ;
	JTextField buscar = new JTextField("buscar");
	JButton agregar = new JButton("añadir");
	JButton mas_opciones = new JButton("mas...");
	
	public VistaAgendaPrueba() {
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
			panelCitas.add(new ElementoCita2(aux.getAsunto(),aux.getDescripcion(),
					aux.getHoraInicio().toString(),aux.getHoraFin().toString(),aux.getFecha().toString()));
		}
	}
	
}
class ElementoCita2 extends JButton {
	private JLabel asuntoCita;
	private JLabel descripcionCita;
	private JLabel horaInicioCita;
	private JLabel horaFinCita;
	private JLabel fechaCita;
	public ElementoCita2(String asunto,String descripcion,String horaInicio,String horaFin,String fecha) {
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
	}
}
