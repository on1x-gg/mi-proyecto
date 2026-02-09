package clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Reparacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int cod=100;
	private String desc;
	private Double coste;
	private LocalDate fecha;
	private static int numrep=0;
	
	public Reparacion(String desc, Double coste, LocalDate fecha) {
		this.cod=cod+numrep;
		this.desc=desc;
		this.coste=coste;
		this.fecha=fecha;
		numrep++;
	}

	public static int getCod() {
		return cod;
	}

	public static void setCod(int cod) {
		Reparacion.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public static int getNumrep() {
		return numrep;
	}

	public static void setNumrep(int numrep) {
		Reparacion.numrep = numrep;
	}

	@Override
	public String toString() {
		return "Reparacion [cod=" + cod + ",desc=" + desc + ", coste=" + coste + ", fecha=" + fecha + "]";
	}
	
}
