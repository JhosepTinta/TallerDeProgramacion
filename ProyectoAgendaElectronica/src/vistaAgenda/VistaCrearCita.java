package vistaAgenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.*;
import modelo.Cita;
import vistaMemo.VistaMemo;

public class VistaCrearCita extends JPanel {

	public JButton aceptar;
	public JButton cancelar;
	private Color colorDeFondo = new Color(244, 247, 252);
	//Color colorDeFondo = Color.white;
	JLabel asunto = new JLabel("Asunto: ");
	JLabel descripcion = new JLabel("Descripción: ");
	JLabel horaInicio = new JLabel("Hora de Inicio: ");
	JLabel horaFin = new JLabel("Hora a Concluir: ");
	JLabel fecha = new JLabel("Fecha: ");
	JLabel lugar = new JLabel("Lugar: ");
	JLabel contactos = new JLabel("Contactos: ");
	JLabel notificaciones = new JLabel("Notificación:");
	public JSpinner numeroSeleccionado = new JSpinner(new SpinnerNumberModel(30, 0, 30, 1));
	public JComboBox tiempoSeleccionado;
	public JRadioButton activarNotificaciones = new JRadioButton("", true);

	public JButton calendarioBoton = new JButton(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaBotonCalendario.png")));
	public JTextField contactosC, asuntoC, horaInicioC, horaFinC, fechaC;
	public JTextArea descripcionC, lugarC;

	public VistaMemo memo;

////////////////////////////////////////////////////
	public VistaCrearCitaContactos panelDeContactos;
///////////////////////////////////////////////////////
	//paneles de decoracion
	public JPanel bordeMemo = new JPanel();
	public JPanel bordeTitulo = new JPanel();
	public JPanel bordeFecha = new JPanel();
	public JPanel bordeHoraInicio = new JPanel();
	public JPanel bordeHoraFin = new JPanel();
	public JPanel bordeDescripcion= new JPanel();
	public JPanel bordeLugar = new JPanel();
	public JPanel bordeContactos = new JPanel();
	/////////////////////////////////////////////////
	public VistaCrearCita() {
		calendarioBoton.setBackground(colorDeFondo);
		calendarioBoton.setBorder(null);
		activarNotificaciones.setBackground(colorDeFondo);
		aceptar = new JButton(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaAceptar1.png")));
		aceptar.setBackground(colorDeFondo);
		aceptar.setBorder(null);
		cancelar = new JButton(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaCancelar1.png")));
		cancelar.setBackground(colorDeFondo);
		cancelar.setBorder(null);
		setBackground(colorDeFondo);
		memo = new VistaMemo();
		contactosC = new JTextField();
		asuntoC = new JTextField();
		descripcionC = new JTextArea();
		horaInicioC = new JTextField("   00  :  00  :  00");
		horaFinC = new JTextField("   00  :  00  :  00");
		fechaC = new JTextField("  00  /  00  /  2020");
		lugarC = new JTextArea();
		////////////////////////////////////////////////////
		panelDeContactos = new VistaCrearCitaContactos();
		///////////////////////////////////////////////////777
		bordeMemo.setBackground(new Color(174,214,241));
		bordeTitulo.setBackground(new Color(174,214,241));
		bordeContactos.setBackground(new Color(174,214,241));
		bordeFecha.setBackground(new Color(174,214,241));
		bordeHoraInicio.setBackground(new Color(174,214,241));
		bordeHoraFin.setBackground(new Color(174,214,241));
		bordeLugar.setBackground(new Color(174,214,241));
		bordeDescripcion.setBackground(new Color(174,214,241));
		///////////////////////////////////////////////////////
		cancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaCancelar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				cancelar.setIcon(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaCancelar1.png")));
			}
		});
		
		aceptar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				aceptar.setIcon(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaAceptar2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				aceptar.setIcon(new ImageIcon(VistaCrearCita.class.getResource("/botones/AgendaAceptar1.png")));
			}
		});
		agregarComponentes();
	}

	public VistaCrearCita(String asunto, String descripcion, String horaInicio, String horaFin, String fecha,
			String contactos, String lugar) {
		contactosC = new JTextField(contactos);
		asuntoC = new JTextField(asunto);
		descripcionC = new JTextArea(descripcion);
		horaInicioC = new JTextField(horaInicio);
		horaFinC = new JTextField(horaFin);
		fechaC = new JTextField(fecha);
		lugarC = new JTextArea(lugar);
		agregarComponentes();
	}

	private void agregarComponentes() {
		setLayout(null);
		//////////////////////////////////
		bordeMemo.setBounds(20, 58, 259, 344);
		bordeTitulo.setBounds(183, 20, 504, 24);
		asuntoC.setBorder(null);
		bordeFecha.setBounds(368, 260, 104, 24);
		fechaC.setBorder(null);
		bordeHoraInicio.setBounds(678, 260, 104, 24);
		horaInicioC.setBorder(null);
		bordeHoraFin.setBounds(678, 315, 104, 24);
		horaFinC.setBorder(null);
		bordeDescripcion.setBounds(348, 113, 394, 134);
		bordeLugar.setBounds(368, 300, 154, 74);
		bordeContactos.setBounds(118, 420,404, 24);
		contactosC.setBorder(null);
		//////////////////////////////////
		
		String lista[] = { "minutos", "horas", "dias", "semanas" };
		tiempoSeleccionado = new JComboBox<String>(lista);
		tiempoSeleccionado.setBackground(Color.white);

		activarNotificaciones.setBounds(570, 370, 20, 20);
		tiempoSeleccionado.setBounds(720, 370, 90, 20);
		numeroSeleccionado.setBounds(675, 370, 35, 20);

		notificaciones.setBounds(595, 370, 100, 20);
		asunto.setBounds(135, 25, 50, 10);
		asuntoC.setBounds(185, 22, 500, 20);

		horaInicio.setBounds(580, 265, 100, 10);
		horaInicioC.setBounds(680, 262, 100, 20);
		horaFin.setBounds(580, 320, 100, 10);
		horaFinC.setBounds(680, 317, 100, 20);
		fecha.setBounds(300, 265, 100, 10);
		calendarioBoton.setBounds(472, 257, 30, 30);
		fechaC.setBounds(370, 262, 100, 20);
		lugarC.setLineWrap(true);
		lugar.setBounds(300, 305, 100, 15);
		lugarC.setBounds(370, 302, 150, 70);
		descripcionC.setLineWrap(true);

		descripcion.setBounds(350, 85, 100, 15);
		descripcionC.setBounds(350, 115, 390, 130);

		contactos.setBounds(30, 425, 100, 10);
		contactosC.setBounds(120, 422, 400, 20);
		cancelar.setBounds(705, 490, 120, 40);
		aceptar.setBounds(575, 490, 120, 40);

		memo.setBounds(22, 60, 255, 340);

		////////////////////////////////////////////////////
		panelDeContactos.setBounds(120, 441, 399,100);
		panelDeContactos.setVisible(false);
		///////////////////////////////////////////////////////

		add(asunto);
		add(asuntoC);
		add(horaInicio);
		add(horaInicioC);
		add(horaFin);
		add(horaFinC);
		add(fecha);
		add(fechaC);
		add(lugar);
		add(lugarC);
		add(descripcion);
		add(descripcionC);
		add(contactos);
		add(contactosC);
		add(cancelar);
		add(aceptar);
		add(calendarioBoton);
		add(memo);
		add(notificaciones);
		add(numeroSeleccionado);
		add(tiempoSeleccionado);
		add(activarNotificaciones);

		////////////////////////////////////////////////////
		add(panelDeContactos);
		add(bordeMemo);
		add(bordeTitulo);
		add(bordeFecha);
		add(bordeHoraInicio);
		add(bordeHoraFin);
		add(bordeDescripcion);
		add(bordeLugar);
		add(bordeContactos);
		///////////////////////////////////////////////////////
	}

	public void setControlador(ControladorAgenda control) {
		aceptar.addActionListener(control);
		cancelar.addActionListener(control);
		contactosC.addFocusListener(control);
		calendarioBoton.addActionListener(control);
		panelDeContactos.setControlador(control);
	}

	public void editarTextoBoton(String texto) {
		aceptar.setText(texto);
	}

	public String obtenerFecha() {
		String res = "";
		String fecha = fechaC.getText();
		int n = fecha.length();
		for (int i = 0; i < n; i++) {
			char aux = fecha.charAt(i);
			if (esNumero("" + aux) || aux == '/') {
				res += aux;
			}
		}
		return res;
	}
	
	public String obtenerMes() {
		String res = "";
		String fecha = obtenerFecha();
		int n = fecha.length();
		boolean marca = false;
		int i=0;
		while (i < n) {
			char aux = fecha.charAt(i);
			if (aux == '/') {
				marca = !marca;
			}else if(marca) {
				res += aux;
			}
			i++;
		}
		return res;
	}
	
	public String obtenerDia() {
		String res = "";
		String fecha = obtenerFecha();
		int n = fecha.length();
		boolean marca = true;
		int i=0;
		while (i < n && marca) {
			char aux = fecha.charAt(i);
			if (aux == '/') {
				marca = false;
			}else if(marca) {
				res += aux;
			}
			i++;
		}
		return res;
	}
	

	public String obtenerHora(JTextField hora) {
		String res = "";
		String reloj = hora.getText();
		int n = reloj.length();
		for (int i = 0; i < n; i++) {
			char aux = reloj.charAt(i);
			if (esNumero("" + aux) || aux == ':') {
				res += aux;
			}
		}
		return res;
	}

	private boolean esNumero(String cadena) {
		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		return resultado;
	}

	public void limpiarEspacios() {
		contactosC.setText("");
		asuntoC.setText("");
		descripcionC.setText("");
		horaInicioC.setText("   00  :  00  :  00");
		horaFinC.setText("   00  :  00  :  00");
		fechaC.setText(" 00  /  00  /  2020");
		lugarC.setText("");
		;
	}

	public void darValores(String asunto, String descripcion, String horaInicio, String horaFin, String fecha,
			String contactos, String lugar) {
		contactosC.setText(contactos);
		
		asuntoC.setText(asunto);
		descripcionC.setText(descripcion);
		horaInicioC.setText("   " + horaInicio);
		horaFinC.setText("   " + horaFin);
		fechaC.setText(" " + fecha);
		lugarC.setText(lugar);
	}

