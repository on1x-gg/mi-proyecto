package clases;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Motor implements Serializable,Comparable<Motor>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String marca;
	protected ArrayList<Reparacion> reparaciones;
	protected static int nummotores=100;
	
	public Motor(String marca,ArrayList<Reparacion> reparaciones) {
		this.id=nummotores++;
		this.marca=marca;
		this.reparaciones=reparaciones;
	}
	
	public int compareTo(Motor otra) {
        return this.marca.compareToIgnoreCase(otra.marca);
    }
	public void aniadirReparacion(Reparacion r) {
		reparaciones.add(r);
	}
	
	public void listarReparaciones() {
		for(Reparacion r : reparaciones) {
			System.out.println(r.toString());
		}
	}
	
	public int enumerarReparaciones() {
		int num=0;
		for(Reparacion r : reparaciones) {
			r.toString();
			num++;
		}
		return num;
	}
	
	public void eliminarReparacion(Reparacion r) {
		reparaciones.remove(r);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", marca=" + marca + "]";
	}
	
}
