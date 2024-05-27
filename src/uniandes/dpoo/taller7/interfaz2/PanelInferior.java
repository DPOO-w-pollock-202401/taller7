package uniandes.dpoo.taller7.interfaz2;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel{

	private JLabel nombre;
	private JTextField textNombre;
	private Ventana principal;
	
	public PanelInferior(Ventana principal) {
		this.principal=principal;
		setLayout(new FlowLayout());
		
		nombre = new JLabel("Jugador:");
		textNombre = new JTextField (15);
		textNombre.setEditable(false);
		add(nombre);
		add(textNombre);
	}
	
	public void setNombreJugador(String nombre) {
		textNombre.setText(nombre);
	}
}
