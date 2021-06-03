package clases;

import excepciones.NombreIncorrectoException;

public abstract class EntidadConNombre {
	private String nombre;

	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreIncorrectoException {
		this.nombre = nombre;
		if(this.nombre.isBlank()) {
			throw new NombreIncorrectoException("El nombre introducido no es correcto");
		}
		this.nombre = nombre;
	}
	
	
}
