import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;
public class Cinemar {
	
	private Credenciales cs;
	private Usuario u;
	
	public Cinemar() {
		cs=new Credenciales();
	}
	public void IniciarSesion(){
		String username;
		String password;
		String continuar;
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("username: ");
		username=entrada.nextLine();
		
		System.out.println("password: ");
		password=entrada.nextLine();
		
		if(existeUsuario(username, password)) {
			Menu();
			do {
				Menu();
				System.out.println("desea continuar? s/n");
				continuar=entrada.nextLine();
				
			}while(continuar.equals("y"));
			
		}else {
			System.out.println("el usuario no existe");
		}
	}

	public void Menu() {
		String valor;
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("#### MENU DE OPCIONES - INGRESE UN NUMERO ####");
		System.out.println("1) CREAR RESERVA"); //executequery
		System.out.println("2) MODIFICAR RESERVA");
		System.out.println("3) VER MIS RESERVAS");//executequery
		System.out.println("5) HISTORICO DE ENTRADAS");
		
		System.out.println("6) VER SALAS");//executequery
		
		System.out.println("7) VER TODAS LAS RESERVAS");//executequery
		System.out.println("8) VER RESERVA POR CLIENTE");//executequery
		System.out.println("9) CREAR SALA CON PELICULA");
		System.out.println("10) MODIFICAR UNA SALA");
		System.out.println("11) ELIMINAR UNA SALA");
		System.out.println("12) MODIFICAR DESCUENTO");
		
		valor=entrada.nextLine();
		
		switch(valor) {
		case "1":	System.out.println("se hace 1");
					break;
		case "2":	System.out.println("se hace 2");
					break;
		case "3":	System.out.println("se hace 3");
					break;
		case "4":	System.out.println("se hace 4");
					break;
		case "5":	System.out.println("se hace 5");
					break;
		case "6":	System.out.println("se hace 6");
					break;
		case "7":	System.out.println("se hace 7");
					break;
		case "8":	System.out.println("se hace 8");
					break;
		case "9":	System.out.println("se hace 9");
					break;
		case "10":	System.out.println("se hace 10");
					break;
		case "11":	System.out.println("se hace 11");
					break;
		case "12":	System.out.println("se hace 12");
					break;
		
		default: 	System.out.println("debe ingresar una opcion valida");
					break;
		}
		
		
	}
	//USUARIO
	// existe usuario devuelve true si el usuario ya existe en la BDD
	public boolean existeUsuario(String usuario,String contraseña) {
		Connection conn=null;
		Statement stmt=null;
		boolean respuesta=false;
		try {
			//PASO 2: Registrar JDBC driver
			Class.forName(cs.JDBDC_DRIVER);
			//PASO 3: Abrir una Conexion
			System.out.println("Conectando con la base de datos...");
			conn=DriverManager.getConnection(cs.DB_URL,cs.USER,cs.PASS);
			//PASO 4: Ejecutar una consulta SQL
			System.out.println("Creando el estado...");
			stmt=conn.createStatement();
			String sql;
			//sql="SELECT * from usuarios";
			sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir por tipo de columna
				String username=rs.getString("username");
				String password=rs.getString("password");
				System.out.println("usuario: "+username);
				System.out.println("contraseña: "+password);
				if(username.equals(usuario) && password.equals(contraseña)) {
					respuesta=true;
				}
				//Mostrar valores
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// Resolver errores para JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Resolver errores para Class.forName
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		System.out.println("Adios!..");
		return respuesta;
	}
	
	
	public void RegistrarUsuario(Usuario usuario) {
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//PASO 2: Registrar JDBC driver
			Class.forName(cs.JDBDC_DRIVER);
			//PASO 3: Abrir una Conexion
			System.out.println("Conectando con la base de datos...");
			conn=DriverManager.getConnection(cs.DB_URL,cs.USER,cs.PASS);
			//PASO 4: Ejecutar una consulta SQL
			System.out.println("Creando el estado...");
			stmt=conn.createStatement();
			String sql;
			sql="INSERT INTO usuarios VALUES('"+usuario.getUserid()+"','"+usuario.getRol_usuario()+"','"+usuario.getUsername()+
					"','"+usuario.getPassword()+"','"+usuario.getEmail()+"','"+usuario.getFecha_nacimiento()+"','"+usuario.getTelefono()+"','"+usuario.getFecha_alta()+"')";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			/*while(rs.next()) {
				//Recibir por tipo de columna
				String username=rs.getString("username");
				String password=rs.getString("password");
				System.out.println("usuario: "+username);
				System.out.println("contraseña: "+password);
				if(username.equals(usuario) && password.equals(contraseña)) {
					respuesta=true;
				}
				//Mostrar valores
			}*/
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// Resolver errores para JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Resolver errores para Class.forName
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		System.out.println("Adios!..");
	}
	
	public Usuario dameUsuario(String user, String pass) {
		Usuario usuario=new Usuario();
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//PASO 2: Registrar JDBC driver
			Class.forName(cs.JDBDC_DRIVER);
			//PASO 3: Abrir una Conexion
			System.out.println("Conectando con la base de datos...");
			conn=DriverManager.getConnection(cs.DB_URL,cs.USER,cs.PASS);
			//PASO 4: Ejecutar una consulta SQL
			System.out.println("Creando el estado...");
			stmt=conn.createStatement();
			String sql;
			
			sql="SELECT id_usuario, rol, username, password,email,fecha_nacimiento,telefono,fecha_registro FROM"
					+ " usuarios WHERE username= '"+user+"' and password= '"+pass+"';";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int user_id=rs.getInt("id_usuario");
				String rol=rs.getString("rol");
				String nombre_usuario=rs.getString("username");
				String password_usuario=rs.getString("password");
				String email_usuario=rs.getString("email");
				java.util.Date fecha_nacimiento=rs.getTimestamp("fecha_nacimiento");
				int telefono_usuario=rs.getInt("telefono");
				java.util.Date fecha_registro=rs.getTimestamp("fecha_registro");
				
				
				//usuario=new Usuario(user_id,nombre_usuario,password_usuario,rol,email_usuario,telefono_usuario);
				usuario.setUserid(user_id);
				usuario.setRol_usuario(rol);
				usuario.setUsername(nombre_usuario);
				usuario.setPassword(password_usuario);
				usuario.setEmail(email_usuario);
				usuario.setTelefono(telefono_usuario);
				
				usuario.setFecha_nacimiento(fecha_nacimiento);
				usuario.setFecha_alta(fecha_registro);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// Resolver errores para JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Resolver errores para Class.forName
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		System.out.println("Adios!..");

		
		return usuario;
	}
	
	public void mostrarFunciones() {
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			//PASO 2: Registrar JDBC driver
			Class.forName(cs.JDBDC_DRIVER);
			//PASO 3: Abrir una Conexion
			System.out.println("Conectando con la base de datos...");
			conn=DriverManager.getConnection(cs.DB_URL,cs.USER,cs.PASS);
			//PASO 4: Ejecutar una consulta SQL
			System.out.println("Creando el estado...");
			stmt=conn.createStatement();
			String sql;
			
			sql="SELECT id_funcion,fecha,salas_id_sala,peliculas_id_pelicula,nombre FROM funciones "
					+ "INNER JOIN peliculas on peliculas_id_pelicula = id_pelicula WHERE fecha <= curdate();";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_funcion=rs.getInt("id_funcion");
				Date fecha=rs.getDate("fecha");
				int id_sala=rs.getInt("salas_id_sala");
				String pelicula=rs.getString("nombre");
				
				//Mostrar valores
				System.out.println("id de funcion: "+id_funcion);
				System.out.println("fecha de la funcion: "+fecha);
				System.out.println("en sala: "+id_sala);
				System.out.println("pelicula numero: "+pelicula);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// Resolver errores para JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Resolver errores para Class.forName
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		System.out.println("Adios!..");
	}
	public void CrearReserva(Usuario u) {
		//necesito usuario, funcion
		
	}

}
