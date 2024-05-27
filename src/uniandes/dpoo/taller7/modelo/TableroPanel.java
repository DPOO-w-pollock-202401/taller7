package uniandes.dpoo.taller7.modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class TableroPanel extends JPanel{

	private Tablero tablero;
	public TableroPanel() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablero != null) {
					int tam = tablero.darTablero().length;
					int width = getWidth();
					int height = getHeight();
					int celWidth = width/tam;
					int celHeight = height/tam;
					int fila = e.getY()/celHeight;
					int columna = e.getX()/celWidth;
					tablero.jugar(fila, columna);
					repaint();
				}
			}
		});
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero =tablero;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(tablero != null) {
			Graphics2D g2d = (Graphics2D) g;
			int tam= tablero.darTablero().length;
			int width = getWidth();
			int height = getHeight();
			int celWidth = width/tam;
			int celHeight = height/tam;
			boolean[][] estado = tablero.darTablero();
			for (int i = 0;i<tam;i++) {
				for (int j = 0; j<tam;j++) {
					if (estado[i][j]) {
						g2d.setColor(Color.YELLOW);
					}else {
						g2d.setColor(Color.BLACK);
					}
					g2d.fillRoundRect(j*celWidth, i*celHeight, celWidth, celHeight, 10, 10);
				}
			}
		}
		
	}

	
}
