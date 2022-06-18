import java.util.ArrayList;

public class Sala {
	
	private int num_sala;
	public static int num_sala_siguiente=1;
	private int capacidad;
	private ArrayList<String> formato_de_sala;
	private ArrayList<Butaca> asientos;
	
	public Sala(int capacidad){
		
		this.num_sala=num_sala_siguiente;
		num_sala_siguiente++;
		this.capacidad=capacidad;
		this.asientos=new ArrayList<>();
		for(int i=0;i<this.capacidad;i++){
			asientos.add(new Butaca());
		}
		this.formato_de_sala=new ArrayList<>();
		formato_de_sala.add("2D");
		
	}

	public int getNum_sala() {
		return num_sala;
	}

	public void setNum_sala(int num_sala) {
		this.num_sala = num_sala;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Butaca> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Butaca> asientos) {
		this.asientos = asientos;
	}
	
	
	public ArrayList<String> getFormatos() {
		return formato_de_sala;
	}

	public void setFormatos(ArrayList<String> formatos) {
		this.formato_de_sala = formatos;
	}

	public void mostrarDatosSala() {
		
		System.out.println("DATOS DE LA SALA: ");
		System.out.println("Numero de sala: "+this.num_sala);
		System.out.println("Capacidad: "+this.capacidad);
		System.out.println("Butacas: ");
		for(Butaca a:asientos) {
			System.out.println("Butaca Nº "+a.getNum_butaca());
			System.out.println("Precio $"+a.getPrecio());
			System.out.println("Estado "+a.getEstado());
		}
		
	}
}
