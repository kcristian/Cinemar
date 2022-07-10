
public class Butaca {

	private int num_butaca;
	private String identificador;
	private boolean estado;
	
	public Butaca(int num_butaca,String identificador) {
		
		this.num_butaca=num_butaca;
		this.identificador=identificador;
		this.estado=false;
	}
	
	public Butaca() {
		
	}
	public int getNum_butaca() {
		return num_butaca;
	}

	public void setNum_butaca(int num_asiento) {
		this.num_butaca = num_asiento;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado=estado;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String estaLibre() {
		String respuesta="LIBRE";
		
		if(getEstado()) {
			respuesta="OCUPADA";
		}
		
		return respuesta;
	}
	
	public String toString() {
		return " butaca Nº"+getNum_butaca()+" identificador: "+getIdentificador()+" estado: "+estaLibre()+" \n";
	}
}
