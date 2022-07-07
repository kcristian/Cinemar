import java.util.ArrayList;
import java.util.Date;

public class Datos_prueba {
	private ArrayList<Pelicula>peliculas;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Sala> salas;
	private ArrayList<Reserva> reservas;
	private ArrayList<Funcion> funciones;
	public Datos_prueba() {		
		
		peliculas=new ArrayList<>();
		usuarios=new ArrayList<>();
		salas=new ArrayList<>();
		funciones=new ArrayList<>();
		reservas=new ArrayList<>();
		
	}
	
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}

	public void iniciar() {
		
		// Creando usuarios
		
		Date d1=new Date(72,6,12);
		Date d2=new Date(72,6,12);
		Date d3=new Date(72,6,12);
		Date d4=new Date(72,6,12);
		Date d5=new Date(72,6,12);
		
		Usuario u1=new Usuario(1,"Jacqeline","741852","ADMINISTRACION","jacqueline@gmail.com",4227809,d1);
		Usuario u2=new Usuario(2,"Cristian","852963","ADMINISTRACION","cristian@gmail.com",4234565,d2);
		Usuario u3=new Usuario(3,"Gabriela","963074","CLIENTE","gabriela@gmail.com",4247894,d3);
		Usuario u4=new Usuario(4,"Ismael","185296","CLIENTE","ismael@gmail.com",4213202,d4);
		Usuario u5=new Usuario(5,"Andrea","307418","CLIENTE","andrea@gmail.com",4278596,d5);
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
		usuarios.add(u5);
		
		// Creando peliculas
		
		Pelicula p1= new Pelicula(1,"V de Venganza", new Clasificacion("M18","mayores de 18 años"),
				new TipoPelicula("2D","Ingles",true), new Genero(1,"Accion"), 130);
		
		Pelicula p2= new Pelicula(2,"Sonic", new Clasificacion("ATP","Apta para todo publico"),
				new TipoPelicula("3D","Latino",false), new Genero(2, "Aventura"), 90);
		
		Pelicula p3= new Pelicula(3,"Spiderman", new Clasificacion("ATP","Apta para todo publico"),
				new TipoPelicula("2D","Latino",false), new Genero(3, "Ciencia Ficcion"), 120);
		
		Pelicula p4= new Pelicula(4, "Dr Strange", new Clasificacion("ATP","Apta para todo publico"),
				new TipoPelicula("3D","Ingles",true), new Genero(4, "Aventura"), 120);
		
		Pelicula p5= new Pelicula(5, "Red Liberty", new Clasificacion("M18","mayores de 18 años"),
				new TipoPelicula("3D","Ingles",true), new Genero(5, "Ciencia Ficcion"), 110);
		
		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		
		//creando salas
		Sala s1=new Sala(1,500,500);
		Sala s2=new Sala(2,500,1000);
		Sala s3=new Sala(3,500,1500);
		Sala s4=new Sala(4,500,2000);
		Sala s5=new Sala(5,500,2500);
		Sala s6=new Sala(6,500,3000);
		
		salas.add(s1);
		salas.add(s2);
		salas.add(s3);
		salas.add(s4);
		salas.add(s5);
		salas.add(s6);
		
		
		//creando Fechas y funciones
		
		Date f1=new Date(122,5,27,15,30,0);
		Date f2=new Date(122,5,28,17,30,0);
		Date f3=new Date(122,5,29,19,00,0);
		Date f4=new Date(122,5,30,21,30,0);
		Date f5=new Date(122,6,1,23,30,0);
		Date f6=new Date(122,6,3,00,00,0);
		
		
		funciones.add(new Funcion(1,f1,s1,p1));
		funciones.add(new Funcion(2,f2,s2,p2));
		funciones.add(new Funcion(3,f3,s3,p3));
		funciones.add(new Funcion(4,f4,s4,p3));
		funciones.add(new Funcion(5,f5,s5,p4));
		funciones.add(new Funcion(6,f6,s6,p5));
		
		Reserva r=new Reserva(1, u5, funciones.get(4), funciones.get(4).getSala_funcion().getAsientos().get(25),10);
		reservas.add(r);
	}
}