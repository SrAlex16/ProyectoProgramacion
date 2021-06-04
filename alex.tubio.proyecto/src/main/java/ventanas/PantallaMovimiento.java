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
import javax.swing.JTextArea;
import java.awt.Color;
/**
 * 
 * @author alejandro
 *
 */
public class PantallaMovimiento extends JPanel {
	private VentanaMapa mapa;
	private boolean mapaActivo=false;
	private Ventana ventana;
	private VerEnemigos enemigos;
	private boolean bestiarioActivo=false;
	private byte numeroPasillo;
	
	public PantallaMovimiento(Casilla actual) {
		setBackground(Color.GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.SOUTH);

		// crear boton del mapa
		final JButton verMapa = new JButton("Ver el mapa");
		panel.add(verMapa);
		verMapa.setFont(new Font("Ink Free", Font.BOLD, 20));
		
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

		// boton "Ir a la izquierda"
		JButton pasilloA = new JButton("Pasillo A");
		panel.add(pasilloA);
		pasilloA.setFont(new Font("Ink Free", Font.BOLD, 20));

		pasilloA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO moverte entre las casillas
			}
		});
		
		// boton "Ir a la derecha"
		JButton pasilloB = new JButton("Pasillo B");
		panel.add(pasilloB);
		pasilloB.setFont(new Font("Ink Free", Font.BOLD, 20));
		pasilloB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO moverte entre las casillas
			}
		});
		
		//crear boton "bestiario"
		final JButton bestiario = new JButton("Abrir Bestiario");
		panel.add(bestiario);
		bestiario.setFont(new Font("Ink Free", Font.BOLD, 20));
		
		JTextArea descripcion = new JTextArea(actual.getDescripcion());
		descripcion.setEditable(false);
		descripcion.setForeground(Color.WHITE);
		descripcion.setFont(new Font("Ink Free", Font.PLAIN, 18));
		descripcion.setBackground(Color.DARK_GRAY);
		add(descripcion, BorderLayout.CENTER);
		
		//abrir y cerrar el bestiario
		bestiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!bestiarioActivo){
					try {
						enemigos= new VerEnemigos();
					} catch (ImgException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					bestiario.setText("Cerrar Bestiario");
					bestiarioActivo=true;
				}else{
					bestiario.setText("Abrir bestiario");
					bestiarioActivo=false;
					enemigos.setVisible(false);
					enemigos.dispose();
					enemigos=null;
				}
				
			}
		});
		this.setVisible(true);
	}
}
