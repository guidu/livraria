/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.dao;

import br.com.gd.modelo.Autor;
import br.com.gd.modelo.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Aninha S.A
 */
public class AutorDAO implements IBaseDAO{
        private EntityManager em;
    public AutorDAO(EntityManager entityManager){
        this.em = entityManager;
    }
    public List<Autor>autores(){
        Query q = em.createQuery("select a from Autor a order by a.nome");
        return q.getResultList();
    }

    public Autor buscaPorId(Integer autorId) {
        TypedQuery<Autor> q = em.createQuery("select a from Autor a where a.id = :pId",Autor.class);
        q.setParameter("pId", autorId);
        return q.getSingleResult();
    }

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
}
