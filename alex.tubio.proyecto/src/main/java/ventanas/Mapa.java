package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Mapa extends JFrame{
	public Mapa() {
		this.setSize(640, 850);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mapa del juego");
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Imegenes/mapa.jpg")));
		lblNewLabel.setBounds(0, 0, 734, 811);
		getContentPane().add(lblNewLabel);
		//TODO buscar y poner icono de ventana
		
		this.setVisible(true);
	}
}
