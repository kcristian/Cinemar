
public class Asiento {

	private int num_asiento;
	private double precio;
	private Estado_asiento estado;
	
	public Asiento(int numero_asiento,double precio) {
		
		this.num_asiento=numero_asiento;
		this.precio=precio;
		this.estado=Estado_asiento.LIBRE;
	}

	public int getNum_asiento() {
		return num_asiento;
	}

	public void setNum_asiento(int num_asiento) {
		this.num_asiento = num_asiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Estado_asiento getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		try {
			this.estado = Estado_asiento.valueOf(estado);
		} catch (Exception e) {
			System.out.println("debe ingresar un estado valido");
		}
	}
	
	
}
