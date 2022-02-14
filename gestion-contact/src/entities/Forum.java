/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author 21695
 */
public class Forum {
    private String commentaire ;
    private String titre;

    public Forum() {
    }

    public Forum(String commentaire, String titre) {
        this.commentaire = commentaire;
        this.titre = titre;
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

    @Override
    public String toString() {
        return "Forum{" + "commentaire=" + commentaire + ", titre=" + titre + '}';
    }
    
}
