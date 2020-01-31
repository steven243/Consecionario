package proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
  Clase Concesionario --> contiene la logica para realizar los alquileres de vehiculos.
 */
public class Concesionario {
	
	static ArrayList<Renting> vehiculos=new ArrayList<Renting>();
	static ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	
	/**
	  Metodo estatico para aniadir objetos que tenga el interfaz renting implementado.
	  @param v	--> vehiculo  a aniadir
	 */
	static void aniadirVehiculo(Renting v){
		vehiculos.add(v);		
	}
	
	/**
	  Metodo para buscar un vehiculo por placa en el ArrayList
	  @param placa	--> placa del vehiculo
	  @return objeto de la clase vehiculo si lo encuentra si no null
	 */
	static Vehiculo buscarVehiculo(String placa){
		Vehiculo v=null;
		
		for(int i=0;i<vehiculos.size();i++){
			if(((Vehiculo)vehiculos.get(i)).getPlaca().equals(placa))		
				v=(Vehiculo)vehiculos.get(i);			
		}		
		return v;
	}
	
	/**
	  Metodo para aniadir clientes al ArrayList clientes
	  @param c	--> cliente a aniadir
	 */
	static void aniadirCliente(Cliente c){
		clientes.add(c);
	}
	
	/**
	  Metodo para buscar clientes por la cedula en el ArrayList clientes
	  @param ced	--> cedula de la persona a buscar
	  @return	cliente si lo encuentra y si no devuelve null
	 */
	static Cliente buscarCliente(String ced){
		
		Cliente c=null;
		
		for(int i=0;i<clientes.size();i++){
			
			if(clientes.get(i).getCedula().equals(ced)) {		
				c=clientes.get(i);
			}
			
		}
		
		return c;
	}	
	
	/**
	  Metodo estatico para alquilar vehiculos 
	 */
	static void alquilar(){
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		String ced;
		String placa;
		Cliente c;
		Vehiculo v = null;
		System.out.println("Clientes: ");
		boolean alquilado = false;
		
		for(int i=0;i<clientes.size();i++){	
			
			System.out.println("\tNombre: " + (clientes.get(i)).getNombre() + "\tCedula: " + (clientes.get(i)).getCedula());
		
		}
		
		System.out.print("Introduce la cedula del cliente que desea alquilar:");
		ced = teclado.nextLine();
		c = buscarCliente(ced);
		if(c!=null) {
			System.out.println("Vehiculos: ");
			
			for(int i=0;i<vehiculos.size();i++) {
				
				System.out.println("Marca: "+ (((Vehiculo)vehiculos.get(i)).getMarca() + "\tPlaca: " + (((Vehiculo)vehiculos.get(i)).getPlaca())) );
			
			}
			
			System.out.print("Introduce la placa del vehiculo a alquilar: ");
			placa = teclado.nextLine();
			v = buscarVehiculo(placa);
			
			if(v!=null) {
				
				if(v instanceof Particular) {
					
					alquilado = ((Particular)v).alquilar(c);	
					v.setAlquilado(alquilado);
				
				} else if(v instanceof Furgoneta) {
						
					alquilado = ((Furgoneta)v).alquilar(c);
						v.setAlquilado(alquilado);
				
				} else {
					
					alquilado=((Camion)v).alquilar(c);
					v.setAlquilado(alquilado);
				}
			} else {
				System.out.println("Placa no encontrada");
			}
		}else {
			System.out.println("Cedula no encontrada");
		}
	}
	
