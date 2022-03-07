/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author rahma
 */
public class Sponsor  {
    private int idS ;
    private String nomS ;
    private String prenomS ;
    private String descriptionS ; 
    private String imageS ;
    public Sponsor() {
        
    }

    public Sponsor(int idS, String nomS, String prenomS, String descriptionS , String imageS) {
        this.idS = idS;
        this.nomS = nomS;
        this.prenomS = prenomS;
        this.descriptionS = descriptionS;
        this.imageS=imageS ;
    }

    public Sponsor(String nomS, String prenomS, String descriptionS ,String imageS) {
        this.nomS = nomS;
        this.prenomS = prenomS;
        this.descriptionS = descriptionS;
        this.imageS=imageS ;
    }

    public String getImageS() {
        return imageS;
    }

    public void setImageS(String imageS) {
        this.imageS = imageS;
    }

    public int getIdS() {
        return idS;
    }

    public String getNomS() {
        return nomS;
    }


    public String getPrenomS() {
        return prenomS;
    }

    public String getDescriptionS() {
        return descriptionS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public void setPrenomS(String prenomS) {
        this.prenomS = prenomS;
    }

    public void setDescriptionS(String descriptionS) {
        this.descriptionS = descriptionS;
    }

    @Override
    public String toString() {
        return "Sponsor{" + "idS=" + idS + ", nomS=" + nomS + ", prenomS=" + prenomS + ", descriptionS=" + descriptionS +", ImageS=" + imageS + '}';
    }
    
}
