package clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import enums.TiposDeEnemigos;
import excepciones.BaseDeDatosException;
import excepciones.ImgException;
import excepciones.NumeroCasillaNoExisteException;

public class Casilla {
	private ArrayList<Byte> destinosPosibles;
	private byte numero;
	private String descripcion;
	private BufferedImage imagen;
	private Personaje enemigo;

	public Casilla(byte numero, String descripcion)
			throws BaseDeDatosException, SQLException, ImgException, NumeroCasillaNoExisteException {
		super();
		destinosPosibles = new ArrayList<Byte>();
		this.numero = numero;

		Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goblinsandzombies", "alex", "alex");
		Statement smtDatosBasicos = conexion.createStatement();
		ResultSet resultCasillaBasicos = smtDatosBasicos.executeQuery("Select * from casilla where numero=" + numero);
		if (resultCasillaBasicos.next()) {
			this.descripcion = resultCasillaBasicos.getString("descripcion");
		} else {
			throw new NumeroCasillaNoExisteException("Esa casilla no existe (Casilla)");
		}
		resultCasillaBasicos.close();
		try {
			// System.out.println(new
			// File("./fondosCasilla/"+numero+".jpg").getAbsolutePath().toString());
			// imagen de fondo
			this.imagen = ImageIO.read(new File("./fondosCasilla/" + numero + ".jpg"));

			Statement smt = conexion.createStatement();
			// Select * from caminos_casilla where origen= numero
			ResultSet resultCasilla = smt.executeQuery("Select * from caminos_casilla where origen = " + this.numero);
			while (resultCasilla.next()) {
				destinosPosibles.add(resultCasilla.getByte("destino"));
			}
			resultCasilla.close();
		} catch (IOException e) {
			// excepcion de la imagen de fondo
			e.printStackTrace();
			throw new ImgException("No se ha podido poner el fondo (Casilla)");
		} catch (SQLException e) {
			// excepcion de la base de datos
			throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (Casilla)");
		}

		// select * from enemigo where casilla=numero
		Statement smt = conexion.createStatement();
		System.out.println("select * from enemigo where casilla=" + this.numero);

		ResultSet resultEnemigo = smt.executeQuery("select * from enemigo where casilla=" + this.numero);
		if (resultEnemigo.next()) {
			// Para hacer al enemigo en java, necesitas pasarle arma y armadura, y para eso
			// necesitas sacarlos de base de datos
			// Para eso, antes de crear el enemigo en Java, necesitas crear el objeto arma y
			// armadura:
			// Select * from arma where nombre= (el valor de la columna arma que has sacado
			// de la consulta en enemigo)
			// Crear el objeto Arma
			Arma arma = null;
			try {
				Statement smt2 = conexion.createStatement();
				ResultSet resultArma = smt2
						.executeQuery("Select * from arma where nombre=" + resultEnemigo.getString("arma"));

				while (resultArma.next()) {
					arma = new Arma(resultArma.getBoolean("unSoloUso"), (byte) resultArma.getInt("vidaAportada"),
							(byte) resultArma.getInt("ataqueAportado"), resultArma.getString("nombre"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (arma) (Casilla)");
			}

			// Select * from armadura where nombre=(el valor de la columna armadura que has
			// sacado de la consulta en enemigo)
			// Crear el objecto armadura
			Armadura armadura = null;
			try {
				Statement smt3 = conexion.createStatement();
				ResultSet resultArmadura = smt3
						.executeQuery("Select * from armadura where nombre=" + resultEnemigo.getString("Armadura"));
				if (resultArmadura.next()) {
					armadura = new Armadura(resultArmadura.getBoolean("unSoloUso"),
							(byte) resultArmadura.getInt("vidaAportada"),
							(byte) resultArmadura.getInt("ataqueAportado"), resultArmadura.getString("nombre"));
				}
			} catch (SQLException e) {
				throw new BaseDeDatosException(
						"No se ha podido leer la tabla de la base de datos (armadura) (Casilla)");
			}

			// Crear el objeto enemigo y ponerlo en this. enemigo.
			TiposDeEnemigos te = null;
			switch (resultEnemigo.getString("tipo")) {
			case ("zombie"):
				te = TiposDeEnemigos.ZOMBIE;
				break;
			case ("goblin"):
				te = TiposDeEnemigos.GOBLIN;
				break;
			case ("dragon"):
				te = TiposDeEnemigos.DRAGON;
				break;
			}

			this.enemigo = new Enemigo(te, resultEnemigo.getString("nombre"), resultEnemigo.getByte("ataque"),
					resultEnemigo.getByte("vida"), armadura, arma, this);
		}
	}

	public ArrayList<Byte> getDestinosPosibles() {
		return destinosPosibles;
	}

	public void setDestinosPosibles(ArrayList<Byte> destinosPosibles) {
		this.destinosPosibles = destinosPosibles;
	}

	@Override
	public String toString() {
		return "Casilla [DestinosPosibles=" + destinosPosibles + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", enemigo=" + enemigo + "]";
	}

}
