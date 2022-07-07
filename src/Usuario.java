import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Usuario{

	private int userid;
	private Rol rol_usuario;
	private String username;
	private String password;
	private String email;
	private Date fecha_nacimiento;
	private int telefono;
	private Date fecha_alta;
	
	public Usuario(int user_id,String nombre,String password,String rs,String email,int telefono,Date fecha_nac) {
		super();
		this.username=nombre;
		this.password=password;
		try {
			this.rol_usuario=Rol.valueOf(rs.toUpperCase());
		} catch (Exception e) {
			System.out.println("debe ingresar un rol valido");
		}
		this.fecha_alta=new Date();
		this.email=email;
		this.userid=user_id;
		this.telefono=telefono;
		this.fecha_nacimiento=fecha_nac;
	}
	
	public Usuario() {
		
	}
	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public Date getFecha_alta() {
		return fecha_alta;
	}


	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
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

	public void setRol_usuario(String rol_usuario) {
		try {
			this.rol_usuario=Rol.valueOf(rol_usuario.toUpperCase());
		} catch (Exception e) {
			System.out.println("debe ingresar un rol valido");
		}
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String toString() {
		final String NEW_FORMAT="yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
		
		return "id: "+ getUserid() + " rol: " +getRol_usuario() + " username: " +
				getUsername() + " password: " + getPassword() + " email: " + getEmail() + " fecha de alta: " + sdf.format(fecha_alta);
		
	}
	
	
}
