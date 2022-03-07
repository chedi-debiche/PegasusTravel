/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;



/**
 *
 * @author 21695
 */
public class Forum {
    private int idForum ;
    private String commentaire ;
    private String titre;
    private Date dateForum;
    private String typeForum;
    public Forum() {
    }

    public Forum(String commentaire, String titre,Date dateForum,String typeForum ) {
        this.commentaire = commentaire;
        this.titre = titre;
        this.dateForum=dateForum;
        this.typeForum=typeForum;
    }

    public Forum(int idForum, String commentaire, String titre, Date dateForum, String typeForum) {
        this.idForum = idForum;
        this.commentaire = commentaire;
        this.titre = titre;
        this.dateForum = dateForum;
        this.typeForum = typeForum;
    }

    

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateForum() {
        return dateForum;
    }

    public void setDateForum(Date dateForum) {
        this.dateForum = dateForum;
    }

    public String getTypeForum() {
        return typeForum;
    }

    public void setTypeForum(String typeForum) {
        this.typeForum = typeForum;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    @Override
    public String toString() {
        return "Forum{" + "idForum=" + idForum + ", commentaire=" + commentaire + ", titre=" + titre + ", dateForum=" + dateForum + ", typeForum=" + typeForum + '}';
    }

    

    

    
    
}
