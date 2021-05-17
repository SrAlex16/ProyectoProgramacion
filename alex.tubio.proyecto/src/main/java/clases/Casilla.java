package clases;

import java.util.ArrayList;

public class Casilla {
	private ArrayList <Casilla> DestinosPosibles;
	private Casilla casillaActual;
	
	public Casilla(ArrayList<Casilla> destinosPosibles, Casilla casillaActual) {
		super();
		DestinosPosibles = destinosPosibles;
		this.casillaActual = casillaActual;
	}
	
	public ArrayList<Casilla> getDestinosPosibles() {
		return DestinosPosibles;
	}
	public void setDestinosPosibles(ArrayList<Casilla> destinosPosibles) {
		DestinosPosibles = destinosPosibles;
	}
	public Casilla getCasillaActual() {
		return casillaActual;
	}
	public void setCasillaActual(Casilla casillaActual) {
		this.casillaActual = casillaActual;
	}
	
	@Override
	public String toString() {
		return "Casilla [DestinosPosibles=" + DestinosPosibles + ", casillaActual=" + casillaActual + "]";
	}
	
	
}
