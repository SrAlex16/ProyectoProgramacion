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

import clases.Casilla;
import excepciones.ImgException;

import javax.swing.JLabel;
import java.awt.event.MouseEvent;

public class PantallaMovimiento extends JPanel {
	private VentanaMapa mapa;
	private boolean mapaActivo=false;
	private Ventana ventana;
	private VerEnemigos verEnemigos;
	private boolean bestiarioActivo;
	
	public PantallaMovimiento(Casilla actual) {
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
				try {
					mapa = new VentanaMapa();
				} catch (ImgException e1) {
					//throw new ImgException ("No se ha podido mostrar el mapa (VentanaMapa)");
				}
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
		
		//boton "bestiario"
		verEnemigos= new VerEnemigos();
		
		final JButton bestiario = new JButton("Abrir Bestiario");
		verEnemigos.setFont(new Font("Ink Free", Font.BOLD, 20));
		panel.add(bestiario);
		
		//abrir y cerrar el bestiario
		verEnemigos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!bestiarioActivo){
					verEnemigos= new VerEnemigos();
					bestiario.setText("Cerrar Bestiario");
				}else {
					bestiario.setText("Abrir bestiario");
					bestiarioActivo=false;
					verEnemigos.setVisible(false);
					verEnemigos.dispose();
					verEnemigos=null;
				}
				
			}
		});
		
		

		// botón "Ver el mapa"
		verMapa.setFont(new Font("Ink Free", Font.BOLD, 20));

		// boton "Ir a la izquierda"
		JButton irRecto = new JButton("Pasillo A");
		panel.add(irRecto);
		irRecto.setFont(new Font("Ink Free", Font.BOLD, 20));

		// boton "Ir a la derecha"
		JButton irDerecha = new JButton("Pasillo B");
		panel.add(irDerecha);
		irDerecha.setFont(new Font("Ink Free", Font.BOLD, 20));
		
		//Select * from casilla where numero=1
		
		
		JLabel textoCasilla = new JLabel("poner texto");
		add(textoCasilla, BorderLayout.CENTER);

		this.setVisible(true);
	}
}
