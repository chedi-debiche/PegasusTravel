/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author CC
 */

public class maisonH {

    static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String nom,localisation,description,image_maison;
    private int id_maison;
    private float prix;
    

      public maisonH(String nom, String localisation, String description, float prix, String image_maison) {
        this.nom = nom;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
        this.image_maison = image_maison;
    }
    
    
    public maisonH(int id_maison,String nom, String localisation, String description, float prix, String image_maison) {
        this.id_maison=id_maison ;
        this.nom = nom;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
        this.image_maison = image_maison;
    }

    
     public int getId_maison() {
        return id_maison;
    }
    public String getNom() {
        return nom;
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
    
    public String getImage_maison() {
        return image_maison;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        
     public void setImage_maison(String image_maison) {
        this.image_maison = image_maison;
    }

    @Override
    public String toString() {
        return "maisonH{" + "nom=" + nom + ", localisation=" + localisation + ", description=" + description + ", image_maison=" + image_maison + ", id_maison=" + id_maison + ", prix=" + prix + '}';
    }


    
}
