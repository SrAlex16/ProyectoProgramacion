package ventanas;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import clases.Casilla;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame {
	Mapa mapa;
	Image icono;

	public Ventana() {

		try {
			icono = ImageIO.read(new File("./icono.png"));
			this.setIconImage(icono);
		} catch (IOException e) {
			System.out.println("el icono no funciona");
			e.printStackTrace();
		}

		this.setSize(884, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Juego");
		this.setResizable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//crear boton del mapa
		final JButton verMapa = new JButton("Ver el mapa"); // TODO Hacer que el mapa se cierre

		// abrir el mapa
		verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapa = new Mapa();
				verMapa.setText("Cerrar mapa"); // Cambiar el texto del bot�n
			}
		});

		// cerrar el mapa
		verMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mapa != null) {
					mapa.dispose();
					verMapa.setText("Abrir el mapa");
				}
			}
		});
		
		//bot�n "Ver el mapa"
		verMapa.setFont(new Font("Ink Free", Font.BOLD, 20));
		panel.add(verMapa);

		//boton "Ir a la izquierda"
		JButton irIzquierda = new JButton("Ir a la izquierda");
		irIzquierda.setFont(new Font("Ink Free", Font.BOLD, 20));
		panel.add(irIzquierda);

		//boton "Ir a la derecha"
		JButton irDerecha = new JButton("Ir a la derecha");
		irDerecha.setFont(new Font("Ink Free", Font.BOLD, 20));
		panel.add(irDerecha);
		
		//boton "Ir a la izquierda"
		JButton irRecto = new JButton("Ir recto");
		irRecto.setFont(new Font("Ink Free", Font.BOLD, 20));
		panel.add(irRecto);

		this.setVisible(true);
		// TODO Poner la casilla en la que te encuentras
	}
}
