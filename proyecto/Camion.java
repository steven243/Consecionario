package proyecto;

import java.util.Scanner;


/**
  Clase Camion --> Hereda de Vehiculo e implementa la interfaz Renting, aniade el boolean grua, para indicar
  si tiene grua autocargante e int plus, que es el plus por la grua
 */
public class Camion extends Vehiculo implements Renting{
	Scanner teclado = new Scanner(System.in);
	boolean grua;
	int plus = 90000;	
	
	/**
	  Constructor parametrizado que se base en el de la clase padre y valor de grua, además de inicializar
	  los valores de precioDia y precioKm	
	  @param modelo
	  @param placa
	  @param km
	  @param grua
	 */
	public Camion(String modelo,String placa,int km,boolean grua){
		
		super(modelo,placa,km);
		this.grua = grua;
		precioDia = 300000;
		precioKm = 10000;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		
		boolean alquilar = false;
		
		if(cliente.getCarnetCamion() && !cliente.getAlquilado()) {			
			
			String opcion;
			
			System.out.print("Para cuantos dias se alquila? ");
			dias = teclado.nextInt();
			
			System.out.println("El coste del alquiler es de: $" + dias*precioDia + " + $"+ precioKm +" por km recorrido");
			
			if(grua) {
				System.out.println("Este  camion tiene un suplemento de $"+ plus +" por estar dotado de grua autocargante");
			}
			
			do{
			
				System.out.print("Desea alquilar el camion? Si(s) No(n)");
				opcion = teclado.nextLine();
			
			}while(!super.comprobarOpcion(opcion));
			
			if(opcion.equals("s")){
				
				cliente.setAlquilado(true);
				alquilar = true;
				System.out.println("Ha aceptado el alquiler.");
			
			}else {
			
				alquilar = false;			
		
			}
		}
		else {
			
			System.out.println("No se puede alquilar el vehiculo:");
			if(!cliente.getCarnetCamion())
				System.out.println("El cliente no tiene el carnet necesario para alquilar el camion");
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
		
			System.out.print("Cuantos Km indica el kilometaje? ");
			kmMarcador=teclado.nextInt();			
		
		}while(!compruebaKm(kmMarcador));
		
		kmCobrar = kmMarcador-km;
		
		System.out.println("Ha hecho " + kmCobrar + "Km con un coste total de $"+ kmCobrar*precioKm);
		System.out.println("El precio total del alquiler es de: ");
		System.out.println("\t# $"+ dias*precioDia + " por los dias de alquiler");
		System.out.println("\t# $"+ kmCobrar*precioKm +" por los Km.");
		
		if(grua) {
			
			System.out.println("\t# $"+ plus +" por estar dotado de grua");
			precio = (dias*precioDia) + (kmCobrar*precioKm) + plus;
		
		}else{
			
			precio = (dias*precioDia) + (kmCobrar*precioKm);
		
		}
		
		System.out.println("\t#Total: $"+ precio);
		
		cliente.setAlquilado(false);
		km = kmMarcador;
		
	}	
}