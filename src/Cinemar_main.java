
public class Cinemar_main {

	public static void main(String[] args) {
		//Datos de usuario de prueba
		String username="Cristian9";
		String password="1234425";
		String rol="ADMINISTRACION";
		Usuario u1=new Usuario(username,password,rol);
		Usuario u2=new Usuario(username,password,rol);
		Usuario u3=new Usuario(username,password,rol);
		u1.mostrarDatos();
		u2.mostrarDatos();
		u3.mostrarDatos();
	}

}
