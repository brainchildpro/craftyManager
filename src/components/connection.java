package components;

import java.sql.*;
import java.util.ArrayList;
import components.YamlProperty;
public class connection
{
  static Connection conn;
  //set debug mode
  public static boolean Debug = true;
  

  public static ArrayList<YamlProperty> main(String args)
  {
	  ArrayList<YamlProperty> W = new ArrayList<YamlProperty>();
	  try
	    {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      if(Debug ){System.out.println("[SQL Driver Loaded]");}
	      
	      conn =DriverManager.getConnection("jdbc:mysql://localhost:8889/perfectServer","root","root");
	     
	      W = doQuery(args);
	      conn.close();
	      
	    }
	    catch (ClassNotFoundException ex) {if(Debug){System.out.println("[SQL Connection Error]");};System.err.println(ex.getMessage());}
	    catch (IllegalAccessException ex) {if(Debug){System.out.println("[SQL Connection Error]");};System.err.println(ex.getMessage());}
	    catch (InstantiationException ex) {if(Debug){System.out.println("[SQL Connection Error]");};System.err.println(ex.getMessage());}
	    catch (SQLException ex)           {if(Debug){System.out.println("[SQL Connection Error]");};System.err.println(ex.getMessage());}
	  return W;
	
  }
 
  /*private static int count(String query)
  {
	  int x = 0;
	  if(Debug){System.out.println("[Count Loaded]");}
	  try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      if(Debug){System.out.println("[Counting]");}
	      
	      while (rs.next())
	      {
	        x++;
	      } 
	    }
	    catch (SQLException ex)
	    {
	    System.out.println("\n[FAIL] ... ");
	      System.err.println(ex.getMessage());
	    }
	  if(Debug){System.out.println("[Counted: " + x+"]");}
   return x;
  } */

  private static ArrayList<YamlProperty> doQuery(String query)
  {
	if(Debug){System.out.println("[OUTPUT FROM SELECT]"); System.out.println("[" + query + "]");}
    //String query = "SELECT * FROM  `template` ORDER BY  `id` ASC ";
	ArrayList<YamlProperty> Y = new ArrayList<YamlProperty>();
    try
    {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      if(Debug){System.out.println("[doQuery Try]");}
      
      while (rs.next())
      {
    	
    	
    	YamlProperty Z = new YamlProperty();
    	Z.Property = rs.getString("property");
    	Z.Value = rs.getString("value");
    	Z.Comment = rs.getBoolean("comment");
    	Z.Seperator = rs.getString("Seperator");
    	
    	Y.add(Z);
        
      } 
      if(Debug){System.out.println("[doQuery End]");}
    }
    catch (SQLException ex)
    {
    System.out.println("\n[FAIL] ... ");
      System.err.println(ex.getMessage());
    }
   
    return Y;
  }

  private void doInsertTest()
  {
    System.out.print("\n[Performing INSERT] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("INSERT INTO COFFEES " +
                       "VALUES ('BREAKFAST BLEND', 200, 7.99, 0, 0)");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
  
  private void doRandomTest(String text)
  {
    System.out.print("\n[" + text +"] ... ");
    
  }
  private void doUpdateTest()
  {
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void doDeleteTest()
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
}