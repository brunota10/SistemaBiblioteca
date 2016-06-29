package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AlunoDao;
import model.domain.Aluno;
import model.facade.AlunoFacade;

@WebService(serviceName="ws/aluno")
public class AlunoFacadeImpl implements AlunoFacade {
	
	@Inject
	private AlunoDao alunoDao;
			
	@WebMethod
	public List<Aluno> getAlunos() {
		return alunoDao.getAlunos(new Aluno());
	}
	
	@Override
	@WebMethod(operationName="getAlunoCodigo")
	public List<Aluno> getAlunos(@WebParam(name="codigoAluno") 
							Integer codigo) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		return alunoDao.getAlunos(aluno);
	}
	
	@WebMethod
	public Aluno salvar(@WebParam(name="aluno") Aluno aluno) {
		return alunoDao.salvar(aluno);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="aluno") Aluno aluno) {
		alunoDao.atualizar(aluno);
	}
	
	@WebMethod
	public void deletarAluno(@WebParam(name="codigoAluno") Integer codigo) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		alunoDao.excluir(aluno);
	}


}
