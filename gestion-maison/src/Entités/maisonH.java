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
    private int id_maison;
    private float prix;

      public maisonH(String nom, String image, String localisation, String description, float prix) {
        this.nom = nom;
        this.image = image;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
    }
    
    
    public maisonH(int id_maison,String nom, String image, String localisation, String description, float prix) {
        this.id_maison=id_maison ;
        this.nom = nom;
        this.image = image;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
    }

    
     public int getId_maison() {
        return id_maison;
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

    public float getPrix() {
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

    public void setPrix(float prix) {
        this.prix = prix;
    }
        public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }


    @Override
    public String toString() {
        return "maisonH{" + "id_maison=" + id_maison + ", nom=" + nom + ",image=" + image + ", localisation=" + localisation + ", description=" + description + ", prix=" + prix + '}';
    }
    
}
