package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PantallaMovimiento extends JPanel {
	private VentanaMapa mapa;
	private boolean mapaActivo=false;
	private Ventana ventana;
	
	public PantallaMovimiento() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		// crear boton del mapa
		final JButton verMapa = new JButton("Ver el mapa");
		panel.add(verMapa);

		// abrir y cerrar el mapa
		verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!mapaActivo) {
				mapa = new VentanaMapa();
				verMapa.setText("Cerrar mapa"); // Cambiar el texto del botón
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

		// botón "Ver el mapa"
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
