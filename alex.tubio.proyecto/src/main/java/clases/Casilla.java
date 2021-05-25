package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Casilla {
	private ArrayList <Casilla> DestinosPosibles;
	private byte numero;
	private String descripcion;
	private BufferedImage imagen;
	private Personaje enemigo;
	
	public Casilla(byte numero) {
		super();
		this.numero=numero;
		//select * from casilla where numero=this.numero
		//a partir de ahi rellenas destinosPosibles, descripcion, imagen, y enemigo.
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
