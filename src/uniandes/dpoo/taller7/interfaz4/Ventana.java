package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.TableroPanel;
import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class Ventana extends JFrame implements ActionListener{
	
	private PanelSuperior panSup;
	private PanelDerecho panDer;
	private PanelInferior panInf;
	private TableroPanel tabPan;
	private Top10 top10;
	private Tablero tablero;
	private String nombreJugador;
	
	public Ventana() {
		setTitle("Lights Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		
		panSup = new PanelSuperior(this);
		panDer = new PanelDerecho(this);
		panInf = new PanelInferior(this);
		tabPan = new TableroPanel();
		
		add(panSup, BorderLayout.NORTH);
		add(panDer, BorderLayout.EAST);
		add(panInf, BorderLayout.SOUTH);
		add(tabPan, BorderLayout.CENTER);
		
		top10 = new Top10();
		setVisible(true);
		
		nombreJugador = "Jugador";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com.equals("NUEVO")) {
			int tamanio = panSup.getTamanioSeleccionado();
			int dificultad = panSup.getDificultadSeleccionada();
			tablero = new Tablero(tamanio);
			tablero.desordenar(dificultad);
			tabPan.setTablero(tablero);
			tabPan.repaint();
		}else if (com.equals("REINICIAR")) {
			if(tablero != null) {
				tablero.reiniciar();
				tabPan.repaint();
			}
		} else if (com.equals("TOP 10")) {
            JDialog dialogoTop10 = new DialTop10(this, top10);
            dialogoTop10.setVisible(true);
		}else if (com.equals("CAMBIAR JUGADOR")) {
			String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
			if (nuevoNombre != null && nuevoNombre.trim().isEmpty()) {
				panInf.setNombreJugador(nuevoNombre);
			}
		}
		
	}

	public void verificarGanador() {
		if (tablero != null && tablero.tableroIluminado()) {
			int puntaje = tablero.calcularPuntaje();
			nombreJugador = JOptionPane.showInputDialog(this, "¡Ganaste! Ingrese su nombre:");
			if(nombreJugador != null && !nombreJugador.trim().isEmpty()) {
				top10.agregarRegistro(nombreJugador, puntaje);
				JOptionPane.showMessageDialog(this, "Puntaje registrado: " + puntaje);
			}
		}
	}
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new Ventana();
	}
}
