package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import VistaCalendario.VentanaCalendarioCita;
import controlador.ControladorAgenda.ElementoCitaDos;
import controlador.ControladorAgenda.ElementoCitaDos.PanelDescripcion;
import lineales.ListaSE;
import modelo.*;
import noLineales.ArbolBB;

import vistaAgenda.*;
import vistaMemo.*;

// lll revisar la forma
//en la que esta borrando
public class ControladorAgenda implements ActionListener, FocusListener {

	private Agenda agendaControlada;
	private VistaAgenda vistaControlada;

	/////////// atributos auxiliares///////////
	private VistaCrearCita crearCita;
	private VistaDetalleCitaPanel detalleCita;
	private VistaCrearMemo crearMemo;
	private VistaDetalleMemo detalleMemo;
	private VentanaCalendarioCita ventanacalendariocita;

	private boolean editandoCita = false;
	private boolean editandoMemo = false;
	private boolean observandoCita = false;

	private Cita citaDeMomento = null;
	private Memo memoDeMomento = null;
	private ArrayList<Memo> listaMemoDeMomento = new ArrayList<>();
	private Archivo contactos = new Archivo();
	//////////////////////////////////////////
	public ControladorAgenda(Agenda modelo, VistaAgenda vista) {
		agendaControlada = modelo;
		vistaControlada = vista;

		crearCita = new VistaCrearCita();
		detalleCita = new VistaDetalleCitaPanel();
		crearMemo = new VistaCrearMemo();
		detalleMemo = new VistaDetalleMemo();

		crearCita.setControlador(this);
		crearCita.memo.setControlador(this);
		crearMemo.setControlador(this);
		detalleCita.setControlador(this);
		detalleMemo.setControlador(this);
		llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Zona de Eventos para la
	////////////////////////////////////////////////////////////////////////////////////////////////////////// vistaAgenda///////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == vistaControlada.agregar) {
			textoSuperiorDelPanel("Usted esta creando una Cita...");
			crearCita.limpiarEspacios();

			//////////////////////////////////////////////////// 7
			//// Inicia la vista de memos ///////////////
			crearCita.memo.visibilidadTextoSuperior(false, "");
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			//////////////////////////////////////////////////////

			definirPanel(crearCita);// pone en pantalla el panel para creae citas

		} else if (evento.getSource() == crearCita.aceptar) {
			quitarTextoSuperioDelPanel(true);

			if (!editandoCita) {
				/// lo necesario para crear///
				Cita paraAgregar = new Cita(crearCita.asuntoC.getText(), crearCita.descripcionC.getText(),
						new Reloj(crearCita.obtenerHora(crearCita.horaInicioC)),
						new Reloj(crearCita.obtenerHora(crearCita.horaFinC)), new Fecha(crearCita.obtenerFecha()),
						crearCita.lugarC.getText());
				paraAgregar.setListaRecordatorios(generarLista(listaMemoDeMomento));
				paraAgregar.setContactosEnCita(crearCita.contactosC.getText());
				if (crearCita.activarNotificaciones.isSelected()) {
					System.out.println("notificacion marcada");
					Reloj alarmaRescatada = traducirNotificacion(
							Integer.parseInt(crearCita.numeroSeleccionado.getValue().toString()),
							(String) crearCita.tiempoSeleccionado.getSelectedItem(), paraAgregar.getFecha(),
							paraAgregar.getHoraInicio());
					System.out.println(alarmaRescatada);
					String dia_noche = diaNocheCita(paraAgregar.getHoraInicio());
					AlertaAlarma alarma = new AlertaAlarma();
					alarma.CrearAlarma(filtroNumero(alarmaRescatada.getHora()),
							filtroNumero(alarmaRescatada.getMinutos()), filtroNumero(alarmaRescatada.getSegundos()),
							dia_noche);
					paraAgregar.setAlarmaCita(alarma);
				}
				agregarCita(paraAgregar);
				crearCita.limpiarEspacios();// limpia los recuadros despues de usarlos

				/////////////////////////////
			} else {

				citaDeMomento.setAsunto(crearCita.asuntoC.getText());
				citaDeMomento.setDescripcion(crearCita.descripcionC.getText());
				citaDeMomento.setHoraInicio(new Reloj(crearCita.obtenerHora(crearCita.horaInicioC)));
				citaDeMomento.setHoraFin(new Reloj(crearCita.obtenerHora(crearCita.horaFinC)));
				citaDeMomento.setFecha(new Fecha(crearCita.obtenerFecha()));
				citaDeMomento.setLugar(crearCita.lugarC.getText());
				citaDeMomento.setListaRecordatorios(generarLista(listaMemoDeMomento));
				citaDeMomento.setContactosEnCita(crearCita.contactosC.getText());
				listaMemoDeMomento = new ArrayList<Memo>();
				crearCita.limpiarEspacios();
				llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
				citaDeMomento = null;
				editandoCita = false;
			}
			crearCita.memo.panelMemos.removeAll();
			listaMemoDeMomento.clear();
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() == crearCita.cancelar) {
			quitarTextoSuperioDelPanel(true);
			listaMemoDeMomento = new ArrayList<Memo>();
			crearCita.memo.panelMemos.removeAll();
			crearMemo.limpiarEspacios();
			citaDeMomento = null;
			editandoCita = false;
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() == crearCita.memo.agregar) {
			crearCita.memo.visibilidadTextoSuperior(true, "Usted esta creando un Memo ...");
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.definirPanel(crearMemo);
		} else if (evento.getSource() == crearCita.memo.eliminar) {
			if (JOptionPane.showConfirmDialog(vistaControlada, "Esta seguro de eliminar la lista de Recordatorios",
					"Titulo", 2, 2) == 0) {
				listaMemoDeMomento = new ArrayList<Memo>();
				llenarPanelMemo(listaMemoDeMomento, crearCita.memo.panelMemos);
				crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			}

		} else if (evento.getSource() == crearMemo.aceptar) {
			crearCita.memo.visibilidadTextoSuperior(false, "");
			crearCita.memo.visibilidadComponentesInferiores(true);

			if (!editandoMemo) {
				/// espacio para codigo de creacion de memo
				agregarMemo(new Memo(crearMemo.tituloC.getText(), crearMemo.textoC.getText()));
			} else {
				memoDeMomento.setTexto(crearMemo.textoC.getText());
				memoDeMomento.setTitulo(crearMemo.tituloC.getText());
				memoDeMomento = null;
				editandoMemo = false;
				llenarPanelMemo(listaMemoDeMomento, crearCita.memo.panelMemos);
			}

			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			crearMemo.limpiarEspacios();
		} else if (evento.getSource() == crearMemo.cancelar) {
			crearCita.memo.visibilidadTextoSuperior(false, "");
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);

		} else if (evento.getSource() instanceof ElementoCita) {
			ElementoCita a = (ElementoCita) evento.getSource();
			Cita b = a.getCita();
			detalleCita.darValores(b.getAsunto(), b.getDescripcion(), b.getHoraInicio().toString(),
					b.getHoraFin().toString(), b.getFecha().toString(), b.getContactosEnCita().toString(),
					b.getLugar());
			llenarPanelMemo(b.getListaRecordatorios(), detalleCita.detalleMemo.panelMemos);
			textoSuperiorDelPanel("Usted esta revisando una Cita...");
			observandoCita = true;
			definirPanel(detalleCita);
			citaDeMomento = b;

		} else if (evento.getSource() == detalleCita.editar) {

			crearCita.darValores(citaDeMomento.getAsunto(), citaDeMomento.getDescripcion(),
					citaDeMomento.getHoraInicio().toString(), citaDeMomento.getHoraFin().toString(),
					citaDeMomento.getFecha().toString(), citaDeMomento.getContactosEnCita().toString(),
					citaDeMomento.getLugar());
			editandoCita = true;
			textoSuperiorDelPanel("Usted esta editando una Cita...");
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.visibilidadTextoSuperior(false, "");
			listaMemoDeMomento = generarLista(citaDeMomento.getListaRecordatorios());
			llenarPanelMemo(listaMemoDeMomento, crearCita.memo.panelMemos);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			observandoCita = false;
			definirPanel(crearCita);
		} else if (evento.getSource() == detalleCita.cancelar) {
			quitarTextoSuperioDelPanel(true);
			citaDeMomento = null;
			editandoCita = false;
			observandoCita = false;
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() instanceof ElementoMemo) {
			ElementoMemo rescatado = (ElementoMemo) evento.getSource();
			Memo memoRescatado = rescatado.getMemo();
			memoDeMomento = memoRescatado;
			detalleMemo.darValores(memoRescatado.getTitulo(), memoRescatado.getTexto());
			if (!observandoCita) {
				crearCita.memo.visibilidadComponentesInferiores(false);
				crearCita.memo.visibilidadTextoSuperior(true, "Esta revisando un Memo");
				detalleMemo.editar.setVisible(true);
				crearCita.memo.definirPanel(detalleMemo);
			} else {
				String fechaCreacionMemo = memoDeMomento.getFechaCreacion().toString();
				detalleCita.detalleMemo.visibilidadTextoSuperior(true,
						"Memo creado el: " + fechaCreacionMemo.replaceAll(" ", ""));
				detalleMemo.editar.setVisible(false);
				detalleCita.detalleMemo.definirPanel(detalleMemo);

			}

		} else if (evento.getSource() == detalleMemo.editar) {
			crearMemo.darValores(memoDeMomento.getTitulo(), memoDeMomento.getTexto());
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.visibilidadTextoSuperior(true, "Usted esta editando un Memo ...");
			editandoMemo = true;
			observandoCita = false;///////////////////////////////////////////////////////////////////////////// 7
			crearCita.memo.definirPanel(crearMemo);
		} else if (evento.getSource() == detalleMemo.cancelar) {
			if (!observandoCita) {
				crearCita.memo.visibilidadComponentesInferiores(true);
				crearCita.memo.visibilidadTextoSuperior(false, "");
				memoDeMomento = null;
				crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			} else {
				detalleCita.detalleMemo.visibilidadTextoSuperior(false, "");
				detalleCita.detalleMemo.definirPanel(detalleCita.detalleMemo.panelMemos);
			}
		} else if (evento.getSource() == vistaControlada.buscarBoton) {
			String textoBuscado = vistaControlada.buscar.getText();
			ListaSE<Cita> listaBuscada = agendaControlada.buscarLugarAsunto(textoBuscado, textoBuscado);
			llenarPanelCitas(listaBuscada);
			vistaControlada.visibilidadVolver(true);
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() == vistaControlada.volver) {
			llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
			vistaControlada.visibilidadVolver(false);
			vistaControlada.visibilidadBuscar(true);
			vistaControlada.buscar.setText("buscar");
			definirPanel(vistaControlada.panelCitas);
		} else if (evento.getSource() == crearCita.calendarioBoton) {
			ventanacalendariocita = new VentanaCalendarioCita(crearCita);
			// crearCita.fechaC.setText(ventanacalendariocita.calen.getFechaMarcada());
		} else if (evento.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) evento.getSource();
			if (item.getText().equals("Eliminar Varios")) {
				vistaControlada.visibilidadVolverDos(true);
				vistaControlada.seleccion.setSelected(false);
				llenarPanelCitasDos((ListaSE<Cita>) agendaControlada.getLista().inOrden(), false);
				definirPanel(vistaControlada.panelCitas);
			}
		} else if (evento.getSource() == vistaControlada.eliminar) {
			if (JOptionPane.showConfirmDialog(vistaControlada, "Seguro de eliminar las citas seleccionadas", "Titulo",
					2, 2) == 0) {
				if (vistaControlada.seleccion.isSelected()) {
					agendaControlada.setLista(new ArbolBB<Cita>());
					llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
					vistaControlada.visibilidadVolver(false);
					vistaControlada.visibilidadBuscar(true);
					vistaControlada.buscar.setText("buscar");
					definirPanel(vistaControlada.panelCitas);
				} else {
					int i = 0;
					while (i < vistaControlada.panelCitas.getComponentCount()) {
						ElementoCitaDos elemento = (ElementoCitaDos) vistaControlada.panelCitas.getComponent(i);
						if (elemento.elementoSeleccionado()) {
							agendaControlada.eliminarCita(elemento.getCita());
						}
						i++;
					}
					llenarPanelCitasDos((ListaSE<Cita>) agendaControlada.getLista().inOrden(), false);
					definirPanel(vistaControlada.panelCitas);
				}

			}
		} else if (evento.getSource() == crearCita.panelDeContactos.buscar) {
			ArrayList<String> lista = contactos.contactos(crearCita.panelDeContactos.textoBusqueda.getText());
			llenarListaContactos(lista);
			crearCita.panelDeContactos.actualizarPanel();
		} else if (evento.getSource() == crearCita.panelDeContactos.cerrar) {
			crearCita.panelDeContactos.setVisible(false);
		} else if(evento.getSource() instanceof ElementoContacto) {
			ElementoContacto contactoRecuperado = (ElementoContacto)evento.getSource();
			String nombreRecuperado = contactoRecuperado.getTexto();
			crearCita.contactosC.setText(crearCita.contactosC.getText()+nombreRecuperado+", ");
		}
		agendaControlada.guardarDatosAgenda();
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
	private void llenarPanelCitas(ListaSE<Cita> lista) {
		vistaControlada.panelCitas.removeAll();
		ListaSE<Cita> listaCitas = lista;
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			vistaControlada.panelCitas.add(new ElementoCita(aux, this));
		}
	}

	// segundo metodo que permite actualizar las citas mostradas en el panel en
	// pantalla
	private void llenarPanelCitasDos(ListaSE<Cita> lista, boolean estado) {
		vistaControlada.panelCitas.removeAll();
		ListaSE<Cita> listaCitas = lista;
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			vistaControlada.panelCitas.add(new ElementoCitaDos(aux, this, estado));
			// vistaControlada.panelCitas.add(new ElementoCitaDos(aux,
			// this));////////////////////////////////// borrar
		}
	}

	public void contar() {///////////////////////////////////////////////////////////////////////////////////////////////////////////// 7
		JPanel a = vistaControlada.panelCitas;
		for (int i = 0; i < a.getComponentCount(); i++) {
			if (a.getComponent(i) instanceof ElementoCita) {
				ElementoCita aun = (ElementoCita) a.getComponent(i);
				System.out.println(aun.getCita());
			}
		}
	}
	//

	// metodo que junta el agregar y actualizar
	private void agregarCita(Cita otra) {
		agregarCitaEnPanel(otra);
		llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
	}
	//

	// metodo para actualizar el panel de memos
	private void llenarPanelMemo(ArrayList<Memo> listaMemo, JPanel aLlenar) {
		aLlenar.removeAll();
		ArrayList<Memo> listaCitas = listaMemo;
		for (int i = 0; i < listaCitas.size(); i++) {
			Memo aux = listaCitas.get(i);
			aLlenar.add(new ElementoMemo(aux, this));
		}
	}

	// metodo para actualizar el panel de cita cuando se hace click en agenda
	public void llenarPanelCitaRapido() {
		vistaControlada.panelCitas.removeAll();
		ListaSE<Cita> listaCitas = (ListaSE<Cita>) agendaControlada.getLista().inOrden();
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			vistaControlada.panelCitas.add(new ElementoCita(aux, this));
		}
	}

	// metodo que agragega elementos
	public void agregarMemo(Memo otro) {
		listaMemoDeMomento.add(otro);
		llenarPanelMemo(listaMemoDeMomento, crearCita.memo.panelMemos);
	}

	// metodo para generar listas
	private ArrayList<Memo> generarLista(ArrayList<Memo> lista) {
		ArrayList<Memo> respuesta = new ArrayList<Memo>();
		for (int i = 0; i < lista.size(); i++) {
			respuesta.add(lista.get(i));
		}
		return respuesta;
	}

	// metodo para definir el texto de arriba al crear, editar o revisar una cita
	private void textoSuperiorDelPanel(String titulo) {
		vistaControlada.visibilidadComponentes(false);// oculta los componentes superiores
		vistaControlada.editarTextoReferente(titulo);
		vistaControlada.estadoTextoReferente(true);// pone visible el texto referente en la parte superior
	}

	// metodo para quitar el texto de la parte de arriba cuando estamos creando,
	// editando o revisando
	private void quitarTextoSuperioDelPanel(boolean estado) {
		vistaControlada.estadoTextoReferente(!estado);
		vistaControlada.visibilidadComponentes(estado);
	}

	// metodo para traducir la notificacion a la clase AlertaAlarma
	private Reloj traducirNotificacion(int tiempo, String medida, Fecha fechaCita, Reloj inicioCita) {
		Reloj res = inicioCita;
		if (medida.equals("minutos")) {
			if (tiempo <= inicioCita.getMinutos()) {
				res = new Reloj(inicioCita.getHora(), inicioCita.getMinutos() - tiempo, inicioCita.getSegundos());
			} else {
				res = inicioCita.getHora() != 0
						? new Reloj(inicioCita.getHora() - 1, 60 - tiempo, inicioCita.getSegundos())
						: new Reloj(23, 60 - tiempo, inicioCita.getSegundos());
			}
		} else if (medida.equals("horas")) {
			if (tiempo <= inicioCita.getHora()) {
				res = new Reloj(inicioCita.getHora() - tiempo, inicioCita.getMinutos(), inicioCita.getSegundos());
			}
		} else if (medida.equals("dias")) {

		} else if (medida.equals("semanas")) {

		}
		return res;
	}

	// metodo para saber si la cita inicia en el dia o la noche
	private String diaNocheCita(Reloj inicioCita) {
		String res = "";
		if (inicioCita.getHora() <= 12) {
			res = "AM";
		} else {
			res = "PM";
		}
		return res;
	}

	// filtro de numeros
	private int filtroNumero(int n) {
		int res = n;
		if (n == 13) {
			res = 1;
		} else if (n == 14) {
			res = 2;
		} else if (n == 15) {
			res = 3;
		} else if (n == 16) {
			res = 4;
		} else if (n == 17) {
			res = 5;
		} else if (n == 18) {
			res = 6;
		} else if (n == 19) {
			res = 7;
		} else if (n == 20) {
			res = 8;
		} else if (n == 21) {
			res = 9;
		} else if (n == 22) {
			res = 10;
		} else if (n == 23) {
			res = 11;
		} else if (n == 0) {
			res = 12;
		}
		return res;
	}
	
	//llenar los contactos
	private void llenarListaContactos(ArrayList<String> lista) {
		crearCita.panelDeContactos.listaContactos.removeAll();
		for(int i=0;i<lista.size();i++) {
			crearCita.panelDeContactos.listaContactos.add(new ElementoContacto(lista.get(i),this));
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////// Eventos de Foco //////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

// metodo que se usa cuando un componente gana el foco
	public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
		if (e.getSource() == crearCita.contactosC) {
			System.out.println("ganaste el foco");
			crearCita.panelDeContactos.restablecerValores();
			crearCita.hacerVisiblePanelContactos(true);
		} else if (e.getSource() == vistaControlada.seleccion) {
			if (vistaControlada.seleccion.isSelected()) {
				llenarPanelCitasDos((ListaSE<Cita>) agendaControlada.getLista().inOrden(), false);
				System.out.println("1");
			} else {
				llenarPanelCitasDos((ListaSE<Cita>) agendaControlada.getLista().inOrden(), true);
				System.out.println("2");
			}
			// llenarPanelCitasDos((ListaSE<Cita>)
			// agendaControlada.getLista().inOrden(),true);

			definirPanel(vistaControlada.panelCitas);
		}
	}

// metodo que se usa cuando un componente pierde el foco
	public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub
		if (e.getSource() == crearCita.contactosC) {
			// System.out.println("perdiste el foco");
			// crearCita.hacerVisiblePanelContactos(false);
		} else if (e.getSource() == crearCita.panelDeContactos) {
			crearCita.panelDeContactos.setVisible(false);
			System.out.println("falta poco");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////// Clase ElementoCita para mostrar la cita en un panel/////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	class ElementoCita extends JButton implements ActionListener {

		private JLabel asuntoCita, horaInicioCita, horaFinCita, fechaCita;
		private Cita cita;
		JPopupMenu emergente = new JPopupMenu();
		public JMenuItem opcion1 = new JMenuItem("Eliminar");
		JMenuItem opcion2 = new JMenuItem("Eliminar Varios");

		public ElementoCita(Cita cita, ControladorAgenda control) {
			this.cita = cita;
			this.addActionListener(control);
			Border bordePanel = new TitledBorder(new EtchedBorder());
			setBorder(bordePanel);
			setBackground(Color.white);
			setLayout(new GridLayout(2, 3, 250, 15));
			asuntoCita = new JLabel(" " + cita.getAsunto());
			horaInicioCita = new JLabel("  " + cita.getHoraInicio().toString());
			horaFinCita = new JLabel(cita.getHoraFin().toString());
			fechaCita = new JLabel(cita.getFecha().toString());

			emergente.add(opcion1);
			emergente.add(opcion2);

			setComponentPopupMenu(emergente);
			opcion1.addActionListener(this);
			opcion2.addActionListener(control);

			agregarLabels();
//detalleCita.setControlador(this);
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
			// addActionListener(this);
		}

		public Cita getCita() {
			return cita;
		}

		public void setCita(Cita nueva) {
			cita = nueva;
		}

		public void setControlador(ControladorAgenda control) {
			this.addActionListener(control);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == opcion1) {
				if (JOptionPane.showConfirmDialog(vistaControlada, "Esta seguro de eliminar la Cita", "Titulo", 2,
						2) == 0) {
					agendaControlada.eliminarCita(cita);
					llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
					definirPanel(vistaControlada.panelCitas);
				}
				agendaControlada.guardarDatosAgenda();
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////// Clase ElementoMemo para mostrar un memo en un panel/////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	class ElementoMemo extends JButton implements ActionListener {
		private JLabel tituloMemo, resumenMemo;
		private Memo memo;

		JPopupMenu emergente = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Eliminar");

		public ElementoMemo(Memo memo, ControladorAgenda control) {
			setBackground(new Color(182, 248, 188));
			this.memo = memo;
			addActionListener(control);
			Border bordePanel = new TitledBorder(new EtchedBorder());
			setBorder(bordePanel);
			setBackground(Color.white);
			setLayout(new GridLayout(2, 0));
			tituloMemo = new JLabel(memo.getTitulo());
			resumenMemo = new JLabel(memo.getTexto());

			emergente.add(opcion1);
			setComponentPopupMenu(emergente);
			opcion1.addActionListener(this);

			add(tituloMemo);
			add(resumenMemo);
		}

		public Memo getMemo() {
			return memo;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == opcion1) {
				if (!observandoCita) {
					if (JOptionPane.showConfirmDialog(vistaControlada, "Esta seguro de eliminar este Memo", "Titulo", 2,
							2) == 0) {
						listaMemoDeMomento.remove(memo);
						llenarPanelMemo(listaMemoDeMomento, crearCita.memo.panelMemos);
						crearCita.memo.definirPanel(crearCita.memo.panelMemos);
					}
				}
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////Clase ElementoCitaDos para mostrar la cita en un panel/////////////////////////////
//////////////////////////cando queremos borrar algun elemento////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	class ElementoCitaDos extends JButton {

		private JLabel asuntoCita, horaInicioCita, horaFinCita, fechaCita;
		private JRadioButton seleccionElemento;
		JPanel panelSeleccion = new JPanel();

		private Cita cita;

		Border bordePanel = new TitledBorder(new EtchedBorder());

		public ElementoCitaDos(Cita cita, ControladorAgenda control, boolean estado) {
			this.cita = cita;
			this.addActionListener(control);
//seleccionElemento.setBorder(bordePanel);
			seleccionElemento = new JRadioButton("", estado);
			panelSeleccion.setBackground(Color.white);
			panelSeleccion.setBorder(bordePanel);
			panelSeleccion.setLayout(new GridLayout(3, 0));
			panelSeleccion.add(new JLabel(" "));
			panelSeleccion.add(seleccionElemento);

			setLayout(new BorderLayout());
			Border bordePanel = new TitledBorder(new EtchedBorder());
			setBorder(bordePanel);
			setBackground(Color.white);
			seleccionElemento.setBackground(Color.white);
			add(new PanelDescripcion(), BorderLayout.CENTER);
			add(panelSeleccion, BorderLayout.WEST);
		}

		public Cita getCita() {
			return cita;
		}

		public void setCita(Cita nueva) {
			cita = nueva;
		}

		public void setControlador(ControladorAgenda control) {
			this.addActionListener(control);
		}

		public boolean elementoSeleccionado() {
			return seleccionElemento.isSelected();
		}

		class PanelDescripcion extends JPanel {

			public PanelDescripcion() {
// Border bordePanel = new TitledBorder(new EtchedBorder());
// setBorder(bordePanel);
// setBackground(new Color(204,255,229));
// setBackground(new Color(102,255,178));
// setBackground(new Color(153,255,204));
// setBackground(new Color(102,178,255));
// setBackground(new Color(153,204,255));
				setBackground(new Color(204, 229, 255));
				setLayout(new GridLayout(2, 3, 250, 15));
				asuntoCita = new JLabel(" " + cita.getAsunto());
				horaInicioCita = new JLabel("  " + cita.getHoraInicio().toString());
				horaFinCita = new JLabel(cita.getHoraFin().toString());
				fechaCita = new JLabel(cita.getFecha().toString());
				agregarLabels();
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
			}

		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////// Clase ElementoMemo para mostrar un memo en un panel/////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	class ElementoContacto extends JButton {
		
		private JLabel contacto;
		private String contactoNombre;
		public ElementoContacto(String nombre, ControladorAgenda control) {
			addActionListener(control);
			Border bordePanel = new TitledBorder(new EtchedBorder());
			setBorder(bordePanel);
			setLayout(new GridLayout(2, 0));
			contactoNombre = nombre;
			contacto = new JLabel(nombre);

			add(contacto);
		}
		
		public String getTexto() {
			return contactoNombre;
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

}