	/**
	  Metodo estatico para devolver vehiculos 
	 */
	static void devolver(){
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		String ced;
		String placa;
		Cliente c;
		Vehiculo v;
		
		System.out.println("Clientes con vehiculos alquilados: ");
		
		for(int i=0;i<clientes.size();i++) {
			
			if(clientes.get(i).getAlquilado()) {
				System.out.println("\tNombre: "+(clientes.get(i)).getNombre()+"\tCedula "+(clientes.get(i)).getCedula());
			}
		}
		System.out.println();
		
		System.out.print("Introduce la cedula del cliente que desea devolver:");
		ced = teclado.nextLine();
		c = buscarCliente(ced);
		if(c!=null){
			
			System.out.println();
			System.out.println("Vehiculos alquilados: ");
			
			for(int i=0;i<vehiculos.size();i++) {
				
				if(((Vehiculo)vehiculos.get(i)).getAlquilado()) {
					System.out.println("Marca: "+(((Vehiculo)vehiculos.get(i)).getMarca()+"\t\\tplaca: "+(((Vehiculo)vehiculos.get(i)).getPlaca())));
				}
				
			}
			
			System.out.println();			
			System.out.print("Introduce la placa del vehiculo a devolver: ");
			placa = teclado.nextLine();
			v = buscarVehiculo(placa);
			
			if(v!=null) {
				
				if(v instanceof Particular){
					
					((Particular)v).devolver(c);
					v.setAlquilado(false);
					
				} else if(v instanceof Furgoneta){
					
					((Furgoneta)v).devolver(c);
					v.setAlquilado(false);
				
				} else{
					
					((Camion)v).devolver(c);
					v.setAlquilado(false);
				
				}
			}else {
				System.out.println("placa no coincide con ningun vehiculo alquilado");
			}
		}else {
			System.out.println("Cedula no coincide con ningun cliente que tenga vehiculos alquilados");
		}
	}
	
	
	/**
	  Main del programa, crea los objetos, y muestra un menu de opciones
	 */
	public static void main(String[] args) {
		
		Date fechaHoy = new Date();
		
		Particular coche =new Particular("Coche Hyundai", "111bbb",100);
		Furgoneta furgo=new Furgoneta("Furgoneta Ford","222ccc",200,8);
		Furgoneta furgo2=new Furgoneta("Furgoneta Mazda","123abc",0,6);
		Camion camion=new Camion("Camion Pegaso","333ddd",1000,true);
		Camion camion2=new Camion("Camion CAT","444eee",700,false);
		Cliente cliente1=new Cliente("cliente 1","111A");
		Cliente cliente2=new Cliente("Cliente 2","222B");
		Cliente cliente3=new Cliente("Cliente 3","333C");
		
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);
		
		String opcion;
		boolean salir=false;
		
		aniadirVehiculo(coche);
		aniadirVehiculo(furgo);
		aniadirVehiculo(furgo2);
		aniadirVehiculo(camion);
		aniadirVehiculo(camion2);
		
		cliente1.setCarnetParticular(true);
		cliente2.setCarnetFurgoneta(true);
		cliente2.setCarnetCamion(true);
		cliente3.setCarnetParticular(true);
		cliente3.setCarnetFurgoneta(true);
		
		aniadirCliente(cliente1);
		aniadirCliente(cliente2);
		aniadirCliente(cliente3);
		
		do{	
			System.out.println("------------------------------------------------------");
			System.out.println("**********Alquiler de vehiculos**********");
			System.out.println("Fecha de inicio de sesión: " + fechaHoy.toString());
			System.out.println("\tPara alquilar vehiculo pulsa 1.");
			System.out.println("\tPara devolver vehiculo pulsa 2.");
			System.out.println("\tPara aniadir un nuevo cliente pulsa 3.");
			System.out.println("\tPara salir pulsa 4.");
			System.out.print("\nEscoge una opcion: ");
			opcion=teclado.nextLine();
			
			
			switch(opcion){
			
				case "1":
					alquilar();
					break;
					
				case "2":
					devolver();
					break;
					
				case "3":
					Cliente c=new Cliente();
					c.rellenarDatos();
					aniadirCliente(c);
					break;
					
				case "4":
					salir=true;
					break;
					
				default:
					System.out.println("Opcion incorrecta");
					break;			
			}			
		}while(!salir);
		
		System.out.println("------------------------------------------------------");
		System.out.println("------------ Proceso Terminado con Exito -------------");
		System.out.println("------------------------------------------------------");
	}

}