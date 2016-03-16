package br.com.gd.bean;

import br.com.gd.dao.UsuarioDAO;
import br.com.gd.modelo.Usuario;
import br.com.gd.util.JpaUtils;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aninha S.A
 */
@ManagedBean
@SessionScoped
public class Login {
    private String nameServlet = "controller login";
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNameServlet() {
        return nameServlet;
    }

    public void setNameServlet(String nameServlet) {
        this.nameServlet = nameServlet;
    }

    public String acessar() {
        JpaUtils jpaUtils = new JpaUtils();
        UsuarioDAO usuarioDao = new UsuarioDAO(jpaUtils.getEntityManager());
        Usuario usuario = new Usuario();
        usuario.setUsuario(login);
        usuario.setSenha(senha);
        if (usuarioDao.acessar(usuario)) {
            return "index?faces-redirect=true";
        } else {
            acessoNegado();
            return null;
        }
    }
    public void acessoNegado() {
        FacesMessage msg;
        msg = new FacesMessage("Acesso negado Usuário ou Senha inválido.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String formLogin(){
        return "index?faces-redirect=true";
    }
    
}
