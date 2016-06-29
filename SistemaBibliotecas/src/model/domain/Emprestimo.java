package model.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Transactional
@XmlRootElement
@Entity
@Table(name="TB_EMPRESTIMO")
public class Emprestimo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_EMPRESTIMO")
	private Integer codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CD_ALUNO",referencedColumnName="CD_ALUNO")
	private Aluno aluno;
	
	@NotNull(message="O campo data emprestimo é obrigatório")
	@Column(name="DT_EMPRESTIMO")
	private Date dataEmprestimo;
	
	@Column(name="DT_DEVOLUCAO")
	private Date dataDevolucao;
	
	@ManyToMany
	@JoinTable(name="TB_ITEM_EMPRESTIMO", 
			   joinColumns= @JoinColumn(name="CD_EMPRESTIMO"), 
			   inverseJoinColumns= @JoinColumn(name="CD_ACERVO"))
	private List<Acervo> acervos;

	public Emprestimo() {
		super();
	}


	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	
	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}



	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}



	public Date getDataDevolucao() {
		return dataDevolucao;
	}



	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
