package proyecto;

import java.util.Scanner;

/**
  Clase Cliente con los datos personales y los tipos de carnet 
 */
public class Cliente {	
	
	String nombre;
	String ced;
	boolean carnetParticular = false;
	boolean carnetFurgoneta = false;
	boolean carnetCamion = false;
	boolean alquilado = false;		//true indica que ya tiene un vehiculo alquilado
	
	/**
	  Constructor por defecto
	 */
	public Cliente(){		
	}
	
	/**
	  Constructor parametrizado para aniadir nombre y cedula
	  @param nombre
	  @param cedula
	 */
	public Cliente(String nombre, String ced){
		this.nombre = nombre;
		this.ced = ced;
	}

	/**
	  @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	  @param nombre setea el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	  @return la cedula
	 */
	public String getCedula() {
		return ced;
	}

	/**
	  @param ced setea la Cedula
	 */
	public void setCedula(String ced) {
		this.ced = ced;
	}
	
	/**
	  @return the carnetParticular
	 */
	public boolean getCarnetParticular() {
		return carnetParticular;
	}

	/**
	  @param carnetParticular setea el carnet del Particular
	 */
	public void setCarnetParticular(boolean carnetParticular) {
		this.carnetParticular = carnetParticular;
	}


	/**
	  @return the carnetFurgoneta
	 */
	public boolean getCarnetFurgoneta() {
		return carnetFurgoneta;
	}

	/**
	  @param carnetFurgoneta setea el carnet de la Furgoneta
	 */
	public void setCarnetFurgoneta(boolean carnetFurgoneta) {
		this.carnetFurgoneta = carnetFurgoneta;
	}

	/**
	  @return el carnetCamion
	 */
	public boolean getCarnetCamion() {
		return carnetCamion;
	}

	/**
	  @param carnetCamion setea el carnetCamion
	 */
	public void setCarnetCamion(boolean carnetCamion) {
		this.carnetCamion = carnetCamion;
	}

	/**
	  @return si ha alquilado
	 */
	public boolean getAlquilado() {
		return alquilado;
	}

	/**
	  @param alquilado setea el alquilado
	 */
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	/**
	  Metodo para comprobar si la opcion es valida ("s" o "n")
	  @param opcion	--> texto a comprobar
	  @return true si opcion es "s" o "n" false cualquier otro
	 */
	private boolean comprobarOpcion(String opcion)
	{
		if(opcion.equals("s")) {
			return true;
		}else if(opcion.equals("n")) {
			return true;
		}else{
			System.out.println("Opcion no valida!");
			return false;
		}
	}
	
	/**
	  Metodo que va pidiendo por pantalla los datos para rellenar la ficha del cliente.
	 */
	public void rellenarDatos()
	{
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		String opcion;
		System.out.println("Introduzca los datos del cliente: ");
		System.out.print("\tNombre: ");
		nombre = teclado.nextLine();
		System.out.print("\tCedula: ");
		ced = teclado.nextLine();
		
		do{
			System.out.print("\tTiene carnet de Particular? Si(s) No(n): ");
			opcion = teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s")) {
			carnetParticular=true;
		}else {
			carnetParticular=false;
		}
		
		do{
			System.out.print("\tTiene carnet para furgonetas? Si(s) No(n): ");
			opcion=teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s")) {
			carnetFurgoneta=true;
		}else {
			carnetFurgoneta=false;
		}
		
		do{
			System.out.print("\tTiene carnet para camion? Si(s) No(n): ");
			opcion=teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s")) {
			carnetCamion=true;
		}else {
			carnetCamion=false;
		}
	}
}