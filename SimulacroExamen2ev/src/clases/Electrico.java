package clases;

import java.util.ArrayList;

public class Electrico extends Motor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int voltaje;
	
	public Electrico(String marca, ArrayList<Reparacion> reparaciones, int voltaje) {
		super(marca,reparaciones);
		this.voltaje=voltaje;
	}

	public int getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(int voltaje) {
		this.voltaje = voltaje;
	}

	@Override
	public String toString() {
		return super.toString()+" Electrico [voltaje=" + voltaje + "]";
	}
	
}
