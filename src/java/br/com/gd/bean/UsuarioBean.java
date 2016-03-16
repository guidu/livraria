package br.com.gd.bean;

import br.com.gd.dao.UsuarioDAO;
import br.com.gd.modelo.Usuario;
import br.com.gd.util.JpaUtils;
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
public class UsuarioBean {
    
    Usuario usuario = new Usuario();
    
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void grava() {
        FacesMessage msg;
        JpaUtils jpaUtils = new JpaUtils();
        UsuarioDAO usuarioDAO = new UsuarioDAO(jpaUtils.getEntityManager());
        if (usuario.getSenha().equals(usuario.getConfirmaSenha())) {
            usuarioDAO.incluir(usuario);
            msg = new FacesMessage("Gravado com sucesso.");
        } else {
            msg = new FacesMessage("A senha digitada deve ser igual a confirmação.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String formUsuario(){
        return "cadastroUsuario?faces-redirect=true";
    }
}
