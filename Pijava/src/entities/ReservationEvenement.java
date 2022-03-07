/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.time.LocalDate;

public class ReservationEvenement extends Evenement{
    private int idRE ;
    private String nomRE ;
    private Date dateRE ;
   // private float prixRE ;
    private int idEvent ;

    public ReservationEvenement() {
    }

    public ReservationEvenement(String nomRE, Date dateRE, float prixRE) {
        this.nomRE = nomRE;
        this.dateRE = dateRE;
//        this.prixRE = prixRE;
    }

    public ReservationEvenement( int idEvent) {
        super(idEvent);
    }

   

    public ReservationEvenement( String nomRE, Date dateRE, int idEvent) {
        super(idEvent);
        this.nomRE = nomRE;
        this.dateRE = dateRE;
    }

    public ReservationEvenement(int idRE, String nomRE, Date dateRE, float prixRE) {
        this.idRE = idRE;
        this.nomRE = nomRE;
        this.dateRE = dateRE;
     //   this.prixRE = prixRE;
    }
    
    public ReservationEvenement(String nomRE, LocalDate dateRE, float prixRE , int idEvent ) {
        
    }

    public ReservationEvenement(String nomRE, Date dateRE, float prixRE , int idEvent ) {
        super (idEvent);
        this.nomRE = nomRE;
    //    this.prixRE=prixRE;
        this.dateRE = dateRE;
        
    }

    public ReservationEvenement(int idRE, String nomRE, Date dateRE) {
        this.idRE = idRE;
        this.nomRE = nomRE;
        this.dateRE = dateRE;
    }

    public ReservationEvenement(String nom, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdRE() {
        return idRE;
    }

    public String getNomRE() {
        return nomRE;
    }

    public Date getdateRE() {
        return dateRE;
    }
    

    public void setIdRE(int idRE) {
        this.idRE = idRE;
    }

//
//    public void setPrixRE(float prixRE) {
//        this.prixRE = prixRE;
//    }

    public void setNomRE(String nomRE) {
        this.nomRE = nomRE;
    }

    public void setdateRE(Date dateRE) {
        this.dateRE = dateRE;
    }

    @Override
    public String toString() {
        return "ReservationEvenement{" + "idRE=" + idRE + ", nomRE=" + nomRE + ", dateRE=" + dateRE +  ", prixRE="  + getIdEvent()+"}";
    }
    
    
    
    
}
