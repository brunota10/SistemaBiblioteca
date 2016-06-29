package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Aluno;

public interface AlunoFacade {

	List<Aluno> getAlunos();

	List<Aluno> getAlunos(Integer codigo);
	
	@ValidateOnExecution
	Aluno salvar(@Valid Aluno aluno);
	
	void atualizar(Aluno aluno);

	void deletarAluno(Integer codigo);

}