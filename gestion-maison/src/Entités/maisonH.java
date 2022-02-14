/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author CC
 */
public class maisonH {
    private String nom,image,localisation,description;
    private int id,prix;

    public maisonH(int id,String nom, String image, String localisation, String description, int prix) {
        this.id=id ;
        this.nom = nom;
        this.image = image;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
    }

    
     public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public int getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
        public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "maisonH{" + "id=" + id + ", nom=" + nom + ",image=" + image + ", localisation=" + localisation + ", description=" + description + ", prix=" + prix + '}';
    }
    
}
