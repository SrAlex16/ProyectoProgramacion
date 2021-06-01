package clases;

import enums.TiposDeEnemigos;

public class Enemigo extends Personaje{
	private ObjetoInventario dropArma;
	private TiposDeEnemigos tipo;
	private ObjetoInventario dropArmadura;
	
	public Enemigo(ObjetoInventario dropArma, TiposDeEnemigos tipo, ObjetoInventario dropArmadura) {
		super();
		this.dropArma = dropArma;
		this.tipo = tipo;
		this.dropArmadura = dropArmadura;
	}

	public Enemigo(Personaje enemigo) {
		// TODO Auto-generated constructor stub
	}

	public ObjetoInventario getDropArma() {
		return dropArma;
	}

	public void setDropArma(ObjetoInventario dropArma) {
		this.dropArma = dropArma;
	}

	public TiposDeEnemigos getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeEnemigos tipo) {
		this.tipo = tipo;
	}

	public ObjetoInventario getDropArmadura() {
		return dropArmadura;
	}

	public void setDropArmadura(ObjetoInventario dropArmadura) {
		this.dropArmadura = dropArmadura;
	}
	
	//soltarDrop()
	
}
