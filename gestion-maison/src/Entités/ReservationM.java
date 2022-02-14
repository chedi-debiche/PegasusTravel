/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

import java.util.List;

/**
 *
 * @author CC
 */
public class ReservationM {
    private int id_res,nb_chambre,nb_personne;
    private String date;
    

    public ReservationM(int id_res, int nb_chambre, int nb_personne , String date) {
        this.id_res = id_res;
        this.nb_chambre = nb_chambre;
        this.nb_personne = nb_personne;
        this.date = date;
    }

    public int getId_res() {
        return id_res;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public int getNb_personne() {
        return nb_personne;
    }

    public String getDate() {
        return date;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

   

    @Override
    public String toString() {
      
        return "ReservationM{" + "id_res=" + id_res + ", nb_chambre=" + nb_chambre + ", nb_personne=" + nb_personne + "date=" + date + '}';
    }

 
    
}
