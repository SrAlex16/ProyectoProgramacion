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

import excepciones.BaseDeDatosException;
import excepciones.ImgException;
import excepciones.NumeroCasillaNoExisteException;

public class Casilla {
	private ArrayList <Byte> destinosPosibles;
	private byte numero;
	private String descripcion;
	private BufferedImage imagen;
	private Personaje enemigo;
	
	public Casilla(byte numero) throws BaseDeDatosException, SQLException, ImgException, NumeroCasillaNoExisteException {
		super();
		destinosPosibles=new ArrayList<Byte>();
		this.numero=numero;
		Connection conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/goblinsandzombies", "root", "admin");
		Statement smtDatosBasicos=conexion.createStatement();
		ResultSet resultCasillaBasicos=smtDatosBasicos.executeQuery("Select * from casilla where numero="+numero);
		if(resultCasillaBasicos.next()) {
			this.descripcion=resultCasillaBasicos.getString("descripcion");
		}else {
			throw new NumeroCasillaNoExisteException("Esa casilla no existe (Casilla)");
		}
		resultCasillaBasicos.close();
		try {
			//imagen de fondo
			this.imagen=ImageIO.read(new File("./fondosCasilla/"+numero+".jpg"));
			
			
			Statement smt=conexion.createStatement();
			//Select * from caminos_casilla where origen= numero
			ResultSet resultCasilla=smt.executeQuery("Select * from caminos_casilla where origen = "+this.numero);
			while(resultCasilla.next()) {
				destinosPosibles.add(resultCasilla.getByte("destino"));
			}
			resultCasilla.close();
		} catch (IOException e) {
			//excepcion de la imagen de fondo
			throw new ImgException("No se ha podido poner el fondo (Casilla)");
		} catch (SQLException e) {
			//excepcion de la base de datos
			throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (Casilla)");
		}
		
		
		//select * from enemigo where casilla=numero
		Statement smt=conexion.createStatement();
		ResultSet resultEnemigo=smt.executeQuery("select * from enemigo where casilla="+this.numero);
		
		//Para hacer al enemigo en java, necesitas pasarle arma y armadura, y para eso necesitas sacarlos de base de datos
		//Para eso, antes de crear el enemigo en Java, necesitas crear el objeto arma y armadura:
		//Select * from arma where nombre= (el valor de la columna arma que has sacado de la consulta en enemigo)
		//Crear el objeto Arma
		try {
			ResultSet resultArma=smt.executeQuery("Select * from arma where nombre="+resultEnemigo.getString("nombre"));

			while(resultArma.next()) {
				Arma arma = new Arma(resultArma.getString("nombre"),resultArma.getInt("ataque"));
			}
		} catch (SQLException e1) {
			throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (Casilla)");
		}
		
		//Select * from armadura where nombre=(el valor de la columna armadura que has sacado de la consulta en enemigo)
		//Crear el objecto armadura
		try {
			ResultSet resultArmadura=smt.executeQuery("Select * from armadura where nombre="+resultEnemigo.getString("Armadura"));
		} catch (SQLException e) {
			throw new BaseDeDatosException("No se ha podido leer la tabla de la base de datos (Casilla)");
		}
		Armadura armadura = new Armadura();
		
		//Crear el objeto enemigo y ponerlo en this. enemigo.
		this.enemigo=new Enemigo(this.enemigo);
		
	}
	
	public ArrayList<Casilla> getDestinosPosibles() {
		return DestinosPosibles;
	}
	public void setDestinosPosibles(ArrayList<Casilla> destinosPosibles) {
		DestinosPosibles = destinosPosibles;
	}

	@Override
	public String toString() {
		return "Casilla [DestinosPosibles=" + DestinosPosibles + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", enemigo=" + enemigo + "]";
	}
	
	
	
	
}
