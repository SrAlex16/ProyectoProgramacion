package clases;

import enums.TiposDeEnemigos;
import excepciones.NombreIncorrectoException;
/**
 * 
 * @author alejandro
 *
 */
public class Enemigo extends Personaje{
	private TiposDeEnemigos tipo;
	
	public Enemigo(TiposDeEnemigos tipo, String nombre, byte ataque, byte vida, Armadura armadura, Arma arma,
			Casilla dondeEstoy) throws NombreIncorrectoException {
		super(nombre, ataque, vida, armadura, arma, dondeEstoy);
		this.tipo = tipo;
		
	//soltarDrop()
	}

	public TiposDeEnemigos getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeEnemigos tipo) {
		this.tipo = tipo;
	}
}
