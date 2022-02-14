
package entities;

/**
 *
 * @author Zoghlami
 */
public class admin {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int salaire;
    public admin(){
        
    }

    public admin(int id, String nom, String prenom, String email, int salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.salaire = salaire;
    }

    public admin(String nom, String prenom, String email, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "admin{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", salaire=" + salaire + '}';
    }
    

    
    
    
    
}
