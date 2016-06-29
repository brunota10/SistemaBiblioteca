package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Acervo;

public interface AcervoFacade {

	List<Acervo> getAcervos();

	List<Acervo> getAcervos(Integer codigo);
	
	@ValidateOnExecution
	Acervo salvar(@Valid Acervo acervo);
	
	void atualizar(Acervo acervo);

	void deletarAcervo(Integer codigo);

}