package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDerecho extends JPanel{

	private JButton botonNuevo;
	private JButton botonReiniciar;
	private JButton botonTop10;
	private JButton botonCambiarJug;
	private Ventana principal;
	
	public PanelDerecho(Ventana principal) {
		this.principal=principal;
		setLayout(new GridLayout(4,1));
		
		botonNuevo = new JButton("NUEVO");
		botonNuevo.setActionCommand("NUEVO");
		botonNuevo.addActionListener(principal);
		
		botonReiniciar = new JButton("REINICIAR");
		botonReiniciar.setActionCommand("REINICIAR");
		botonReiniciar.addActionListener(principal);
		
		botonTop10 = new JButton("TOP 10");
		botonTop10.setActionCommand("TOP 10");
		botonTop10.addActionListener(principal);
		
		botonCambiarJug = new JButton("CAMBIAR JUGADOR");
		botonCambiarJug.setActionCommand("CAMBIAR JUGADOR");
		botonCambiarJug.addActionListener(principal);
		
		add(botonNuevo);
		add(botonReiniciar);
		add(botonTop10);
		add(botonCambiarJug);
	}
}
