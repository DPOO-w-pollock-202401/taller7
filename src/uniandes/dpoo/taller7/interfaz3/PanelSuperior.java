package uniandes.dpoo.taller7.interfaz3;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{

	private JComboBox<String> comboTamanio;
	private JRadioButton facil, dificil;
	private ButtonGroup grupoDificultad;
	private Ventana principal;
	
	public PanelSuperior(Ventana principal) {
		this.principal= principal;
		setLayout(new GridLayout(2, 2));
		
		add(new JLabel("Tamaño de tablero:"));
		comboTamanio = new JComboBox<>(new String[] {"5","10","15"} );
		add(comboTamanio);
		
		add(new JLabel("Dificultad:"));
		JPanel panelDificultad = new JPanel(new FlowLayout());
		facil = new JRadioButton("Fácil");
		dificil = new JRadioButton("Difícil");
		grupoDificultad = new ButtonGroup();
		grupoDificultad.add(facil);
		grupoDificultad.add(dificil);
		panelDificultad.add(facil);
		panelDificultad.add(dificil);
		add(panelDificultad);
	}
	
	public int getTamanioSeleccionado() {
		return Integer.parseInt((String) comboTamanio.getSelectedItem());
	}
	
	public int getDificultadSeleccionada() {
		return facil.isSelected() ? 5: 10;
	}
}
