/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Forum;
import java.util.List;

/**
 *
 * @author 21695
 */
public interface ForumInterface {
    public void AjoutForum();
    public void AjoutForum2(Forum F);
    public List <Forum> afficherReclamation();
    public void supprimer(Forum f  );
    public void modifier(Forum f);
}
