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

import excepciones.ImgException;

public class VentanaMapa extends JFrame{
	public VentanaMapa() throws ImgException {
		Image icono;
		this.setUndecorated(true); //para quitar el borde de arriba de la ventana
		this.setSize(630, 815);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setTitle("Mapa GyZ");
		//this.setResizable(false);
		//getContentPane().setLayout(null);
		
		JLabel imagenMapa = new JLabel("New label");
		imagenMapa.setIcon(new ImageIcon(VentanaMapa.class.getResource("/imagenes/mapa.jpg")));
		imagenMapa.setBounds(0, -21, 634, 831);
		getContentPane().add(imagenMapa);
		
		try {
			icono = ImageIO.read(new File("./icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			throw new ImgException ("No se ha podido mostrar el mapa (VentanaMapa)");
		}
		
		this.setVisible(true);
	}
}
