/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intservice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IService <T>{
    public void ajouter(T t);
   // public T getById(int id);
    List<T> read() throws SQLException;
   // List<T> read();
    public boolean modifier(T t);
    public boolean supprimer(int id );
}

