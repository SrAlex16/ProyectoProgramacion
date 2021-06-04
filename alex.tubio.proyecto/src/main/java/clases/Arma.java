package clases;

import excepciones.NombreIncorrectoException;

public class Arma extends ObjetoInventario{
/**
 * 
 * @param unSoloUso: variable para las pociones, estas solo se pueden usar una vez
 * @param vidaAportada: variable que almacena la vida que aportan las pociones
 * @param ataqueAportado: variable que almacena el ataque que aportan las pociones
 * @param nombre: variable heredada de EntidadConNombre, almacena el nombre de un objeto
 * @throws NombreIncorrectoException: lanza la excepcion si el nombre introducido es incorrecto
 */
	public Arma(boolean unSoloUso, byte vidaAportada, byte ataqueAportado, String nombre) throws NombreIncorrectoException {
		super(unSoloUso, vidaAportada, ataqueAportado, nombre);
		// TODO Auto-generated constructor stub
		//TODO poner pociones
	}

	
}
