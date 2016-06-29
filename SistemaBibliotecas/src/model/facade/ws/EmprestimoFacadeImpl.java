package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.EmprestimoDao;
import model.domain.Emprestimo;
import model.facade.EmprestimoFacade;

@WebService(serviceName="ws/emprestimo")
public class EmprestimoFacadeImpl implements EmprestimoFacade {
	
	@Inject
	private EmprestimoDao emprestimoDao;
			
	@WebMethod
	public List<Emprestimo> getEmprestimos() {
		return emprestimoDao.getEmprestimos(new Emprestimo());
	}
	
	@Override
	@WebMethod(operationName="getEmprestimoCodigo")
	public List<Emprestimo> getEmprestimos(@WebParam(name="codigoEmprestimo") 
							Integer codigo) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setCodigo(codigo);
		return emprestimoDao.getEmprestimos(emprestimo);
	}
	
	@WebMethod
	public Emprestimo salvar(@WebParam(name="emprestimo") Emprestimo emprestimo) {
		return emprestimoDao.salvar(emprestimo);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="emprestimo") Emprestimo emprestimo) {
		emprestimoDao.atualizar(emprestimo);
	}
	
	@WebMethod
	public void deletarEmprestimo(@WebParam(name="codigoEmprestimo") Integer codigo) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setCodigo(codigo);
		emprestimoDao.excluir(emprestimo);
	}


}
