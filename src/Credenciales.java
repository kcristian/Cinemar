
public class Credenciales {
	
	
	public String JDBDC_DRIVER;
	public String DB_URL;
	//CREDENCIALES
	public String USER;
	public String PASS;
	public String path_log4_properties;
	
	//CONSTRUCTOR
	public Credenciales() {
		this.JDBDC_DRIVER="com.mysql.cj.jdbc.Driver";
		this.DB_URL="jdbc:mysql://localhost:3306/cinemar_v1";
		this.USER="root";
		this.PASS="cristian89";
		this.path_log4_properties="C:\\Users\\INTEL\\Documents\\eclipse-workspace\\cinemar1\\to\\log4j.properties";
	}
	
}
