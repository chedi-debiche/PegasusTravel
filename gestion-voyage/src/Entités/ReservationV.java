/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author ASUS
 */
public class ReservationV {
    private int idr,nb_personnes;
    private String date;
    

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public int getNb_personnes() {
        return nb_personnes;
    }

    public void setNb_personnes(int nb_personnes) {
        this.nb_personnes = nb_personnes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReservationV() {
    }

    public ReservationV(int idr, int nb_personnes, String date) {
        this.idr = idr;
        this.nb_personnes = nb_personnes;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReservationV{" + "idr=" + idr + ", nb_personnes=" + nb_personnes + ", date=" + date +'}';
    }
    
    
}
