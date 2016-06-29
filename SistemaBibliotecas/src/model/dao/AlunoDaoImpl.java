package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Aluno;

public class AlunoDaoImpl implements AlunoDao {
	
	@PersistenceContext(unitName="SistemaBibliotecas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunos(Aluno aluno) {
		StringBuffer hql = new StringBuffer("from Aluno c"
				+ " where 1 = 1");		
		if (aluno.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (aluno.getCodigo() != null) {
			query.setParameter("codigo",aluno.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunosComEmprestimos(Aluno aluno) {
		StringBuffer hql = new StringBuffer("from Aluno c left join fetch c.emprestimos");		//e where 1 = 1 
		if (aluno.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (aluno.getCodigo() != null) {
			query.setParameter("codigo",aluno.getCodigo());
		} 
		return query.getResultList();
	}
	
	
	@Override
	@Transactional
	public void excluir(Aluno aluno) {
		aluno = entityManager.merge(aluno);
		entityManager.remove(aluno);
	}

	@Override
	@Transactional
	public Aluno salvar(Aluno aluno) {
		entityManager.persist(aluno);
		return aluno;
	}

	@Override
	@Transactional
	public void atualizar(Aluno aluno) {
		aluno = entityManager.merge(aluno);
		entityManager.persist(aluno);		
	}
	

}
