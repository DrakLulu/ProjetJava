package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.element.Element;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Groupe 4, Louka, Guillaume et Charlotte.
 * @version 1.0
 */
final class LorannBDDConnector {

	   /** The login. */
		  private static String user = "root";
		  //OR Online database user "root"
		  
		  /** The password. */
		  private static String password = "";
		  //OR Online database password "password"
		
		  /** The url. */
		  private static String url = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";
		  //OR Online database url http://151.80.46.117:8585/?server=db&username=root&db=lorann
		  
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
		public LorannBDDConnector() {
			
			userchoice();
		}
		
		
		/* 
		 * Get the lvl choice of the User.
		 */
		 public void userchoice() {
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
		public String start(int n){
			this.n = n; 
			
	        try {
	        	connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String query = "CALL ChooseMap( "+ this.n +" )";
				result = statement.executeQuery(query);
			
				while(result.next()) {
				mapstring = result.getString("contenu");
			
				}
		        
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	         return mapstring;
		}
    
    
    
    
    
    
    /*
     * Instantiates a new Lorann BDD connector.
     */
    /*private LorannBDDConnector() {
        this.open();
    }

    /*
     * Gets the single instance of BoulderDashBDDConnector.
     *
     * @return single instance of BoulderDashBDDConnector
     */
   /* public static LorannBDDConnector getInstance() {
        if (instance == null) {
            setInstance(new LorannBDDConnector());
        }
        return instance;
    }

    /*
     * Sets the instance.
     *
     * @param instance
     *            the new instance
     */
    /*private static void setInstance(final LorannBDDConnector instance) {
        LorannBDDConnector.instance = instance;
    }

    /*
     * Open.
     *
     * @return true, if successful
     */
    /*private boolean open() {
        try {
            this.connection = DriverManager.getConnection(LorannBDDConnector.url, LorannBDDConnector.user,
                    LorannBDDConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /*
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
  /*  public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
     */
    /*public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
   /* public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * Gets the connection.
     *
     * @return the connection
     */
  /*  public Connection getConnection() {
        return this.connection;
    }

    /*
     * Sets the connection.
     *
     * @param connection
     *            the new connection
     */
   /* public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /*
     * Gets the statement.
     *
     * @return the statement
     */
  /*  public Statement getStatement() {
        return this.statement;
    }

    /*
     * Sets the statement.
     *
     * @param statement
     *            the new statement
     */
   /* public void setStatement(final Statement statement) {
        this.statement = statement;
    }
    ***/
    
    
    

}
