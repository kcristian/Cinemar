import java.util.ArrayList;

public class Sala {
	
	private int num_sala;
	public static int num_sala_siguiente=1;
	private int capacidad;
	private ArrayList<Asiento> asientos;
	
	public Sala(int capacidad){
		
		this.num_sala=num_sala_siguiente;
		num_sala_siguiente++;
		this.capacidad=capacidad;
		for(int i=0;i<this.capacidad;i++){
			asientos.add()// creando asientos
		}
		
	}
}
