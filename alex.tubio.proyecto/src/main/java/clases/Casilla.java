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

public class Casilla {
	private ArrayList <Byte> DestinosPosibles;
	private byte numero;
	private String descripcion;
	private BufferedImage imagen;
	private Personaje enemigo;
	
	public Casilla(byte numero,String desc) {
		super();
		this.numero=numero;
		this.descripcion=desc;
		Connection conexion;
		Statement smt;
		ResultSet resultCasilla=null;
		int numeroCasilla;
		//Casilla actual=null;
		
		try {
			//imagen de fondo
			this.imagen=ImageIO.read(new File("./fondosCasilla/"+numero+".jpg"));
			
			conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/goblinsandzombies", "root", "admin");
			smt=conexion.createStatement();
			//Select * from caminos_casilla where origen= numero
			resultCasilla=smt.executeQuery("Select * from caminos_casilla where origen = numero");
		} catch (IOException e) {
			//excepcion de la imagen de fondo
			System.out.println("No se ha podido poner el fondo");
		} catch (SQLException e) {
			//excepcion de la base de datos
			System.out.println("No se ha podido leer la tabla de la base de datos (Casilla)");
		}
		
		do {
			try {
				if(resultCasilla.next()) {
					numeroCasilla=resultCasilla.getInt("numero"); //numero de la casilla
					//String descripcion=resultCasilla.getString("descripcion"); //descripcion de la casilla
					//actual=new Casilla((byte)numeroCasilla/*,descripcion*/);
					
					//metes en el arraylist todos los numeros de casilla destino que salgan (DestinosPosibles)
					DestinosPosibles.add(numero);
				}
			} catch (SQLException e) {
				System.out.println("No se ha podido añadir la casilla al array (Casilla)");
			}
		}while(numero!=6); //ganas cuando llegas a la casilla numero 6
		
		//select * from enemigo where casilla=numero
		//Para hacer al enemigo en java, necesitas pasarle arma y armadura, y para eso necesitas sacarlos de base de datos
		//Para eso, antes de crear el enemigo en Java, necesitas crear el objeto arma y armadura:
		//Select * from arma where nombre= (el valor de la columna arma que has sacado de la consulta en enemigo)
		//Crear el objeto Arma
		//Select * from armadura where nombre=(el valor de la columna armadura que has sacado de la consulta en enemigo)
		//Crear el objecto armadura
		//Crear el objeto enemigo y ponerlo en this. enemigo.
		
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
