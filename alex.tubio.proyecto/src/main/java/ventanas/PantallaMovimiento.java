package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PantallaMovimiento extends JPanel {
	private Mapa mapa;
	private boolean mapaActivo=false;
	
	public PantallaMovimiento() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		// crear boton del mapa
		final JButton verMapa = new JButton("Ver el mapa"); // TODO Hacer que el mapa se cierre
		panel.add(verMapa);

		// abrir el mapa
		verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!mapaActivo) {
				mapa = new Mapa();
				verMapa.setText("Cerrar mapa"); // Cambiar el texto del bot�n
				mapaActivo=true;
				}else {
					verMapa.setText("Abrir mapa");
					mapaActivo=false;
					mapa.setVisible(false);
					mapa.dispose();
					mapa=null;
				}
			}
		});

		// bot�n "Ver el mapa"
		verMapa.setFont(new Font("Ink Free", Font.BOLD, 20));

		// boton "Ir a la izquierda"
		JButton irRecto = new JButton("Ir recto");
		panel.add(irRecto);
		irRecto.setFont(new Font("Ink Free", Font.BOLD, 20));

		// boton "Ir a la izquierda"
		JButton irIzquierda = new JButton("Ir a la izquierda");
		panel.add(irIzquierda);
		irIzquierda.setFont(new Font("Ink Free", Font.BOLD, 20));

		// boton "Ir a la derecha"
		JButton irDerecha = new JButton("Ir a la derecha");
		panel.add(irDerecha);
		irDerecha.setFont(new Font("Ink Free", Font.BOLD, 20));
		
		//Select * from casilla where numero=1
		
		
		JLabel textoCasilla = new JLabel("poner texto");
		add(textoCasilla, BorderLayout.CENTER);

		this.setVisible(true);
	}
}
