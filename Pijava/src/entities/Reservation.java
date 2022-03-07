/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author rahma
 */
public class Reservation {
    
    private int idClient ;
    private int idEvent ;
    private String nomClient ;
    private String prenomClient ; 
    Connection cnx2 ;
    public Reservation() {
        cnx2 = MyConnection.getInstance().getCnx();
    }

    public Reservation(String nomClient, String prenomClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public Connection getCnx2() {
        return cnx2;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setCnx2(Connection cnx2) {
        this.cnx2 = cnx2;
    }

    @Override
    public String toString() {
        return "Resvation{" + "idClient=" + idClient + ", idEvent=" + idEvent + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + '}';
    }

   
}

