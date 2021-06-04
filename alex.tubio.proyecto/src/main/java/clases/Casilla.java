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
import excepciones.NombreIncorrectoException;
import excepciones.NumeroCasillaNoExisteException;
/**
 * 
 * @author alejandro
 *
 */
public class Casilla {
	private ArrayList<Byte> destinosPosibles;
	private byte numero;
	private static String descripcion;
	private BufferedImage imagen;
	private Personaje enemigo;

	public Casilla(byte numero){
		super();
		destinosPosibles = new ArrayList<Byte>();
		this.numero = numero;

		Connection conexion=null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/goblinsandzombies", "alex", "alex");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Statement smtDatosBasicos = null;
		try {
			smtDatosBasicos = conexion.createStatement();
		} catch (SQLException e3) {
			System.out.println("base de datos exception (Casilla)");
			e3.printStackTrace();
		}
		ResultSet resultCasillaBasicos = null;
		try {
			resultCasillaBasicos = smtDatosBasicos.executeQuery("Select * from casilla where numero=" + numero);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			if (resultCasillaBasicos.next()) {
				this.descripcion = resultCasillaBasicos.getString("descripcion");
			} else {
				throw new NumeroCasillaNoExisteException("Esa casilla no existe (Casilla)");
			}
		} catch (SQLException | NumeroCasillaNoExisteException e2) {
			System.out.println("error de base de datos con la casilla (Casilla)");
			e2.printStackTrace();
		}
		try {
			resultCasillaBasicos.close();
		} catch (SQLException e2) {
			System.out.println("No se ha podido cerrar la conexion (Casilla)");
			e2.printStackTrace();
		}
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
		} catch (SQLException e) {
			// excepcion de la base de datos
		}

		// select * from enemigo where casilla=numero
		Statement smt = null;
		try {
			smt = conexion.createStatement();
		} catch (SQLException e2) {
			System.out.println("no se ha podido crear el statement (Casilla)");
			e2.printStackTrace();
		}
		System.out.println("select * from enemigo where casilla=" + this.numero);

		ResultSet resultEnemigo = null;
		try {
			resultEnemigo = smt.executeQuery("select * from enemigo where casilla=" + this.numero);
		} catch (SQLException e2) {
			System.out.println("no se ha podido selecionar el enemigo de la base de datos (Casilla)");
			e2.printStackTrace();
		}
		try {
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
						try {
							arma = new Arma(resultArma.getBoolean("unSoloUso"), (byte) resultArma.getInt("vidaAportada"),
									(byte) resultArma.getInt("ataqueAportado"), resultArma.getString("nombre"));
						} catch (NombreIncorrectoException e) {
							System.out.println("base de datos exception (Casilla)");
							e.printStackTrace();
						}
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
						try {
							armadura = new Armadura(resultArmadura.getBoolean("unSoloUso"),
									(byte) resultArmadura.getInt("vidaAportada"),
									(byte) resultArmadura.getInt("ataqueAportado"), resultArmadura.getString("nombre"));
						} catch (NombreIncorrectoException e) {
							System.out.println("base de datos exception (Casilla)");
							e.printStackTrace();
						}
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

				try {
					this.enemigo = new Enemigo(te, resultEnemigo.getString("nombre"), resultEnemigo.getByte("ataque"),
							resultEnemigo.getByte("vida"), armadura, arma, this);
				} catch (NombreIncorrectoException e) {
					System.out.println("base de datos exception (Casilla)");
					e.printStackTrace();
				}
			}
		} catch (SQLException | BaseDeDatosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Byte> getDestinosPosibles() {
		return destinosPosibles;
	}

	public void setDestinosPosibles(ArrayList<Byte> destinosPosibles) {
		this.destinosPosibles = destinosPosibles;
	}
	
	public static String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Casilla [DestinosPosibles=" + destinosPosibles + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", enemigo=" + enemigo + "]";
	}

}
