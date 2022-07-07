
public class TipoPelicula {
	
	private String formato; 
	private String idioma;
	private boolean subtitulada;
	
	public TipoPelicula(String formato, String idioma, boolean subtitulada) {
		
		this.formato=formato;
		this.idioma=idioma;
		this.subtitulada=subtitulada;
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
		if(this.subtitulada==true) {
			return "Con subtitulos";
		}else {
			return "Sin subtitulos";
		}
	}

	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}
	
	public String toString() {
		return "formato: "+getFormato()+" idioma: "+getIdioma()+" subtitulos: "+isSubtitulada();
	}
}
