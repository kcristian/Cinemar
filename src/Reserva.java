import java.util.Calendar;
import java.util.Date;

public class Reserva {
	
	private int num_reserva;
	public static int num_reserva_siguiente=1;
	private Date fecha_reserva;
	private Usuario usuario;
	private Funcion funcion;
	private Butaca butaca;
	private float precio;
	private int descuento;
	private double precio_final;
	
	public Reserva(Usuario usuario,Funcion funcion,Butaca butaca,int descuento) {
		this.num_reserva=num_reserva_siguiente;
		this.fecha_reserva=new Date();
		//this.fecha_reserva=Calendar.getInstance().getTime();
		this.usuario=usuario;
		this.funcion=funcion;
		this.butaca=butaca;
		this.precio=this.funcion.getSala_funcion().getPrecio_entrada();
		this.descuento=descuento;
		this.precio_final=this.precio-(this.precio*(this.descuento/100));
		
		
		this.num_reserva_siguiente++;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecio_final() {
		return precio_final;
	}

	public void setPrecio_final(double precio_final) {
		this.precio_final = precio_final;
	}

	public int getNum_reserva() {
		return num_reserva;
	}
	
	public void mostrarDatosReserva() {
		System.out.println("DATOS DE RESERVA: ");
		System.out.println("numero de reserva"+getNum_reserva());
		System.out.println("fecha de reserva "+getFecha_reserva());
		System.out.println("Usuario: "+getUsuario().getUsername());
		System.out.println("Pelicula: "+getFuncion().getPelicula().getNombre());
		System.out.println("Fecha: "+getFuncion().getFecha());
		System.out.println("Butaca: "+getButaca().getNum_butaca());
		System.out.println("precio: "+getPrecio());
		System.out.println("descuento: "+getDescuento());
		System.out.println("total: "+getPrecio_final());
		
	}
	
}
