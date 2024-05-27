package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TableroPanel extends JPanel implements ActionListener{

	private Tablero tablero;
	private Ventana ventana;
	private JButton[][] botones;
	
	public TableroPanel(Ventana ventana) {
		this.ventana = ventana;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
		removeAll();
		int tamanio = tablero.darTablero().length;
		setLayout(new GridLayout(tamanio, tamanio));
		botones = new JButton[tamanio][tamanio];
		for (int i=0;i<tamanio;i++) {
			for( int j=0; j<tamanio;j++) {
				botones[i][j]= new JButton();
				botones[i][j].addActionListener(this);
				add(botones[i][j]);
			}
			
		}
		actualizarBotones();
	}
	
	public void actualizarBotones() {
		if(tablero!= null) {
			boolean[][] estado = tablero.darTablero();
			for (int i = 0; i < estado.length; i++) {
				for (int j = 0; j < estado.length; j++) {
					botones[i][j].setBackground(estado[i][j] ? java.awt.Color.WHITE : java.awt.Color.BLACK);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton s = (JButton) e.getSource();
		for(int i=0;i<botones.length;i++) {
			for (int j = 0; j < botones.length; j++) {
				if (botones[i][j] == s) {
					tablero.jugar(i, j);
					actualizarBotones();
					ventana.verificarGanador();
					return;
				}
			}
		}
		
	}
	
}
