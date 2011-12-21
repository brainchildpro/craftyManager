/**
 * 
 */
package components;

import java.sql.Connection;
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
		DBlink.main("SELECT * FROM  `template` ORDER BY  `id` ASC ");
		
		if(Debug){System.out.println("[Main Ended]");}
		
	}

}


