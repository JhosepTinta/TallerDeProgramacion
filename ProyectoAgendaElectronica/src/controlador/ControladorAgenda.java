package controlador;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

import lineales.ListaSE;
import modelo.*;
import vistaAgenda.*;
import vistaMemo.*;

public class ControladorAgenda implements ActionListener {

	private Agenda agendaControlada;
	private VistaAgenda vistaControlada;

	/////////// atributos auxiliares///////////
	private VistaCrearCita crearCita;
	private VistaDetalleCitaPanel detalleCita;
	private VistaCrearMemo crearMemo;
	private VistaDetalleMemo detalleMemo;
	private boolean editando = false;
	//private Cita elemento = null;
	private ElementoCita elemento = null;
	//////////////////////////////////////////
	public ControladorAgenda(Agenda modelo, VistaAgenda vista) {
		agendaControlada = modelo;
		vistaControlada = vista;

		crearCita = new VistaCrearCita();
		detalleCita = new VistaDetalleCitaPanel();
		crearMemo = new VistaCrearMemo();

		crearCita.setControlador(this);
		crearCita.memo.setControlador(this);
		crearMemo.setControlador(this);
	}

	//////////////////////////////////////////// Guardar
	//////////////////////////////////////////// Datos///////////////////////////////////////////////
	public void guardarDatosAgenda() {
		try {
			ObjectOutputStream escribiendo = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\IBM LENOVO\\Desktop\\datos generados\\datosAgenda.dat"));
			escribiendo.writeObject(agendaControlada);
			escribiendo.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "ocurrio algun error al guardar");
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////// Leer Datos
	///////////////////////////////////// Guardados///////////////////////////////////////////////
	public Agenda leerDatosGuardadosAgenda() {
		Agenda datosRecogidos = null;
		try {
			ObjectInputStream leendo = new ObjectInputStream(
					new FileInputStream("C:\\Users\\IBM LENOVO\\Desktop\\datos generados\\datosAgenda.dat"));
			datosRecogidos = (Agenda) leendo.readObject();
			leendo.close();
		} catch (Exception e) {
			System.out.println("No se encontro el archivo datosAgenda.dat");
			System.out.println(e.getMessage());
		}
		return datosRecogidos;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Zona de Eventos para la vistaAgenda///////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == vistaControlada.agregar) {
			vistaControlada.visibilidadComponentes(false);// oculta los componentes superiores
			vistaControlada.editarTextoReferente("Usted esta creando una Cita...");
			vistaControlada.estadoTextoReferente(true);// pone visible el texto referente en la parte superior

			definirPanel(crearCita);// pone en pantalla el panel para creae citas
		} else if (evento.getSource() == vistaControlada.mas_opciones) {
			contar();
		} else if (evento.getSource() == crearCita.aceptar) {
			vistaControlada.estadoTextoReferente(false);
			vistaControlada.visibilidadComponentes(true);

			if (!editando) {
				/// lo necesario para crear///
				agregarCita(new Cita(crearCita.asuntoC.getText(), crearCita.descripcionC.getText(),
						new Reloj(crearCita.obtenerHora(crearCita.horaInicioC)),
						new Reloj(crearCita.obtenerHora(crearCita.horaFinC)), new Fecha(crearCita.obtenerFecha()),
						crearCita.lugarC.getText()));
				crearCita.limpiarEspacios();// limpia los recuadros despues de usarlos
				/////////////////////////////
			}else {
				System.out.println(elemento);
				elemento = null;
				editando = false;
			}
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() == crearCita.cancelar) {
			vistaControlada.estadoTextoReferente(false);
			vistaControlada.visibilidadComponentes(true);

			definirPanel(vistaControlada.panelCitas);
		}else if(evento.getSource()==crearCita.memo.agregar) {
			crearCita.memo.visibilidadTextoSuperior(true);
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.definirPanel(crearMemo);
		}else if(evento.getSource()==crearMemo.aceptar) {
			crearCita.memo.visibilidadTextoSuperior(false);
			crearCita.memo.visibilidadComponentesInferiores(true);
			///espacio para codigo de creacion de memo
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
		}else if(evento.getSource()==crearMemo.cancelar) {
			crearCita.memo.visibilidadTextoSuperior(false);
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
		}
	}

	// metodo para cambiar de paneles
	private void definirPanel(JPanel panel) {
		vistaControlada.listaCitas.setViewportView(panel);
	}
	//

	// metodo que agregar cita en la lista de citas
	private void agregarCitaEnPanel(Cita cita) {
		agendaControlada.agregarCita(cita);
	}
	//

	// metodo que permite actualizar las citas mostradas en el panel en pantalla
	private void llenarPanelCitas() {
		vistaControlada.panelCitas.removeAll();
		ListaSE<Cita> listaCitas = (ListaSE<Cita>) agendaControlada.getLista().inOrden();
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			vistaControlada.panelCitas.add(new ElementoCita(aux));
		}
	}
	
	
	public void contar() {/////////////////////////////////////////////////////////////////////////////////////////////////////////////7
		JPanel a = vistaControlada.panelCitas;
		for(int i=0;i<a.getComponentCount();i++) {
			System.out.println(a.getComponent(i));
		}
	}
	//

	// metodo que junta el agregar y actualizar
	public void agregarCita(Cita otra) {
		agregarCitaEnPanel(otra);
		llenarPanelCitas();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// Clase ElementoCita para mostrar la cita en un
	////////////////////////////////////////////////////////////////////////////////////////////////////////// panel//////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public class ElementoCita extends JButton implements ActionListener {

		private JLabel asuntoCita, horaInicioCita, horaFinCita, fechaCita;
		private Cita cita;

		public ElementoCita(Cita cita) {
			this.cita = cita;
			Border bordePanel = new TitledBorder(new EtchedBorder());
			setBorder(bordePanel);
			setBackground(Color.white);
			setLayout(new GridLayout(2, 3, 250, 15));
			asuntoCita = new JLabel(cita.getAsunto());
			horaInicioCita = new JLabel(cita.getHoraInicio().toString());
			horaFinCita = new JLabel(cita.getHoraFin().toString());
			fechaCita = new JLabel(cita.getFecha().toString());
			agregarLabels();
			detalleCita.setControlador(this);
		}

		private void agregarLabels() {
			asuntoCita.setBounds(3, 3, 100, 15);
			horaInicioCita.setBounds(3, 39, 50, 20);
			horaFinCita.setBounds(56, 39, 50, 20);
			fechaCita.setBounds(350, 39, 50, 20);
			add(asuntoCita);
			add(new JLabel("  "));
			add(new JLabel("  "));
			add(horaInicioCita);
			add(horaFinCita);
			add(fechaCita);
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource() == ElementoCita.this) {
				detalleCita.darValores(cita.getAsunto(), cita.getDescripcion(), cita.getHoraInicio().toString(),
						cita.getHoraFin().toString(), cita.getFecha().toString(), cita.getContactosEnCita().toString(),
						cita.getLugar());
				definirPanel(detalleCita);
			} else if (evento.getSource() == detalleCita.editar) {
				editando = true;
				elemento = this;
				definirPanel(crearCita);
			} else if (evento.getSource() == detalleCita.cancelar) {
				definirPanel(vistaControlada.panelCitas);
			}

		}

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Agenda getAgendaControlada() {
		return agendaControlada;
	}

	public void setAgendaControlada(Agenda agendaControlada) {
		this.agendaControlada = agendaControlada;
	}
	
}
