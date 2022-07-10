import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
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
		
		final String NEW_FORMAT="yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
		String fecha_nacimiento=sdf.format(usuario.getFecha_nacimiento());
		String fecha_de_registro=sdf.format(usuario.getFecha_alta());
		
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
					"','"+usuario.getPassword()+"','"+usuario.getEmail()+"','"+fecha_nacimiento+"','"+usuario.getTelefono()+"','"+fecha_de_registro+"')";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
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
	
	//CLIENTE
	public void CrearReserva(int id_reserva,String fecha,int cantidad,int id_descuento,int id_usuario,int id_funcion,int id_sala,int id_pelicula) {
		//tiene que ser una sala que tenga funcion
			
		//  Registrar JDBC Driver
			
				
				 Connection conn = null;
				 Statement stmt = null;
				 
				 try{
				 //PASO 2: Registrar JDBC driver
				 Class.forName(cs.JDBDC_DRIVER);
				 
				 //PASO3: Abrir una Conexion
				 System.out.println("Connecting to database...");
				 conn = DriverManager.getConnection(cs.DB_URL,cs.USER,cs.PASS);
				 
				 //PASO 4: Ejecutar una consulta SQL
				 System.out.println("Creating statement...");
				 stmt = conn.createStatement();
				 //String sql =  MessageFormat.format("INSERT INTO Usuarios (usuario, clave, administrador) VALUES ({0}, {1}, {2});", nombre, clave, is_admin);
				 String sql = "insert into reservas values("+id_reserva+",'"+fecha+"',"+cantidad+","+id_descuento+","+id_usuario+","+id_funcion+","+id_sala+","+id_pelicula+")";
				 stmt.executeUpdate(sql);
				 System.out.println("Valores Insertados con Exito en tabla reservas");
				 
				 
				 //PASO6: Entorno de Limpieza
				 stmt.close();
				 conn.close();
				 }catch(SQLException se){
					 // Resolver errores para JDBC
					 se.printStackTrace();
				 }catch(Exception e){
					 // Resolver errores para Class.forName
					 e.printStackTrace();
				 }finally{
				 // Bloque finalmente utilizado para cerrar recursos
				 try{
					 if(stmt!=null)
						 stmt.close();
				 }catch(SQLException se2){
				 }// Nada que podamos hacer
				 try{
					 if(conn!=null)
						 conn.close();
				 }catch(SQLException se){
				 se.printStackTrace();
				 	} //cierra finally try
				 } //cierra try
				 System.out.println("Goodbye!");
	}

	public boolean existeReserva(int id_de_reserva) {
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
			sql="SELECT id_reserva FROM reservas WHERE id_reserva= '"+id_de_reserva+"';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir por tipo de columna
				int numero_reserva=rs.getInt("id_reserva");
				
				System.out.println("id_reserva: "+numero_reserva);
				
				if(id_de_reserva==numero_reserva) {
					respuesta=true;
				}
				
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
	
	public void modificarReserva(int id_reserva, String fecha, int cantidad, int descuento, int id_usuario,int id_funcion,int id_sala, int id_pelicula,int id_res_modificar) {
		
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
			
			sql="update reservas set id_reserva='"+id_reserva+"', fecha='"+fecha+"',cantidad='"+cantidad+"',descuento='"+descuento+"',usuarios_id_usuario='"+id_usuario+"',"
					+ "funciones_id_funcion='"+id_funcion+"',funciones_salas_id_sala='"+id_sala+"',funciones_peliculas_id_pelicula='"+id_pelicula+"' where id_reserva="+id_res_modificar+"; ";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
			
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
	public Funcion dameFuncion(int id_funcion) {
		
		Funcion f=new Funcion();
				
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
			System.out.println("se buscara la funcion");
			sql= "SELECT id_funcion,fecha,salas_id_sala,peliculas_id_pelicula FROM funciones WHERE id_funcion="+id_funcion+";";
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				//capturando datos de funcion
				int id_de_funcion=rs.getInt("id_funcion");
				Date fecha_funcion=rs.getDate("fecha");
				int id_de_sala=rs.getInt("salas_id_sala");
				int id_de_pelicula=rs.getInt("peliculas_id_pelicula");
				
				f.setId_funcion(id_de_funcion);
				f.setFecha(fecha_funcion);
				System.out.println("buscando sala..");
				f.setSala_funcion(dameSala(id_de_sala));
				System.out.println("buscando pelicula");
				f.setPelicula(damePelicula(id_de_pelicula));
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
		
		return f;
	}
	
	public void mostrarmisReservas(int id_de_usuario) {
		
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
			
			sql="select id_reserva, fecha, cantidad,username,email,telefono,id_usuario from usuarios "
					+ "inner join reservas on id_usuario=usuarios_id_usuario where usuarios.id_usuario='"+id_de_usuario+"';";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_reserva=rs.getInt("id_reserva");
				Date fecha = rs.getDate("fecha");
				int cantidad = rs.getInt("cantidad");
				String nombre_usuario=rs.getString("username");
				String email_usuario=rs.getString("email");
				int telefono_usuario=rs.getInt("telefono");
				int id_usuario=rs.getInt("id_usuario");
				
				//Mostrar valores
				System.out.println("id de reserva: "+id_reserva);
				System.out.println("fecha de reserva: "+fecha);
				System.out.println("precio de reserva: "+cantidad);
				System.out.println("nombre de usuario: "+nombre_usuario);
				System.out.println("email de usuario: "+email_usuario);
				System.out.println("telefono de usuario: "+telefono_usuario);
				System.out.println("id de usuario: "+id_usuario);
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
	
	public Pelicula damePelicula (int id_pelicula) {
		Pelicula pelicula = new Pelicula();
		Connection conn=null;
		Statement stmt=null;
		System.out.println("se buscara pelicula");
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
			
			sql= "SELECT id_pelicula, nombre,sinopsis, duracion,  director,reparto FROM peliculas WHERE id_pelicula = '"+id_pelicula+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_peli = rs.getInt("id_pelicula");
				String nombre_pelicula = rs.getString("nombre");
				String sinop_pelicula = rs.getString("sinopsis");
				int duracion_peli=rs.getInt("duracion");
				String direct_pelicula = rs.getString("director");
				int id_reparto=rs.getInt("reparto");
				
				
				pelicula.setNum_pelicula(id_peli);
				pelicula.setNombre(nombre_pelicula);
				pelicula.setSinopsis(sinop_pelicula);
				pelicula.setDuracion(duracion_peli);
				pelicula.setDirector(direct_pelicula);
				
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
		System.out.println("se buscara generos");
		pelicula.setGeneros(dameGenero(id_pelicula));
		System.out.println("se buscara actores del reparto");
		pelicula.setReparto(dameActores(id_pelicula));
		System.out.println("se buscara clasificacion");
		pelicula.setClasificacion(dameClasificacion(id_pelicula));
		System.out.println("se buscara tipos de pelicula");
		pelicula.setTipos(dameTiposPelicula(id_pelicula));
		
		return pelicula;
	}
	public ArrayList<TipoPelicula> dameTiposPelicula(int id_pelicula){
		ArrayList<TipoPelicula> tipos = new ArrayList<>();
		TipoPelicula tp=new TipoPelicula();
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
			
			sql= "select id_tipo, formato, idioma, subtitulos,peliculas_id_pelicula from tipo_peliculas where peliculas_id_pelicula="+id_pelicula+";";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int numero_tipo_peli = rs.getInt("id_tipo");
				String formato_tipo_peli = rs.getString("formato");
				String idioma_tipo_peli = rs.getString("idioma");
				String sub_tipo_peli = rs.getString("subtitulos");
				int id_de_pelicula =rs.getInt("peliculas_id_pelicula");
				
				tipos.add(new TipoPelicula(numero_tipo_peli,formato_tipo_peli,idioma_tipo_peli,sub_tipo_peli));
				
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
		
		return tipos;
	}
	
	
	public Clasificacion dameClasificacion(int id_pelicula) {
		Clasificacion clasificacion = new Clasificacion();
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
			
			sql= "SELECT id_clasificacion, identificador,descripcion, peliculas_id_pelicula FROM clasificacion_peliculas WHERE peliculas_id_pelicula = '"+id_pelicula+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_clasifc= rs.getInt("id_clasificacion");
				String identif_clasif = rs.getString("identificador");
				String desc_clasif = rs.getString("descripcion");
				int pel_id_pelicula = rs.getInt("peliculas_id_pelicula");
				
				clasificacion.setNumero_clasificacion(id_clasifc);
				clasificacion.setIdentificador(identif_clasif);
				clasificacion.setDescripcion(desc_clasif);
				
				
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

		
		return clasificacion;
	}
	
	public ArrayList<Genero> dameGenero(int id_de_pelicula){
		ArrayList<Genero> generos= new ArrayList<>();
		Genero g= new Genero();
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
			
			sql= "SELECT id_genero_pelicula, genero_peliculas.nombre,id_pelicula FROM genero_peliculas INNER JOIN peliculas WHERE id_pelicula = '"+id_de_pelicula+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int numero_genero = rs.getInt("id_genero_pelicula");
				String nombre_genero = rs.getString("genero_peliculas.nombre");
				
				//g.setNumero_genero(numero_genero);
				//g.setNombre(nombre_genero);
				generos.add(new Genero(numero_genero, nombre_genero));
				
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

		
		return generos;
	}
	
	public ArrayList<String> dameActores(int id_de_pelicula){
		ArrayList<String> actores= new ArrayList<>();
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
			sql="select  actores.nombre, actores.apellido from actores inner join reparto inner join peliculas on peliculas.reparto = reparto.id_reparto where id_pelicula='"+ id_de_pelicula+"' ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String resultado1 = rs.getString("actores.nombre");
				String resultado2 = rs.getString("apellido");
				actores.add(new String(resultado1 + " " + resultado2));
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
		return actores;
	}
	
	public void mostrarSalas() {
		
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
			
			//sql="SELECT id_sala,capacidad FROM salas  WHERE id_sala = '"+id_sala+"'";
			//sql="SELECT id_sala, capacidad,identificador FROM salas INNER JOIN formato_salas WHERE id_sala='"+id_sala+"'";
			//sql="SELECT id_sala,formato_salas_id_formato,identificador from salas inner join salas_tienen_formato_salas inner join formato_salas on id_sala=salas_id_sala and formato_salas_id_formato=id_formato order by id_sala;\r\n""
			sql= "select id_sala,capacidad,formato_salas_id_formato,identificador,descripcion,precio "
					+ "from salas inner join salas_tienen_formato_salas inner join formato_salas on id_sala=salas_id_sala "
					+ "and formato_salas_id_formato=id_formato ORDER BY id_sala";

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_sal=rs.getInt("id_sala");
				int capacidad_sala=rs.getInt("capacidad");
				//int formato_sala=rs.getInt("formato_salas_id_formato");
				String identif=rs.getString("identificador");
				String descripcion_sala=rs.getString("descripcion");
				float precio=rs.getFloat("precio");
				
				
				//Mostrar valores
				System.out.println("Sala: "+id_sal);
				System.out.println("Capacidad: "+capacidad_sala);
				System.out.println("Formato: "+identif);
				System.out.println("Descripcion: "+descripcion_sala);
				System.out.println("Precio: "+precio);
				System.out.println();
				
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
	
	public Sala dameSala(int id_sala) {
		Sala s=new Sala();
		
		Connection conn=null;
		Statement stmt=null;
		System.out.println("se buscara pelicula");
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
			
			sql= "select id_sala,capacidad,identificador from salas inner join salas_tienen_formato_salas inner join formato_salas \r\n"
					+ "on salas.id_sala=salas_tienen_formato_salas.salas_id_sala and salas_tienen_formato_salas.formato_salas_id_formato=formato_salas.id_formato where salas.id_sala="+id_sala+" ;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_de_sala=rs.getInt("id_sala");
				int capacidad=rs.getInt("capacidad");
				String identificador=rs.getString("identificador");
				
				s.setNum_sala(id_de_sala);
				s.setCapacidad(capacidad);
				s.getFormato_de_sala().add(identificador);
				//*?											
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
		System.out.println("se buscara asientos");
		s.setAsientos(dameButacas(id_sala));
		
		return s;
	}
	public ArrayList<Butaca> dameButacas(int id_sala){
		ArrayList<Butaca> las_butacas=new ArrayList<>();
		
		Connection conn=null;
		Statement stmt=null;
		System.out.println("se buscaran las butacas");
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
			
			sql= "SELECT id_butaca,identificador,estado FROM butacas WHERE salas_id_sala="+id_sala+";";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_de_butaca=rs.getInt("id_butaca");
				String identificador=rs.getString("identificador");
				boolean estado=rs.getBoolean("estado");
				Butaca b=new Butaca();
				b.setNum_butaca(id_de_butaca);
				b.setIdentificador(identificador);
				b.setEstado(estado);
				las_butacas.add(b);
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
		
		return las_butacas;
	}
	//ADMINISTRACION
	
	public void verTodaslasReservas() {
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
			
			sql="select id_reserva, fecha_reserva,id_usuario,username,id_funcion,fecha_funcion,peliculas_id_pelicula,nombre,numero_de_sala,cantidad,precio\r\n"
					+ "from vista_reservas_1 inner join vista_salas_1 on salas_id_sala=numero_de_sala;";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_reserva=rs.getInt("id_reserva");
				Date fecha_reserva=rs.getDate("fecha_reserva");
				int id_usuario=rs.getInt("id_usuario");
				String username = rs.getString("username");
				int id_funcion=rs.getInt("id_funcion");
				Date fecha_funcion=rs.getDate("fecha_funcion");
				//int salas_id_sala=rs.getInt("salas_id_sala");
				int peliculas_id_pelicula=rs.getInt("peliculas_id_pelicula");
				String nombre=rs.getString("nombre");
				int numero_de_sala=rs.getInt("numero_de_sala");
				int cantidad = rs.getInt("cantidad");
				float precio=rs.getFloat("precio");
		
				
				//Mostrar valores
				System.out.println("id de reserva: "+id_reserva);
				System.out.println("fecha de reserva: "+fecha_reserva);
				System.out.println("id de usuario: "+id_usuario);
				System.out.println("username: "+username);
				System.out.println("id de funcion: "+id_funcion);
				System.out.println("fecha de la funcion: "+fecha_funcion);
//				System.out.println("Nº de sala: "+salas_id_sala);
				System.out.println("Nº de pelicula: "+peliculas_id_pelicula);
				System.out.println("nombre de pelicula: "+nombre);
				System.out.println("Nº de sala: "+numero_de_sala);
				System.out.println("cantidad: "+cantidad);
				System.out.println("precio unitario: "+precio);
				System.out.println("");
				
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
	
	public void verRecervaPorCliente (int id_usuario) {
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
			
			sql= "SELECT id_reserva, reservas.fecha, id_usuario,username,id_funcion,funciones.fecha,"
					+ "salas_id_sala,peliculas_id_pelicula,peliculas.nombre,cantidad FROM reservas inner join usuarios "
					+ "inner join funciones inner join salas inner join peliculas on usuarios_id_usuario=usuarios.id_usuario "
					+ "AND funciones_id_funcion=funciones.id_funcion and funciones_salas_id_sala=salas.id_sala "
					+ "AND funciones_peliculas_id_pelicula=peliculas.id_pelicula WHERE id_usuario='"+id_usuario+"' ";
											
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id_reserv=rs.getInt("id_reserva");
				Date fecha_reserv=rs.getDate("reservas.fecha");
				int id_usser=rs.getInt("id_usuario");
				String usser=rs.getString("username");
				int id_func=rs.getInt("id_funcion");
				String fecha_func=rs.getString("funciones.fecha");
				int sal_id_sal=rs.getInt("salas_id_sala");
				int id_pel_pel=rs.getInt("peliculas_id_pelicula");
				String nom_peliculas=rs.getString("nombre");
				int cant_reserv=rs.getInt("cantidad");
				
				
				//Mostrar valores
				System.out.println("ID de reserva: "+id_reserv);
				System.out.println("Fecha de reserva: "+fecha_reserv);
				System.out.println("ID cliente: "+id_usser);
				System.out.println("Cliente: "+usser);
				System.out.println("ID funcion: "+id_func);
				System.out.println("Fecha de funcion: "+fecha_func);
				System.out.println("ID de sala: "+sal_id_sal);
				System.out.println("ID de pelicula: "+id_pel_pel);
				System.out.println("Pelicula: "+nom_peliculas);
				System.out.println("Cantidad de reserva: "+cant_reserv);
				System.out.println();
				
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
	
	// inicio
	public void crearSala(int id_sala,int capacidad) {
		
	}
	public void crearFormatoSala(int id_formato,String identificador,String descripcion,float precio) {
		
	}
	public void crearButaca(int id_butaca,int id_sala){
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
			sql="INSERT INTO butacas(id_butaca,salas_id_sala) VALUES("+id_butaca+","+id_sala+");";
			
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("se inserto una butaca");
			
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
	
	public void reservarButaca(int id_sala) {
		
		
	}
	public void crearPelicula(int id_pelicula,String nombre_pelicula,String sinopsis,int duracion,String director) {
		
	}
	
	
	//fin
	public void modificarSala(int id_sala, int capacidad) {
		
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
			
			//sql="SELECT id_sala, capacidad FROM salas WHERE id_sala= '"+id_sala+"';";
			//ResultSet rs = stmt.executeQuery(sql);
			
			//sql="insert into reservas values ("+id_sala+"',"+capacidad+")';";
			//var sql = "UPDATE customers SET address = 'Canyon 123' WHERE address = 'Valley 345'";
			//UPDATE salas SET id_sala='7', capacidad='690' WHERE id_sala='6';
			//sql="UPDATE salas SET id_sala='"+id_sala+"', capacidad='"+ capacidad+"' WHERE id_sala='"+id_sala+"';";
			//sql="UPDATE salas SET ID_sala='"+ID_sala+"', capacidad='"+ capacidad+"' WHERE id_sala='"+id_sala+"';";
			//sql="SELECT id_sala, capacidad FROM salas WHERE id_sala= '"+id_sala+"';";
			sql="UPDATE salas SET capacidad='"+ capacidad+"' WHERE id_sala='"+id_sala+"';";
			stmt.executeUpdate(sql);
			
			
		
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

	public void eliminarSala(int id_sala) {

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
			
			
			sql="DELETE FROM salas  WHERE id_sala= '"+id_sala+"';";
			stmt.executeUpdate(sql);
			
			
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
	
	public void modificarDescuento(int id_descuento_nuevo,String dia_de_descuento,float descuento_nuevo,int id_descuento_modificar) {
		
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
			
			sql="update descuentos set id_descuento='"+id_descuento_nuevo+"',dia='"+dia_de_descuento+"',descuento="+descuento_nuevo+" where id_descuento="+id_descuento_modificar+";";
			stmt.executeUpdate(sql);
			
			System.out.println("se modifico el descuento");
		
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
	
	public void mostrarDescuentos() {
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
			
			sql="select * from descuentos;";
			//sql="SELECT username, password FROM usuarios WHERE username = '"+usuario+"' AND password = '"+contraseña+"'; ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Recibir datos funciones y nombre de pelicula
				int id_descuento=rs.getInt("id_descuento");
				String dia = rs.getString("dia");
				float descuento=rs.getFloat("descuento");
				
				//Mostrar valores
				System.out.println("id de descuento: "+id_descuento);
				System.out.println("dia que se aplica el descuento: "+dia);
				System.out.println("valor del descuento: "+descuento);
				System.out.println();
				
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


	
}
