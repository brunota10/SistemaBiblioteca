package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AcervoDao;
import model.domain.Acervo;
import model.facade.AcervoFacade;

@Path("/acervo")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AcervoFacadeImpl implements AcervoFacade {

	@Inject
	private AcervoDao acervoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcervoFacade#getAcervos()
	 */	
	@Override
	@GET
	public List<Acervo> getAcervos() {
		return acervoDao.getAcervos(new Acervo());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcervoFacade#getAcervos(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Acervo> getAcervos(@PathParam("codigo") Integer codigo) {
		Acervo acervo = new Acervo();
		acervo.setCodigo(codigo);
		return acervoDao.getAcervos(acervo);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcervoFacade#salvar(model.domain.Acervo)
	 */
	@Override
	@POST 
	public Acervo salvar(Acervo acervo) { 
		acervo = acervoDao.salvar(acervo);
	 	return acervo;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcervoFacade#atualizar(model.domain.Acervo)
	 */
	@Override
	@PUT 
	public void atualizar(Acervo acervo) { 
		acervoDao.atualizar(acervo);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcervoFacade#deletarAcervo(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAcervo(@PathParam("codigo") Integer codigo) {
		Acervo acervo = new Acervo();
		acervo.setCodigo(codigo);
		acervoDao.excluir(acervo);
	}

}
