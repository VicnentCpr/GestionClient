
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Base {
private Connection con;
private ResultSet resultats;
private static final String USER ="root";
private static final String PASS ="pass";
private static final String DB = "jdbc:mysql://localhost/Vincent";


	private static void affiche(String message) {
		System.out.println(message);
	}

	private static void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}

	public Base() {
		 this.con = null;
		 this.resultats = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			arret("Impossible de charger le pilote jdbc:odbc");
		}
		

	}
	
	public boolean ajouterClient(Client client) {
		try{
			con = DriverManager.getConnection(DB,USER,PASS);
			java.sql.Statement ajoutClient = con.createStatement();
			System.out.println("INSERT INTO Client(nom, prenom, email, tel) VALUES ('"+client.getNom()+"', '"+client.getPrenom()+"', '"
					+ client.getEmail()+", '"+ client.getTel()+"')");
			client.setId(ajoutClient.executeUpdate("INSERT INTO Client(nom, prenom, email, tel) VALUES ('"+client.getNom()+"', '"+client.getPrenom()+"', '"
					+ client.getEmail()+"', '"+ client.getTel()+"')", Statement.RETURN_GENERATED_KEYS));
			
			
			return true;
		}catch (SQLException e) {
			arret(e.getMessage());
			return false;
		}
	}
	public ArrayList<Client> selectClients() {
		ArrayList<Client> clients= new ArrayList<>();
		affiche("connexion a la base de données");
		try {

			
			con = DriverManager.getConnection(DB,USER,PASS);
			PreparedStatement rechercheClient = con.prepareStatement("SELECT * FROM client");

			// recherchePersonne.setString(1, "nom3");

			resultats = rechercheClient.executeQuery();

			affiche("parcours des données retournées");

			boolean encore = resultats.next();

			while (encore) {
				System.out.print(resultats.getInt(1) + " :  " + resultats.getString(2) + " " + resultats.getString(3)
						+ " " + resultats.getString(4) + " " + resultats.getString(5));
				System.out.println();
				Client client = new Client(resultats.getInt(1),resultats.getString(2),
										resultats.getString(3),resultats.getString(4),resultats.getString(5));
				clients.add(client);
				encore = resultats.next();
			}
			
			resultats.close();
			con.close();
			return clients;
		} catch (SQLException e) {
			arret(e.getMessage());
			return null;
		}
	}
	
	
}