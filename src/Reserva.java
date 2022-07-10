import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Reserva {
	
	private int num_reserva;
	private Date fecha_reserva;
	private Usuario usuario;
	private Funcion funcion;
	private ArrayList<Butaca> butacas;
	private float precio;
	private float descuento;
	private float precio_final;
	private int cantidad_butacas;
	
	public Reserva(int num_reserva, Usuario usuario,Funcion funcion,int cant_butacas,int descuento) {
		this.num_reserva=num_reserva;
		this.fecha_reserva=new Date();;
		this.usuario=usuario;
		this.funcion=funcion;
		this.butacas=new ArrayList<>();
		this.precio=this.funcion.getSala_funcion().getPrecio_entrada();
		this.descuento=descuento;
		this.precio_final=this.precio-(this.precio*(this.descuento/100));
		this.cantidad_butacas=cant_butacas;
		for(int i=0;i<cant_butacas;i++) {
			getFuncion().getSala_funcion().getAsientos().get(i).setEstado(true);
			butacas.add(getFuncion().getSala_funcion().getAsientos().get(i));
		}
		
	}
	
	public Reserva() {
		
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

	public ArrayList<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(ArrayList<Butaca> butacas) {
		this.butacas = butacas;
	}

	public void setNum_reserva(int num_reserva) {
		this.num_reserva = num_reserva;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecio_final() {
		return precio_final;
	}

	public void setPrecio_final(float precio_final) {
		this.precio_final = precio_final;
	}

	public int getNum_reserva() {
		return num_reserva;
	}
	
	public String toString() {
		final String NEW_FORMAT="yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
		return "numero de reserva: "+getNum_reserva()+" fecha: "+sdf.format(getFecha_reserva())+ " usuario: "+ getUsuario().getUsername()+
				"\nfuncion: "+getFuncion().toString()+ dameButacas()
				+" precio: "+getPrecio()+ " descuento: "+getDescuento()+" precio final: "+getPrecio_final();
	}
	
	public String dameButacas() {
		String resultado="";
		
		for(int i=0;i<butacas.size();i++) {
			resultado ="numero butaca: "+butacas.get(i).getNum_butaca() + " \n";
		}
		return resultado;
		
	}
	
}
