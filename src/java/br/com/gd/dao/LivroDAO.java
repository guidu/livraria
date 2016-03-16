/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.dao;

import br.com.gd.modelo.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aninha S.A
 */
public class LivroDAO implements IBaseDAO{
    private final EntityManager em;
    public LivroDAO(EntityManager entityManager){
        this.em = entityManager;
    }
//    public void adiciona(Livro livro){
//        System.out.println("Numero de AUTORES: "+livro.getAutores().size());
//        em.getTransaction().begin();
//        em.persist(livro);
//        em.getTransaction().commit();
//        em.close();
//    }

    @Override
   public void incluir(Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Livro> listar() {
        Query q = em.createQuery("select l from Livro l");
        return q.getResultList();
    }
}
