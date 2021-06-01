package ventanas;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Image;

import javax.swing.JPanel;

import clases.Casilla;
import clases.Protagonista;
import excepciones.BaseDeDatosException;
import excepciones.ImgException;

public class Ventana extends JFrame {
	private VentanaMapa ventanaMapa;
	private Image icono;
	private PantallaMovimiento pantalla;
	private VentanaInicio ventanaInicio;
	private Protagonista protagonista;

	public Ventana() throws ImgException {		
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
			throw new ImgException ("El icono no funciona (Ventana)");
		}
		this.setContentPane(ventanaInicio);
		this.setVisible(true);
	}

	public void cargaPantallaMovimiento() {
		if (this.pantalla == null) {
			//Consultar de base de datos todos los datos necesarios para crear la casilla numero 1
			Connection conexion;
			try {
				//1- Crear conexion con la base de datos
				//base de datos, usuario, contraseña
				conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goblinsandzombies", "root", "admin");
				
				//2- Crer objeto Statement
				Statement smt = conexion.createStatement();
				
				//3- Crear el objeto ResultSet para hacer select en la base de datos
				ResultSet resultCasilla=smt.executeQuery("select * from casilla where numero=1");
				
				//4- Leer el ResulSet
				Casilla actual=null;
				if(resultCasilla.next()) {
					int numero=resultCasilla.getInt("numero"); //numero de la casilla
					String descripcion=resultCasilla.getString("descripcion"); //descripcion de la casilla
					actual=new Casilla((byte)numero,descripcion);
				}
				//Crear el objeto casilla
				pantalla = new PantallaMovimiento(actual);
			} catch (SQLException e) {
				throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (Ventana)");
			}
			
		}
		this.ventanaInicio.setVisible(false);
		this.setContentPane(this.pantalla);
		this.pantalla.setVisible(true);
	}
}
