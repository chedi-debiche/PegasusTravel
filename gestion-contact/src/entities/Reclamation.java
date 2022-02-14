/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author 21695
 */
public class Reclamation {

    private int numero;
    private String nom ;
    private String prenom ;
    private String email ;
    private String commentaire ;

    public Reclamation(String nom, String prenom, String email, String commentaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
    }
  
    

    public Reclamation(int numero, String nom, String prenom, String email, String commentaire) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
    }

    public Reclamation() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", commentaire=" + commentaire + '}';
    }
    
    
}
