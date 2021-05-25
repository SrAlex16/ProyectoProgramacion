package ventanas;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.swing.JPanel;

import clases.Casilla;
import clases.Protagonista;

public class Ventana extends JFrame {
	private VentanaMapa ventanaMapa;
	private Image icono;
	private PantallaMovimiento pantalla;
	private VentanaInicio ventanaInicio;
	private Casilla[] mapa;
	private Protagonista protagonista;

	public Ventana() {
		//TODO leer de base de datos todas las casillas con todos los enemigos y todas las armas en el mapa
		
		ventanaInicio = new VentanaInicio(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Goblins and Zombies");
		this.setResizable(true);
		this.setSize(884, 600);
		this.setLocation(650, 100);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		try {
			icono = ImageIO.read(new File("./icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			System.out.println("el icono no funciona");
			e.printStackTrace();
		}
		// this.setContentPane(this.pantalla);
		this.setContentPane(ventanaInicio);
		this.setVisible(true);

		// TODO Poner la casilla en la que te encuentras
	}

	public void cargaPantallaMovimiento() {
		if (this.pantalla == null) {
			pantalla = new PantallaMovimiento();
		}
		this.ventanaInicio.setVisible(false);
		this.setContentPane(this.pantalla);
		this.pantalla.setVisible(true);
	}
}
