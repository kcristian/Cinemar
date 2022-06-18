import java.util.Date;

public class Cinemar_main {

	public static void main(String[] args) {
		//Datos de usuario de prueba
		String username="Cristian9";
		String password="1234425";
		String rol="AdmInIStracioN";
		String email="cristian9@gmail.com";
		Usuario u1=new Usuario(username,password,rol,email);
		//u1.mostrarDatos();
		//Sala s1=new Sala(5);
		//s1.mostrarDatosSala();
		//Funcion f1=new Funcion("2022-06-16", "17:15:00", "02:30:00", s1);
		//f1.getSala_funcion().mostrarDatosSala();
		Date f=new Date(122, 7, 15, 10, 10, 10);
		Clasificacion cl1= new Clasificacion("ATP","apta para todo publico");
		TipoPelicula tipo=new TipoPelicula("2D","Ingles",true);
		Sala s2=new Sala(20);
		Pelicula p1= new Pelicula("V de venganza",cl1,tipo);
		Funcion funcion=new Funcion(f, s2, p1);
		funcion.mostrarDatosFuncion();
		
		Butaca b=new Butaca();
		Reserva r=new Reserva(u1, funcion, b,10);
		r.mostrarDatosReserva();
		
	}

}
