package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PantallaMovimiento extends JPanel {
	private Mapa mapa;
	
	public PantallaMovimiento(){
		
		//crear boton del mapa
		final JButton verMapa = new JButton("Ver el mapa"); // TODO Hacer que el mapa se cierre
		
		// abrir el mapa
		verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapa=new Mapa();
				verMapa.setText("Cerrar mapa"); // Cambiar el texto del botón
			}
		});
		
		//botón "Ver el mapa"
		verMapa.setFont(new Font("Ink Free", Font.BOLD, 20));
		this.add(verMapa);

		//boton "Ir a la izquierda"
		JButton irIzquierda = new JButton("Ir a la izquierda");
		irIzquierda.setFont(new Font("Ink Free", Font.BOLD, 20));
		this.add(irIzquierda);

		//boton "Ir a la derecha"
		JButton irDerecha = new JButton("Ir a la derecha");
		irDerecha.setFont(new Font("Ink Free", Font.BOLD, 20));
		this.add(irDerecha);
		
		//boton "Ir a la izquierda"
		JButton irRecto = new JButton("Ir recto");
		irRecto.setFont(new Font("Ink Free", Font.BOLD, 20));
		this.add(irRecto);

		this.setVisible(true);
	}
}
