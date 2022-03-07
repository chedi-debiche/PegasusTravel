/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Zoghlami
 */
public class employee {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String pwd;
   private String poste;
   private int salaire;
   private String role;
   
   
    public employee(){
       
   }

    public employee(int id, String nom, String prenom, String email, String pwd, String poste, int salaire, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.poste = poste;
        this.salaire = salaire;
        this.role = role;
    }

    public employee(String nom, String prenom, String email, String pwd, String poste, int salaire, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.poste = poste;
        this.salaire = salaire;
        this.role = role;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "employee{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pwd=" + pwd + ", poste=" + poste + ", salaire=" + salaire + ", role=" + role + '}';
    }

   
}

