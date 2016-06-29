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

import model.dao.AlunoDao;
import model.domain.Aluno;
import model.facade.AlunoFacade;

@Path("/aluno")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AlunoFacadeImpl implements AlunoFacade {

	@Inject
	private AlunoDao alunoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlunoFacade#getAlunos()
	 */	
	@Override
	@GET
	public List<Aluno> getAlunos() {
		return alunoDao.getAlunosComEmprestimos(new Aluno());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlunoFacade#getAlunos(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Aluno> getAlunos(@PathParam("codigo") Integer codigo) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		return alunoDao.getAlunos(aluno);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlunoFacade#salvar(model.domain.Aluno)
	 */
	@Override
	@POST 
	public Aluno salvar(Aluno aluno) { 
		aluno = alunoDao.salvar(aluno);
	 	return aluno;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlunoFacade#atualizar(model.domain.Aluno)
	 */
	@Override
	@PUT 
	public void atualizar(Aluno aluno) { 
		alunoDao.atualizar(aluno);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlunoFacade#deletarAluno(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAluno(@PathParam("codigo") Integer codigo) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		alunoDao.excluir(aluno);
	}

}
