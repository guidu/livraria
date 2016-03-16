import br.com.gd.modelo.TipoPermissao;
import br.com.gd.util.JpaUtils;
import javax.persistence.EntityManager;

public class Test {
	public static void main(String[] args) {
		EntityManager entityManager;
		          JpaUtils entityUtils = new JpaUtils();
		entityManager = entityUtils.getEntityManager();
		TipoPermissao tipoPermissao = new TipoPermissao();
		tipoPermissao.setSigla("A");
		tipoPermissao.setDescricao("Descricao A");
		entityManager.getTransaction().begin();
		entityManager.persist(tipoPermissao);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
