package proyecto;

/**
  Interfaz Renting --> contiene metodos para alquilar y devolver
 */

public interface Renting {
	
	/**
	  Metodo para decidir alquilar un vehiculo. Si es posible el alquiler muestra los detalles
	  @param cliente	--> cliente al que se le alquila
	  @param placa	--> placa del coche a alquilar
	  @return true si se puede alquilar, false si no se puede alquilar.
	 */
	public boolean alquilar(Cliente cliente);
	
	
	/**
	  Metodo para devolver los vehiculos. Muestra el coste total del alquiler desglosado
	  @param cliente	-->cliente que tenia el vehiculo en alquiler.  
	  @param matricula -->matricula del vehiculo que se le alquilo.
	  @return devuelve el valor del alquiler
	 */
	public void devolver(Cliente cliente);
}