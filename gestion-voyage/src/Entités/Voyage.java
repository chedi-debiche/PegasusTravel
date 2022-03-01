/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author ASUS
 */
public class Voyage {
    private int id, prix;
    private String nom, destination, description;
    

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
     public String getDescription() {
        return description;
    }
      public void setDescription(String description) {
        this.description = description;
    }
        public int getPrix() {
        return prix;
    }
      public void setPrix(int prix) {
        this.prix = prix;
    }
      
    public Voyage() {
    }

    public Voyage(int id, String nom, String destination, String description, int prix) {
        this.id = id;
        this.nom = nom;
        this.destination = destination;
        this.description = description;
        this.prix = prix;
    }
        public Voyage(String nom, String destination, String description, int prix) {
       
        this.nom = nom;
        this.destination = destination;
        this.description = description;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Voyage{" + "id=" + id + ", nom=" + nom + ", destination=" + destination +  ", description=" + description + ", prix=" + prix +'}';
    }
    
    
}
