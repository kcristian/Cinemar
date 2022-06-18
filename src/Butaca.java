
public class Butaca {

	private int num_butaca;
	public static int num_butaca_siguiente=1;
	private Estado_butaca estado;
	
	public Butaca() {
		
		this.num_butaca=num_butaca_siguiente;
		this.num_butaca_siguiente++;
		this.estado=Estado_butaca.LIBRE;
	}

	public int getNum_butaca() {
		return num_butaca;
	}

	public void setNum_butaca(int num_asiento) {
		this.num_butaca = num_asiento;
	}

	public Estado_butaca getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		try {
			this.estado = Estado_butaca.valueOf(estado);
		} catch (Exception e) {
			System.out.println("debe ingresar un estado valido");
		}
	}
	
	public boolean ButacaLibre() {
		boolean respuesta=true;
		
		if(getEstado().equals(Estado_butaca.RESERVADO)) {
			respuesta=false;
		}
		
		return respuesta;
	}
	
}
