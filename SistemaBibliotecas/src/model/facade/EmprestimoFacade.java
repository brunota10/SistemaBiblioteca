package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Emprestimo;

public interface EmprestimoFacade {

	List<Emprestimo> getEmprestimos();

	List<Emprestimo> getEmprestimos(Integer codigo);
	
	@ValidateOnExecution
	Emprestimo salvar(@Valid Emprestimo emprestimo);
	
	void atualizar(Emprestimo emprestimo);

	void deletarEmprestimo(Integer codigo);

}