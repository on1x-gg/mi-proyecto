package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		File fichero=new File("motores.obj");
		ArrayList<Motor> motores=new ArrayList<Motor>();
		if(!fichero.exists()) {
			cargarfichero(fichero,motores);
		}
		leerFichero(fichero,motores);
		System.out.println("Motores cargados: " + motores.size());
		int opcion,opcion0=0;
		do {
		System.out.println("1-Eliminar elementos por marca");
		System.out.println("2 listar motores");
		System.out.println("3-Calcular estadisticas");
		System.out.println("0-Salir");
		opcion=Utilidades.leerInt();
		
		switch (opcion) {
		case 0:
			System.out.println("Gracias por usar el programa");
			opcion0=1;
			fichero.delete();
			break;
		case 1: 
			String marcaus;
			System.out.println("Introduce la marca que quieras eliminar");
			marcaus=Utilidades.introducirCadena();
			Iterator<Motor> it = motores.iterator();
			while (it.hasNext()) {
			    Motor m = it.next();
			    if (m.getMarca().equalsIgnoreCase(marcaus)) {
			        it.remove();
			    }
			}
			cargardatos(fichero,motores);
			break;
		case 2:
			for(Motor m :motores) {
				System.out.println(m.toString());
			}
			break;
		case 3:
			Double precioelec=3*5.0+200,precioopel,precioaudi,opelmax=0.0,audimax=0.0;
			int numopel=0,numaudi=0;
			for(Motor m : motores) {
				if(m.getMarca().equalsIgnoreCase("opel")) {
					if(m instanceof Electrico) {
						precioopel=precioelec;
					}
					else {
						Combustion c=(Combustion)m;
						if(c.getTipo().equalsIgnoreCase("diesel")) {
							precioopel=1500.0;
						}
						else {
							precioopel=2000.0;
						}
					}
					if(opelmax<precioopel) {
						opelmax=precioopel;
						numopel=numopel+m.enumerarReparaciones();
					}
				}
				else if(m.getMarca().equalsIgnoreCase("audi")) {
					if(m instanceof Electrico) {
						precioaudi=precioelec;
					}
					else {
						Combustion c=(Combustion)m;
						if(c.getTipo().equalsIgnoreCase("diesel")) {
							precioaudi=1500.0;
						}
						else {
							precioaudi=2000.0;
						}
					}
					if(opelmax<precioaudi) {
						audimax=precioaudi;
					}
					numaudi=numaudi+m.enumerarReparaciones();
				}
			}
			Collections.sort(motores);
			System.out.println("Marca	Num.reparaciones	Coste reparacion max");
					System.out.println("Audi	"+numaudi+"		"+audimax		);
					System.out.println("Opel	"+numopel+"		"+opelmax		);
				
			break;
		default:
			System.out.println("Elige una opcion valida");
		}
		}while(opcion0==0);
	}

	private static void cargarfichero(File fichero,ArrayList<Motor> motores){
		Combustion c=new Combustion("audi",new ArrayList<Reparacion>(),"diesel");
		Electrico c1=new Electrico("opel",new ArrayList<Reparacion>(),20);
		Combustion c2=new Combustion("audi",new ArrayList<Reparacion>(),"gasolina");
		Electrico c3=new Electrico("audi",new ArrayList<Reparacion>(),30);
		Electrico c4=new Electrico("opel",new ArrayList<Reparacion>(),40);
		
		LocalDate no=LocalDate.now();
		int años=no.getYear()-2020;
		Double precioelec=3*5.0+200;
		
		LocalDate si,si01,si02,si03;
		String si1="2025-11-24";
		si = LocalDate.parse(si1);
		String si2="2026-01-24";
		si01 = LocalDate.parse(si2);
		String si3="2026-02-02";
		si02 = LocalDate.parse(si3);
		String si4="2025-10-13";
		si03 = LocalDate.parse(si4);
		Reparacion r=new Reparacion("motor roto",1500.0,si);
		c.aniadirReparacion(r);
		Reparacion r1=new Reparacion("luna roto",precioelec,si01);
		c1.aniadirReparacion(r1);
		Reparacion r2=new Reparacion("venatana rota",2000.0,si02);
		c2.aniadirReparacion(r2);
		Reparacion r3=new Reparacion("parabrisas roto",precioelec,si03);
		c3.aniadirReparacion(r3);
		
		try (ObjectOutputStream oos =
		         new ObjectOutputStream(new FileOutputStream(fichero))) {
			oos.writeObject(c);
			oos.writeObject(c1);
			oos.writeObject(c2);
			oos.writeObject(c3);
			oos.writeObject(c4);

		} catch (IOException e) {
		    System.out.println("Error de escritura: " + e.getMessage());
		}		
	}
	private static void leerFichero(File fichero, ArrayList<Motor> motores) {
	    motores.clear();

	    try (ObjectInputStream ois =
	         new ObjectInputStream(new FileInputStream(fichero))) {

	        while (true) {
	            motores.add((Motor) ois.readObject());
	        }

	    } catch (EOFException e) {
	        // fin normal
	    } catch (Exception e) {
	        System.out.println("Error al cargar el fichero");
	    }
	}
	private static void cargardatos(File fichero,ArrayList<Motor> motores){
		try (ObjectOutputStream oos =
		         new ObjectOutputStream(new FileOutputStream(fichero))) {
			for(Motor m : motores) {
				oos.writeObject(m);
			}

		} catch (IOException e) {
		    System.out.println("Error de escritura: " + e.getMessage());
		}
	}
}
