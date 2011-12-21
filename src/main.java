/**
 * 
 */


import java.sql.Connection;
import java.util.ArrayList;
//import java.sql.DriverManager;
//import java.sql.SQLException;
/**
 * @author James
 *
 */


public class Main {
	static boolean Debug = true;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(Debug){System.out.println("[Main Started]");}
		connection DBlink = new connection();
		
		ArrayList<YamlProperty> A = DBlink.doQuery("SELECT * FROM  `template` ORDER BY  `id` ASC ");
		if(Debug){System.out.println("[Main Ended]");}
		
	}

}


