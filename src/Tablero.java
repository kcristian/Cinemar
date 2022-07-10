import java.util.Scanner;

public class Tablero {
	
	private Usuario usuario;
	private Cinemarsql cine;
	private String rol;
	public  Tablero() {
		
	}
	
	
	public void Iniciar(){
		String username;
		String password;
		String continuar;

		cine = new Cinemarsql();
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("username: ");
		username=entrada.nextLine();
		
		System.out.println("password: ");
		password=entrada.nextLine();
		
		if(cine.existeUsuario(username, password)) {
			
			usuario=cine.dameUsuario(username, password);
			rol=usuario.getRol_usuario().toString();
			System.out.println(rol);
			do {
				Menu();
				System.out.println("desea salir? y/n..");
				continuar=entrada.nextLine();
			} while (continuar.equals("n"));
			
		}else {
			System.out.println("el usuario no existe");
		}
		
			
		
		
	}
	

	public void Menu() {
		String valor;
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("#### MENU DE OPCIONES - INGRESE UN NUMERO ####");
		System.out.println("1) CREAR RESERVA"); 
		System.out.println("2) MODIFICAR RESERVA");
		System.out.println("3) VER MIS RESERVAS");
		System.out.println("4) HISTORICO DE ENTRADAS");
		
		System.out.println("5) VER SALAS");
		
		System.out.println("6) VER TODAS LAS RESERVAS");
		System.out.println("7) VER RESERVA POR CLIENTE");
		System.out.println("8) CREAR SALA CON PELICULA");
		System.out.println("9) MODIFICAR UNA SALA");
		System.out.println("10) ELIMINAR UNA SALA");
		System.out.println("11) MODIFICAR DESCUENTO");
		
		valor=entrada.nextLine();
		
		switch(valor) {
		case "1":	if(rol.equals("CLIENTE")) {
						try {
							crearReserva();
						} catch (Exception e) {
							
						}
					}else {
						System.out.println("debe ser cliente para realizar esta accion");
					}
					break;
		case "2":	if(rol.equals("CLIENTE")) {
						try {
							modificarReserva();
						} catch (Exception e) {
				
						}
					}else {
						System.out.println("debe ser cliente para realizar esta accion");
					}
					break;
		case "3":	if(rol.equals("CLIENTE")) {
						try {
							verMisReservas();
						} catch (Exception e) {
	
						}
					}else {
						System.out.println("debe ser cliente para realizar esta accion");
					}
					break;
		case "4":	if(rol.equals("CLIENTE")) {
						try {
							verHistoricoDeEntradas();
						} catch (Exception e) {
	
						}
					}else {
						System.out.println("debe ser cliente para realizar esta accion");
					}
					break;
		case "5":	if(rol.equals("CLIENTE")||rol.equals("ADMINISTRACION")) {
						try {
							verSalas();
						} catch (Exception e) {
	
						}
					}else {
						System.out.println("no se pudo realizar esta accion");
					}
					break;
		case "6":	if(rol.equals("ADMINISTRACION")) {
						try {
							verTodasLasReservas();
						} catch (Exception e) {
	
						}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		case "7":	if(rol.equals("ADMINISTRACION")) {
						try {
							mostrarReservasPorCliente();
						} catch (Exception e) {

						}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		case "8":	if(rol.equals("ADMINISTRACION")) {
						try {
							crearSalaConPelicula();
						} catch (Exception e) {

						}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		case "9":	if(rol.equals("ADMINISTRACION")) {
						try {
							modificarUnaSala();
						} catch (Exception e) {

						}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		case "10":	if(rol.equals("ADMINISTRACION")) {
						try {
							eliminarUnaSala();
						} catch (Exception e) {

						}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		case "11":	if(rol.equals("ADMINISTRACION")) {
					try {
							modificarDescuento();
					} catch (Exception e) {

					}
					}else {
						System.out.println("debe ser administrador para realizar esta accion");
					}
					break;
		
		default: 	System.out.println("debe ingresar una opcion valida..");
					break;
		}
		
				
	}
	
	public void crearReserva() {
		
		Scanner r=new Scanner(System.in);
		int id_reserva;
		String fecha;
		int cantidad;
		int id_descuento;
		int id_usuario;
		int id_funcion;
		int id_sala;
		int id_pelicula;
		
		System.out.println("ingrese id de reserva: ");
		id_reserva=r.nextInt();
		System.out.println("ingrese fecha de reserva yyyy/mm/dd: ");
		fecha = r.nextLine();
		System.out.println("ingrese cantidad a reservar");
		cantidad=r.nextInt();
		System.out.println("ingrese id de descuento");
		id_descuento=r.nextInt();
		System.out.println("ingrese id de usuario");
		id_usuario=r.nextInt();
		System.out.println("ingrese id de funcion");
		id_funcion=r.nextInt();
		System.out.println("ingrese id de sala");
		id_sala=r.nextInt();
		System.out.println("ingrese id de pelicula");
		id_pelicula=r.nextInt();
		r.close();
		cine.CrearReserva(id_reserva, fecha, cantidad, id_descuento, id_usuario, id_funcion, id_sala, id_pelicula);
		
	}
	
	public void modificarReserva() {
		Scanner r=new Scanner(System.in);
		int nuevo_id_reserva;
		String fecha;
		int cantidad;
		int id_descuento;
		int id_usuario;
		int id_funcion;
		int id_sala;
		int id_pelicula;
		int id_reserva_a_modificar;
		
		System.out.println("ingrese id de reserva a modificar");
		id_reserva_a_modificar=r.nextInt();
		
		System.out.println("ingrese nuevo id de reserva: ");
		nuevo_id_reserva=r.nextInt();
		System.out.println("ingrese nueva fecha de reserva yyyy/mm/dd: ");
		fecha = r.nextLine();
		System.out.println("ingrese nueva cantidad a reservar");
		cantidad=r.nextInt();
		System.out.println("ingrese nuevo id de descuento");
		id_descuento=r.nextInt();
		System.out.println("ingrese nuevo id de usuario");
		id_usuario=r.nextInt();
		System.out.println("ingrese nuevo id de funcion");
		id_funcion=r.nextInt();
		System.out.println("ingrese nuevo id de sala");
		id_sala=r.nextInt();
		System.out.println("ingrese nuevo id de pelicula");
		id_pelicula=r.nextInt();
		r.close();
		
		cine.modificarReserva(nuevo_id_reserva, fecha, cantidad, id_descuento, id_usuario, id_funcion, id_sala, id_pelicula, id_reserva_a_modificar);
	}
	
	public void verMisReservas() {
		cine.mostrarmisReservas(usuario.getUserid());
	}
	
	public void verHistoricoDeEntradas() {
		System.out.println("en construccion....");
	}
	
	public void verSalas() {
		cine.mostrarSalas();
	}
	
	public void verTodasLasReservas() {
		cine.verTodaslasReservas();
	}
	
	public void mostrarReservasPorCliente() {
		Scanner r=new Scanner(System.in);
		System.out.println("ingrese id de un cliente");
		int id_cliente=r.nextInt();
		r.close();
		cine.verReservaPorCliente(id_cliente);
	}
	public void crearSalaConPelicula() {
		Scanner r=new Scanner(System.in);
		
		int id_sala;
		int sala_cantidad;
		
		int id_pelicula;
		String nombre_pelicula;
		String sinopsis;
		int duracion;
		String director;
		
		System.out.println("ingrese un id para la nueva sala");
		id_sala=r.nextInt();
		System.out.println("ingrese la capacidad de la sala");
		sala_cantidad=r.nextInt();
		
		System.out.println("ingrese id para la pelicula");
		id_pelicula=r.nextInt();
		System.out.println("ingrese nombre de la pelicula");
		nombre_pelicula=r.nextLine();
		System.out.println("ingrese sinopsis de la pelicula");
		sinopsis=r.nextLine();
		System.out.println("ingrese la duracion en minutos");
		duracion=r.nextInt();
		System.out.println("ingrese el nombre del director");
		director=r.nextLine();
		r.close();
		
		cine.crearSala(id_sala, sala_cantidad);
		cine.crearPelicula(id_pelicula, nombre_pelicula, sinopsis, duracion, director);
	}
	
	public void modificarUnaSala() {
		Scanner r=new Scanner(System.in);
		
		int id_sala;
		int capacidad;
		int id_sala_modificar;
		
		System.out.println("ingrese id de sala a modificar");
		id_sala_modificar=r.nextInt();
		System.out.println("ingrese nuevo id de sala");
		id_sala=r.nextInt();
		System.out.println("ingrese nueva capacidad");
		capacidad=r.nextInt();
		r.close();
		
		cine.modificarSala(id_sala, capacidad, id_sala_modificar);
	}
	
	public void eliminarUnaSala() {
		Scanner r=new Scanner(System.in);
		
		int id_sala;
		System.out.println("ingrese el id de sala a eliminar");
		id_sala=r.nextInt();
		r.close();
		
		cine.eliminarSala(id_sala);
	}
	
	public void modificarDescuento() {
		Scanner r=new Scanner(System.in);
		
		int id_descuento_modificar;
		int id_descuento_nuevo;
		String nuevo_dia;
		float descuento;
		
		System.out.println("ingrese el id de descuento que quiere modificar");
		id_descuento_modificar=r.nextInt();
		System.out.println("ingrese nuevo id para el descuento");
		id_descuento_nuevo=r.nextInt();
		System.out.println("ingrese el dia para el descuento");
		nuevo_dia=r.nextLine();
		System.out.println("ingrese el valor del descuento");
		descuento=r.nextFloat();
		r.close();
		
		cine.modificarDescuento(id_descuento_nuevo, nuevo_dia, id_descuento_nuevo, id_descuento_modificar);
	}
	
}
