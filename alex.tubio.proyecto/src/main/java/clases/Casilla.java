package clases;

import java.util.ArrayList;

public class Casilla {
	private ArrayList <Casilla> DestinosPosibles;
	private CasillaActual Casilla;
	public Casilla(ArrayList<Casilla> destinosPosibles, CasillaActual casilla) {
		super();
		DestinosPosibles = destinosPosibles;
		Casilla = casilla;
	}
	public ArrayList<Casilla> getDestinosPosibles() {
		return DestinosPosibles;
	}
	public void setDestinosPosibles(ArrayList<Casilla> destinosPosibles) {
		DestinosPosibles = destinosPosibles;
	}
	public CasillaActual getCasilla() {
		return Casilla;
	}
	public void setCasilla(CasillaActual casilla) {
		Casilla = casilla;
	}
	@Override
	public String toString() {
		return "Casilla [DestinosPosibles=" + DestinosPosibles + ", Casilla=" + Casilla + "]";
	}
	
	
}