///////////////////////////////////////////////////////////////////////////////////////
	public void hacerVisiblePanelContactos(boolean estado) {
		panelDeContactos.setVisible(estado);
	}
///////////////////////////////////////////////////////////////////////////////////////

	public boolean tituloVacio() {
		return asuntoC.getText().equals("")?true:false;
	}
	
	public boolean fechaVacio() {
		String fecha = obtenerFecha();
		String mes = obtenerMes();
		String dia = obtenerDia();
		boolean mesB = (mes.equals("0")||mes.equals("00"))?true:false;
		boolean diaB = (dia.equals("0")||dia.equals("00"))?true:false;
		return (fechaC.getText().equals(" 00  /  00  /  2020")||fecha.equals("00/00/2020")||fecha.equals(" 00/00/2020")
				||fecha.equals(" 00/00/0") ||mesB||diaB)?true:false;
	}
	
	public boolean horaVacio() {
		String inicio = obtenerHora(horaInicioC);
		String fin = obtenerHora(horaFinC);
		boolean casoEspecial = (fin.equals("00:00:00")&&inicio.equals("00:00:00"))?true:false;
		boolean casoEspecial2 = (fin.equals("0:0:0")&&inicio.equals("0:0:0"))?true:false;
		return  (horaFinC.equals("   00  :  00  :  00")|| horaInicioC.equals("   00  :  00  :  00")
				||casoEspecial||casoEspecial2||horaFinC.equals("")|| horaInicioC.equals(""))?true:false;
	}
	
	public void colorInicialBorde() {
		bordeTitulo.setBackground(new Color(174,214,241));
		asuntoC.setText(asuntoC.getText());
		bordeFecha.setBackground(new Color(174,214,241));
		fechaC.setText(fechaC.getText());
		bordeHoraInicio.setBackground(new Color(174,214,241));
		horaInicioC.setText(horaInicioC.getText());
		bordeHoraFin.setBackground(new Color(174,214,241));
		horaFinC.setText(horaFinC.getText());
	}
	
	public void marcarTitulo() {
		colorInicialBorde();
		bordeTitulo.setBackground(Color.red);
		asuntoC.setText(" ");
	}
	
	public void marcarFecha() {
		colorInicialBorde();
		bordeFecha.setBackground(Color.red);
		fechaC.setText("  00  /  00  /  2020");
	}
	
	public void marcarHoras() {
		colorInicialBorde();
		bordeHoraInicio.setBackground(Color.red);
		horaInicioC.setText("   00  :  00  :  00");
		bordeHoraFin.setBackground(Color.red);
		horaFinC.setText("   00  :  00  :  00");
	}
}

