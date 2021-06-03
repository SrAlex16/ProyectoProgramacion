package clases;

public class Personaje extends EntidadConNombre{
	private byte ataque;
	private byte vida;
	private Armadura armadura;
	private Arma arma;
	private Casilla dondeEstoy;
	
	public Personaje(String nombre, byte ataque, byte vida, Armadura armadura, Arma arma, Casilla dondeEstoy) {
		super(nombre);
		this.ataque = ataque;
		this.vida = vida;
		this.armadura = armadura;
		this.arma = arma;
		this.dondeEstoy = dondeEstoy;
	}

	public byte getAtaque() {
		return ataque;
	}

	public void setAtaque(byte ataque) {
		this.ataque = ataque;
	}

	public byte getVida() {
		return vida;
	}

	public void setVida(byte vida) {
		this.vida = vida;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Casilla getDondeEstoy() {
		return dondeEstoy;
	}

	public void setDondeEstoy(Casilla dondeEstoy) {
		this.dondeEstoy = dondeEstoy;
	}
	
	
	//atacar()
	//defenderse()
	//morir()
}
