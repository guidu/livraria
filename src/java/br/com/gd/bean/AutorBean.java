/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.bean;

import br.com.gd.dao.AutorDAO;
import br.com.gd.modelo.Autor;
import br.com.gd.util.JpaUtils;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aninha S.A
 */
@ManagedBean
@ViewScoped
public class AutorBean {
    private Autor autor = new Autor();

    public Autor getAutor() {
        return autor;
    }
    
    public void grava(){
        FacesMessage msg = new FacesMessage("Gravado com sucesso.");
        JpaUtils jpaUtils = new JpaUtils();
        AutorDAO autorDao = new AutorDAO(jpaUtils.getEntityManager());
        autorDao.incluir(autor);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        autor = new Autor();
    }
    public List<Autor>getAutores(){
        JpaUtils jpaUtils = new JpaUtils();
        AutorDAO autorDao = new AutorDAO(jpaUtils.getEntityManager());
        return autorDao.autores();
    }
    public String formLivro(){
        return "livro?faces-redirect=true";
    } 
}
