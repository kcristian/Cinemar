import java.util.Date;

public class Funcion {
	
	private int id_funcion;
	public static int id_funcion_siguiente=1;
	
	private Date fecha;
	private Sala sala_funcion;
	private Pelicula pelicula;
	
	public Funcion(Date fecha,Sala sala,Pelicula pelicula) {
		
		this.id_funcion=this.id_funcion_siguiente;
		this.fecha=fecha;
		this.sala_funcion=sala;
		this.pelicula=pelicula;
		this.id_funcion_siguiente++;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		try {
			this.fecha=fecha;
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de fecha AAAA-MM-DD-hh-mm-ss");
		}
	}


	public Sala getSala_funcion() {
		return sala_funcion;
	}

	public void setSala_funcion(Sala sala_funcion) {
		this.sala_funcion = sala_funcion;
	}

	public int getId_funcion() {
		return id_funcion;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void mostrarDatosFuncion() {
		
		System.out.println("Datos de la funcion");
		System.out.println("Id de la funcion :"+ this.id_funcion);
		System.out.println("Fecha de la funcion: "+this.fecha);
		System.out.println("Sala de la funcion: "+this.sala_funcion.getNum_sala());
		System.out.println("Pelicula: "+this.pelicula.getNombre());
		System.out.println();
		this.sala_funcion.mostrarDatosSala();
	}
	
}
