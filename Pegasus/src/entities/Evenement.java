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
public class Evenement {

    private int idEvent;
    private String nomEvent;
    private String date;

    public Evenement() {
    }

    public Evenement(int idEvent, String nomEvent, String Date) {
        this.idEvent = idEvent;
        this.nomEvent = nomEvent;
        this.date = Date;
    }

    public Evenement(String nomEvent, String Date) {
        this.nomEvent = nomEvent;
        this.date = Date;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public String getDate() {
        return date;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", nomEvent=" + nomEvent + ", Date=" + date + '}';
    }

    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
