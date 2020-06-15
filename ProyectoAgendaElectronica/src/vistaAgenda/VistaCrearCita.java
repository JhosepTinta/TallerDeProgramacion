package vistaAgenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import modelo.Cita;


public class VistaCrearCita extends JFrame {

    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");
    Cita persona;

    public VistaCrearCita() {
        setBounds(550, 300, 250, 510);
        setLayout(new BorderLayout());
        //setUndecorated(true);
        setVisible(true);

        PanelCrearCita lamina = new PanelCrearCita();

        //cerrar ventana
        cancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }

        });
        // rescatar valores aceptar
        aceptar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              
               // persona = new Cita(lamina.nombreC.getText(), lamina.telefonoC.getText(), lamina.correoC.getText());
                //System.out.println(persona);
                cerrarVentana();
            }
            
        });

        JLabel titulo = new JLabel("          Agrega Contacto");

        JPanel botones = new JPanel();
        botones.add(aceptar);
        botones.add(cancelar);
        
        add(titulo,BorderLayout.NORTH);
        add(lamina,BorderLayout.CENTER);
        add(botones,BorderLayout.SOUTH);
    }

    private void cerrarVentana(){
        setVisible(false);
        dispose();
    }
    
    public Cita getDatos(){
        return persona;
    }
}

class PanelCrearCita extends JPanel {

    JLabel asunto = new JLabel("Asunto: ");
    JLabel descripcion = new JLabel("Descripción: ");
    JLabel horaInicio = new JLabel("Hora de Inicio: ");
    JLabel horaFin = new JLabel("Hora a Concluir: ");
    JLabel fecha = new JLabel("Fecha: ");
    JLabel lugar = new JLabel("Lugar: ");
    JTextField asuntoC = new JTextField();
    JTextArea descripcionC = new JTextArea();
    JTextField horaInicioC = new JTextField();
    JTextField horaFinC = new JTextField();
    JTextField fechaC = new JTextField();
    JTextField lugarC = new JTextField();

    public PanelCrearCita() {
        setLayout(new EnColumnas());

        add(asunto);
        add(asuntoC);
        add(descripcion);
        add(descripcionC);
        add(horaInicio);
        add(horaInicioC);
        add(horaFin);
        add(horaFinC);
        add(fecha);
        add(fechaC);
        add(lugar);
        add(lugarC);
        
    }
}