import java.util.ArrayList;

public class Sala {
	
	private int num_sala;
	private int capacidad;
	private ArrayList<String> formato_de_sala;
	private ArrayList<Butaca> asientos;
	private float precio_entrada;
	
	public Sala(int num_sala, int capacidad,int ultimo_num_butaca){
		
		this.num_sala=num_sala;
		this.capacidad=capacidad;
		this.asientos=new ArrayList<>();
		this.formato_de_sala=new ArrayList<>();
		formato_de_sala.add("2D");
		this.precio_entrada=700;
	}
	
	public Sala() {
		this.asientos=new ArrayList<>();
		this.formato_de_sala=new ArrayList<>();
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
	

	public ArrayList<String> getFormato_de_sala() {
		return formato_de_sala;
	}

	public void setFormato_de_sala(ArrayList<String> formato_de_sala) {
		this.formato_de_sala = formato_de_sala;
	}

	public float getPrecio_entrada() {
		return precio_entrada;
	}

	public void setPrecio_entrada(float precio_entrada) {
		if(precio_entrada>=0) {
			this.precio_entrada = precio_entrada;
		}else {
			this.precio_entrada = (-1)*precio_entrada;
		}
		
	}
	public String dameFormatos() {
		String resultado = "[";
		for(int i=0;i<formato_de_sala.size();i++) {
			if(i!=formato_de_sala.size()) {
				String valor= getFormato_de_sala().get(i)+",";
				resultado=resultado+valor;	
			}else {
				String valor= getFormato_de_sala().get(i);
				resultado=resultado+valor;
			}
		}
		
		return resultado + " ]";
	}
	
	public String describeAsientos() {
		String resultado = "\n asientos: [";
		for(int i=0;i<getAsientos().size();i++) {
			if(i!=asientos.size()) {
				String valor=getAsientos().get(i).getNum_butaca()+ " estado: "+getAsientos().get(i).estaLibre()+ ",";
				resultado = resultado+valor;
			}else {
				String valor=getAsientos().get(i).getNum_butaca()+" estado: "+getAsientos().get(i).estaLibre();
				resultado = resultado+valor;
			}
			
		}
		return resultado + "]";
	}
	public String toString() {
		return "numero de sala: "+getNum_sala()+" capacidad: "+getCapacidad()+" formatos de sala: "+dameFormatos()+ describeAsientos();
	}
	
	
	public boolean ExisteButaca(int numero_butaca) {
		boolean respuesta=false;
		for(int i=0;i<asientos.size();i++) {
			if(numero_butaca==asientos.get(i).getNum_butaca()) {
				respuesta=true;
			}
		}
		
		return respuesta;
	}
	
	public int cantidadAsientosLibres() {
		int resultado=0;
		
		for(int i=0;i<asientos.size();i++) {
			if(getAsientos().get(i).estaLibre().equals("LIBRE")) {
				resultado++;
			}
		}
		
		return resultado;
	}
	
}
