package clases;

import java.util.ArrayList;

public class Protagonista extends Personaje{
	private ArrayList <ObjetoInventario> inventario;

	public Protagonista(String nombre, byte ataque, byte vida, Armadura armadura, Arma arma, Casilla dondeEstoy,
			ArrayList<ObjetoInventario> inventario) {
		super(nombre, ataque, vida, armadura, arma, dondeEstoy);
		this.inventario = inventario;
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
