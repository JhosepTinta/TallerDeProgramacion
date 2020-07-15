package vistaAgenda;

import java.awt.Color;

import javax.swing.*;
import controlador.ControladorAgenda;
import vistaMemo.VistaMemo;

public class VistaDetalleCitaPanel extends JPanel {
	public JButton editar = new JButton("Editar");
	public JButton cancelar;
	JLabel asunto = new JLabel("El asunto de la cita es: ");
	JLabel descripcion = new JLabel("El motivo es: ");
	JLabel horaInicio = new JLabel("Su cita inica: ");
	JLabel horaFin = new JLabel("Su cita termina: ");
	JLabel fecha = new JLabel("La fecha que fijo es: ");
	JLabel lugar = new JLabel("El lugar que escogio es: ");
	JLabel contactos = new JLabel("Los contactos relacionados son: ");
	JLabel contactosC, asuntoC, descripcionC, horaInicioC, horaFinC, fechaC, lugarC;
	public VistaMemo detalleMemo;
	private Color colorDeFondo = new Color(193, 255, 229);
	
	public VistaDetalleCitaPanel() {
		cancelar = new JButton(new ImageIcon(VistaDetalleCitaPanel.class.getResource("/botones/AgendaCancelar1.png")));
		cancelar.setBackground(colorDeFondo);
		cancelar.setBorder(null);
		contactosC = new JLabel();
		asuntoC = new JLabel();
		descripcionC = new JLabel();
		horaInicioC = new JLabel();
		horaFinC = new JLabel();
		fechaC = new JLabel();
		lugarC = new JLabel();
		agregarElementos();
	}
	
	public void darValores(String asunto, String descripcion, String horaInicio, String horaFin, String fecha,
			String contactos, String lugar) {
		contactosC.setText(contactos);
		asuntoC.setText(asunto);
		descripcionC.setText(descripcion);
		horaInicioC.setText("   "+horaInicio);
		horaFinC.setText("   "+horaFin);
		fechaC.setText(" "+fecha);
		lugarC.setText(lugar);
	}

	private void agregarElementos() {
		setBackground(colorDeFondo);
		setLayout(null);
		detalleMemo = new VistaMemo();
		detalleMemo.setBackground(colorDeFondo);
		detalleMemo.visibilidadComponentesInferiores(false);
		detalleMemo.setBounds(550, 100, 365, 340);
		
		asunto.setBounds(75, 50, 150, 10);
		asuntoC.setBounds(240, 75, 150, 20);
		
		fecha.setBounds(620, 15, 150, 20);
		fechaC.setBounds(740, 15, 100, 20);
		
		descripcion.setBounds(75, 110, 100, 15);
		descripcionC.setBounds(240, 65, 315, 145);
		lugar.setBounds(75, 205, 150, 15);
		lugarC.setBounds(240, 222, 180, 20);
		contactos.setBounds(75, 275, 195, 10);
		contactosC.setBounds(240, 295, 200, 20);
		horaInicio.setBounds(75, 375, 100, 10);
		horaInicioC.setBounds(170, 375, 100, 10);
		horaFin.setBounds(305, 375, 100, 10);
		horaFinC.setBounds(420, 375, 100, 10);

		editar.setBounds(575, 490, 120, 40);
		cancelar.setBounds(705, 490, 120, 40);
		add(asunto);
		add(asuntoC);
		add(fecha);
		add(fechaC);
		add(descripcion);
		add(descripcionC);
		add(lugar);
		add(lugarC);
		add(contactos);
		add(contactosC);
		add(horaInicio);
		add(horaInicioC);
		add(horaFin);
		add(horaFinC);
		add(cancelar);
		add(editar);
		add(detalleMemo);
	}
	
	public void setControlador(ControladorAgenda elementoCita) {
		editar.addActionListener(elementoCita);
		cancelar.addActionListener(elementoCita);
	}
}
