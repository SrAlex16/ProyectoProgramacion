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
/**
 * 
 * @author alejandro
 *
 */
public class VentanaMapa extends JFrame{
	public VentanaMapa() throws ImgException {
		this.setUndecorated(true); //para quitar el borde de arriba de la ventana
		this.setSize(630, 815);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel imagenMapa = new JLabel("New label");
		imagenMapa.setIcon(new ImageIcon(VentanaMapa.class.getResource("/imagenes/mapa.jpg")));
		imagenMapa.setBounds(0, -21, 634, 831);
		getContentPane().add(imagenMapa);
		
		this.setVisible(true);
	}
}
