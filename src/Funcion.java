import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {
	
	private int id_funcion;
	public static int id_funcion_siguiente=1;
	private LocalDate fecha;
	private LocalTime hora_inicio;
	private LocalTime duracion;
	private LocalTime hora_fin;
	private Sala sala_funcion;
	private Pelicula pelicula;
	
	public Funcion(String fecha,String inicio,String duracion,Sala sala) {
		
		this.id_funcion=this.id_funcion_siguiente;
		try {
			this.fecha=LocalDate.parse(fecha);
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de fecha AAAA-MM-DD");
		}
		try {
			this.hora_inicio=LocalTime.parse(inicio);
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de hora HH:MM:SS");
		}
		try {
			this.duracion=LocalTime.parse(duracion);
			
			this.hora_fin=this.hora_inicio.plusMinutes(this.duracion.getMinute());
			this.hora_fin=this.hora_inicio.plusHours(this.duracion.getHour());
			
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de hora HH:MM:SS");
		}
		this.sala_funcion=sala;
		this.id_funcion_siguiente++;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		try {
			this.fecha=LocalDate.parse(fecha);
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de fecha AAAA-MM-DD");
		}
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		try {
			this.hora_inicio=LocalTime.parse(hora_inicio);
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de hora HH:MM:SS");
		}
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		try {
			this.duracion=LocalTime.parse(duracion);
			this.hora_fin=this.hora_inicio.plusHours(this.duracion.getHour());
			this.hora_fin=this.hora_inicio.plusMinutes(this.duracion.getMinute());
		} catch (Exception e) {
			System.out.println("Debe ingresar un formato de hora HH:MM:SS");
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

	public LocalTime getHora_fin() {
		return hora_fin;
	}
	
	public void mostrarDatosFuncion() {
		
		System.out.println("Datos de la funcion");
		System.out.println("Id de la funcion :"+ this.id_funcion);
		System.out.println("Fecha de la funcion: "+this.fecha);
		System.out.println("Hora de la funcion: "+this.hora_inicio);
		System.out.println("Duracion de la funcion: "+this.duracion);
		System.out.println("Hora de finalizacion: "+this.hora_fin);
		System.out.println();
		this.sala_funcion.mostrarDatosSala();
	}
	
}
