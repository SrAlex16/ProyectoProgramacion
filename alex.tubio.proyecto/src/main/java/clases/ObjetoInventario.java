package clases;

public class ObjetoInventario extends EntidadConNombre{
	private boolean unSoloUso;
	private byte vidaAportada;
	private byte ataqueAportado;
	
	public ObjetoInventario(boolean unSoloUso, byte vidaAportada, byte ataqueAportado) {
		super();
		this.unSoloUso = unSoloUso;
		this.vidaAportada = vidaAportada;
		this.ataqueAportado = ataqueAportado;
	}
	
	public boolean isUnSoloUso() {
		return unSoloUso;
	}
	public void setUnSoloUso(boolean unSoloUso) {
		this.unSoloUso = unSoloUso;
	}
	public byte getVidaAportada() {
		return vidaAportada;
	}
	public void setVidaAportada(byte vidaAportada) {
		this.vidaAportada = vidaAportada;
	}
	public byte getAtaqueAportado() {
		return ataqueAportado;
	}
	public void setAtaqueAportado(byte ataqueAportado) {
		this.ataqueAportado = ataqueAportado;
	}
	
	
	//serSustituida()
	//cambiarEstadisticas()
}
