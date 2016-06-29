package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Transactional
@XmlRootElement
@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ALUNO")
	private Integer codigo;
	
	@Size(min=11,message="R.A. precisa ter pelo menos 11 caracteres")
	@NotNull(message="O campo R.A. é obrigatório")	
	@Column(name="RA_ALUNO")
	private Integer ra;
	
	@Size(min=10,message="R.A. precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo R.A. é obrigatório")
	@Column(name="NM_ALUNO")
	private String nome;
	
	@Size(min=8,message="Telefone precisa ter pelo menos 8 caracteres")
	@NotNull(message="O campo telefone é obrigatório")
	@Column(name="TEL_ALUNO")
	private String telefone;
	
	@NotNull(message="O campo endereço é obrigatório")
	@Column(name="END_ALUNO")
	private String endereco;
	
	@NotNull(message="O campo e-mail é obrigatório")
	@Column(name="EMAIL_ALUNO")
	private String email;
	
	@OneToMany(mappedBy="aluno")
	private List<Emprestimo> emprestimos;
	
	public Aluno() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
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
		Aluno other = (Aluno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
