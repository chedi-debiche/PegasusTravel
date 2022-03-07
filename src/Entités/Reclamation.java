/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

import java.sql.Date;


/**
 *
 * @author 21695
 */
public class Reclamation extends  Client{

    private int numero;
    private String commentaire ;
     private Date  dateReclamation; 
     private String typeReclamation;

    public Reclamation(int numero,  String nom, String prenom, String email,String commentaire, Date dateReclamation, String typeReclamation, int id) {
        super(id, nom, prenom, email);
        this.numero = numero;
        this.commentaire = commentaire;
        this.dateReclamation = dateReclamation;
        this.typeReclamation = typeReclamation;
    }

    public Reclamation() {
    }

    

    public Reclamation(String nom, String prenom, String email,String commentaire, Date dateReclamation, String typeReclamation,  int id) {
        super(id, nom, prenom, email);
        this.commentaire = commentaire;
        this.dateReclamation = dateReclamation;
        this.typeReclamation = typeReclamation;
    }

    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public int getNumero() {
        return numero;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public String getTypeReclamation() {
        return typeReclamation;
    }

   

    public Reclamation(int numero, String commentaire, Date dateReclamation, String typeReclamation, int id) {
        super(id);
        this.numero = numero;
        this.commentaire = commentaire;
        this.dateReclamation = dateReclamation;
        this.typeReclamation = typeReclamation;
    }

    public void getPrenom(String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
  
  
   
}
