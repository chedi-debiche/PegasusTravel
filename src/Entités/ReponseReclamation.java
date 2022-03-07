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
public class ReponseReclamation extends Reclamation {
    private int IdRep;
private int numero;
private String Reponse;

    
   

    public ReponseReclamation(String Reponse) {
        this.Reponse = Reponse;
    }

    public ReponseReclamation(int numero, String Reponse) {
        this.numero = numero;
        this.Reponse = Reponse;
    }

    public ReponseReclamation() {
    }

    private ReponseReclamation(int numero, String nom, String prenom, String email, String commentaire,String typeReclamation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
    public int getNumero() {
        return numero;
    }

@Override
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ReponseReclamation(int IdRep, int numero, String Reponse) {
        this.IdRep = IdRep;
        this.numero = numero;
        this.Reponse = Reponse;
    }

    public int getIdRep() {
        return IdRep;
    }

    public void setIdRep(int IdRep) {
        this.IdRep = IdRep;
    }

    @Override
    public String toString() {
        return "ReponseReclamation{" + "IdRep=" + IdRep + ", numero=" + numero + ", Reponse=" + Reponse + '}';
    }

    

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String Reponse) {
        this.Reponse = Reponse;
    }
     



    
   
    
    
}
