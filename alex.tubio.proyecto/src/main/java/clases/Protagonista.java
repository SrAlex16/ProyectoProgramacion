package clases;

import java.util.ArrayList;

import excepciones.NombreIncorrectoException;
/**
 * 
 * @author alejandro
 *
 */
public class Protagonista extends Personaje{
	private ArrayList <ObjetoInventario> inventario;

	public Protagonista(String nombre, byte ataque, byte vida, Armadura armadura, Arma arma, Casilla dondeEstoy,
			ArrayList<ObjetoInventario> inventario) throws NombreIncorrectoException {
		super(nombre, ataque, vida, armadura, arma, dondeEstoy);
		this.inventario = inventario;
	}
	
	public Protagonista(String nombre) throws NombreIncorrectoException {
		super(nombre,(byte)20,(byte)200,null,null,new Casilla((byte)1));
		inventario=new ArrayList<ObjetoInventario>();
	}

	public ArrayList<ObjetoInventario> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<ObjetoInventario> inventario) {
		this.inventario = inventario;
	}
	
	
	
	//andar()
	//tomarPocionVida()
	//tomarPocionAtaque()
}
