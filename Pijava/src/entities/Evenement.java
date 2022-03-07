/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author rahma
 */
public class Evenement  {

    private int idEvent;
    private String nomEvent;
    private Float prixEvent ;
    private Date date;

    public Evenement() {
    }

    public Evenement(int idEvent) {
        this.idEvent = idEvent;
    }
    

    public Evenement(int idEvent, String nomEvent, Float prixEvent ,Date Date) {
        this.idEvent = idEvent;
        this.nomEvent = nomEvent;
        this.date = Date;
        this.prixEvent = prixEvent ;
    }

    public Evenement(String nomEvent,Float prixEvent , Date date ) {
        this.nomEvent = nomEvent;
        this.prixEvent= prixEvent ;
        this.date = date;
    }

    public Evenement(String Nom, LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public Float getPrixEvent() {
        return prixEvent;
    }

    public void setPrixEvent(Float prixEvent) {
        this.prixEvent = prixEvent;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", nomEvent=" + nomEvent + ", prixEvent=" + prixEvent + ", date=" + date + '}';
    }

    

    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
