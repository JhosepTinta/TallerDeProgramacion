package controlador;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import VistaCalendario.VentanaCalendarioCita;
import lineales.ListaSE;
import modelo.*;
import vistaAgenda.*;
import vistaMemo.*;
// revisar la forma en la que esta borrando
public class ControladorAgenda implements ActionListener {

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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == vistaControlada.agregar) {
			textoSuperiorDelPanel("Usted esta creando una Cita...");
			crearCita.limpiarEspacios();
				
			////////////////////////////////////////////////////7
			////Inicia la vista de memos ///////////////
			crearCita.memo.visibilidadTextoSuperior(false,"");
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			//////////////////////////////////////////////////////
			 

			definirPanel(crearCita);// pone en pantalla el panel para creae citas
			
		} else if (evento.getSource() == vistaControlada.mas_opciones) {
			contar();
		} else if (evento.getSource() == crearCita.aceptar) {
			quitarTextoSuperioDelPanel(true);

			if (!editandoCita) {
				/// lo necesario para crear///
				Cita paraAgregar =new Cita(crearCita.asuntoC.getText(), crearCita.descripcionC.getText(),
						new Reloj(crearCita.obtenerHora(crearCita.horaInicioC)),
						new Reloj(crearCita.obtenerHora(crearCita.horaFinC)), new Fecha(crearCita.obtenerFecha()),
						crearCita.lugarC.getText());
				paraAgregar.setListaRecordatorios(generarLista(listaMemoDeMomento));
				if(crearCita.activarNotificaciones.isSelected()) {
					System.out.println("notificacion marcada");
					Reloj alarmaRescatada = traducirNotificacion(Integer.parseInt(crearCita.numeroSeleccionado.getValue().toString())
							,(String)crearCita.tiempoSeleccionado.getSelectedItem(), 
							paraAgregar.getFecha(),paraAgregar.getHoraInicio());
					String dia_noche = diaNocheCita(paraAgregar.getHoraInicio());
					AlertaAlarma alarma = new AlertaAlarma();
					alarma.CrearAlarma(filtroNumero(alarmaRescatada.getHora()),
							filtroNumero(alarmaRescatada.getMinutos()),filtroNumero(alarmaRescatada.getSegundos()), 
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
				citaDeMomento.setFecha( new Fecha(crearCita.obtenerFecha()));
				citaDeMomento.setLugar(crearCita.lugarC.getText());
				citaDeMomento.setListaRecordatorios(generarLista(listaMemoDeMomento));
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
			crearCita.memo.visibilidadTextoSuperior(true,"Usted esta creando un Memo ...");
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.definirPanel(crearMemo);
		} else if (evento.getSource() == crearMemo.aceptar) {
			crearCita.memo.visibilidadTextoSuperior(false,"");
			crearCita.memo.visibilidadComponentesInferiores(true);
			
			if(!editandoMemo) {
				/// espacio para codigo de creacion de memo
				agregarMemo(new Memo(crearMemo.tituloC.getText(),crearMemo.textoC.getText()));
			}else {
				memoDeMomento.setTexto(crearMemo.textoC.getText());
				memoDeMomento.setTitulo(crearMemo.tituloC.getText());
				memoDeMomento = null;
				editandoMemo = false;
				llenarPanelMemo(listaMemoDeMomento,crearCita.memo.panelMemos);
			}
			
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			crearMemo.limpiarEspacios();
		} else if (evento.getSource() == crearMemo.cancelar) {
			crearCita.memo.visibilidadTextoSuperior(false,"");
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			
		} else if (evento.getSource() instanceof ElementoCita) {
			ElementoCita a = (ElementoCita) evento.getSource();
			Cita b = a.getCita();
			detalleCita.darValores(b.getAsunto(), b.getDescripcion(), b.getHoraInicio().toString(),
					b.getHoraFin().toString(), b.getFecha().toString(), b.getContactosEnCita().toString(),
					b.getLugar());
			llenarPanelMemo(b.getListaRecordatorios(),detalleCita.detalleMemo.panelMemos);
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
			llenarPanelMemo(listaMemoDeMomento,crearCita.memo.panelMemos);
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			observandoCita = false;
			definirPanel(crearCita);
		} else if (evento.getSource() == detalleCita.cancelar) {
			quitarTextoSuperioDelPanel(true);
			citaDeMomento = null;
			editandoCita = false;
			observandoCita = false;
			definirPanel(vistaControlada.panelCitas);
		}else if(evento.getSource() instanceof ElementoMemo) {
			ElementoMemo rescatado = (ElementoMemo)evento.getSource();
			Memo memoRescatado = rescatado.getMemo();
			memoDeMomento = memoRescatado;
			detalleMemo.darValores(memoRescatado.getTitulo(),memoRescatado.getTexto());
			if(!observandoCita) {
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.visibilidadTextoSuperior(true,"Esta revisando un Memo");
			detalleMemo.editar.setVisible(true);
			crearCita.memo.definirPanel(detalleMemo);
			}else {
				String fechaCreacionMemo = memoDeMomento.getFechaCreacion().toString();
				detalleCita.detalleMemo.visibilidadTextoSuperior(true,"Memo creado el: "+fechaCreacionMemo.replaceAll(" ",""));
				detalleMemo.editar.setVisible(false);
				detalleCita.detalleMemo.definirPanel(detalleMemo);
				
			}
			
		}else if(evento.getSource() == detalleMemo.editar) {
			crearMemo.darValores(memoDeMomento.getTitulo(), memoDeMomento.getTexto());
			crearCita.memo.visibilidadComponentesInferiores(false);
			crearCita.memo.visibilidadTextoSuperior(true, "Usted esta editando un Memo ...");
			editandoMemo = true;
			observandoCita = false;/////////////////////////////////////////////////////////////////////////////7
			crearCita.memo.definirPanel(crearMemo);
		}else if(evento.getSource() == detalleMemo.cancelar) {
			if(!observandoCita) {
			crearCita.memo.visibilidadComponentesInferiores(true);
			crearCita.memo.visibilidadTextoSuperior(false, "");
			memoDeMomento = null;
			crearCita.memo.definirPanel(crearCita.memo.panelMemos);
			}else {
				detalleCita.detalleMemo.visibilidadTextoSuperior(false,"");
				detalleCita.detalleMemo.definirPanel(detalleCita.detalleMemo.panelMemos);
			}
		}else if(evento.getSource() == vistaControlada.buscarBoton) {
			String textoBuscado = vistaControlada.buscar.getText();
			ListaSE<Cita> listaBuscada = agendaControlada.buscarLugarAsunto(textoBuscado, textoBuscado);
			llenarPanelCitas(listaBuscada);
			vistaControlada.visibilidadVolver(true);
			definirPanel(vistaControlada.panelCitas);
		}else if(evento.getSource() == vistaControlada.volver) {
			llenarPanelCitas((ListaSE<Cita>) agendaControlada.getLista().inOrden());
			vistaControlada.visibilidadVolver(false);
			vistaControlada.buscar.setText("buscar");
			definirPanel(vistaControlada.panelCitas);
		}else if(evento.getSource() == crearCita.calendarioBoton) {
	         ventanacalendariocita = new VentanaCalendarioCita();
	         String fecha = ventanacalendariocita.calen.getActual().diaapretado;
	         crearCita.fechaC.setText(fecha);
	        
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
	private void llenarPanelCitas(ListaSE<Cita> lista) {
		vistaControlada.panelCitas.removeAll();
		ListaSE<Cita> listaCitas = lista;
		for (int i = 0; i < listaCitas.longitud(); i++) {
			Cita aux = listaCitas.acceder(i);
			vistaControlada.panelCitas.add(new ElementoCita(aux, this));
		}
	}

	public void contar() {///////////////////////////////////////////////////////////////////////////////////////////////////////////// 7
		JPanel a = vistaControlada.panelCitas;
		for (int i = 0; i < a.getComponentCount(); i++) {
			if(a.getComponent(i) instanceof ElementoCita) {
				ElementoCita aun = (ElementoCita)a.getComponent(i);
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
	
	//metodo para actualizar el panel de memos
	private void llenarPanelMemo(ArrayList<Memo> listaMemo, JPanel aLlenar) {
		aLlenar.removeAll();
		ArrayList<Memo> listaCitas = listaMemo;
		for (int i = 0; i < listaCitas.size(); i++) {
			Memo aux = listaCitas.get(i);
			aLlenar.add(new ElementoMemo(aux, this));
		}
	}
	
	//metodo que agragega elementos
	public void agregarMemo(Memo otro) {
		listaMemoDeMomento.add(otro);
		llenarPanelMemo(listaMemoDeMomento,crearCita.memo.panelMemos);
	}
	
	//metodo para generar listas 
	private ArrayList<Memo> generarLista(ArrayList<Memo> lista){
		ArrayList<Memo> respuesta = new ArrayList<Memo>();
		for(int i=0;i<lista.size();i++) {
			respuesta.add(lista.get(i));
		}
		return respuesta;
	}
	
	//metodo para definir el texto de arriba al crear, editar o revisar una cita
	private void textoSuperiorDelPanel(String titulo) {
		vistaControlada.visibilidadComponentes(false);// oculta los componentes superiores
		vistaControlada.editarTextoReferente(titulo);
		vistaControlada.estadoTextoReferente(true);// pone visible el texto referente en la parte superior
	}
	
	//metodo para quitar el texto de la parte de arriba cuando estamos creando, editando o revisando
	private void quitarTextoSuperioDelPanel(boolean estado) {
		vistaControlada.estadoTextoReferente(!estado);
		vistaControlada.visibilidadComponentes(estado);
	}
	
	//metodo para traducir la notificacion a la clase AlertaAlarma
		private Reloj traducirNotificacion(int tiempo, String medida,Fecha fechaCita,Reloj inicioCita) {
			Reloj res = inicioCita;
			if(medida.equals("minutos")) {
				if(tiempo <= inicioCita.getMinutos()) {
					res = new Reloj(inicioCita.getHora(),inicioCita.getMinutos()-tiempo,inicioCita.getSegundos());
				}else {
					res = inicioCita.getHora()!=0 ? new Reloj(inicioCita.getHora()-1,60-tiempo,inicioCita.getSegundos()):
						 new Reloj(23,60-tiempo,inicioCita.getSegundos());
				}
			}else if(medida.equals("horas")) {
				if(tiempo <=inicioCita.getHora()) {
					res = new Reloj(inicioCita.getHora()-tiempo,inicioCita.getMinutos(),inicioCita.getSegundos());
				}
			}else if(medida.equals("dias")) {
				
			}else if(medida.equals("semanas")) {
				
			}
			return res;
		}
		
		//metodo para saber si la cita inicia en el dia o la noche
		private String diaNocheCita(Reloj inicioCita) {
			String res = "";
			if(inicioCita.getHora()<=12) {
				res = "AM";
			}else {
				res = "PM";
			}
			return res;
		}
		
		//filtro de numeros 
		private int filtroNumero(int n) {
			int res = n;
			if(n == 13) {res = 1;}
			else if(n == 14) {res = 2;}
			else if(n == 15) {res = 3;}
			else if(n == 16) {res = 4;}
			else if(n == 17) {res = 5;}
			else if(n == 18) {res = 6;}
			else if(n == 19) {res = 7;}
			else if(n == 20) {res = 8;}
			else if(n == 21) {res = 9;}
			else if(n == 22) {res = 10;}
			else if(n == 23) {res = 11;}
			else if(n == 0) {res = 12;}
			return res;
		}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////// Clase ElementoCita para mostrar la cita en un panel/////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//////////////////////////////////////////////////////////////////////////////////////////////////////////
class ElementoCita extends JButton {

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
//detalleCita.setControlador(this);
	}

	public ElementoCita(Cita cita, ControladorAgenda control) {
		this.cita = cita;
		this.addActionListener(control);
		Border bordePanel = new TitledBorder(new EtchedBorder());
		setBorder(bordePanel);
		setBackground(Color.white);
		setLayout(new GridLayout(2, 3, 250, 15));
		asuntoCita = new JLabel(cita.getAsunto());
		horaInicioCita = new JLabel(cita.getHoraInicio().toString());
		horaFinCita = new JLabel(cita.getHoraFin().toString());
		fechaCita = new JLabel(cita.getFecha().toString());
		agregarLabels();
//detalleCita.setControlador(this);
	}

	public ElementoCita() {
		cita = null;
		Border bordePanel = new TitledBorder(new EtchedBorder());
		setBorder(bordePanel);
		setBackground(Color.white);
		setLayout(new GridLayout(2, 3, 250, 15));
		asuntoCita = new JLabel(cita.getAsunto());
		horaInicioCita = new JLabel(cita.getHoraInicio().toString());
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
		// addActionListener(this);
	}

	/*
	 * public void actionPerformed(ActionEvent evento) { if (evento.getSource() ==
	 * ElementoCita.this) { detalleCita.darValores(cita.getAsunto(),
	 * cita.getDescripcion(), cita.getHoraInicio().toString(),
	 * cita.getHoraFin().toString(), cita.getFecha().toString(),
	 * cita.getContactosEnCita().toString(), cita.getLugar());
	 * definirPanel(detalleCita); //System.out.println(cita); } else if
	 * (evento.getSource() == detalleCita.editar) { editando = true;
	 * //crearCita.limpiarEspacios();
	 * //System.out.println("aqui inicia el problema");
	 * crearCita.darValores(cita.getAsunto(), cita.getDescripcion(),
	 * cita.getHoraInicio().toString(), cita.getHoraFin().toString(),
	 * cita.getFecha().toString(), cita.getContactosEnCita().toString(),
	 * cita.getLugar());
	 * 
	 * definirPanel(crearCita); System.out.println(cita); } else if
	 * (evento.getSource() == detalleCita.cancelar) {
	 * definirPanel(vistaControlada.panelCitas); }
	 * 
	 * }
	 */

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita nueva) {
		cita = nueva;
	}

	public void setControlador(ControladorAgenda control) {
		this.addActionListener(control);
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////// Clase ElementoMemo para mostrar un memo en un panel/////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
class ElementoMemo extends JButton {
	private JLabel tituloMemo, resumenMemo;
	private Memo memo;
	public ElementoMemo(Memo memo,ControladorAgenda control) {
		this.memo = memo;
		addActionListener(control);
		Border bordePanel = new TitledBorder(new EtchedBorder());
		setBorder(bordePanel);
		setBackground(Color.white);
		setLayout(new GridLayout(2, 0));
		tituloMemo = new JLabel(memo.getTitulo());
		resumenMemo = new JLabel(memo.getTexto());
		add(tituloMemo);
		add(resumenMemo);
	}
	
	public Memo getMemo() {
		return memo;
	}
}