import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcion {
	
	private int id_funcion;
	private Date fecha;
	private Sala sala_funcion;
	private Pelicula pelicula;
	
	public Funcion(int idfuncion, Date fecha,Sala sala,Pelicula pelicula) {
		
		this.id_funcion=idfuncion;
		this.fecha=fecha;
		this.sala_funcion=sala;
		this.pelicula=pelicula;
	}
	
	public Funcion() {
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha=fecha;
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
	
	public void setId_funcion(int id_funcion) {
		this.id_funcion = id_funcion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String toString() {
		final String NEW_FORMAT="yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
		
		return "id funcion: "+ getId_funcion()+ " Fecha: "+ sdf.format(getFecha())+ " Horario: "+sdf.format(getFecha()) + " en sala: "+
				getSala_funcion().toString()+" pelicula: "+getPelicula().toString();
	}
	
	public boolean hayLugares(int cantidad_req) {
		boolean respuesta = false;
		
		if(cantidad_req <= getSala_funcion().cantidadAsientosLibres()) {
			respuesta=true;
		}
		
		return respuesta;
	}
}
