package br.com.gd.bean;

import br.com.gd.dao.AutorDAO;
import br.com.gd.dao.LivroDAO;
import br.com.gd.modelo.Autor;
import br.com.gd.modelo.Livro;
import br.com.gd.util.JpaUtils;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class LivroBean {

    private Livro livro = new Livro();
    private Integer autorId;
//    ExternalContext contextExterno = FacesContext.getCurrentInstance().getExternalContext();
//    Map<String, Object> mapaSessao = contextExterno.getSessionMap();
//    Login login = (Login) mapaSessao.get("Login");
//    public LivroBean(){
//        System.out.println("usuario logado: "+login);
//    }
    @ManagedProperty(value = "#{login}")
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Livro getLivro() {
        return livro;
    }
    public String getUsuarioLogado(){
        System.out.println("blz: "+login.getNameServlet());
        System.out.println("agora sim: "+login.getLogin());
        if(login.getLogin() == null){
            return "telaLogin?faces-redirect=true";
        }else{
            return "livro?faces-redirect=true";
        }
    }

    public List<Autor> getAutores() {
        System.out.println("porque entrou aqui?");
        JpaUtils jpaUtils = new JpaUtils();
        AutorDAO autorDao = new AutorDAO(jpaUtils.getEntityManager());
        return autorDao.autores();
    }

    public void gravaAutor() {
        JpaUtils jpaUtils = new JpaUtils();
        AutorDAO autorDao = new AutorDAO(jpaUtils.getEntityManager());
        Autor autor = autorDao.buscaPorId(this.autorId);
        this.livro.adicionaAutor(autor);
    }

    public void grava() {
        FacesMessage msg = new FacesMessage();
        JpaUtils jpaUtils = new JpaUtils();
        LivroDAO livroDao = new LivroDAO(jpaUtils.getEntityManager());
        if (!livro.getAutores().isEmpty()) {
            System.out.println("entrou...");
            msg = new FacesMessage("Gravado com sucesso.");
            livroDao.incluir(livro);
            livro = new Livro();
        } else if (livro.getAutores().isEmpty()) {
            msg = new FacesMessage("É necessário adiciona pelo menos um Autor.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }

    public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        String valor = value.toString();
        if (!valor.startsWith("1")) {
            throw new ValidatorException(new FacesMessage("O ISBN deve começar com o número um."));
        }
    }

    public String formAutor() {
        return "autor?faces-redirect=true";
    }

    public List<Livro> getLivros() {
        JpaUtils jpaUtils = new JpaUtils();
        LivroDAO livroDao = new LivroDAO(jpaUtils.getEntityManager());
        return livroDao.listar();
    }

    public String formConsulta() {
        return "livroConsulta?faces-redirect=true";
    }
}
