package model.dao;

import java.util.List;

import model.domain.Aluno;

public interface AlunoDao {

	List<Aluno> getAlunos(Aluno aluno);
	
	public List<Aluno> getAlunosComEmprestimos(Aluno aluno);
	
	public void excluir(Aluno aluno);

	Aluno salvar(Aluno aluno);

	void atualizar(Aluno aluno);

}