/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gd.dao;

import br.com.gd.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Aninha S.A
 */
public class UsuarioDAO implements IUsuarioDAO<Usuario>,IBaseDAO {

    private final EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> consultar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acessar(Usuario t) {
        Usuario usuario = null;
        try {
            TypedQuery<Usuario> query = entityManager.createQuery("select a from Usuario a where usuario = :pUsuario and senha = :pSenha", Usuario.class);
            query.setParameter("pUsuario", t.getUsuario());
            query.setParameter("pSenha", t.getSenha());
            usuario = query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            entityManager.close();
        }

        return usuario != null;
    }

    @Override
    public void incluir(Object o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
        entityManager.close();
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
