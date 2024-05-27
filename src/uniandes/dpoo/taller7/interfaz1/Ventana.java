package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller7.interfaz2.PanelDerecho;
import uniandes.dpoo.taller7.interfaz2.PanelInferior;
import uniandes.dpoo.taller7.interfaz2.PanelSuperior;
import uniandes.dpoo.taller7.interfaz3.TableroPanel;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class Ventana extends JFrame{
	
	private PanelSuperior panSup;
	private PanelDerecho panDer;
	private PanelInferior panInf;
	private TableroPanel tabPan;
	private Top10 top10;
	private Tablero tablero;
	
	public Ventana() {
		setTitle("Lights Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		
		
		
		top10 = new Top10();
		setVisible(true);
	}

	

	public static void main(String[] args) {
		FlatLightLaf.install();
		new Ventana();
	}
}
