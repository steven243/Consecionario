package proyecto;

import java.util.Scanner;

/**
  Clase para el Particular
 */
public class Particular extends Vehiculo implements Renting {
	
	Scanner teclado=new Scanner(System.in);
		
	/**
	  Constructor parametrizado para indicar modelo, matricula y km, ademas de inicializar los
	  valores de precioDia y precioKm
	  @param modelo
	  @param matricula
	  @param km
	 */
	public Particular(String modelo,String placa,int km){
		super(modelo,placa,km);
		precioDia=100000;
		precioKm=10000;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		boolean alquilar=false;
		
		if(cliente.getCarnetParticular() && !cliente.getAlquilado())
		{			
			String opcion;
			System.out.print("Para cuantos dias se alquila? ");
			dias=teclado.nextInt();
			System.out.println("El coste del alquiler es de: $"+ dias*precioDia +" + $"+ precioKm +" por km recorrido");
			
			do{
				System.out.print("Desea alquilar el Particular? Si(s) No(n)");
				opcion=teclado.nextLine();
			}while(!comprobarOpcion(opcion));
			
			if(opcion.equals("s")){
				cliente.setAlquilado(true);		
				alquilar=true;
				System.out.println("Ha aceptado el alquiler.");
			}else
				alquilar=false;			
		}
		else {
			System.out.println("No se puede alquilar el vehiculo:");
			if(!cliente.getCarnetParticular())
				System.out.println("El cliente no tiene el carnet de Particular necesario para alquilar el vehiculo");
			else
				System.out.println("El cliente ya tiene un vehiculo alquilado.");
		}
		return alquilar;
	}

	@Override
	public void devolver(Cliente cliente) {
		int precio;
		int kmMarcador,kmCobrar;
		
		do{
			System.out.print("Cuantos Km indica el kilometraje? ");
			kmMarcador=teclado.nextInt();			
		}while(!compruebaKm(kmMarcador));
		
		kmCobrar=kmMarcador-km;
		
		System.out.println("Ha hecho " + kmCobrar + "Km con un coste total de $"+ kmCobrar*precioKm);
		System.out.println("El precio total del alquiler es de: ");
		System.out.println("\t# $" + dias*precioDia + " por los dias de alquiler");
		System.out.println("\t# $" + kmCobrar*precioKm + " por los Km.");
		precio=(dias*precioDia)+(kmCobrar*precioKm);
		System.out.println("\t#Total: $" + precio);
		
		cliente.setAlquilado(false);
		km=kmMarcador;		
		}	
}