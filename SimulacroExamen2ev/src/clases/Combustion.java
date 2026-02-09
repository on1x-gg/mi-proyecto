package clases;

import java.util.ArrayList;

public class Combustion extends Motor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tipo;
	
	public Combustion(String marca, ArrayList<Reparacion> reparaciones,String tipo) {
		super(marca,reparaciones);
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString()+" Combustion [tipo=" + tipo + "]";
	}
	
}
