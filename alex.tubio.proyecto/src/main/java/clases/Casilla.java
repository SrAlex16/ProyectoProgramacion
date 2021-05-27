package clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
		try {
			this.imagen=ImageIO.read(new File("./fondosCasilla/"+numero+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Select * from caminos_casilla where origen= numero
		//metes en el arraylist todos los numeros de casilla destino que salgan
		//select * from enemigo where casilla=numero
		//Para hacer al enemigo en java, necesitas pasarle arma y armadura, y para eso necesitas sacarlos de base de datos
		//Para eso, antes de crear el enemigo en Java, necesitas crear el objeto arma y armadura:
		//Select * from arma where nombre= (el valor de la columna arma que has sacado de la consulta en enemigo)
		//Crear el objeto Arma
		//Select * from armadura where nombre=(el valor de la columna armadura que has sacado de la consulta en enemigo)
		//Crear el objecto armadura
		//Crear el objeto enemigo y ponerlo en this. enemigo.
		
		//buscar fondos de las casillas
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
