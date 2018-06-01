package model.dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.element.Element;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Groupe 4, Louka, Guillaume et Charlotte.
 * @version 1.0
 */
public final class LorannBDDConnector 
{

	   /** The login. */
		  private static String user = "root";
		  //OR Online database: user "root"
		  
		  /** The password. */
		  private static String password = "";
		  //OR Online database: password "password"
		
		  /** The url. */
		  private static String url = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";
		  //OR Online database: url http://151.80.46.117:8585/?server=db&username=root&db=lorann
		  
		  /**The result of the query. */
		  static ResultSet result = null; 
		  
		  /** The Connection. */
		  static Connection connection; 
		  
		  /** The Statement. */
		  static Statement statement;
		  
		  /** The representation of the map in a string, from the DB. */
		  static String mapstring;

		  /** Table of Elements that representing the map.*/
		  Element[][] table = null;
		  
		  /** The number of the lvl chosen by the User*/
		  private int n;
		
		  
		  
		/** The constructor.
		 * 
		 */ 
		public LorannBDDConnector() 
		{
			
			userchoice();
		}
		
		
		/* 
		 * Get the lvl choice of the User.
		 */
		 public void userchoice() 
		 {
	    	 System.out.println("Quel niveau voulez vous jouez?");
				Scanner sc = new Scanner(System.in);
		        String choice = sc.nextLine() ;
		     
				if (choice.contains("1")) {
					this.n = 1; 
				}
				else if (choice.contains("2")){
					this.n = 2;
				}
				else if (choice.contains("3")) {
					this.n = 3;
				}
				
				else if (choice.contains("4")) {
					this.n = 4;
				}
				else if (choice.contains("5")) {
					this.n = 5;
				}	
				
				else {
					System.out.println("Niveau choisit: 1");
					this.n = 1;
					}
	     }
		
		
		/*
		 * Connect to the DB
		 * and get the lvl.
		 */
		public String start()
		{
			userchoice(); 
			
	        try {
	        	connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String query = "CALL ChooseMap("+ this.n +")";
				result = statement.executeQuery(query);
			
				while(result.next()) {
				mapstring = result.getString("contenu");
			
				}
		        
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	         return mapstring;

		}
}

