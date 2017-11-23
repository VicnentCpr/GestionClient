
public class Client {
	
private String nom;
private String prenom;
private String email;
private String tel;
private int id;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Client(int id,String nom, String prenom, String email, String tel) {
	this.nom = nom;
	this.id=id;
	this.prenom = prenom;
	this.email = email;
	this.tel = tel;
}
public Client(String nom, String prenom, String email, String tel) {
	this.nom = nom;
	this.id=id;
	this.prenom = prenom;
	this.email = email;
	this.tel = tel;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
@Override
public String toString() {
	return this.nom+" "+this.prenom;
}


}
