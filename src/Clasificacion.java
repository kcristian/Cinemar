
public class Clasificacion {
	
	private int numero_clasificacion;
	private String identificador;
	private String descripcion;
	
	public Clasificacion(int numero_clasificacion, String identificador,String descripcion) {
		this.numero_clasificacion=numero_clasificacion;
		this.identificador=identificador;
		this.descripcion=descripcion;
	}
	
	public Clasificacion() {
		
	}
	
	
	public int getNumero_clasificacion() {
		return numero_clasificacion;
	}

	public void setNumero_clasificacion(int numero_clasificacion) {
		this.numero_clasificacion = numero_clasificacion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return "numero de clasificacion: "+getNumero_clasificacion()+"identificador: "+getIdentificador()+" descripcion: "+getDescripcion();
	}
}
