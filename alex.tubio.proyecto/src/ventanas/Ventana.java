package ventanas;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.swing.JPanel;

public class Ventana extends JFrame {
	Mapa mapa;
	Image icono;
	PantallaMovimiento pantalla=new PantallaMovimiento();
	public Ventana() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Goblins and Zombies");
		this.setResizable(true);
		this.setSize(884, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));

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
		this.setContentPane(this.pantalla);
		
		// TODO Poner la casilla en la que te encuentras
	}
}
