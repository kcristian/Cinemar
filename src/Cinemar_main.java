import java.text.SimpleDateFormat;
import java.util.Date;

public class Cinemar_main {

	public static void main(String[] args) {
		//Datos de usuario de prueba
		String username="Cristian9";
		String password="1234425";
		String rol="AdmInIStracioN";
		String email="cristian9@gmail.com";
		int telefono=4290478;
		Usuario u1=new Usuario(100,username,password,rol,email,telefono,new Date(192,7,10));
		Cinemar c=new Cinemar();
		
		//Datos_prueba dp=new Datos_prueba();
		
		//dp.getPeliculas().get(1).agregarActor("cristian");
		//System.out.println(dp.getPeliculas().get(1).toString());
		
		
		//Sala s1=new Sala(5);
		//s1.mostrarDatosSala();
		//Funcion f1=new Funcion("2022-06-16", "17:15:00", "02:30:00", s1);
		//f1.getSala_funcion().mostrarDatosSala();
		/*Date f=new Date(122, 7, 15, 10, 10, 10);
		Clasificacion cl1= new Clasificacion("ATP","apta para todo publico");
		TipoPelicula tipo=new TipoPelicula("2D","Ingles",true);
		Genero g1 = new Genero("Terror");
		Sala s2=new Sala(20);
		Pelicula p1= new Pelicula("V de venganza",cl1,tipo,g1,180);
		Funcion funcion=new Funcion(f, s2, p1);
		funcion.mostrarDatosFuncion();
		
		Butaca b=new Butaca();
		Reserva r=new Reserva(u1, funcion, b,10);
		r.mostrarDatosReserva();*/
		
		
		/*Date f2=new Date();
		final String NEW_FORMAT="yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
		System.out.println("hoy es: " + sdf.format(f2));*/
		
		
	}

}
