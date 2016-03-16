/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aninha S.A
 */
public class JpaUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrariaPU");
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}
