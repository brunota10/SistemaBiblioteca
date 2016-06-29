package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Emprestimo;

public class EmprestimoDaoImpl implements EmprestimoDao {
	
	@PersistenceContext(unitName="SistemaBibliotecas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Emprestimo> getEmprestimos(Emprestimo emprestimo) {
		StringBuffer hql = new StringBuffer("from Emprestimo c"
				+ " where 1 = 1");		
		if (emprestimo.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (emprestimo.getCodigo() != null) {
			query.setParameter("codigo",emprestimo.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Emprestimo emprestimo) {
		emprestimo = entityManager.merge(emprestimo);
		entityManager.remove(emprestimo);
	}

	@Override
	@Transactional
	public Emprestimo salvar(Emprestimo emprestimo) {
		entityManager.merge(emprestimo);
		return emprestimo;
	}

	@Override
	@Transactional
	public void atualizar(Emprestimo emprestimo) {
		emprestimo = entityManager.merge(emprestimo);
		entityManager.persist(emprestimo);		
	}
	

}
