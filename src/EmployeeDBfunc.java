import java.sql.*;

public class EmployeeDBfunc {
	//MySQL default DB URL
	static final String DBURL = "jdbc:mysql://localhost/";
	//Company database URL
	static final String CDBURL = "jdbc:mysql://localhost/CompanyDB";
	
	/**create a database called CompanyDB**/
	public static void CreateDB(String Username, String Password) {
		Connection Connt = null;
		Statement Statemt =  null;
		try {
			//register JDBC driver
			System.out.println("Registering driver...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//connect to DB
			System.out.println("Connecting to database...");
			Connt =  DriverManager.getConnection
					(DBURL,Username,Password);
			
			System.out.println("Creating new database...");
			Statemt = Connt.createStatement();
			//create DB syntax
			String createDBsql = "CREATE DATABASE [IF NOT EXISTS] CompanyDB";
			
			//execute the query
			Statemt.executeUpdate(createDBsql);
			System.out.println("Created new database CompanyDB");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			try{
				if(Statemt!=null){
					Connt.close();
				}
			}catch(SQLException sqle){
			}
			try{
				if(Connt!=null)
					Connt.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
	/**excute the input query
	 * @param sql input query does not require 
	 * returning results
	 * create, update, insert, delete, etc..
	 */
	public static void ExcuteUpdateQuery(String Username, String Password, String sql) {
		Connection Connt = null;
		Statement Statemt =  null;
		try {
			//register JDBC driver
			System.out.println("Registering driver...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//connect to DB
			System.out.println("Connecting to database...");
			Connt =  DriverManager.getConnection
					(CDBURL,Username,Password);
			
			System.out.println("Excuting your query...");
			Statemt = Connt.createStatement();
			
			//execute the query
			Statemt.executeUpdate(sql);
			System.out.println("Excuted your query");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			try{
				if(Statemt!=null){
					Connt.close();
				}
			}catch(SQLException sqle){
			}
			try{
				if(Connt!=null)
					Connt.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
	/**
	 * return ResultSet from specified SQL query
	 */
	public static ResultSet ExcuteQuery(String Username, String Password, String sql) {
		Connection Connt = null;
		Statement Statemt =  null;
		try {
			//register JDBC driver
			System.out.println("Registering driver...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//connect to DB
			System.out.println("Connecting to database...");
			Connt =  DriverManager.getConnection
					(CDBURL,Username,Password);
			
			System.out.println("Excuting your query...");
			Statemt = Connt.createStatement();
			
			//execute the query
			ResultSet rs = Statemt.executeQuery(sql);
			System.out.println("Excuted your query");
			
			return rs;
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			try{
				if(Statemt!=null){
					Connt.close();
				}
			}catch(SQLException sqle){
			}
			try{
				if(Connt!=null)
					Connt.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return null;
	}
	
}
