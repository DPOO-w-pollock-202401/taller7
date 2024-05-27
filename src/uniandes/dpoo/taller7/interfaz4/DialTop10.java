package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class DialTop10 extends JDialog{

	public DialTop10(Ventana ventana, Top10 top10) {
		super(ventana, "Top 10", true);
		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(ventana);
		
		Collection<RegistroTop10> registros = top10.darRegistros();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(RegistroTop10 registro: registros) {
			listModel.addElement(registro.darNombre() + " - " + registro.darPuntos());
		}
		
		JList<String> lista = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(lista);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.addActionListener(e -> setVisible(false));
		add(botonCerrar, BorderLayout.SOUTH);
	}
}
