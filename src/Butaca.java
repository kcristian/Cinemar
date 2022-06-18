
public class Butaca {

	private int num_butaca;
	public static int num_butaca_siguiente=1;
	private double precio;
	private Estado_asiento estado;
	
	public Butaca() {
		
		this.num_butaca=num_butaca_siguiente;
		this.num_butaca_siguiente++;
		this.precio=500;
		this.estado=Estado_asiento.LIBRE;
	}

	public int getNum_butaca() {
		return num_butaca;
	}

	public void setNum_butaca(int num_asiento) {
		this.num_butaca = num_asiento;
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
