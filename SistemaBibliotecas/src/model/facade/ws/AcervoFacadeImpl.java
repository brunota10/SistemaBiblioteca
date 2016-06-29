package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AcervoDao;
import model.domain.Acervo;
import model.facade.AcervoFacade;

@WebService(serviceName="ws/acervo")
public class AcervoFacadeImpl implements AcervoFacade {
	
	@Inject
	private AcervoDao acervoDao;
			
	@WebMethod
	public List<Acervo> getAcervos() {
		return acervoDao.getAcervos(new Acervo());
	}
	
	@Override
	@WebMethod(operationName="getAcervoCodigo")
	public List<Acervo> getAcervos(@WebParam(name="codigoAcervo") 
							Integer codigo) {
		Acervo acervo = new Acervo();
		acervo.setCodigo(codigo);
		return acervoDao.getAcervos(acervo);
	}
	
	@WebMethod
	public Acervo salvar(@WebParam(name="acervo") Acervo acervo) {
		return acervoDao.salvar(acervo);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="acervo") Acervo acervo) {
		acervoDao.atualizar(acervo);
	}
	
	@WebMethod
	public void deletarAcervo(@WebParam(name="codigoAcervo") Integer codigo) {
		Acervo acervo = new Acervo();
		acervo.setCodigo(codigo);
		acervoDao.excluir(acervo);
	}


}
