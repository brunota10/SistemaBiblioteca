package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Acervo;

public class AcervoDaoImpl implements AcervoDao {
	
	@PersistenceContext(unitName="SistemaBibliotecas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Acervo> getAcervos(Acervo acervo) {
		StringBuffer hql = new StringBuffer("from Acervo c"
				+ " where 1 = 1");		
		if (acervo.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (acervo.getCodigo() != null) {
			query.setParameter("codigo",acervo.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Acervo acervo) {
		acervo = entityManager.merge(acervo);
		entityManager.remove(acervo);
	}

	@Override
	@Transactional
	public Acervo salvar(Acervo acervo) {
		entityManager.persist(acervo);
		return acervo;
	}

	@Override
	@Transactional
	public void atualizar(Acervo acervo) {
		acervo = entityManager.merge(acervo);
		entityManager.persist(acervo);		
	}
	

}
