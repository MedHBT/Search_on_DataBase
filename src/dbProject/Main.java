package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] argv){

		Intro In = null;
		MainWindow Win = null;
		
		DBCInformation DBCI = null;
		Connection cnx = null;
		
		process(In,DBCI,cnx,Win);
	} 
	
	public static void process(Intro In,DBCInformation DBCI,Connection cnx,MainWindow Win){
		
		boolean success = false;
		
		System.out.println("[MSG] The app is showing the introduction Window ...");
		In = new Intro();
		In.showWin();
		while(In.isVisible() == true){
			try {
				Thread.sleep(0);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		DBCI = In.getDBCInformation();
		
		try{
			System.out.println("[MSG] The app is preparing the driver ...");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while(!success){
				try{
					System.out.println("[MSG] The app is trying to connect to the database ...");
					cnx = DriverManager.getConnection("jdbc:oracle:thin:@"+DBCI.getAddressServer()+":"+DBCI.getPortServer()+":"+DBCI.getDataBaseName(),DBCI.getUser(),DBCI.getPassword());				
					success =true;
				}
				catch(SQLException SQLE){
					//System.out.println(SQLE);
					System.out.println("[MSG] The app failed to connect to the database ...");
					System.out.println("[MSG] The app is updating the information to sign in ...");
					DialogDBC DBC = new DialogDBC(null, "Database connection error", true);
					DBCI = DBC.showDBCInformation();
					while(In.isVisible() == true){
						try {
							Thread.sleep(0);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, DBCI.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			System.out.println("[MSG] The app is connected to the database ...");
			Win =new MainWindow(cnx);
			Win.showWin();
			while(Win.isVisible() == true){
				try {
					Thread.sleep(0);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Thread.sleep(1000);
			if (Win.signOut == true){
				process(In,DBCI,cnx,Win);
			}
			/*Statement statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from CLIENT");
			int i = 1 ;
			while (resultSet.next()) {
				try{
					System.out.print(i);  
			        System.out.print("\t"+resultSet.getString(1));  
			        System.out.print("\t"+resultSet.getString(2));  
		            System.out.print("\t"+resultSet.getString(3)); 
		            System.out.print("\t"+resultSet.getString(4));
		            System.out.print("\t"+resultSet.getString(5));
		            System.out.println(); 
		            i++;
				}
				catch(Exception eWhile){
					System.out.println("exception inside while");
				}	 
	        }*/
		}
		catch(ClassNotFoundException CNFE){
			System.out.println(CNFE);
			System.exit(1);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(2);
		}
	}

}
