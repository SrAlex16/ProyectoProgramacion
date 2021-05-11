package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Mapa extends JFrame{
	public Mapa() {
		Image icono;
		this.setUndecorated(true); //para quitar el borde de arriba de la ventana
		this.setSize(645, 840);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mapa del juego");
		this.setResizable(false);
		//getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/mapa.jpg")));
		lblNewLabel.setBounds(0, -21, 634, 831);
		getContentPane().add(lblNewLabel);
		
		try {
			icono = ImageIO.read(new File("./icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			System.out.println("el icono no funciona");
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
}
