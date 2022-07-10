import java.util.ArrayList;

public class Pelicula {
	
	private int num_pelicula;
	private String nombre;
	private String sinopsis;
	private int duracion;
	private String director;
	private ArrayList<String> reparto;
	
	private ArrayList<Genero> generos; 
	private Clasificacion clasificacion;
	private ArrayList<TipoPelicula> tipos;
	
	Pelicula(int num_pelicula, String nombre,Clasificacion cl,TipoPelicula tipo,Genero genero,int duracion,TipoPelicula tp){
		
		this.num_pelicula= num_pelicula;
		this.nombre=nombre;
		this.sinopsis="NINGUNA";
		this.generos=new ArrayList<>();
		this.generos.add(genero);
		this.reparto=new ArrayList<>();
		this.reparto.add("-");
		this.director="-";
		this.clasificacion=cl;
		this.tipos=new ArrayList<>();
		this.tipos.add(tp);
		this.duracion=duracion;
	}

	public Pelicula() {
		
	}
	public void setNum_pelicula(int num_pelicula) {
		this.num_pelicula = num_pelicula;
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

	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
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



	public ArrayList<TipoPelicula> getTipos() {
		return tipos;
	}

	public void setTipos(ArrayList<TipoPelicula> tipos) {
		this.tipos = tipos;
	}

	public int getNum_pelicula() {
		return num_pelicula;
	}
	
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public void agregarActor(String nom_ape) {
		reparto.add(nom_ape);
	}
	public void agregarGenero(Genero g) {
		generos.add(g);
	}
	public String dameReparto() {
		String resultado="[ ";
		for(int i=0;i<reparto.size();i++) {
			String valor= getReparto().get(i)+"/";
			resultado = resultado + valor;
		}
		
		return resultado + " ]";
	}
	
	public String dameGeneros() {
		String resultado = "[";
		for(int i=0;i<generos.size();i++) {
			String valor= getGeneros().get(i).getNombre()+"/";
			resultado=resultado+valor;
		}
		
		return resultado + " ]";
	}
	
	public String dameTipos() {
		String resultado="[ ";
		
		for(int i=0;i<tipos.size();i++) {
			String valor= getTipos().get(i).getFormato()+"/"+getTipos().get(i).getIdioma()+"/"+getTipos().get(i).isSubtitulada();
			resultado=resultado+valor;
		}
		
		return resultado +" ]";
	}
	public String toString() {
		return "numero pelicula: "+ getNum_pelicula()+ " nombre: "+ getNombre() + " sinopsis: " + getSinopsis() + " duracion: "+ getDuracion() +
				" director: "+ getDirector()+ "\n"+ " reparto: "+ dameReparto() +"\n"+ " genero: " + dameGeneros() +"\n"+ 
				"clasificacion: "+getClasificacion().toString()+" tipo de pelicula: "+ dameTipos();
	}
}
