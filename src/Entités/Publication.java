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
public class Publication {
    private int idPub;
   
    private Date datePub;
    private String Path;
    private String description;

    public Publication() {
    }

    public String getDescription() {
        return description;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }
    

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public Publication(int idPub, Date datePub, String Path, String description) {
        this.idPub = idPub;
        this.datePub = datePub;
        this.Path = Path;
        this.description = description;
    }

    public Publication( Date datePub, String Path, String description) {
        this.datePub = datePub;
        this.Path = Path;
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Publication{" + "idPub=" + idPub + ", datePub=" + datePub + ", Path=" + Path + ", description=" + description + '}';
    }

    

    

    
    

    
    
}
