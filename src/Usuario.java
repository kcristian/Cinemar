import java.time.*;

public class Usuario{

	private int userid;
	private Rol rol_usuario;
	private String username;
	private String password;
	private LocalDate fecha_alta;
	public static int id_siguiente=1;
	
	public Usuario(String nombre,String password,String rs) {
		
		this.username=nombre;
		this.password=password;
		this.rol_usuario=Rol.valueOf(rs);
		this.fecha_alta=LocalDate.now();
		this.userid=id_siguiente;
		this.id_siguiente++;
	}
	
	
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public LocalDate getFecha_alta() {
		return fecha_alta;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String nombre) {
		this.username = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol_usuario() {
		return rol_usuario;
	}

	public void setRol_usuario(Rol rol_usuario) {
		this.rol_usuario = rol_usuario;
	}
	public void mostrarDatos() {
		
		System.out.println("user Id: "+this.userid);
		System.out.println("username: "+this.username);
		System.out.println("password: "+this.password);
		System.out.println("rol: "+this.rol_usuario);
		System.out.println("fecha de alta: "+ this.fecha_alta);
	}
}
