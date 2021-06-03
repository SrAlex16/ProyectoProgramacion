package ventanas;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import excepciones.BaseDeDatosException;
import excepciones.ImgException;
import excepciones.NombreIncorrectoException;
import excepciones.NumeroCasillaNoExisteException;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInicio extends JPanel{
	private JTextField nombreJugador;
	private Ventana ventana;
	
	public VentanaInicio(Ventana v) {
		this.ventana=v;
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 62, 429, 124, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 48, 64, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea textoInicio = new JTextArea("Hola, bienvenido a Goblins & Zombies. \n \u00BFCu\u00E1l es tu nombre?");
		textoInicio.setBackground(Color.LIGHT_GRAY);
		textoInicio.setEditable(false);
		textoInicio.setLineWrap(true);
		textoInicio.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		GridBagConstraints gbc_textoInicio = new GridBagConstraints();
		gbc_textoInicio.fill = GridBagConstraints.BOTH;
		gbc_textoInicio.insets = new Insets(0, 0, 5, 5);
		gbc_textoInicio.gridx = 2;
		gbc_textoInicio.gridy = 2;
		add(textoInicio, gbc_textoInicio);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/gifs/jugador.gif")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		nombreJugador = new JTextField();
		nombreJugador.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		nombreJugador.setForeground(Color.WHITE);
		nombreJugador.setBackground(Color.GRAY);
		GridBagConstraints gbc_nombreJugador = new GridBagConstraints();
		gbc_nombreJugador.insets = new Insets(0, 0, 5, 5);
		gbc_nombreJugador.fill = GridBagConstraints.BOTH;
		gbc_nombreJugador.gridx = 2;
		gbc_nombreJugador.gridy = 3;
		add(nombreJugador, gbc_nombreJugador);
		nombreJugador.setColumns(10);
		
		JButton okNombre = new JButton("OK");
		okNombre.addMouseListener(new MouseAdapter() {
			//@Override
			String nombreJugadorStr;
			//Ventana ventana;
			//PantallaMovimiento pantalla;
			public void mouseClicked(MouseEvent e) {
				nombreJugadorStr=nombreJugador.getText();
				System.out.println(nombreJugadorStr);
				try {
					ventana.cargaPantallaMovimiento();
				} catch (BaseDeDatosException e1) {
					System.out.println("No se han podido leer los datos de la base de datos (VentanaInicio)");
					e1.printStackTrace();
				} catch (ImgException e1) {
					System.out.println("Img Exception (VentanaInicio)");
					e1.printStackTrace();
				} catch (NumeroCasillaNoExisteException e1) {
					System.out.println("La casilla no existe (ventanaInicio)");
				}
				
			}
		});
		
		okNombre.setBackground(Color.GRAY);
		okNombre.setForeground(Color.BLACK);
		okNombre.setFont(new Font("Segoe Script", Font.PLAIN, 15));
		GridBagConstraints gbc_okNombre = new GridBagConstraints();
		gbc_okNombre.insets = new Insets(0, 0, 5, 5);
		gbc_okNombre.gridx = 3;
		gbc_okNombre.gridy = 3;
		add(okNombre, gbc_okNombre);
	}

	public JTextField getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(JTextField nombreJugador, String nombrejugadorStr) {
		
	}

	public Ventana getVentana() {
		return ventana;
	}

	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}
	
	
}
