package main;

import excepciones.ImgException;
import excepciones.VentanaException;
import ventanas.PantallaMovimiento;
import ventanas.Ventana;
import ventanas.VentanaInicio;
import ventanas.VerEnemigos;

public class Main {
	public static void main (String[] args) throws VentanaException {
		try {
			Ventana ventana=new Ventana();
		} catch (ImgException e) {
			throw new VentanaException("No se ha podido crear la ventana (Main)");
		}
		//PantallaMovimiento p = new PantallaMovimiento();
	}
}
