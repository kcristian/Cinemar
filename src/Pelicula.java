import java.util.ArrayList;

public class Pelicula {
	
	private int num_pelicula;
	public static int num_pelicula_siguiente=1;
	private String nombre;
	private String sinopsis;
	private ArrayList<String> genero;
	private String director;
	private ArrayList<String> reparto;
	private Clasificacion clasificacion;
	private TipoPelicula tipo;
	
	Pelicula(String nombre,Clasificacion cl,TipoPelicula tipo){
		
		this.num_pelicula=num_pelicula_siguiente;
		this.nombre=nombre;
		this.sinopsis="NINGUNA";
		this.genero=new ArrayList<>();
		this.genero.add("-");
		this.reparto=new ArrayList<>();
		this.reparto.add("-");
		this.director="-";
		this.clasificacion=cl;
		this.tipo=tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public ArrayList<String> getGenero() {
		return genero;
	}

	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public ArrayList<String> getReparto() {
		return reparto;
	}

	public void setReparto(ArrayList<String> reparto) {
		this.reparto = reparto;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public TipoPelicula getTipo() {
		return tipo;
	}

	public void setTipo(TipoPelicula tipo) {
		this.tipo = tipo;
	}

	public int getNum_pelicula() {
		return num_pelicula;
	}
	
	public void mostrarDatosPelicula() {
		System.out.println("DATOS DE PELICULA");
		System.out.println("numero de pelicula: "+getNum_pelicula());
		System.out.println("nombre de pelicula: "+getNombre());
		System.out.println("generos: ");
		for(int i=0;i<this.genero.size();i++) {
			System.out.println(this.genero.get(i));
		}
		System.out.println("sinopsis: "+getSinopsis());
		System.out.println("director: "+getDirector());
		
		System.out.println("reparto:");
		for(int i=0;i<this.reparto.size();i++) {
			System.out.println(this.reparto.get(i));
		}
		System.out.println("Clasificacion: "+getClasificacion().getIdentificador()+": "+getClasificacion().getDescripcion());
		System.out.println("Tipo: "+getTipo().getFormato()+" "+getTipo().getIdioma()+" "+getTipo().isSubtitulada());
	}
}
