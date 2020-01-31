package proyecto;

/**
 * Clase Vehiculo --> clase padre para los tipos de vehiculos
 */
public class Vehiculo {
	
	protected String placa;
	protected String marca;
	protected int dias;			//dias para los que se alquila
	protected int precioDia;
	protected int precioKm;
	protected int km;			//Kms antes de salir
	protected boolean alquilado=false;
		
	/**
	  Constructor parametrizado para aniadir los atributos de Vehiculo
	  @param placa --> placa
	  @param marca	--> marca y modelo
	  @param km	--> km 
	  @param precioDia	-->precio de alquiler por dia
	  @param precioKm	-->precio de alquiler por km
	 */
	protected Vehiculo(String marca, String placa, int km)
	{
		this.placa=placa;
		this.marca=marca;
		this.km=km;		
	}
	
	/**
	  Metodo get para placa
	  @return la placa
	 */
	public String getPlaca() {
		return placa;
	}
	
	/**
	  Metodo set para alquilado
	  @param alquilado	--> true cuando se alquila, false cuando se devuelve
	 */
	public void setAlquilado(boolean alquilado){
		this.alquilado=alquilado;
	}
	
	/**
	  @return true cuando esta alquilado, false cuando esta disponible
	 */
	public boolean getAlquilado(){
		return alquilado;
	}
	
	/**
	  Metodo set para placa
	  @param placa setea la placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/**
	  metodo get para marca
	  @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	  Metodo set para marca
	  @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	  Metodo get para dias
	  @return the dias
	 */
	public int getDias() {
		return dias;
	}
	
	/**
	  Metodo set para dias
	  @param dias the dias to set
	 */
	public void setDias(int dias) {
		this.dias = dias;
	}
	/**
	  Metodo get para precioDia
	  @return the precioDia
	 */
	public int getPrecioDia() {
		return precioDia;
	}
	
	/**
	  Metodo set para precioDia
	  @param precioDia the precioDia to set
	 */
	public void setPrecioDia(int precioDia) {
		this.precioDia = precioDia;
	}
	
	/**
	  Metodo get para precioKm
	  @return the precioKm
	 */
	public int getPrecioKm() {
		return precioKm;
	}
	
	/**
	  Metodo set para precioKm
	  @param precioKm the precioKm to set
	 */
	public void setPrecioKm(int precioKm) {
		this.precioKm = precioKm;
	}
	
	/**
	  Metodo get para km
	  @return the km
	 */
	public int getKm() {
		return km;
	}
	
	/**
	  Metodo set para km
	  @param km setea los km
	 */
	public void setKm(int km) {
		this.km = km;
	}	
	
	/**
	  Metodo para mostrar por pantalla los datos de los vehiculos
	 */
	public void  MostrarDatos() {
		
		System.out.println("Marca y Modelo: " + marca);
		System.out.println("Placa: " + placa);
		System.out.println("Kilometros: " + km);
		System.out.println("Precios de alquiler:");
		System.out.println("\tPrecio por dia: " + precioDia);
		System.out.println("\tPrecio por Km: " + precioKm);
		
		if(alquilado) {
			System.out.println("El vehiculo esta disponible.");
		}else {
			System.out.println("El vehiculo no esta disponible.");		
		}
	}
	
	/**
	  Metodo para comprobar si la opcion es valida ("s" o "n")
	  @param opcion	-->texto a comprobar
	  @return true si opcion es "s" o "n" false cualquier otro
	 */
	protected boolean comprobarOpcion(String opcion) {
		if(opcion.equals("s") || opcion.equals("n")) {
			return true;		
		}else{
			System.out.println("Opcion no valida!");
			return false;
		}
	}	
	
	protected boolean compruebaKm(int marcadorKm){
		if(marcadorKm<km){
			System.out.println("Numero de kilometros menor que el del marcador antes de alquilar.");
			return false;
		}else {
			return true;
		}
	}
}