package model.dao;

import java.util.List;

import model.domain.Acervo;

public interface AcervoDao {

	List<Acervo> getAcervos(Acervo acervo);
	
	public void excluir(Acervo acervo);

	Acervo salvar(Acervo acervo);

	void atualizar(Acervo acervo);

}