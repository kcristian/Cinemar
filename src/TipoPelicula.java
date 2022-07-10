
public class TipoPelicula {
	
	private int numero_tipo;
	private String formato; 
	private String idioma;
	private String subtitulos;
	
	public TipoPelicula(int numero_tipo,String formato, String idioma, String subtitulos) {
		
		this.numero_tipo=numero_tipo;
		this.formato=formato;
		this.idioma=idioma;
		this.subtitulos=subtitulos;
	}
	
	public TipoPelicula() {
		
	}

	public int getNumero_tipo() {
		return numero_tipo;
	}

	public void setNumero_tipo(int numero_tipo) {
		this.numero_tipo = numero_tipo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String isSubtitulada() {
		if(this.subtitulos.equals("NINGUNO")) {
			return "Sin subtitulos";
		}else {
			return "Con subtitulos";
		}
	}

	public void setSubtitulada(String subtitulada) {
		this.subtitulos = subtitulada;
	}
	
	public String toString() {
		return "formato: "+getFormato()+" idioma: "+getIdioma()+" subtitulos: "+isSubtitulada();
	}
}
