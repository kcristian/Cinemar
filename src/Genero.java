
public class Genero {
	
	private int numero_genero;
	private String nombre;

	public Genero(int num_genero, String nombre) {
		this.numero_genero= num_genero;
		this.nombre=nombre;
	}
	
	public Genero() {
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero_genero() {
		return numero_genero;
	}
	
	public String toString() {
		return " nombre de genero: " + getNombre();
	}
}
