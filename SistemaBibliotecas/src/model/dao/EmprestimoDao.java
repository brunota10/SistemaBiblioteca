package model.dao;

import java.util.List;

import model.domain.Emprestimo;

public interface EmprestimoDao {

	List<Emprestimo> getEmprestimos(Emprestimo emprestimo);
	
	public void excluir(Emprestimo emprestimo);

	Emprestimo salvar(Emprestimo emprestimo);

	void atualizar(Emprestimo emprestimo);

}