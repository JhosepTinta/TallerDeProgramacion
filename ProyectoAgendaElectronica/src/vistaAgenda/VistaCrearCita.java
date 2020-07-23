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
	private Color colorDeFondo = new Color(167, 255, 186);
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
		fechaC = new JTextField(" 00  /  00  /  2020");
		lugarC = new JTextArea();
		////////////////////////////////////////////////////
		panelDeContactos = new VistaCrearCitaContactos();
		
		///////////////////////////////////////////////////////
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
		
		Border bordePanel = new TitledBorder(new EtchedBorder());
		descripcionC.setBorder(bordePanel);
		lugarC.setBorder(bordePanel);
		
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

		contactos.setBounds(20, 425, 100, 10);
		contactosC.setBounds(120, 422, 400, 20);
		cancelar.setBounds(705, 490, 120, 40);
		aceptar.setBounds(575, 490, 120, 40);

		memo.setBounds(20, 60, 365, 340);

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

}

