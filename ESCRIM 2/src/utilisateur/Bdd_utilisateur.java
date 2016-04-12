package utilisateur;

import java.sql.*;

public class Bdd_utilisateur {

	static String pilote = "com.mysql.jdbc.Driver";
	static Connection connexion;
	
	public static void connecter (String login,String motdepasse)throws SQLException{
		
		try {
			Class.forName(pilote);
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/escrim","root","");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		
	}
	  public static void deconnecter() throws SQLException{
	        connexion.close();
	        
	    }
	  public static ResultSet lecture(String requete) throws SQLException{
	        Statement stmt=connexion.createStatement();
	       ResultSet resultat=stmt.executeQuery(requete);
	        return resultat;
	    }
	    public static void ecriture(String requete) throws SQLException{
	        Statement stmt= connexion.createStatement();
	        int resultat = stmt.executeUpdate(requete);
	    }
    }
	

