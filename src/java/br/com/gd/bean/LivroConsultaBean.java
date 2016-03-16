package br.com.gd.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Aninha S.A
 */
@ManagedBean
@ViewScoped
public class LivroConsultaBean {
    
    public String formConsulta(){
        return "livroConsulta?faces-redirect=true";
    }
}
