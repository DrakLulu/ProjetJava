package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.IDAOConnector;
import model.element.Element;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 * 
 */
public class DAOConnector implements IDAOConnector{
	
      /** The login. */
	  private static String user = "root";
	    
	  /** The password. */
	  private static String password = "";
	 
	  /** The url. */
	  private static String url = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";
	  
	  	static ResultSet result = null; 
		static Connection connection; 
		static Statement statement;
		static String mapstring;

		Element[][] table = null; 

		private int currentLevel;
	
	public DAOConnector() {
		userchoice();
	}
	/*
	 * Connect to the DB and get the lvl.
	 */
	 
	public String start(){

		
        try {
        	connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			String query = "CALL ChooseMap("+ this.currentLevel +")";
			result = statement.executeQuery(query);
		
			while(result.next()) {
			mapstring = result.getString("contenu");
			//System.out.println(mapstring +" \n");
			}
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
         return mapstring;
	}

	/**
	 * This method allow the player to choose the level he wants to play. Between 1 and 5.
	 * 
	 */
	 public void userchoice() 
	 {
    	 System.out.println("Which level would you like to play?");
			Scanner sc = new Scanner(System.in);
	        String choice = sc.nextLine() ;
	     
			if (choice.contains("1")) {
				this.currentLevel = 1; 
			}
			else if (choice.contains("2")){
				this.currentLevel = 2;
			}
			else if (choice.contains("3")) {
				this.currentLevel = 3;
			}
			
			else if (choice.contains("4")) {
				this.currentLevel = 4;
			}
			else if (choice.contains("5")) {
				this.currentLevel = 5;
			}	
			
			else {
				System.out.println("Choosen One"); // what a joke. 
				this.currentLevel = 1;
				}
			sc.close();
     }
	
}