package proyecto;

import java.util.Scanner;

/**
 * Clase Furgoneta --> hereda de Vehiculo e implementa la interfaz Renting.
 * cuenta con los atributos aniadidos de "int plus" e "int numPuestos."
 */
public class Furgoneta extends Vehiculo implements Renting {

	Scanner teclado = new Scanner(System.in);
	int numPuestos;
	int plus = 30000;

	/**
	 * Constructor parametrizado que se basa en el de la clase padre y anide el
	 * numero de plazas, ademas de incializar los atributos precioDia y precioKm;
	 * 
	 * @param modelo
	 * @param placa
	 * @param km
	 * @param numPuestos    --> numero de puestos de la furgoneta
	 */
	public Furgoneta(String modelo, String placa, int km, int numPuestos) {
		super(modelo, placa, km);
		this.numPuestos = numPuestos;
		precioDia = 20000;
		precioKm = 3000;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		boolean alquilar = false;

		if (cliente.getCarnetFurgoneta() && !cliente.getAlquilado()) {
			String opcion;

			System.out.print("Para cuantos dias se alquila? ");
			dias = teclado.nextInt();
			System.out.println(
					"El coste del alquiler es de: $" + dias * precioDia + " + $" + precioKm + "pesos por km recorrido");
			if (numPuestos> 7)
				System.out.println("Este vehiculo tiene un costo extra de $" + plus + " por ser de mas de 7 puestos");

			do {
				System.out.print("Desea alquilar la furgoneta? Si(s) No(n)");
				opcion = teclado.nextLine();
			} while (!super.comprobarOpcion(opcion));

			if (opcion.equals("s")) {
				cliente.setAlquilado(true);
				alquilar = true;
				System.out.println("Ha aceptado el alquiler.");
			} else
				alquilar = false;
		} else {
			System.out.println("No se puede alquilar el vehiculo:");
			if (!cliente.getCarnetFurgoneta())
				System.out.println("El cliente no tiene el carnet necesario para alquilar la furgoneta");
			else
				System.out.println("El cliente ya tiene un vehiculo alquilado.");
		}
		return alquilar;
	}

	@Override
	public void devolver(Cliente cliente) {
		float precio;
		int kmMarcador, kmCobrar;

		do {
			System.out.print("Cuantos Km indica el kilometraje? ");
			kmMarcador = teclado.nextInt();
		} while (!compruebaKm(kmMarcador));

		kmCobrar = kmMarcador - km;

		System.out.println("Ha hecho " + kmCobrar + "Km con un coste total de $" + kmCobrar * precioKm);
		System.out.println("El precio total del alquiler es de: ");
		System.out.println("\t# $" + dias * precioDia + " por los dias de alqiler");
		System.out.println("\t# $" + kmCobrar * precioKm + " por los Km.");
		
		if (numPuestos > 7) {
			System.out.println("\t# $" + plus + " por tener m�s de 7 puestos");
			precio = (dias * precioDia) + (kmCobrar * precioKm) + plus;
		} else {
			precio = (dias * precioDia) + (kmCobrar * precioKm);
		}

		System.out.println("\t#Total: $" + precio);

		cliente.setAlquilado(false);
		km = kmMarcador;
	}
}
