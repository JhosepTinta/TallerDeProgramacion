package vistaAgenda;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgenda;
import modelo.*;
import vistaMemo.*;

public class VistaDetalleCitaVentana extends JFrame implements ActionListener {
/// probar extends JDesktopPane
    JButton editar = new JButton("Editar");
    JButton cancelar = new JButton("Cancelar");
    
    JLabel asunto = new JLabel("El asunto de la cita es: ");
    JLabel descripcion = new JLabel("El motivo es: ");
    JLabel horaInicio = new JLabel("Su cita inica: ");
    JLabel horaFin = new JLabel("Su cita termina: ");
    JLabel fecha = new JLabel("La fecha que fijo es: ");
    JLabel lugar = new JLabel("El lugar que escogio es: ");
    JLabel contactos = new JLabel("Los contactos relacionados son: ");
    JLabel contactosC,asuntoC,descripcionC,horaInicioC,horaFinC,fechaC,lugarC;
    public VistaMemo vistaMemo;
    VistaDetalleMemo detalleMemo;
    
    Cita cita;
    
    public VistaDetalleCitaVentana(Cita cita,Color linea,Color letras) {
    	this.cita = cita;
    	
    	
        contactosC = new JLabel(cita.getContactosEnCita().toString());
        asuntoC = new JLabel(cita.getAsunto());
        descripcionC = new JLabel(cita.getDescripcion());
        horaInicioC = new JLabel(cita.getHoraInicio().toString());
        horaFinC = new JLabel(cita.getHoraFin().toString());
        fechaC = new JLabel(cita.getFecha().toString());
        lugarC = new JLabel(cita.getLugar());
        vistaMemo = new VistaMemo();
        vistaMemo.listaMemos.setBounds(0, 25, 250, 140);
        vistaMemo.setBackground(Color.white);
        detalleMemo = new  VistaDetalleMemo();
        
       
        add(new PanelVerCita(letras));
        
        editar.addActionListener(this);
        
        setBounds(410, 220, 625, 330);	
    	setBackground(Color.white);
    	setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    class PanelVerCita extends JPanel{
    	 public PanelVerCita(Color colorLetra) {
    		 setLayout(null);
    		 asunto.setBounds(35,45,150, 10);
    		 asuntoC.setBounds(170, 40, 150, 20);
    		 fecha.setBounds(370, 20, 150, 10);
    		 fechaC.setBounds(490, 15, 100, 20);
    		 descripcion.setBounds(35, 85, 100, 15);
    		 descripcionC.setBounds(35, 45, 315, 145);
    		 lugar.setBounds(35, 145, 150, 15);
    		 lugarC.setBounds(185, 142, 180, 20);
    		 
    		 horaInicio.setBounds(35, 175, 100, 10);
    		 horaInicioC.setBounds(150, 175, 100, 10);
    		 horaFin.setBounds(35, 200, 100, 10);
    		 horaFinC.setBounds(150, 200, 100, 10);
    		 
    		 contactos.setBounds(35, 245, 195, 10);
    		 contactosC.setBounds(230, 240, 200, 20);

    		 cancelar.setBounds(485, 275, 100, 25);
    		 editar.setBounds(355, 275, 100, 25);
    		 
    		 asunto.setForeground(colorLetra);
    		 fecha.setForeground(colorLetra);
    		 descripcion.setForeground(colorLetra);
    		 lugar.setForeground(colorLetra);
    		 horaInicio.setForeground(colorLetra);
    		 horaFin.setForeground(colorLetra);
    		 contactos.setForeground(colorLetra);
    		 
    		 vistaMemo.setBounds(350, 100, 250, 170);
    		 llenarPanelMemos(cita.getListaRecordatorios());
    	    
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
    	        add(vistaMemo);
    	      
    	    }
    	 public void paintComponent(Graphics g) {
    		 g.drawLine(35, 70, 575, 70);
    		 g.setColor(Color.red);
    	 }
    }

    private void llenarPanelMemos(ArrayList<Memo> lista) {
    	for(int i=0;i<lista.size();i++) {
    		Memo aux = lista.get(i);
    		vistaMemo.panelMemos.add(new ElementoMemo(aux,this));
    	}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == editar) {
			setVisible(false);
			VistaCrearCita nuevo = new VistaCrearCita(asuntoC.getText(), descripcionC.getText(),
					horaInicioC.getText(), horaFinC.getText(), fechaC.getText(), contactosC.getText(), lugarC.getText());
			
		}else if(e.getSource() == cancelar) {
			setVisible(false);
		}
	}
       
}

class ElementoMemo extends JButton {
	private JLabel tituloMemo, resumenMemo;
	private Memo memo;
	public ElementoMemo(Memo memo,VistaDetalleCitaVentana control) {
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
