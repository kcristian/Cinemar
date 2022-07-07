
public class Butaca {

	private int num_butaca;
	private boolean estado;
	
	public Butaca(int num_butaca) {
		
		this.num_butaca=num_butaca;
		this.estado=false;
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
	
	public String estaLibre() {
		String respuesta="LIBRE";
		
		if(getEstado()) {
			respuesta="OCUPADA";
		}
		
		return respuesta;
	}
	
	public String toString() {
		return "butaca Nº"+getNum_butaca()+" estado: "+estaLibre()+" \n";
	}
}
